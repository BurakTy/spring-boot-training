package com.buraktuysuz.springboottraining.converter;
import com.buraktuysuz.springboottraining.dto.ProductDetailDto;
import com.buraktuysuz.springboottraining.dto.ProductDto;
import com.buraktuysuz.springboottraining.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductConverter {


    ProductConverter INSTANCE = Mappers.getMapper(ProductConverter.class);

    @Mapping(source = "categoryId", target = "category.id")
    Product convertProductDtoToProduct(ProductDto productDto);

    @Mapping(source = "category.id", target = "categoryId")
    ProductDto convertProductToProductDto(Product product);

    @Mapping(source = "price", target = "productPrice")
    @Mapping(source = "name", target = "productName")
    @Mapping(source = "category.name", target = "categoryName")
    ProductDetailDto convertProductToProductDetailDto(Product product);
}
