package com.thy.bbb_lbb.anno;

import java.lang.annotation.*;

/**
 * 分页注解，配合PageHelper使用
 *
 * @author c4x
 * 2023-5-5
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface UsePage {

    ParamSource value() default ParamSource.PARAMS;

    /**
     * 参数来源
     *
     * @author c4x
     * 2023-5-5 13:38
     */
    enum ParamSource {
        HEADERS,// 来自Headers
        PARAMS  // 来自params
    }
}
