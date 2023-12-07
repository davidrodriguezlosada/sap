package com.davidrl.sap.installer.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

@Configuration
public class ApplicationConfig {

    private static final Logger LOG = LoggerFactory.getLogger(ApplicationConfig.class);

    @Value("${info.app.build.java}")
    private String buildJavaVersion;

    @Value("${info.app.build.encoding}")
    private String buildEnconding;

    @Value("${info.app.build.mavenversion}")
    private String buildMavenVersion;

    @Value("${info.app.build.buildname}")
    private String buildName;

    @Value("${info.app.build.parentversion}")
    private String buildParentVersion;

    @Value("${info.app.build.buildtimestamp}")
    private String buildTimestamp;

    @EventListener(ApplicationReadyEvent.class)
    public void doSomethingAfterStartup() {
      LOG.info("Application build java version: {}", buildJavaVersion);
      LOG.info("Application build enconding: {}", buildEnconding);
      LOG.info("Application build maven version: {}", buildMavenVersion);
      LOG.info("Application build name: {}", buildName);
      LOG.info("Application build parent version: {}", buildParentVersion);
      LOG.info("Application build timestamp: {}", buildTimestamp);
    }
}
