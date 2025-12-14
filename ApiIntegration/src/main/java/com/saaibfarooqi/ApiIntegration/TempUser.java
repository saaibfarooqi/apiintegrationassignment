package com.saaibfarooqi.ApiIntegration;

public class TempUser {
    private String name;
    private String email;
    private String sourceSystem;

    public TempUser(String name, String email, String sourceSystem) {
        this.name = name;
        this.email = email;
        this.sourceSystem = sourceSystem;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSourceSystem() {
        return sourceSystem;
    }


}
