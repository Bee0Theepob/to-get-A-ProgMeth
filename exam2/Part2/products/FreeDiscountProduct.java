package products;

import discount.FreeDiscountable;
import discount.Sellable;
import logic.ShopUtil;

public class FreeDiscountProduct extends BaseProduct implements Sellable,FreeDiscountable {
	private int promoQuantity;
	private int freeQuantity;
	
	public int getPromoQuantity() {
		return promoQuantity;
	}

	public void setPromoQuantity(int promoQuantity) {
		this.promoQuantity = Math.max(1,promoQuantity);
	}

	public int getFreeQuantity() {
		return freeQuantity;
	}

	public void setFreeQuantity(int freeQuantity) {
		this.freeQuantity = Math.max(1,freeQuantity);
	}

	public FreeDiscountProduct(String name, int price, int promoQ, int freeQ){
		super(name, price);
		this.setPromoQuantity(promoQ);
		this.setFreeQuantity(freeQ);
	}
	public int calcFreeDiscountPieces(int totalQuantityBought) {
		return ShopUtil.calculateFreeDiscountPieces(this.getFreeQuantity(), this.getPromoQuantity(), totalQuantityBought);
	}
	public int calculateDiscount(int quantity) {
		return this.getPrice()*this.getFreeQuantity();
		
	}
	public String toString() {
		return this.getProductName() + " (Price: " + this.getPrice() + ", Buy " + this.getPromoQuantity() + " Get " + this.getFreeQuantity() + " Free)";
	}
}
