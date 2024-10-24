package com.thy.bbb_lbb.controller;

import com.github.pagehelper.PageInfo;
import com.thy.bbb_lbb.domain.dto.UserDTO;
import com.thy.bbb_lbb.domain.po.UserPO;
import com.thy.bbb_lbb.domain.vo.UserVO;
import com.thy.bbb_lbb.result.GlobalException;
import com.thy.bbb_lbb.result.ResultBody;
import com.thy.bbb_lbb.service.UserService;
import com.thy.bbb_lbb.util.BeanUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

/**
 * @author c4x
 * 2024-10-17 14:07:38
 */
@RestController
@RequestMapping("/user")
@Tag(name = "User相关接口")
@Validated
public class UserController {
    private final UserService service;

    UserController(UserService service) {
        this.service = service;
    }

    /**
     * 分页查询
     *
     * @return 所有数据
     * @author c4x
     * 2024-10-17 14:07:38
     */
    @Operation(summary = "分页查询", description = "分页查询")
    @PostMapping("/listPage")
    public ResultBody<PageInfo<UserVO>> listPage(@RequestBody UserDTO dto) {
        final var rawList = service.listPage(dto);
        final var page = BeanUtils.convertPage(rawList, UserVO.class);
        return ResultBody.ok(page);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     * @author c4x
     * 2024-10-17 14:07:38
     */
    @Operation(summary = "查询详情", description = "通过主键查询单条数据")
    @GetMapping("/details")
    public ResultBody<UserVO> getDetails(@Parameter(required = true, description = "主键") @NotNull(message = "invalid id") Integer id) {
        final var po = service.getDetails(id);
        final var vo = BeanUtils.convertBean(po, UserVO.class);
        return ResultBody.ok(vo);
    }

    /**
     * 登录验证
     */
    @Operation(summary = "登录验证", description = "登录验证")
    @PostMapping("/login")
    public ResultBody<UserPO> login(@Parameter(required = true) @RequestBody UserDTO dto) {
        // 通过wrapper查询数据库中是否有账号密码匹配的数据，没有则抛出错误
        UserPO user = service.login(dto);
        if (user != null) {
            return ResultBody.ok(user);
        } else {
            throw new GlobalException("账号或密码错误");
        }
    }

    /**
     * 新增数据
     *
     * @param user 实体对象
     * @return 新增结果
     * @author c4x
     * 2024-10-17 14:07:38
     */
//    @PostMapping("/insert")
//    @Operation(summary = "新增数据", description = "新增数据")
//    public ResultBody<String> insert(@RequestBody @Valid UserPO user) {
//        if (service.insertWithAccount(user)) {
//            return ResultBody.ok();
//        }
//        throw new GlobalException("新增失败");
//    }

    /**
     * 修改数据
     *
     * @param user 实体对象
     * @return 修改结果
     * @author c4x
     * 2024-10-17 14:07:38
     */
//    @Operation(summary = "修改数据", description = "修改数据")
//    @PostMapping("/update")
//    public ResultBody<String> updateById(@RequestBody @Valid UserPO user) {
//        if (service.updateByIdWithAccount(user)) {
//            return ResultBody.ok();
//        }
//        throw new GlobalException("修改失败");
//    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除结果
     * @author c4x
     * 2024-10-17 14:07:38
     */
//    @GetMapping("/delete")
//    @Operation(summary = "删除数据", description = "删除数据")
//    public ResultBody<String> deleteById(@Parameter(required = true, description = "主键") @NotNull(message = "invalid id") Integer id) {
//        if (service.removeByIdWithAccount(id)) {
//            return ResultBody.ok();
//        }
//        throw new GlobalException("删除失败");
//    }
}
