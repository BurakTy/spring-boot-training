package com.buraktuysuz.springboottraining.controller;

import com.buraktuysuz.springboottraining.dto.ProductDetailDto;
import com.buraktuysuz.springboottraining.dto.ProductDto;
import com.buraktuysuz.springboottraining.entity.Category;
import com.buraktuysuz.springboottraining.entity.Product;
import com.buraktuysuz.springboottraining.exception.ProductNotFoundException;
import com.buraktuysuz.springboottraining.service.entitySevice.CategoryEntitySevice;
import com.buraktuysuz.springboottraining.service.entitySevice.ProductEntityService;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/api/products/")
public class UrunController {

    ProductEntityService productEntityService;
    CategoryEntitySevice categoryEntitySevice;

    public UrunController(ProductEntityService productEntityService, CategoryEntitySevice categoryEntitySevice) {
        this.productEntityService = productEntityService;
        this.categoryEntitySevice = categoryEntitySevice;
    }

    @GetMapping("merhaba")
    public String merhaba() {
        return "Merhaba Dünya";
    }

    @GetMapping("")
    public List<Product> findAllProductList() {
        return productEntityService.findAll();
    }

    @GetMapping("{id}")
    public EntityModel<Product> findProductById(@PathVariable Long id) {

        Product product = productEntityService.findById(id);
        if (product == null) {
            throw new ProductNotFoundException("Product Not Found : " + id);
        }
        WebMvcLinkBuilder linkToProduct = WebMvcLinkBuilder.linkTo(
                WebMvcLinkBuilder.methodOn(this.getClass())
                        .findAllProductList()
        );
        EntityModel entityModel= EntityModel.of(product).add(linkToProduct.withRel("all products"));

        return entityModel;
    }

    @DeleteMapping("{id}")
    public Product deleteProductById(@PathVariable Long id) {

        Product product = productEntityService.findById(id);
        if (product == null) {
            throw new ProductNotFoundException("Product Not Found : " + id);
        }
        return product;
    }

    @PostMapping("")
    public ResponseEntity<Object> saveProduct(@RequestBody ProductDto productDto) {

        Product product = convertProductDtotooProduct(productDto);
        product=productEntityService.save(product);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(product.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    @GetMapping("dto/{id}")
    public ProductDetailDto findProductDtoById(@PathVariable Long id) {

        Product product = productEntityService.findById(id);

        ProductDetailDto productDetailDto = convertProductToProductDetailDto(product);

        return productDetailDto;
    }

    private ProductDetailDto convertProductToProductDetailDto(Product product) {
        Category category = categoryEntitySevice.findById(product.getCategory().getId());

        ProductDetailDto productDetayDto = new ProductDetailDto();
        productDetayDto.setUrunAdi(product.getName());
        productDetayDto.setUrunFiyati(product.getPrice());
        productDetayDto.setKategoriAdi(category.getName());
        return productDetayDto;
    }
    private Product convertProductDtotooProduct(ProductDto productDto) {
        Category category = categoryEntitySevice.findById(productDto.getCategoryId());

        Product prod = new Product();
        prod.setName(productDto.getName());
        prod.setPrice(productDto.getPrice());
        prod.setCreateDate(productDto.getCreateDate());
        prod.setCategory(category);

        return prod;
    }

}
