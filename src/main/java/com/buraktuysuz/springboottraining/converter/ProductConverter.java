package com.buraktuysuz.springboottraining.converter;
import com.buraktuysuz.springboottraining.dto.ProductDetailDto;
import com.buraktuysuz.springboottraining.dto.ProductDto;
import com.buraktuysuz.springboottraining.entity.Product;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductConverter {


    ProductConverter INSTANCE = Mappers.getMapper(ProductConverter.class);

    @Mapping(target = "category.id",source = "categoryId")
    Product convertProductDtoToProduct(ProductDto productDto);

    @Mapping( target = "categoryId",source = "category.id")
    ProductDto convertProductToProductDto(Product product);

    @Mapping(source = "price", target = "productPrice")
    @Mapping(source = "name", target = "productName")
    @Mapping(source = "category.name", target = "categoryName")
    ProductDetailDto convertProductToProductDetailDto(Product product);

    @AfterMapping()
    default void setNulls(@MappingTarget() final Product product,ProductDto productDto){
        if(productDto.getCategoryId()==null){
            product.setCategory(null);
        }
    }
}
