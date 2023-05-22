package com.oasis.onlinestore;

import com.oasis.onlinestore.domain.*;
import com.oasis.onlinestore.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class OnlineStoreApplication implements CommandLineRunner {
	@Autowired
	OrderRepository orderRepo;

	public static void main(String[] args) {
		SpringApplication.run(OnlineStoreApplication.class, args);
	}

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


	}
}
