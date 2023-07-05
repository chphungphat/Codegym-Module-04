package codegym.demoSpringBoot.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ProductResponseDTO {
    private long id;

    @JsonProperty(value = "productName")
    private String productName;

    private double price;
}
