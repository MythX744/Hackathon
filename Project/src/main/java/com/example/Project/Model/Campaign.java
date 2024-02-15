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
}
