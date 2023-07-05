package codegym.demoSpringBoot.mapper;

import codegym.demoSpringBoot.dto.response.ProductResponseDTO;
import codegym.demoSpringBoot.entity.Product;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductMapper {
    public List<ProductResponseDTO> entitiesToDtos(List<Product> productList) {
       return productList.stream()
               .map(this::entityToDto)
               .toList();
    }

    public ProductResponseDTO entityToDto(Product element) {
        ProductResponseDTO result = new ProductResponseDTO();
        BeanUtils.copyProperties(element, result);
        return result;
    }

}
