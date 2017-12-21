package edu.mum.cs544.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class MailConfiguration {

    @Value("${spring.mail.properties.mail.transport.protocol}")

    private String protocol;

    @Value("${spring.mail.host}")

    private String host;

    @Value("${spring.mail.port}")

    private int port;

    @Value("${spring.mail.properties.mail.smtp.auth}")

    private boolean auth;

    @Value("${spring.mail.properties.mail.smtp.starttls.enable}")

    private boolean starttls;

    @Bean
    public JavaMailSender javaMailSender() {

        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        Properties mailProperties = new Properties();

        mailProperties.put("mail.smtp.auth", auth);

        mailProperties.put("mail.smtp.starttls.enable", starttls);

        mailSender.setJavaMailProperties(mailProperties);

        mailSender.setHost(host);

        mailSender.setPort(port);

        mailSender.setProtocol(protocol);

        //mailSender.setUsername(username);

        //mailSender.setPassword(password);

        return mailSender;

    }

}
