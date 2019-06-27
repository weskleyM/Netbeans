package com.web.main.model;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
    @Temporal(TemporalType.DATE)
    private Date pDate;

    private float total;

    private int status;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Item> items;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    private String endEntrega;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getpDate() {
        return pDate;
    }

    public void setpDate(Date pDate) {
        this.pDate = pDate;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getEndEntrega() {
        return endEntrega;
    }

    public void setEndEntrega(String endEntrega) {
        this.endEntrega = endEntrega;
    }

}
