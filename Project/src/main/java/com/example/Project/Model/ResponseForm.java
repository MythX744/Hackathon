package com.example.Project.Model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "RESPONSE_FORMS")
public class ResponseForm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "text")
    private String text;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "decision")
    private String decision;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public ResponseForm() {

    }

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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDecision() {
        return decision;
    }

    public void setDecision(String decision) {
        this.decision = decision;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ResponseForm(Long id, String text, LocalDate date, String decision, User user) {
        this.id = id;
        this.text = text;
        this.date = date;
        this.decision = decision;
        this.user = user;
    }

    @Override
    public String toString() {
        return "ResponseForm{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", date=" + date +
                ", decision='" + decision + '\'' +
                ", user=" + user +
                '}';
    }
}
