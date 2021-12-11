package com.buraktuysuz.springboottraining.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table(name = "kategori")
public class Category implements Serializable {
    @SequenceGenerator(name="generator", sequenceName = "kategori_id_seq")
    @Id
    @GeneratedValue(generator = "generator",strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "adi",nullable = false,length = 50)
    private String adi;

    @Column(name="kirilim")
    private Long kirilim;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="id_ust_kategori",foreignKey = @ForeignKey(name = "fk_kategori_kategori_id"))
    private Category ustKategori;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id;}

    public String getAdi() { return adi; }
    public void setAdi(String adi) { this.adi = adi; }

    public Long getKirilim() { return kirilim; }
    public void setKirilim(Long kirilim) { this.kirilim = kirilim; }

    public Category getUstKategori() { return ustKategori; }
    public void setUstKategori(Category ustKategori) {  this.ustKategori = ustKategori; }

    @Override
    public String toString() {
        return "Kategori{" +
                "id=" + id +
                ", adi='" + adi + '\'' +
                ", kirilim=" + kirilim +
                ", ustKategori=" + ustKategori +
                '}';
    }
}
