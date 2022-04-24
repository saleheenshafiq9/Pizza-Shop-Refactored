package ingredients;

public class Chicken extends Toppings {
    @Override
    public float price() {
        return 4.0f;
    }

    @Override
    public String ItemName() {
        return "Chicken";
    }
}
