package com.thy.bbb_lbb.service;


import com.thy.bbb_lbb.domain.po.UserPO;
import com.thy.bbb_lbb.domain.dto.UserDTO;

import java.util.List;

/**
 * User服务
 *
 * @author c4x
 * 2024-10-17 14:07:39
 */
public interface UserService {
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     * @author c4x
     * 2024-10-17 14:07:39
     */
    UserPO getDetails(Integer id);

    /**
     * 分页查询
     *
     * @param dto 查询条件
     * @return 所有数据
     * @author c4x
     * 2024-10-17 14:07:39
     */
    List<UserPO> listPage(UserDTO dto);

    /**
     * 新增数据，并记录操作人
     *
     * @param user 实例对象
     * @return 是否成功
     * @author c4x
     * 2024-10-17 14:07:39
     */
    boolean insert(UserPO user);

    /**
     * 通过主键更新数据，并记录操作人
     *
     * @param user 实例对象
     * @return 是否成功
     * @author c4x
     * 2024-10-17 14:07:39
     */
    boolean updateById(UserPO user);

    /**
     * 通过主键删除数据，并记录操作人
     *
     * @param id 主键
     * @return 是否成功
     * @author c4x
     * 2024-10-17 14:07:39
     */
    boolean deleteById(Integer id);
}
