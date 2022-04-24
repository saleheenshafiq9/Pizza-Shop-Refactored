package ingredients;

public abstract class Toppings implements Item {
    public Addons PizzaType() {
        return new Box();
    }

    public abstract float price();
}
