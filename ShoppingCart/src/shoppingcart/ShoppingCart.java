package shoppingcart;
import java.util.ArrayList;


import java.util.Iterator;

import products.Product;

public class ShoppingCart {
	private List<CartLine> cartLines = new ArrayList<>();

	public void addProduct(Product product) {
		for (CartLine cartLine : cartLines) {
			if (cartLine.getProduct().getProductNumber().equals(product.getProductNumber())) {
				cartLine.setQuantity(cartLine.getQuantity() + 1);
				return;
			}
		}
		CartLine newCartLine = new CartLine();
		newCartLine.setProduct(product);
		newCartLine.setQuantity(1);
		cartLines.add(newCartLine);
	}

	public void removeProduct(Product product) {
		Iterator<CartLine> iterator = cartLines.iterator();
		while (iterator.hasNext()) {
			CartLine cartLine = iterator.next();
			if (cartLine.getProduct().getProductNumber().equals(product.getProductNumber())) {
				if (cartLine.getQuantity() > 1) {
					cartLine.setQuantity(cartLine.getQuantity() - 1);
				} else {
					iterator.remove();
				}
				return;
			}
		}
	}

	public void printCartContents() {
		System.out.println("shopping cart contents:");
		for (CartLine cartLine : cartLines) {
			System.out.println(cartLine.getQuantity() + " "
					+ cartLine.getProduct().getProductNumber() + " "
					+ cartLine.getProduct().getDescription() + " "
					+ cartLine.getProduct().getPrice());
		}
		System.out.println("Total price = " + getTotalPrice());
	}

	public double getTotalPrice() {
		double totalPrice = 0.0;
		for (CartLine cartLine : cartLines) {
			totalPrice += cartLine.getProduct().getPrice() * cartLine.getQuantity();
		}
		return totalPrice;
	}
}
