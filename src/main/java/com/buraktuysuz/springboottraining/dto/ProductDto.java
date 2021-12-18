package com.buraktuysuz.springboottraining.dto;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;

public class ProductDto {
    private Long id;
    @Size(min = 2)
    private String name;
    private BigDecimal price;
    @Past // Sadece geçmiş bir tarih kabul eder
    private Date createDate;
    private Long categoryId;


    public Long getId() { return id; }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getCreateDate() {
        return createDate;
    }
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Long getCategoryId() {
        return categoryId;
    }
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
