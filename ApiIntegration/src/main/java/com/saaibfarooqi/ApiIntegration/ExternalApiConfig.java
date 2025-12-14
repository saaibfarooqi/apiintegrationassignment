package com.saaibfarooqi.ApiIntegration;

import jakarta.persistence.*;

@Entity
@Table(name= "EXTERNAL_API_CONFIG")
public class ExternalApiConfig {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "systemName")
    private String systemName;
    @Column(name = "apiUrl")
    private String apiUrl;
    @Column(name = "httpMethod")
    private String httpMethod;
    @Column(name = "arrayNode")
    private String arrayNode;
    @Column(name = "nameField")
    private String nameField;
    @Column(name = "emailField")
    private String emailField;

    public Long getId() {
        return id;
    }

    public String getApiUrl() {
        return apiUrl;
    }

    public String getArrayNode() {
        return arrayNode;
    }

    public String getEmailField() {
        return emailField;
    }

    public String getHttpMethod() {
        return httpMethod;
    }

    public String getNameField() {
        return nameField;
    }

    public String getSystemName() {
        return systemName;
    }

    @Override
    public String toString() {
        return "Systemname  + " + this.getSystemName();
    }
}

