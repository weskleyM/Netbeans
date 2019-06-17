package com.ufc.main.model;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "auth_user")
public class User {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "auth_user_id")
     private int id;

     @NotNull(message = "Campo usuário é obrigatório")
     @Column(name = "usuario")
     private String usuario;

     @NotNull(message = "Campo usuário é obrigatório")
     @Email(message = "Email inválido")
     @Column(name = "email")
     private String email;

     @NotNull(message = "Campo usuário é obrigatório")
     @Length(min = 5, message = "Mínimo de 5 digitos")
     @Column(name = "senha")
     private String senha;

     @Column(name = "status")
     private String status;

     @ManyToMany(cascade = CascadeType.ALL)
     @JoinTable(name = "auth_user_role", joinColumns = @JoinColumn(name = "auth_user_id"), inverseJoinColumns = @JoinColumn(name = "auth_role_id"))
     private Set<Role> roles;

     public int getId() {
          return id;
     }

     public void setId(int id) {
          this.id = id;
     }

     public String getUsuario() {
          return usuario;
     }

     public void setUsuario(String usuario) {
          this.usuario = usuario;
     }

     public String getEmail() {
          return email;
     }

     public void setEmail(String email) {
          this.email = email;
     }

     public String getSenha() {
          return senha;
     }

     public void setSenha(String senha) {
          this.senha = senha;
     }

     public String getStatus() {
          return status;
     }

     public void setStatus(String status) {
          this.status = status;
     }

     public Set<Role> getRoles() {
          return roles;
     }

     public void setRoles(Set<Role> roles) {
          this.roles = roles;
     }

}
