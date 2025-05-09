package com.bachatt_assignment.vehiclemanagement;

import com.bachatt_assignment.vehiclemanagement.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.sql.Connection;

import javax.sql.DataSource;

@SpringBootApplication
public class VehiclemanagementApplication {
	@Autowired
	private DataSource dataSource;

	@Autowired
	private VehicleRepository vehicleRepository;
	public static void main(String[] args) {
		SpringApplication.run(VehiclemanagementApplication.class, args);
	}
	@Bean
	public CommandLineRunner verifyStartup() {
		return args -> {
			System.out.println("🚀 Vehicle Management API started on port 8080");
			try (Connection conn = dataSource.getConnection()) {
				System.out.println("✅ Connected to MySQL at URL: " +
						conn.getMetaData().getURL());
			}
			System.out.println("📦 Vehicles currently in DB: " +
					vehicleRepository.count());
		};
	}
}
