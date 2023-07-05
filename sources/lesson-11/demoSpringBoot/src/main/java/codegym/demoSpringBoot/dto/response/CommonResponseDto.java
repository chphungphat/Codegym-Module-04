package codegym.demoSpringBoot.dto.response;

import lombok.Data;

@Data
public class CommonResponseDto {
    private Boolean success;

    private String message;

    private Object data;
}
