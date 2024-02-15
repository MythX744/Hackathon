package com.example.Project.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "message")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "id_receiver")
    private Long idReceiver;
    @Column(name = "id_sender")
    private Long idSender;
    @Column(name = "message")
    private String message;

    public Message() {
    }

    public Message(Long idReceiver, Long idSender, String message) {
        this.idReceiver = idReceiver;
        this.idSender = idSender;
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdReceiver() {
        return idReceiver;
    }

    public void setIdReceiver(Long idReceiver) {
        this.idReceiver = idReceiver;
    }

    public Long getIdSender() {
        return idSender;
    }

    public void setIdSender(Long idSender) {
        this.idSender = idSender;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", idReceiver=" + idReceiver +
                ", idSender=" + idSender +
                ", message='" + message + '\'' +
                '}';
    }

}
