package com.example.Project.Model;

import jakarta.persistence.*;


import java.sql.Timestamp;
import java.time.LocalDate;

@Entity
@Table(name = "MESSAGES")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sender_id")
    private User sender;
    @Column(name = "date")
    private LocalDate date;
    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private User receiver;
    @Column(name = "text", length = 500)
    private String text;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Message(Long id, User sender, LocalDate date, User receiver, String text) {
        this.id = id;
        this.sender = sender;
        this.date = date;
        this.receiver = receiver;
        this.text = text;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", sender=" + sender +
                ", date=" + date +
                ", receiver=" + receiver +
                ", text='" + text + '\'' +
                '}';
    }
}

