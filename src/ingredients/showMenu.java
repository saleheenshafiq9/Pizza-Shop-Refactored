package ingredients;

public class showMenu {
    public showMenu() {
    }

    public void showMenu() {
        PizzaBuilder pizzaBuilder = new PizzaBuilder();
        SelectPizza margaritaPizza = pizzaBuilder.MargaritaPizza();
        System.out.println("Margarita Pizza");
        margaritaPizza.showItems();
        System.out.println("Total Cost: " + (margaritaPizza.getCost() + 10.0f));

        SelectPizza hawaiianPizza = pizzaBuilder.HawaiianPizza();
        System.out.println("Hawaiian Pizza");
        hawaiianPizza.showItems();
        System.out.println("Total Cost: " + (hawaiianPizza.getCost() + 9.0f));

        SelectPizza meatLoversPizza = pizzaBuilder.MeatLoversPizza();
        System.out.println("Meat Lovers Pizza");
        meatLoversPizza.showItems();
        System.out.println("Total Cost: " + (meatLoversPizza.getCost() + 10.0f));

        SelectPizza supremePizza = pizzaBuilder.SupremePizza();
        System.out.println("Supreme Pizza");
        supremePizza.showItems();
        System.out.println("Total Cost: " + (supremePizza.getCost() + 0.5f));

        SelectPizza bbqChickenPizza = pizzaBuilder.BbqChickenPizza();
        System.out.println("Bbq Chicken Pizza");
        bbqChickenPizza.showItems();
        System.out.println("Total Cost: " + (bbqChickenPizza.getCost() + 8.0f));

        SelectPizza spicySeafoodPizza = pizzaBuilder.SpicySeafoodPizza();
        System.out.println("Spicy Seafood Pizza");
        spicySeafoodPizza.showItems();
        System.out.println("Total Cost: " + (spicySeafoodPizza.getCost() + 5.5f));

        SelectPizza chickenPrawnPizza = pizzaBuilder.ChickenPrawnPizza();
        System.out.println("Chicken & Prawn Pizza");
        chickenPrawnPizza.showItems();
        System.out.println("Total Cost: " + (chickenPrawnPizza.getCost() + 6.5f));
    }
}