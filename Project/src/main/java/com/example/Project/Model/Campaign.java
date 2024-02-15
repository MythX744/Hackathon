package com.example.Project.Model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "CAMPAIGNS")
public class Campaign {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "date")
    private LocalDate date;
    @ManyToOne
    @JoinColumn(name="school_id", nullable=false)
    private School school;
    @OneToMany(mappedBy = "campaign", cascade = CascadeType.ALL)
    private Set<ResponseCampaign> responses;

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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public Set<ResponseCampaign> getResponses() {
        return responses;
    }

    public void setResponses(Set<ResponseCampaign> responses) {
        this.responses = responses;
    }

    public Campaign(Long id, String name, LocalDate date, School school, Set<ResponseCampaign> responses) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.school = school;
        this.responses = responses;
    }

    @Override
    public String toString() {
        return "Campaign{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", school=" + school +
                ", responses=" + responses +
                '}';
    }
}
