package codegym.demoSpringBoot.controller;

import codegym.demoSpringBoot.dto.request.ProductCreateRequestDto;
import codegym.demoSpringBoot.dto.request.ProductUpdateRequestDto;
import codegym.demoSpringBoot.dto.response.CommonResponseDto;
import codegym.demoSpringBoot.dto.response.ProductResponseDTO;
import codegym.demoSpringBoot.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<?> getAllProduct(){
        List<ProductResponseDTO> body = productService.getAllProduct();
        CommonResponseDto commonResponseDto = new CommonResponseDto();
        commonResponseDto.setSuccess(true);
        commonResponseDto.setMessage("Success");
        commonResponseDto.setData(body);
        return new ResponseEntity<>(commonResponseDto, HttpStatus.OK);
    }

    @PostMapping("/product")
    public ResponseEntity<?> addProduct(@RequestBody ProductCreateRequestDto requestDto){
        ProductResponseDTO responseDTO = productService.addProduct(requestDto);
        CommonResponseDto commonResponseDto = new CommonResponseDto();
        commonResponseDto.setSuccess(true);
        commonResponseDto.setMessage("Success");
        commonResponseDto.setData(responseDTO);
        return new ResponseEntity<>(commonResponseDto, HttpStatus.OK);
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable("id") long id,
                                           @RequestBody ProductUpdateRequestDto requestDto){
        try{
            ProductResponseDTO responseDTO = productService.updateProduct(id, requestDto);
            CommonResponseDto commonResponseDto = new CommonResponseDto();
            commonResponseDto.setSuccess(true);
            commonResponseDto.setMessage("Success");
            commonResponseDto.setData(responseDTO);
            return new ResponseEntity<>(commonResponseDto, HttpStatus.OK);
        } catch (Exception e){
            CommonResponseDto commonResponseDto = new CommonResponseDto();
            commonResponseDto.setSuccess(false);
            commonResponseDto.setMessage(e.getMessage());
            commonResponseDto.setData(null);
            log.error(e.getMessage());
            return new ResponseEntity<>(commonResponseDto, HttpStatus.BAD_REQUEST);
        }

    }
}
