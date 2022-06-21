package com.uml.q05;

public class ShopKeeper {
	// Cart 클래스를 멤버필드로 구성하되 생명주기 영향을 받지 않으므로
	// ShopKeeper와 Cart 클래스는 집합연관관계 
	private Cart cart;

	public int makeBillPaper() {
		//Item 클래스를 메서드 내부에서 참조하고 있으므로 의존관계
		int sum = 0;
		for(Item i : cart.getItems()) {
			sum += i.getItemPrice();
		}
		return sum;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
	public void calculate(Calculator calc) {
		//Calculator 클래스를 메서드 매개변수로써 참조하고 있으므로 의존관계
		calc.calculate();
	}
	
}
