package com.buraktuysuz.springboottraining.dto;

public class CategoryDto {

    private Long id;
    private String name;
    private Long depth;
    private Long upperCategoryId;


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id;  }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Long getDepth() { return depth; }
    public void setDepth(Long depth) { this.depth = depth; }

    public Long getUpperCategoryId() { return upperCategoryId; }
    public void setUpperCategoryId(Long upperCategoryId) { this.upperCategoryId = upperCategoryId; }
}
