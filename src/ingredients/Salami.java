package ingredients;

public class Salami extends Toppings {
    @Override
    public float price() {
        return 3.0f;
    }

    @Override
    public String ItemName() {
        return "Salami";
    }
}
