package net.plus.supermarket;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import net.plus.supermarket.model.Item;
import net.plus.supermarket.repository.ItemRepository;
import net.plus.supermarket.services.CheckOutService;

public class TestCheckOutService {

	List<Item> inputItems = new ArrayList<Item>();

	List<Item> hcItems = new ArrayList<Item>();

	CheckOutService checkOutService = new CheckOutService();
	ItemRepository repo = new ItemRepository();



	@Before
	public void setUp() throws Exception {

		inputItems.add(new Item("A",3)); 
		inputItems.add(new Item("B",2));
		inputItems.add(new Item("C",2));

		hcItems = repo.getData();
	}


	@Test
	public void testcalculateBill() {

		assertEquals(Double.valueOf(213),checkOutService.calculateBill(inputItems));
	}


}
