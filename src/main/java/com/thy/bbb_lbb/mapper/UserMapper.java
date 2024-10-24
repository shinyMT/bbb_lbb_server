package com.thy.bbb_lbb.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

import com.thy.bbb_lbb.domain.po.UserPO;
import com.thy.bbb_lbb.domain.dto.UserDTO;

/**
 * @author c4x
 * 2024-10-17 14:07:42
 */
@Mapper
public interface UserMapper extends BaseMapper<UserPO> {
    /**
     * 列出全部
     *
     * @param dto 查询条件
     * @return list结果集
     * @author c4x
     * 2024-10-17 14:07:42
     */
    List<UserPO> listAll(UserDTO dto);

    /**
     * 登录验证
     * @author thy
     * 2024-10-21 14:50:00
     * */
    UserPO login(UserDTO dto);
}
