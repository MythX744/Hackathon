package com.example.Project.Model;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "RESPONSECAMPAIGN")
public class ResponseCampaign {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "text")
    private String text;
    @ManyToOne
    @JoinColumn(name="campaign_id", nullable=false)
    private Campaign campaign;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Campaign getCampaign() {
        return campaign;
    }

    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
    }

    public ResponseCampaign(Long id, String text, Campaign campaign) {
        this.id = id;
        this.text = text;
        this.campaign = campaign;
    }

    @Override
    public String toString() {
        return "ResponseCampaign{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", campaign=" + campaign +
                '}';
    }
}
