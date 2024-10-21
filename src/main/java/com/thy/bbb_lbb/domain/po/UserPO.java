package com.thy.bbb_lbb.domain.po;

import java.io.Serial;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;

/**
 * @author c4x
 * 2024-10-17 14:07:45
 */
@TableName("user")
@Schema(description = "")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UserPO extends Model<UserPO> implements Serializable {
    @Serial
    private static final long serialVersionUID = 590462156805042820L;

    @Schema(description = "")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @Schema(description = "")
    @TableField(value = "code")
    private String code;

    @Schema(description = "")
    @TableField(value = "name")
    private String name;

    @Schema(description = "")
    @TableField(value = "password")
    private String password;
}
