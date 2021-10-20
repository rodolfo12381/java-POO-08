package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy");
		SimpleDateFormat sdf2 = new SimpleDateFormat ("dd/MM/yyyy HH:mm:ss");
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner (System.in);
		
		Client cliente;
		System.out.println("Enter cliente data: ");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		String dataRecebida = sc.next();
		Date birthDate = sdf.parse(dataRecebida);
		cliente = new Client (name,email,birthDate);
		System.out.println("Enter order data:");
		System.out.print("Status: ");
		OrderStatus status =  OrderStatus.valueOf(sc.next());
		System.out.print("How many items to this order? ");
		int N = sc.nextInt();
		Order order = new Order (new Date(),status,cliente);
		Product product;
		for (int i=0; i<N; i++) {
			System.out.println("Enter #"+(i+1)+" item data:");
			System.out.print("Product name: ");
			sc.nextLine();
			String productName = sc.nextLine();
			System.out.print("Product price: ");
			double productPrice = sc.nextDouble();
			System.out.print("Quantity: ");
			Integer productQuantity = sc.nextInt();
			product = new Product (productName,productPrice);
			OrderItem it = new OrderItem (productQuantity,productPrice,product);
			order.addItem(it);
		}
		System.out.println();
		System.out.println(order);
		
		
		
		
	}

}
