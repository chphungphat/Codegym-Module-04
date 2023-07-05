package codegym.demoSpringBoot.dto.request;

import lombok.Data;

@Data
public class ProductCreateRequestDto {

    private String productName;

    private double price;
}
