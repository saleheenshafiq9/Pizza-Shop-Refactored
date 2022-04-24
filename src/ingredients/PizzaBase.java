package ingredients;

public class PizzaBase extends Food{
	private String sizeStr;
	private int diameter;
	public static int convertToDiameter(String size) {
		int result = 0;
		return SizeWithPrice.SizeWithPrice(size, result);
	}

	public PizzaBase(String name, double price, String size) {
		super(name, price);
		this.sizeStr = size;
		this.diameter = convertToDiameter(size);
	}

	public PizzaBase(PizzaBase other, String size) {
		super(other.clone().getName(), other.clone().getPrice());
		this.sizeStr = size;
		this.diameter = convertToDiameter(size);

		double newPrice = other.getCostPerSquareInch() * this.getSquareInches(); 
		setPrice(newPrice);
	}

	public String getSizeString() {
		return this.sizeStr;
	}

	public double getSquareInches() {
		double result;
		result = Math.PI * (Math.pow((this.diameter / 2.0), 2));
		return result; 
	}

	public double getCostPerSquareInch() {
		return getPrice() / getSquareInches();
	}

	public void setSize(String size) {
		double oldCostPerSquareInch = getCostPerSquareInch();
		if(size.equals("small") || size.equals("medium") || size.equals("large")) {
			this.sizeStr = size;
			this.diameter = convertToDiameter(size);
		}
		else {
			System.out.println("Invalid size: The size should be small, medium or large.");
		}

		double newPrice = oldCostPerSquareInch * getSquareInches();
		setPrice(newPrice);
	}

	@Override
	public PizzaBase clone() {
		String copiedName = getName();
		double copiedPrice = getPrice();
		String copiedSize = this.sizeStr;
		return new PizzaBase(copiedName, copiedPrice, copiedSize);
	}

	@Override
	public boolean equals(Object other) {
		boolean isEqual = false;
		if(other != null && getClass() == other.getClass()) {
			PizzaBase anotherPizza = (PizzaBase) other;

			if(getName() != null && this.sizeStr != null && anotherPizza.getName() != null &&
					anotherPizza.sizeStr != null) {
				if(getName().equals(anotherPizza.getName()) &&
						getPrice() == anotherPizza.getPrice() &&
						this.sizeStr.equals(anotherPizza.sizeStr)) {
					isEqual = true;
				}
			}
			else if(getName() == null && anotherPizza.getName() == null &&
					this.sizeStr != null && anotherPizza.sizeStr != null) {
				if(this.sizeStr.equals(anotherPizza.sizeStr) && getPrice() == anotherPizza.getPrice()) {
					isEqual = true;
				}
			}
			else if(this.sizeStr == null && anotherPizza.sizeStr == null &&
					getName() != null && anotherPizza.getName() != null) {
				if(getName().equals(anotherPizza.getName()) && getPrice() == anotherPizza.getPrice()) {
					isEqual = true;
				}
			}
			else if(this.sizeStr == null && anotherPizza.sizeStr == null && 
					getName() == null && anotherPizza.getName() == null	) {
				if(getPrice() == anotherPizza.getPrice()) {
					isEqual = true;
				}
			}
		}
		return isEqual;
	}

	@Override
	public String toString() {
		return this.sizeStr + ' ' + getName() + ' ' + "pizza base";
	}

	public static void main(String[] args) {

	}
}
