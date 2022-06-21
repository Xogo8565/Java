package com.uml.q05;

import java.util.List;

public class Cart {
	// Item 클래스를 멤버필드 + 메서드의 매개변수 형태로 참조하고 있으므로 집합연관관계
	private List<Item> items;
	
	public Cart() {}
	public Cart(List<Item> items) {
		this.items = items;
	}

	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	public void addItem(Item item) {
		this.items.add(item);
	}
	
}
