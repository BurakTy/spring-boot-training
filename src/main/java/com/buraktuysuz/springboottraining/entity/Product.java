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

    @Column(length = 50)
    private String adi;

    @Column(precision = 19,scale = 2)
    private BigDecimal fiyat;

    @Column(name="kayit_tarihi")
    @Temporal(TemporalType.TIMESTAMP)
    private Date kayitTarihi;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_kategori",foreignKey = @ForeignKey(name = "fk_urun_kategori_id"))
    private Category kategori;

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public String getAdi() {return adi;}
    public void setAdi(String adi) { this.adi = adi;}

    public BigDecimal getFiyat() { return fiyat;}
    public void setFiyat(BigDecimal fiyat) { this.fiyat = fiyat;}

    public Date getKayitTarihi() { return kayitTarihi;}
    public void setKayitTarihi(Date kayitTarihi) { this.kayitTarihi = kayitTarihi;}

    public Category getKategori() { return kategori;}
    public void setKategori(Category kategori) { this.kategori = kategori;}

    @Override
    public String toString() {
        return "Urun{" +
                "id=" + id +
                ", adi='" + adi + '\'' +
                ", fiyat=" + fiyat +
                ", kayitTarihi=" + kayitTarihi +
                ", kategori=" + kategori +
                '}';
    }
}
