package net.plus.supermarket.model;

public class Item {
	
	
	private String itemId;
	private Integer qty;
	private Double price;
	private String comboOfferItem;
	private Integer priorityIndex;
	
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getQty() {
		return qty;
	}
	public void setQty(Integer qty) {
		this.qty = qty;
	}
	public Item() {
		super();
	}

	
	public Item(String itemId, Integer qty) {
		super();
		this.itemId = itemId;
		this.qty = qty;
	}
	public Integer getPriorityIndex() {
		return priorityIndex;
	}
	public void setPriorityIndex(Integer priorityIndex) {
		this.priorityIndex = priorityIndex;
	}
	public String getComboOfferItem() {
		return comboOfferItem;
	}
	public void setComboOfferItem(String comboOfferItem) {
		this.comboOfferItem = comboOfferItem;
	}
	public Item(String itemId, Integer qty, Double price, String comboOfferItem, Integer priorityIndex) {
		super();
		this.itemId = itemId;
		this.qty = qty;
		this.price = price;
		this.comboOfferItem = comboOfferItem;
		this.priorityIndex = priorityIndex;
	}

	
	
	

}
