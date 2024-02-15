package com.example.Project.Model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "USERS")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String fullname;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "profile")
    private String profile;

    @Column(name = "phone_number")
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<ResponseForm> responseForms;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public Set<ResponseForm> getResponseForms() {
        return responseForms;
    }

    public void setResponseForms(Set<ResponseForm> responseForms) {
        this.responseForms = responseForms;
    }

    public User() {
    }

    public User(String fullname, String email, String password, LocalDate dateOfBirth, String profile, String phoneNumber, School school, Set<ResponseForm> responseForms) {
        this.fullname = fullname;
        this.email = email;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.profile = profile;
        this.phoneNumber = phoneNumber;
        this.school = school;
        this.responseForms = responseForms;
    }
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fullname='" + fullname + '\'' +
                ", email='" + email + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", profile='" + profile + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", school=" + school +
                ", responseForms=" + responseForms +
                '}';
    }
}
