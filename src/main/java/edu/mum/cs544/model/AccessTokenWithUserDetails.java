package edu.mum.cs544.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccessTokenWithUserDetails implements Serializable {

    @JsonProperty("accessToken")
    private String accessToken;


    @JsonProperty("id")
    private long id;

    @JsonProperty("email")
    private String email;

    @Override
    public String toString() {
        return "{" +
                " 'accessToken':'" + accessToken + '\'' +
                ", 'id':" + "'" + id  + '\'' +
                ", 'email':'" + email + '\'' +
                ", 'lastName':'" + lastName + '\'' +
                ", 'firstName':'" + firstName + '\'' +
                ", 'category':'" + category + '\'' +
                '}';
    }

   // String test="{accessToken='a7805d44-e4b9-47f0-99f7-32138ae40c11-9f12ceee-4cfe-4155-ac5e-a60a34709ef8-038bad79-7127-4f1b-b5bb-56ce0df0b59e-75e02ed4-ca80-41ea-96cc-c039a13e577f', id=1, email='larogundade@mum.edu', lastName='Arogundade', firstName='Lukman', category='STUDENT'});";

    @JsonProperty("lastName")
    private String lastName;

    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("category")
    private String category;


    public <T> AccessTokenWithUserDetails(String token, T user) {
        this.accessToken = token;

        Person s = (Person) user;

        this.email = s.getEmail();

        this.firstName = s.getFname();
        this.lastName = s.getLname();

        this.category = s.getCategory();

        this.id = s.getId();

    }

}
