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
