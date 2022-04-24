package ingredients;

public class Pizza extends Food {
	private PizzaBase base;
	private final FoodSet toppings;
	final private FoodSet originalToppings;

	public Pizza(String name, double price, FoodSet ingredients, PizzaBase base) {
		super(name, price);

		this.base = base.clone();

		this.toppings = ingredients.clone();
		this.originalToppings = ingredients.clone();
	}

	public Pizza(Pizza menuItem, PizzaBase base) {
		super(menuItem.getName(), menuItem.getPrice());
		this.toppings = menuItem.getToppings().clone();
		this.originalToppings = menuItem.getOriginalToppings().clone();
		this.base = base.clone();

		double pizzaPrice = this.getPrice();
		this.setPrice(pizzaPrice + (base.getPrice() - menuItem.getBase().getPrice()));
	}
	@Override
	public Pizza clone() {
		String copiedName = this.getName();
		double copiedPrice = this.getPrice();
		FoodSet copiedToppings = this.toppings.clone();
		PizzaBase copiedPizzaBase = this.base.clone();

		return new Pizza(copiedName, copiedPrice, copiedToppings, copiedPizzaBase);
	}

	public int countAdditionalToppings(FoodSet toppings, FoodSet originalToppings) {
		int count = 0;
		for(int i = 0; i < toppings.count(); i++) {
			boolean contain = false;
			for(int j = 0; j < originalToppings.count(); j++) {
				if(toppings.get(i).equals(originalToppings.get(j))) {
					contain = true;
				}
			}
			if(!contain) {
				count++;
			}
		}
		return count;
	}

	public double getPrice() {
		double totalPrice = super.getPrice();
		Food[] additionalToppings = 
				new Food[countAdditionalToppings(this.toppings, this.originalToppings)];
		int index = 0;

		while(index < countAdditionalToppings(this.toppings, this.originalToppings)) {
			for(int i=0; i<this.toppings.count(); i++) {
				boolean contain = false;
				int j = 0;
				while(!contain && j<this.originalToppings.count()) {
					if(this.toppings.get(i).equals(this.originalToppings.get(j))) {
						contain = true;
					}
					j++; 
				}
				if(!contain) {
					additionalToppings[index] = new Food(this.toppings.get(i));
					index++;
				}
			}
		}

		for (Food additionalTopping : additionalToppings) {
			if (additionalTopping != null) {
				totalPrice += additionalTopping.getPrice();
			}
		}

		return totalPrice;
	}

	public PizzaBase getBase() {
		return this.base.clone();
	}

	public FoodSet getToppings() {
		return this.toppings.clone();
	}

	public FoodSet getOriginalToppings() {
		return this.originalToppings.clone();
	}

	public void setBase(PizzaBase base) {
		if(base != null) {
			double difference = base.getPrice() - getBase().getPrice();
			this.base = base.clone();
			double currentPizzaPrice = super.getPrice();
			setPrice(currentPizzaPrice + difference);
		}
	}

	public void add(Food topping) {
		if(topping.getClass() != PizzaBase.class && topping.getClass() != Pizza.class) {
			this.toppings.add(topping);
		}
	}
	public void remove(String topping) {
		if(this.toppings.getPositionSameName(topping) != -1) {
			this.toppings.remove(topping);
		}
		else {
			System.out.println("Cannot find the topping.");
		}
	}

	@Override
	public String toString() {
		StringBuilder thePizza = new StringBuilder(this.getName() + ", " + this.base.getSizeString() + ' ' +
				this.base.getName() + ' ' + this.getFormattedPrice() + ": \n \t");

		for(int i=0; i<this.toppings.count(); i++ ) {
			if(i != this.toppings.count() - 1) {
				thePizza.append(this.toppings.get(i).getName()).append(", ");
			}
			else {
				thePizza.append(this.toppings.get(i).getName());
			}
		}
		return thePizza.toString();
	}
	
	public static void main(String[] args) {
	}
}
