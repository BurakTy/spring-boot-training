package com.buraktuysuz.springboottraining.converter;

import com.buraktuysuz.springboottraining.dto.CategoryDto;
import com.buraktuysuz.springboottraining.dto.ProductDto;
import com.buraktuysuz.springboottraining.entity.Category;
import com.buraktuysuz.springboottraining.entity.Product;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryConverter {

    CategoryConverter INSTANCE = Mappers.getMapper(CategoryConverter.class);

//    @Mapping(target = "upperCategory.id", source = "upperCategoryId")
//    Category convertCategoryDtoToCategory(CategoryDto categoryDto);

    @Mapping(target = "upperCategoryId", source = "upperCategory.id")
    CategoryDto convertCategoryToCategoryDto(Category category);

    @Mapping(target = "upperCategoryId", source = "upperCategory.id")
    List<CategoryDto> convertCategoryListToCategoryDtoList(List<Category> categoryList);

    @Mapping(target = "upperCategory.id", source = "upperCategoryId")
    Category convertCategoryDtoToCategory(CategoryDto categoryDto);

    @AfterMapping()
    default void setNulls(@MappingTarget() final Product product, ProductDto productDto){
        if(productDto.getCategoryId()==null){
            product.setCategory(null);
        }
    }

//    @Named("categoryIdToCategory")  //kullanmak için qualifiedByName = "categoryIdToCategory"
//    public static Category categoryIdToCategory(Long upperCategoryId) {
//        if (upperCategoryId == null) {
//            return null;
//        } else {
//            Category cat = new Category();
//            cat.setId(upperCategoryId);
//            return cat;
//        }
//    }
}
