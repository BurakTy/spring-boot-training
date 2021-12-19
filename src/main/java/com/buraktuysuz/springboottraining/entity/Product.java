package com.buraktuysuz.springboottraining.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table(name = "urun")
public class Product implements Serializable {

    @SequenceGenerator(name="generator", sequenceName = "urun_id_seq")
    @Id
    @GeneratedValue(generator = "generator",strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(length = 50,name = "adi")
    private String name;

    @Column(name="fiyat",precision = 19,scale = 2)
    private BigDecimal price;

    @Column(name="kayit_tarihi")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_kategori",foreignKey = @ForeignKey(name = "fk_urun_kategori_id"))
    private Category category;

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public String getName() {return name;}
    public void setName(String adi) { this.name = adi;}

    public BigDecimal getPrice() { return price;}
    public void setPrice(BigDecimal price) { this.price = price;}

    public Date getCreateDate() { return createDate;}
    public void setCreateDate(Date createDate) { this.createDate = createDate;}

    public Category getCategory() { return category;}
    public void setCategory(Category category) { this.category = category;}

    @Override
    public String toString() {
        return "Urun{" +
                "id=" + id +
                ", adi='" + name + '\'' +
                ", fiyat=" + price +
                ", kayitTarihi=" + createDate +
                ", kategori=" + category +
                '}';
    }
}
