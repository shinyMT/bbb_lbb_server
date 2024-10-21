package com.thy.bbb_lbb.domain.dto;

import java.io.Serial;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;

/**
 * @author c4x
 * 2024-10-17 14:07:47
 */
@Schema(description = "DTO")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = -57791892899329910L;

    @Schema(description = "")
    private Integer id;

    @Schema(description = "")
    private String code;

    @Schema(description = "")
    private String name;

    @Schema(description = "")
    private String password;
}
