package codegym.demoSpringBoot.service.impl;

import codegym.demoSpringBoot.dto.request.ProductCreateRequestDto;
import codegym.demoSpringBoot.dto.request.ProductUpdateRequestDto;
import codegym.demoSpringBoot.dto.response.ProductResponseDTO;
import codegym.demoSpringBoot.entity.Product;
import codegym.demoSpringBoot.mapper.ProductMapper;
import codegym.demoSpringBoot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private static List<Product> products;

    @Autowired
    private ProductMapper productMapper;

    static {
        products = new ArrayList<Product>();
        products.add(Product.builder()
                .id(1)
                .productName("quan tay")
                .price(100).build());
        products.add(Product.builder()
                .id(2)
                .productName("quan nam")
                .price(200).build());
        products.add(Product.builder()
                .id(3)
                .productName("quan nu")
                .price(300).build());

    }

    @Override
    public List<ProductResponseDTO> getAllProduct() {
        List<Product> productList = products;

        return productMapper.entitiesToDtos(productList);
    }

    @Override
    public ProductResponseDTO addProduct(ProductCreateRequestDto requestDto) {
        Product product = Product.builder()
                .id(products.size() + 1)
                .productName(requestDto.getProductName())
                .price(requestDto.getPrice())
                .build();
        products.add(product);

        return productMapper.entityToDto(product);
    }

    @Override
    public ProductResponseDTO updateProduct(long id, ProductUpdateRequestDto requestDto) {
        // check id invalid
        Product currentProduct = products.stream().filter(element -> element.getId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("invalid id"));
        currentProduct.setPrice(requestDto.getPrice());

        return productMapper.entityToDto(currentProduct);
    }
}
