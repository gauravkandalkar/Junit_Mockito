package com.gaurav.vo;

import java.util.List;

public class OrderVO {
	private String orderID;
	private List<ItemVO> ItemList;

	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public List<ItemVO> getItemList() {
		return ItemList;
	}

	public void setItemList(List<ItemVO> itemList) {
		ItemList = itemList;
	}
}
