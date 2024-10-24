package com.thy.bbb_lbb.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.thy.bbb_lbb.domain.bo.PoopBO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

import com.thy.bbb_lbb.domain.po.PoopPO;

/**
 * @author thy
 * 2024-10-17 14:47:27
 */
@Mapper
public interface PoopMapper extends BaseMapper<PoopPO> {
    /**
     * 分页查询
     *
     * @return list结果集
     */
    List<PoopPO> listByYearMonth(int userId, String year, String month);

    /**
     * 根据年份统计结果
     * */
    List<PoopBO> listStatisticsByYear(int year, int userId);
}
