package edu.mum.cs544.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.sql.Timestamp;


public class User extends AbstractModel {

    @JsonIgnore
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;
    private String address;
    private String ssn;
    private char gender;
    private String fullName;
    private int active;
    private boolean loginStatus;
    private Boolean passwordExpired = Boolean.FALSE;
    private int passwordExpirationDaysRemaining;
    private Timestamp lockedDate;
    private long loginAttempts;
    private long lastUpdatedBy;

    public Timestamp getLockedDate() {
        return lockedDate;
    }

    public void setLockedDate(Timestamp lockedDate) {
        this.lockedDate = lockedDate;
    }

    public long getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(long lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public boolean isLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(boolean loginStatus) {
        this.loginStatus = loginStatus;
    }

    public Boolean getPasswordExpired() {
        return passwordExpired;
    }

    public void setPasswordExpired(Boolean passwordExpired) {
        this.passwordExpired = passwordExpired;
    }

    public int getPasswordExpirationDaysRemaining() {
        return passwordExpirationDaysRemaining;
    }

    public void setPasswordExpirationDaysRemaining(int passwordExpirationDaysRemaining) {
        this.passwordExpirationDaysRemaining = passwordExpirationDaysRemaining;
    }

    public long getLoginAttempts() {
        return loginAttempts;
    }

    public void setLoginAttempts(long loginAttempts) {
        this.loginAttempts = loginAttempts;
    }


}
