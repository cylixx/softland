package com.softland.example.persistence.queue;

public interface MessagePublisher {

    void publish(final String message);
}
