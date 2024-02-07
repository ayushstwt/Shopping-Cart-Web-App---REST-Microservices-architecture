package com.narainox.inventoryservice;

import com.narainox.inventoryservice.model.Inventory;
import com.narainox.inventoryservice.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InventoryServiceApplication implements CommandLineRunner {

	@Autowired
	private InventoryRepository inventoryRepository;

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Inventory inventory=Inventory.builder()
				.skuCode("iphone_13")
				.quantity(100)
				.build();

		Inventory inventory2=Inventory.builder()
				.skuCode("iphone_13_red")
				.quantity(0)
				.build();

		inventoryRepository.save(inventory);
		inventoryRepository.save(inventory2);
	}
}
