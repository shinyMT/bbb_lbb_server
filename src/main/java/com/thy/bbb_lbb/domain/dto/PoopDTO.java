package com.thy.bbb_lbb.domain.dto;

import java.util.Date;
import java.io.Serial;

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
    private Integer id;

    @Schema(description = "")
    private Integer userId;

    @Schema(description = "")
    private Date poopTime;
}
