package codegym.demoSpringBoot.service;

import codegym.demoSpringBoot.dto.request.ProductCreateRequestDto;
import codegym.demoSpringBoot.dto.request.ProductUpdateRequestDto;
import codegym.demoSpringBoot.dto.response.ProductResponseDTO;

import java.util.List;

public interface ProductService {
    List<ProductResponseDTO> getAllProduct();

    ProductResponseDTO addProduct(ProductCreateRequestDto requestDto);


    ProductResponseDTO updateProduct(long id, ProductUpdateRequestDto requestDto);
}
