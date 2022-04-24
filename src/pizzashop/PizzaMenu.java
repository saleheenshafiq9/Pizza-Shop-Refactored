package pizzashop;

import ingredients.Food;
import ingredients.FoodSet;
import ingredients.Pizza;

public class PizzaMenu extends FoodSet{
	public PizzaMenu() {
		super();
	}

	@Override
	public void add(Food pizza) {
		if(pizza instanceof Pizza) {
			super.add(pizza);
		}
    }

	@Override
	public Pizza get(String name) {
		if(super.get(name) instanceof Pizza){
			return (Pizza)super.get(name);
			}
		return null;
	}

	@Override 
	public Pizza get(int index) {
		if(super.get(index) instanceof Pizza) {
			return (Pizza)super.get(index);
		}
		return null;
	}

	@Override 
	public String toString() {
		StringBuilder result = new StringBuilder("Menu: \n");
		for(int i = 0; i<this.count(); i++) {
			result.append(get(i).getName()).append(", ").append(get(i).getBase().getSizeString()).append(' ').append(get(i).getBase().getName()).append(' ').append(get(i).getFormattedPrice()).append(": \n \t");
			for(int j=0; j<get(i).getToppings().count(); j++ ) {
				if(j != get(i).getToppings().count() - 1) {
					result.append(get(i).getToppings().get(j).getName()).append(", ");
				}
				else {
					result.append(get(i).getToppings().get(j).getName());
				}
			}
			result.append("\n");
		}
		return result.toString();
	}

	public static void main(String[] args) {
		PizzaMenu menu = new PizzaMenu();
		System.out.println(menu);
	}
}
