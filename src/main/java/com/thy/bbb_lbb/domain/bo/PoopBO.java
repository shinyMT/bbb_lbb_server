package com.thy.bbb_lbb.domain.bo;

import java.util.Date;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

/**
 * @author thy
 * 2024-10-17 14:47:27
 */
@Schema(description = "BO")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PoopBO {
    @Schema(description = "月份")
    private int month;

    @Schema(description = "次数")
    private int num;
}
