package com.proyect.proyect.Models;

import java.time.LocalDateTime;

public class Message {
    private LocalDateTime local;
    private String message;

    public Message(LocalDateTime local, String message) {
        this.local = local;
        this.message = message;
    }

    public LocalDateTime getLocal() {
        return local;
    }

    public void setLocal(LocalDateTime local) {
        this.local = local;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
