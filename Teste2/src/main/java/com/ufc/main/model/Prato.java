package com.ufc.main.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "auth_prato")
public class Prato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prato_id")
    private Long id;

    @Column(name = "prato_nome")
    private String nome;

    @Column(name = "prato_desc")
    private String desc;

    @Column(name = "prato_preco")
    private float preco;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

}
