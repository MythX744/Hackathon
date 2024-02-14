package com.example.Project.Model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUser;
    @Column(name="fullname")
    private String fullname;
    @Column(name="email")
    private String email;
    @Column(name="password")
    private String password;
    @Column(name="profil")
    private int profil;
    @Column(name="dob")
    private Date dob;
    @Column(name="phone")
    private int phone;
    @Column(name="address")
    private String address;

    public User() {
    }
    public User(int idUser, String fullname, String email, String password, int profil, Date dob, int phone, String address) {
        this.idUser = idUser;
        this.fullname = fullname;
        this.email = email;
        this.password = password;
        this.profil = profil;
        this.dob = dob;
        this.phone = phone;
        this.address = address;
    }
    public int getIdUser() {
        return idUser;
    }
    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getProfil() {
        return profil;
    }

    public void setProfil(int profil) {
        this.profil = profil;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "idUser=" + idUser +
                ", fullname='" + fullname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", profil='" + profil + '\'' +
                ", dob=" + dob +
                ", phone=" + phone +
                ", address='" + address + '\'' +
                '}';
    }
}
