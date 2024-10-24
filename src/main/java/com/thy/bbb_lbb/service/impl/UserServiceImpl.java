package com.thy.bbb_lbb.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.thy.bbb_lbb.anno.UsePage;
import com.thy.bbb_lbb.mapper.UserMapper;
import com.thy.bbb_lbb.domain.po.UserPO;
import com.thy.bbb_lbb.domain.dto.UserDTO;
import com.thy.bbb_lbb.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * User服务
 *
 * @author c4x
 * 2024-10-17 14:07:39
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserPO> implements UserService {

    @Resource
    private UserMapper mapper;

    @Override
    public UserPO getDetails(Integer id) {
        return mapper.selectById(id);
    }

    @UsePage
    @Override
    public List<UserPO> listPage(UserDTO dto) {
        return mapper.listAll(dto);
    }

    @Override
    public boolean insert(UserPO user) {
        return mapper.insert(user) > 0;
    }

    @Override
    public boolean updateById(UserPO user) {
        return false;
    }

    @Override
    public boolean deleteById(Integer id) {
        return false;
    }

    @Override
    public UserPO login(UserDTO dto) {
        LambdaQueryWrapper<UserPO> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UserPO::getCode, dto.getCode());
        wrapper.eq(UserPO::getPassword, dto.getPassword());

        List<UserPO> poList = list(wrapper);

        return !poList.isEmpty() ? poList.get(0) : null;

    }

}
