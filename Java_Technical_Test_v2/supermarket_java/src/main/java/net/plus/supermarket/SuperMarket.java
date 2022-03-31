package net.plus.supermarket;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import net.plus.supermarket.model.Item;
import net.plus.supermarket.services.CheckOutService;


public class SuperMarket {

	public static void main(String[] args) {


		SuperMarket superMarket = new SuperMarket();
		superMarket.display();

	}


	public void display() {
		try {
			
			// Getting Input from console 

			List<Item> inputItems = new ArrayList<Item>();
			Scanner in = new Scanner(System.in);

			System.out.println("Welcome To MORE SuperMarket");
			System.out.println("***************************");
			System.out.println("Please Provide Item and it's Quantity Details separated with a single space.Each Item should be mentioned in seperate line .Once done please type END. ");
			System.out.println("Item : qty");
			System.out.println("----   ---");
			boolean flag= true;
			while(flag) {
				String inputLine = in.nextLine();
				if(inputLine.equalsIgnoreCase("END")) {
					flag=false;
				}
				else {
					String[] itemArr = inputLine.split(" ");
					inputItems.add(new Item(itemArr[0].trim(),Integer.valueOf(itemArr[1].trim())));
				}
			}

			// Logic to calculate Total bill.
			CheckOutService checkOutService = new CheckOutService();
			Double totalPrice = checkOutService.calculateBill(inputItems);


			System.out.println("\n");
			System.out.println("Bill Amount : " + totalPrice);
			System.out.println("\n");
			System.out.println("Have another bill to calculate? (Type Y for yes and N for No)");
			String endLine = in.nextLine();
			if(endLine.equalsIgnoreCase("Y")) {
				display();
			}
			else {
				System.out.println("Thanks For Shopping With MORE SuperMarket...");
			}
		}
		catch(Exception e) {
			System.out.println("Something Went Wrong.Please Try Again with proper input format.Kindly check README.txt For Reference.");
			System.out.println("\n");
			display();
		}
	}



}
