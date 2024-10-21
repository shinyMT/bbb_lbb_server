package com.thy.bbb_lbb.service.impl;


import com.thy.bbb_lbb.anno.UsePage;
import com.thy.bbb_lbb.mapper.UserMapper;
import com.thy.bbb_lbb.domain.po.UserPO;
import com.thy.bbb_lbb.domain.dto.UserDTO;
import com.thy.bbb_lbb.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * User服务
 *
 * @author c4x
 * 2024-10-17 14:07:39
 */
@Service(UserServiceImpl.TAG)
public class UserServiceImpl implements UserService {
    @SuppressWarnings("unused")
    public final static String TAG = "userService";

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
        return mapper.updateById(user) > 0;
    }

    @Override
    public boolean deleteById(Integer id) {
        return mapper.deleteById(id) > 0;
    }
}
