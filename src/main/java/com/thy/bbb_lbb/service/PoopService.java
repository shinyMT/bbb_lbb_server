package com.thy.bbb_lbb.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.thy.bbb_lbb.domain.po.PoopPO;

import java.util.List;

/**
 * @author thy
 * 2024-10-17 14:47:26
 */
public interface PoopService extends IService<PoopPO> {
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    PoopPO getDetails(Integer id);

    /**
     * 根据年份月份查询
     *
     * @return 所有数据
     */
    List<PoopPO> listByYearMonth(int year, int month);

    /**
     * 新增数据
     *
     * @param poop 实例对象
     * @return 实例对象
     */
    boolean insert(PoopPO poop);

    /**
     * 修改数据
     *
     * @param poop 实例对象
     * @return 实例对象
     */
    boolean updateById(PoopPO poop);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);
}