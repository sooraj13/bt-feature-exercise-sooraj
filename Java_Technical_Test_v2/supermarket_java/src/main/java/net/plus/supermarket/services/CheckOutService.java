package net.plus.supermarket.services;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import net.plus.supermarket.model.Item;
import net.plus.supermarket.repository.ItemRepository;

public class CheckOutService extends BillCalculation{




	// Logic to calculate Total bill.
	public  Double calculateBill(List<Item> inputItems) {


		List<Item> dbItems = getSortedData();	// Getting sorted List of items detail from DB

		HashMap<String,Integer> itemQtyMap = getItemQtyMap(inputItems);//Creating a map to identify the items purchased and it's quantity

		Double totalPrice = 0D;

		for(Item inputItem :inputItems) {

			Integer reqItemQty =inputItem.getQty();
			Double itemTotalPrice = 0D;

			for(Item dbItem:dbItems) {
				
				Integer dbQty = dbItem.getQty();
				OfferLogic offerLogic = null;

				if(reqItemQty>0 && inputItem.getItemId().equals(dbItem.getItemId())) {

					if(dbItem.getPriorityIndex()!=null && dbItem.getPriorityIndex() == 0 ) { //For Combo offer PriorityIndex will be set to 0.(Combo offer scenario Ex:if D  is purchased with an 'A' )
						
						offerLogic = new ComboOfferLogic();
						int mCount = offerLogic.doOfferLogic(inputItem,dbItem,itemQtyMap,reqItemQty,itemTotalPrice,null);
						
						Double dbPrice =dbItem.getPrice(); 
						itemTotalPrice = itemTotalPrice + (mCount*dbPrice);
						reqItemQty = reqItemQty-(mCount);

					}
					else {  // Normal Offer Scenario (Ex:3 for 130 and 1 for 50 scenarios)

						offerLogic = new NormalOfferLogic();
						int mCount =offerLogic.doOfferLogic(null,dbItem,null,reqItemQty,itemTotalPrice,dbQty);
						
						Double dbPrice = dbItem.getPrice();
						itemTotalPrice = itemTotalPrice + (mCount*dbPrice);
						reqItemQty = reqItemQty-(mCount*dbQty);

					}
				}
			}

			totalPrice = totalPrice +itemTotalPrice;

		}

		return totalPrice;
	}



	// Getting sorted List of item details from DB
	public static List<Item> getSortedData(){

		ItemRepository repo = new ItemRepository();
		// Getting hard coded price  details .
		List<Item> hcItems = repo.getData();

		//Doing a sorting on the list of hard coded data so that the first item coming in iterator will be the best offer for that particular product.
		// Using a field priorityIndex to identify the order of best offers available for that product.The Best offer will have a Lower priority index. 
		Collections.sort(hcItems,Comparator.comparing(Item::getItemId)
				.thenComparingInt(Item::getPriorityIndex));

		return hcItems;
	}



	//Creating a map to identify the items purchased and it's quantity
	public  static HashMap<String,Integer> getItemQtyMap( List<Item> inputItems ) {

		HashMap<String,Integer> itemQtyMap = new HashMap<>();

		//Using below map For SpecialOffer scenarios(Ex:If D is purchased with an 'A' we need to identify how many A's are present in Request)
		for(Item inputItem :inputItems) {
			itemQtyMap.put(inputItem.getItemId(), inputItem.getQty());
		}

		return itemQtyMap;

	}







}
