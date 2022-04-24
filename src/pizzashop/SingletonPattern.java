package pizzashop;

public class SingletonPattern {
    public static void main(String[] args) {
        SinglePizza singlePizza = SinglePizza.getInstance();
        singlePizza.insidePizzaShop();
    }
}
