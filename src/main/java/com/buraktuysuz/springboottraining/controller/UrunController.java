package com.buraktuysuz.springboottraining.controller;

import com.buraktuysuz.springboottraining.dto.ProductDetailDto;
import com.buraktuysuz.springboottraining.entity.Category;
import com.buraktuysuz.springboottraining.entity.Product;
import com.buraktuysuz.springboottraining.service.entitySevice.CategoryEntitySevice;
import com.buraktuysuz.springboottraining.service.entitySevice.ProductEntityService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
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

    @GetMapping("/products")
    public List<Product> findAllProductList() {
        return productEntityService.findAll();
    }

    @GetMapping("/products/{id}")
    public Product findProductById(@PathVariable Long id) {
        return productEntityService.findById(id);
    }

    @GetMapping("/products/dto/{id}")
    public ProductDetailDto findProductDtoById(@PathVariable Long id) {

        Product product = productEntityService.findById(id);

        ProductDetailDto productDetailDto = convertProductToProductDetailDto(product);

        return productDetailDto;
    }

    private ProductDetailDto convertProductToProductDetailDto(Product product) {
        Category category = categoryEntitySevice.findById(product.getKategori().getId());

        ProductDetailDto productDetayDto = new ProductDetailDto();
        productDetayDto.setUrunAdi(product.getAdi());
        productDetayDto.setUrunFiyati(product.getFiyat());
        productDetayDto.setKategoriAdi(category.getAdi());
        return productDetayDto;
    }

}
