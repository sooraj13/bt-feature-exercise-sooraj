package net.plus.supermarket.services;

import java.util.List;

import net.plus.supermarket.model.Item;

public abstract class BillCalculation {
	
	
	public  abstract Double calculateBill(List<Item> inputItems);

}
