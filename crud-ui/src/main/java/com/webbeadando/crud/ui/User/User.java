package com.webbeadando.crud.ui.User;

import jakarta.persistence.*;

@Entity
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String Vezeteknev;

    @Column
    private String Keseresztnev;

    @Column
    private int Telefonszam;

    @Column
    private String Problema;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVezeteknev() {
        return Vezeteknev;
    }

    public void setVezeteknev(String vezeteknev) {
        Vezeteknev = vezeteknev;
    }

    public String getKeseresztnev() {
        return Keseresztnev;
    }

    public void setKeseresztnev(String keseresztnev) {
        Keseresztnev = keseresztnev;
    }

    public int getTelefonszam() {
        return Telefonszam;
    }

    public void setTelefonszam(int telefonszam) {
        Telefonszam = telefonszam;
    }

    public String getProblema() {
        return Problema;
    }

    public void setProblema(String problema) {
        Problema = problema;
    }
}
