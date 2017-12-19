package edu.mum.cs544.service;


import edu.mum.cs544.dao.AbstractDao;
import edu.mum.cs544.dao.EmailDao;
import edu.mum.cs544.model.AbstractModel;
import edu.mum.cs544.model.EmailDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class EmailService extends AbstractService<AbstractModel> {

    private static final Logger logger = LoggerFactory.getLogger(EmailService.class);


    @Autowired
    private JavaMailSender javaMailSender;


    @Autowired
    public EmailService(@Qualifier("emailDao") AbstractDao<AbstractModel> dao){//,JavaMailSender javaMailSender) {
        super(dao);
       // this.javaMailSender = javaMailSender;
    }

    public void queueEmail(EmailDetails email) {

        EmailDao emailDao = (EmailDao) this.dao;
        emailDao.queueMessage(email);
    }

    public void sendQueuedEmails() {
        EmailDao emailDao = (EmailDao) this.dao;
        try {

            List<EmailDetails> emailList = emailDao.getEmailsToSend();

        for(EmailDetails e : emailList) {

            SimpleMailMessage message = new SimpleMailMessage();

            message.setTo(e .getRecipient());
            message.setSubject(e .getSubject());
            message.setText(e.getContent());
            message.setFrom(e.getSender());

            javaMailSender.send(message);

            updateEmailStatus(e.getId(),1);
        }

        }catch (Exception e)
        {
            logger.error("sendQueuedEmails(): " + e.getMessage());
        }

    }

    public void updateEmailStatus(long id, int status) {

        EmailDao emailDao = (EmailDao) this.dao;
        emailDao.updateEmailStatus(id, status);
    }
}
