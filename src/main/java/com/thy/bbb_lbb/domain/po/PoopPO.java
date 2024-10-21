package com.thy.bbb_lbb.domain.po;

import java.util.Date;
import java.io.Serial;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;

/**
 * @author thy
 * 2024-10-17 14:47:27
 */
@TableName("Poop")
@Schema(description = "")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PoopPO extends Model<PoopPO> implements Serializable {
    @Serial
    private static final long serialVersionUID = -73714110713620909L;

    @Schema(description = "")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @Schema(description = "")
    @TableField(value = "user_id")
    private Integer userId;

    @Schema(description = "")
    @TableField(value = "poop_time")
    private Date poopTime;
}
