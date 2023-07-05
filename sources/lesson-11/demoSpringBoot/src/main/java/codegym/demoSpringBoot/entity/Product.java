package codegym.demoSpringBoot.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class Product {
    private long id;

    private String productName;

    private double price;
}
