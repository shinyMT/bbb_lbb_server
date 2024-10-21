package com.thy.bbb_lbb.domain.bo;

/**
 * @author c4x
 * date 2022/3/30
 * description
 */
public interface ICodeNameEnum {
    int getCode();

    String getName();

    ICodeNameEnum getByCode(String code);
}
