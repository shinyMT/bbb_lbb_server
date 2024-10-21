package com.thy.bbb_lbb.domain.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

/**
 * @author c4x
 * 2024-10-17 14:07:46
 */
@Schema(description = "VO")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVO {

    @Schema(description = "")
    private Integer id;

    @Schema(description = "")
    private String code;

    @Schema(description = "")
    private String name;

    @Schema(description = "")
    private String password;
}
