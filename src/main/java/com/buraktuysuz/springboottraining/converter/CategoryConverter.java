package com.buraktuysuz.springboottraining.converter;

import com.buraktuysuz.springboottraining.dto.CategoryDto;
import com.buraktuysuz.springboottraining.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryConverter {

    CategoryConverter INSTANCE = Mappers.getMapper(CategoryConverter.class);

    @Mapping(source = "upperCategoryId", target = "upperCategory.id")
    Category convertCategoryDtoToCategory(CategoryDto categoryDto);

}
