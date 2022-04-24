package ingredients;

public class Mushrooms extends Toppings {
    @Override
    public float price() {
        return 2.5f;
    }

    @Override
    public String ItemName() {
        return "Mushrooms";
    }
}
