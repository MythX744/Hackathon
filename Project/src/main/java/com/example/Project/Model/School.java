package com.example.Project.Model;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "SCHOOLS")
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "city")
    private String city;
    @OneToMany(mappedBy = "school")
    private Set<User> users;
    @OneToMany(mappedBy = "school", cascade = CascadeType.ALL)
    private Set<Campaign> campaigns;

    public School() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Set<Campaign> getCampaigns() {
        return campaigns;
    }

    public void setCampaigns(Set<Campaign> campaigns) {
        this.campaigns = campaigns;
    }

    public School(Long id, String name, String city, Set<User> users, Set<Campaign> campaigns) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.users = users;
        this.campaigns = campaigns;
    }

    @Override
    public String toString() {
        return "School{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", users=" + users +
                ", campaigns=" + campaigns +
                '}';
    }
}
