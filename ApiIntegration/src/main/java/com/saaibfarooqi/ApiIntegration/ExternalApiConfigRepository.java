package com.saaibfarooqi.ApiIntegration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExternalApiConfigRepository extends JpaRepository<ExternalApiConfig, Long> {

    ExternalApiConfig findBySystemName(String systemName);
}

