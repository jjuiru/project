package com.team1.mohaji;

import com.team1.mohaji.config.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef="auditAwareImpl")
@EnableTransactionManagement
@EnableConfigurationProperties(FileStorageProperties.class)
public class MohajiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MohajiApplication.class, args);
	}

}
