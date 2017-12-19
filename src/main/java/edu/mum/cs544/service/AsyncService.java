package edu.mum.cs544.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;


@Service
public class AsyncService {


    @Autowired
    private EmailService emailService;


    @Async
    public void sendQueuedEmails() {
        this.emailService.sendQueuedEmails();
    }


}
