package com.theakylino.librarysystem.configs;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DatabaseConfig {
  @Bean
  @Profile("test")
  public DataSource h2DataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName("org.h2.Driver");
    dataSource.setUrl("jdbc:h2:mem:devdb");
    dataSource.setUsername("dev");
    dataSource.setPassword("dev");
    return dataSource;
  }

  @Bean
  @Profile("prod")
  public DataSource oracleDataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
    dataSource.setUrl("jdbc:oracle:thin:@//localhost:1521/XEPDB1");
    dataSource.setUsername("sys");
    dataSource.setPassword("aolazo2437124371.");
    return dataSource;
  }
}
