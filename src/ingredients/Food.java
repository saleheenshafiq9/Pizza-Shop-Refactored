package ingredients;

import java.text.DecimalFormat;

public class Food {
	private final String name;
	private double price;

	public Food(String name, double price) throws NullPointerException {
		if(name == null) {
			throw new NullPointerException("The name of food cannot be null");
		}
		else {
			this.name = name;
			this.price = price;
		}
	}

	public Food(Food other) throws NullPointerException{
		if(other != null) {
			double copiedPrice = other.price;
			this.name = other.name;
			this.price = copiedPrice;
		}

		else {
			System.out.println("Error: You created an invalid food, please create another one.");
			throw new NullPointerException("Food cannot be null!");
		}
	}

	public double getPrice() {
		return this.price;
	}

	public String getName() {
		return this.name;
	}

	protected void setPrice(double price) {
		if(price>=0) {
			this.price = price;
		}
	}

	public String getFormattedPrice() {
		double originalPrice = this.getPrice();
		DecimalFormat df = new DecimalFormat("$##0.00");

		return df.format(originalPrice);
	}

	@Override
	public boolean equals(Object other) {
		boolean isEqual = false;
		if(other != null && getClass() == other.getClass()) {
			Food anotherFood = (Food) other;

			if(this.name != null && anotherFood.getName() != null ) { 
				if(this.name.equals(anotherFood.getName()) && this.price == anotherFood.getPrice()) {
					isEqual = true;
				}
			}
			else if(this.name == null && anotherFood.getName() == null 
					&& this.price == anotherFood.getPrice()) {
				isEqual = true;
			}
		}
		return isEqual;
	}

	@Override
	public String toString() {
		return getName() + ' ' +getFormattedPrice();
	}

	@Override
	public Food clone() {
		double copiedPrice = this.price;
		return new Food(this.name, copiedPrice);
	}

	public static void main(String[] args) {
	}
}

