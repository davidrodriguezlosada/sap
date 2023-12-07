package com.davidrl.sap.entity.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Main DB configuration for SAP
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.davidrl.sap.entity.repositories")
public class DBConfig {

}
