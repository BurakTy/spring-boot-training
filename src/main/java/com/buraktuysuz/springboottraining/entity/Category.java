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
    private String name;

    @Column(name="kirilim")
    private Long depth;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="id_ust_kategori",foreignKey = @ForeignKey(name = "fk_kategori_kategori_id"))
    private Category upperCategory;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id;}

    public String getName() { return name; }
    public void setName(String adi) { this.name = adi; }

    public Long getDepth() { return depth; }
    public void setKirilim(Long kirilim) { this.depth = kirilim; }

    public Category getUpperCategory() { return upperCategory; }
    public void setUstKategori(Category upperCategory) {  this.upperCategory = upperCategory; }

    @Override
    public String toString() {
        return "Kategori{" +
                "id=" + id +
                ", adi='" + name + '\'' +
                ", kirilim=" + depth +
                ", ustKategori=" + upperCategory +
                '}';
    }
}
