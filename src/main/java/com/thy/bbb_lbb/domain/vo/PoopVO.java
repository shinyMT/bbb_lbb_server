package com.thy.bbb_lbb.domain.vo;

import java.util.Date;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

/**
 * @author thy
 * 2024-10-17 14:47:27
 */
@Schema(description = "VO")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PoopVO {

    @Schema(description = "")
    private Integer id;

    @Schema(description = "")
    private Integer userId;

    @Schema(description = "")
    private Date poopTime;
}
