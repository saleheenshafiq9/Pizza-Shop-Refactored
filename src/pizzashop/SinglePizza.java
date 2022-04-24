package pizzashop;

public class SinglePizza {
    private static SinglePizza instance = new SinglePizza();
    private SinglePizza() {}

    public static SinglePizza getInstance() {
        return instance;
    }

    public void insidePizzaShop() {
        PizzaShop town = new PizzaShop();
        town.commandPromptView();
    }
}
