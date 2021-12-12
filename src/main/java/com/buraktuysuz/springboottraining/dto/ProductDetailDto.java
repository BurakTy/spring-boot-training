package com.buraktuysuz.springboottraining.dto;

import java.math.BigDecimal;

public class ProductDetailDto {
    private String productName;
    private String categoryName;
    private BigDecimal productPrice;

    public ProductDetailDto() {
    }

    public ProductDetailDto(String urunAdi, String kategoriAdi, BigDecimal urunFiyati) {
        this.productName = urunAdi;
        this.categoryName = kategoriAdi;
        this.productPrice = urunFiyati;
    }

    public String getUrunAdi() {
        return productName;
    }
    public void setUrunAdi(String urunAdi) { this.productName = urunAdi; }

    public String getKategoriAdi() {
        return categoryName;
    }
    public void setKategoriAdi(String kategoriAdi) {
        this.categoryName = kategoriAdi;
    }

    public BigDecimal getUrunFiyati() {
        return productPrice;
    }
    public void setUrunFiyati(BigDecimal urunFiyati) {
        this.productPrice = urunFiyati;
    }

    @Override
    public String toString() {
        return "UrunDetayDto{" +
                "urunAdi='" + productName + '\'' +
                ", kategoriAdi='" + categoryName + '\'' +
                ", urunFiyati=" + productPrice +
                '}';
    }
}
