package com.thy.bbb_lbb.controller;


import com.thy.bbb_lbb.domain.po.PoopPO;
import com.thy.bbb_lbb.domain.vo.PoopVO;
import com.thy.bbb_lbb.result.ResultBody;
import com.thy.bbb_lbb.service.PoopService;
import com.thy.bbb_lbb.util.BeanUtils;
import com.github.pagehelper.PageInfo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author thy
 * 2024-10-17 14:47:26
 */
@RestController
@RequestMapping("/poop")
@Tag(name = "Poop相关接口")
@Validated
public class PoopController {
    private final PoopService service;

    PoopController(PoopService service) {
        this.service = service;
    }

    /**
     * 根据年份月份查询
     *
     * @return 所有数据
     */
    @Operation(summary = "分页查询", description = "分页查询")
    @GetMapping("/listByYearMonth")
    public ResultBody<List<PoopPO>> listByYearMonth(@Parameter(name = "年份") @RequestParam int year, @Parameter(name = "月份") @RequestParam int month) {
        final var rawList = service.listByYearMonth(year, month);
        return ResultBody.ok(rawList);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @Operation(summary = "查询详情", description = "通过主键查询单条数据")
    @GetMapping("/details")
    public ResultBody<PoopVO> getDetails(@Parameter(required = true, description = "主键") @NotBlank(message = "invalid id") Integer id) {
        final var po = service.getDetails(id);
        final var vo = BeanUtils.convertBean(po, PoopVO.class);
        return ResultBody.ok(vo);
    }

    /**
     * 新增数据
     *
     * @param poop 实体对象
     * @return 新增结果
     */
    @PostMapping("/insert")
    @Operation(summary = "新增数据", description = "新增数据")
    public ResultBody<String> insert(@RequestBody @Valid PoopPO poop) {
        service.insert(poop);
        return ResultBody.ok();
    }

    /**
     * 修改数据
     *
     * @param poop 实体对象
     * @return 修改结果
     */
    @Operation(summary = "修改数据", description = "修改数据")
    @PostMapping("/update")
    public ResultBody<String> updateById(@RequestBody @Valid PoopPO poop) {
        service.updateById(poop);
        return ResultBody.ok();
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除结果
     */
    @GetMapping("/delete")
    @Operation(summary = "删除数据", description = "删除数据")
    public ResultBody<String> deleteById(@Parameter(required = true, description = "主键") @NotBlank(message = "invalid id") Integer id) {
        service.deleteById(id);
        return ResultBody.ok();
    }
}