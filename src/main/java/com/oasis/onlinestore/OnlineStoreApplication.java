package com.oasis.onlinestore;

import com.oasis.onlinestore.domain.*;
import com.oasis.onlinestore.repository.OrderRepository;
import com.oasis.onlinestore.service.ItemService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class OnlineStoreApplication implements CommandLineRunner {

	@Autowired
	OrderRepository orderRepo;
	@Autowired
	ItemService itemService;

	public static void main(String[] args) {
		SpringApplication.run(OnlineStoreApplication.class, args);
	}

	@Transactional
	@Override
	public void run(String... args) throws Exception {
		Order o1 = new Order();
		Order o2 = new Order();
		List<Order> orders = new ArrayList<>();
		orders.add(o1);
		orders.add(o2);

		o1.setStatus(Status.SHIPPED);
		Address testAddress = new Address("123 Main St", "City", "State", AddressType.SHIPPING  );
//		Customer cust = new Customer("John", "Bob", "johnBob@gmail.com");
		o1.setShippingAddress(testAddress);
//		cust.setOrders(orders);
		orderRepo.save(o1);


		List<Order> foundOrders = orderRepo.findByShippingAddress(testAddress);
//		List<Order> findCustomer = orderRepo.findByCustomer(cust);


		for (Order order:foundOrders) {
			System.out.println(order);

		}

		testItemService();
	}

	private void testItemService() {
		Item item1 = new Item(
				"Stationary baby swings",
				"Baby Swing for Infants, Electric Portable Baby Swing for Newborn, Bluetooth Touch Screen/Remote Control Timi",
				"image",
				"183837478",
				12
		);
		Item item2 = new Item(
				"Alienware Ultrawide Curved Gaming Monitor 38 Inch",
				"144Hz Refresh Rate, 3840 x 1600 WQHD , IPS, NVIDIA G-SYNC Ultimate, 1ms Response Time, 2300R Curvature, VESA Display HDR 600, AW3821DW - White",
				"someimage",
				"183837478",
				2
		);
		itemService.save(item1);
		itemService.save(item2);

		List<Item> foundItems = itemService.findNameLike("Alienware");
		System.out.println(foundItems);

		List<Item> foundAllItems = itemService.findAll();
		System.out.println(foundAllItems);
	}
}
