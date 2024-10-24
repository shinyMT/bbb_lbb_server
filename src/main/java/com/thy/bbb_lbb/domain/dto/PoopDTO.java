package com.thy.bbb_lbb.domain.dto;

import java.util.Date;
import java.io.Serial;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;

/**
 * @author thy
 * 2024-10-17 14:47:27
 */
@Schema(description = "DTO")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PoopDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = -24597859774343636L;

    @Schema(description = "")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date poopTime;

    @Schema(description = "年份")
    private int year;

    @Schema(description = "月份")
    private int month;
}
