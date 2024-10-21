package com.thy.bbb_lbb.util;

import com.thy.bbb_lbb.result.GlobalException;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * BeanUtils
 *
 * @author BeanUtils
 */
public class BeanUtils extends org.springframework.beans.BeanUtils {

    /**
     * 转换实体，当原实体与新实体变量名称与类型一致时，可将原实体变量的值复制到新实体
     *
     * @param source      原实体
     * @param targetClass 目标实体类型
     * @return 新实体
     * @author c4x
     * 2023-5-5 14:32
     */
    public static <E, T> T convertBean(E source, Class<T> targetClass) {
        if (source == null) {
            return null;
        }
        try {
            T t = targetClass.getDeclaredConstructor().newInstance();
            copyProperties(source, t);
            return t;
        } catch (ReflectiveOperationException e) {
            throw new GlobalException(e.getMessage());
        }
    }

    /**
     * 转换递归对象，将对象中与对象同类的变量或与对象同类变量的List递归转换
     *
     * @param source      原实体
     * @param targetClass 目标实体类型
     * @return 新实体
     * @author c4x
     * 2023-5-18 19:12
     */
    @SuppressWarnings("unchecked")
    public static <E, T> T convertBeanRecursive(E source, Class<T> targetClass) {
        if (source == null) {
            return null;
        }
        // 递归对象值缓存
        final var valueMap = new HashMap<Field, Object>();
        // 源类
        final var sourceClass = source.getClass();
        // 源类所有变量
        final var sourceFields = sourceClass.getDeclaredFields();
        // 目标类所有变量缓存
        final var targetFieldMap = new HashMap<String, Field>();
        for (var field : targetClass.getDeclaredFields()) {
            targetFieldMap.put(field.getName(), field);
        }
        try {
            for (var sourceField : sourceFields) {
                final var targetField = targetFieldMap.get(sourceField.getName());
                // 判断源变量在目标对象中是否具有同名变量
                if (targetField == null) {
                    continue;
                }
                // 如果源对象中有与其相同类型的变量
                if (sourceField.getClass() == sourceClass) {
                    sourceField.setAccessible(true);
                    // 原始变量值
                    final var sourceValue = sourceField.get(source);
                    if (sourceValue != null) {
                        // 递归转换值
                        final var value = convertBeanRecursive(sourceValue, targetClass);
                        // 存入变量缓存
                        valueMap.put(targetField, value);
                    }
                    // 如果源对象中有与其相同类型的变量列表
                } else if (sourceField.getType() == List.class) {
                    final var genericType = sourceField.getGenericType();
                    // 判断列表类型，需与源类一致
                    if (genericType instanceof ParameterizedType &&
                            sourceClass == ((ParameterizedType) genericType).getActualTypeArguments()[0]) {
                        sourceField.setAccessible(true);
                        // 获取到列表变量，泛型类型与源类一致
                        final var sourceList = (List<E>) sourceField.get(source);
                        if (sourceList != null) {
                            // 递归转换每个值
                            final var value = sourceList.stream()
                                    .map(it -> convertBeanRecursive(it, targetClass))
                                    .toList();
                            // 存入变量缓存
                            valueMap.put(targetField, value);
                        }
                    }
                }
            }
            final var target = targetClass.getDeclaredConstructor().newInstance();
            // 转换本体
            copyProperties(source, target);
            // 写入全部缓存的变量
            for (var targetField : valueMap.keySet()) {
                targetField.setAccessible(true);
                targetField.set(target, valueMap.get(targetField));
            }
            return target;
        } catch (ReflectiveOperationException e) {
            throw new GlobalException(e.getMessage());
        }
    }

    /**
     * 转换实体分页，配合PageHelper使用
     * 当原实体与新实体变量名称与类型一致时，可将原实体变量的值复制到新实体
     *
     * @param source             原实体
     * @param elementTargetClass 目标实体类型
     * @return 新实体
     * @author c4x
     * 2023-5-5 14:34
     */
    public static <E, T> PageInfo<T> convertPage(List<E> source, Class<T> elementTargetClass) {
        if (!(source instanceof Page<E>)) {
            throw new GlobalException("source is not an instance of Page");
        }
        final var sourcePageInfo = new PageInfo<>(source);
        final var targetPageInfo = new PageInfo<T>();
        copyProperties(sourcePageInfo, targetPageInfo, "list");
        targetPageInfo.setList(convertList(source, elementTargetClass));
        return targetPageInfo;
    }

    /**
     * 转换分页信息中的实体类型
     * 当原实体与新实体变量名称与类型一致时，可将原实体变量的值复制到新实体
     *
     * @param pageInfo           分页信息
     * @param elementTargetClass 目标实体类型
     * @return 新实体
     * @author c4x
     * 2023-5-15 11:03
     */
    public static <E, T> PageInfo<T> convertPageInfo(PageInfo<E> pageInfo, Class<T> elementTargetClass) {
        final var pageVO = new PageInfo<T>();
        copyProperties(pageInfo, pageVO, "list");
        pageVO.setList(convertList(pageInfo.getList(), elementTargetClass));
        return pageVO;
    }

    /**
     * 转换实体列表，当原实体与新实体变量名称与类型一致时，可将原实体变量的值复制到新实体
     *
     * @param source             原实体
     * @param elementTargetClass 目标实体类型
     * @return 新实体
     * @author c4x
     * 2023-5-5 14:34
     */
    public static <E, T> List<T> convertList(List<E> source, Class<T> elementTargetClass) {
        if (source == null) {
            return null;
        }
        try {
            List<T> ls = new ArrayList<>();
            for (E s : source) {
                if (s == null) {
                    ls.add(null);
                } else {
                    T t = elementTargetClass.getDeclaredConstructor().newInstance();
                    copyProperties(s, t);
                    ls.add(t);
                }
            }
            return ls;
        } catch (ReflectiveOperationException e) {
            throw new GlobalException(e.getMessage());
        }
    }
}
