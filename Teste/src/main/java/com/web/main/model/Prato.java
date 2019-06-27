package com.web.main.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "auth_prato")
public class Prato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prato_id")
    private Integer id;

    @Column(name = "prato_nome")
    private String pnome;

    @Column(name = "prato_preco")
    private String preco;

    private int status;

    @OneToMany(mappedBy = "prato", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Item> itens;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPnome() {
        return pnome;
    }

    public void setPnome(String pnome) {
        this.pnome = pnome;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

}
