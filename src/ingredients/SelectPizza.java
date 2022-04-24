package ingredients;

import java.util.ArrayList;
import java.util.List;

public class SelectPizza {
    private final List<Item> items = new ArrayList<Item>();
    private final Base base = new Base() {
        @Override
        public String ThinCrust() {
            return "Thin Crust";
        }
        public String CheeseCrust() {
            return "Cheese Crust";
        }
        public String DeepPan() {
            return "Deep Pan";
        }
    };

    public void addItem(Item item){
        items.add(item);
    }

    public float getCost(){
        float cost = 0.0f;
        for (Item item : items) {
            cost += item.price();
        }
        return cost;
    }

    public void showItems(){
        System.out.println(base.ThinCrust());
        for (Item item : items) {
            System.out.print(item.ItemName());
            System.out.print(", toppings" + item.PizzaType().toppings());
            System.out.println(", Price : " + item.price());
        }
    }
}
