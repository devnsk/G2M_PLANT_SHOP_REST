package com.plant_eshop_backend.service.impl;

import com.plant_eshop_backend.Exception.ResourceNotFound;
import com.plant_eshop_backend.dto.*;
import com.plant_eshop_backend.entity.*;
import com.plant_eshop_backend.repository.*;
import com.plant_eshop_backend.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;

@Service
public class ProductServiceImpl implements ProductService {


    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private SizeRepo sizeRepo;

    @Autowired
    private ColorRepo colorRepo;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    @Transactional
    public ProductResponse saveProduct(ProductDto pdto) throws RuntimeException{
        Product product=null;
        boolean isProductMatch = productRepo.getAllProductNames()
                .anyMatch(name -> name.equalsIgnoreCase(pdto.getProductName()));
        if(isProductMatch){

            return new ProductResponse("Product already exist", false, HttpStatus.ACCEPTED , null);

        }
        else {
            if(pdto.getCatagoryName()!=null) {

                Product p = modelMapper.map(pdto, Product.class);
                try {
                    boolean isCategoryMatch = categoryRepo.getAllCategoryNames()
                            .anyMatch(name -> name.equalsIgnoreCase(pdto.getCatagoryName()));
                    System.out.println("IS Category"+isCategoryMatch);
                    if (isCategoryMatch) {
                        System.out.println("Category already present");
                        Category category = categoryRepo.getCategoryByName(pdto.getCatagoryName());
                        p.setCategory(category);
                    } else {
                        System.out.println("New Category Object created");
                        Category category = new Category();
                        category.setCategoryName(pdto.getCatagoryName());
                        category = categoryRepo.save(category);
                        p.setCategory(category);
                    }


                    for (ProductImage productImage : p.getProductImages()) {
                        System.out.println("For loop 1");
                        productImage.setProduct(p);
                    }

                    for (ProductSize productSize : p.getProductSizes()) {
                        Size size = new Size();
                        size.setSizeName(productSize.getSize().getSizeName());
                        size.setSizePrice(productSize.getSize().getSizePrice());
                        size = sizeRepo.save(size);
                        productSize.setSize(size);
                        productSize.setProduct(p);
                        System.out.println("For loop 2");
                    }
                    for (ProductColor productColor : p.getProductColors()) {
                        Color color = new Color();
                        color.setColorName(productColor.getColor().getColorName());
                        color.setColorPrice(productColor.getColor().getColorPrice());
                        color = colorRepo.save(color);
                        productColor.setColor(color);
                        productColor.setProduct(p);
                        System.out.println("For loop 3");
                    }
                    product = productRepo.save(p);

                }catch (Exception e){
                    System.out.println(e.getMessage());
                }

                return product != null
                        ? new ProductResponse("Product Successfully Inserted", true, HttpStatus.ACCEPTED, pdto)
                        : new ProductResponse("Failed To Insert", false, HttpStatus.NOT_FOUND, null);
            }
            else {
                return new ProductResponse("Category Name Not found", false, HttpStatus.NOT_FOUND, null);
            }
        }
    }

    @Override
    public List<ProductDto> getAllProduct() throws RuntimeException {
        List<ProductDto> productDtos=new ArrayList<>();
        List<Product> productList=productRepo.findAll();
        for(Product product:productList){
            ProductDto productDto=modelMapper.map(product,ProductDto.class);
            productDto.setCatagoryName(product.getCategory().getCategoryName());
            productDtos.add(productDto);
        }
        return productDtos;
    }

    @Override
    public ProductResponse getProductById(String pid) {
       Product product= productRepo.findById(pid).orElseThrow(() -> new ResourceNotFound("Product not found with id: "+pid ));
       ProductDto pdto=modelMapper.map(product,ProductDto.class);
       pdto.setCatagoryName(product.getCategory().getCategoryName());

        return product.getProductId() != null
                ? new ProductResponse("Product Successfully Selected", true, HttpStatus.ACCEPTED, pdto)
                : new ProductResponse("Failed Select Product", false, HttpStatus.NOT_FOUND, null);
    }
}
