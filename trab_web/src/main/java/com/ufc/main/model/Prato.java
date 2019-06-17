package com.ufc.main.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "prato")
public class Prato {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "cod")
     private int cod;

     @Column(name = "nome")
     private String nome;

     @Column(name = "desc")
     private String desc;

     @Column(name = "preco")
     private float preco;

     public int getCod() {
          return cod;
     }

     public void setCod(int cod) {
          this.cod = cod;
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
