package com.plant_eshop_backend.controller;

import com.plant_eshop_backend.dto.ProductDto;
import com.plant_eshop_backend.dto.ProductResponse;
import com.plant_eshop_backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ManageProductController {


    @Autowired
    private ProductService productService;



    @PostMapping("/saveProduct")
    public ResponseEntity<ProductResponse> saveProducts(@RequestBody ProductDto productDto){
        ProductResponse product=productService.saveProduct(productDto);

            return new ResponseEntity(product, HttpStatus.ACCEPTED);


    }

    @GetMapping("/getAllProduct")
    public ResponseEntity<List<ProductDto>> getAllProducts(){
        return new ResponseEntity<>(productService.getAllProduct(),HttpStatus.OK) ;
    }


    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getById(@PathVariable("id")String pid){
        ProductResponse response=productService.getProductById(pid);
        return new ResponseEntity<>(response,HttpStatus.OK);

    }
}
