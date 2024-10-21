package com.thy.bbb_lbb.domain.bo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

/**
 * @author c4x
 * 2024-10-17 14:07:46
 */
@Schema(description = "BO")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserBO {

    @Schema(description = "")
    private Integer id;

    @Schema(description = "账号")
    private String code;

    @Schema(description = "")
    private String name;

    @Schema(description = "密码")
    private String password;
}
