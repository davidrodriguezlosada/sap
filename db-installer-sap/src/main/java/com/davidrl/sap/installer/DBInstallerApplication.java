package com.davidrl.sap.installer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Main Startpoint of the Application
 */
@SpringBootApplication
public class DBInstallerApplication {

  /**
   * Start the Application
   *
   * @param args Application arguments
   */
  public static void main(String[] args) {
    ConfigurableApplicationContext context = SpringApplication.run(DBInstallerApplication.class);
    context.close();
  }
}
