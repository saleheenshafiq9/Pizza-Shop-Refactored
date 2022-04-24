package pizzashop;

import ingredients.Pizza;
import ingredients.PizzaBuilder;

public record choosePizza(pizzashop.commandPrompt commandPrompt) {

    public Pizza choosePizza() {
        PizzaBuilder builderPattern = new PizzaBuilder();
        builderPattern.showMenu();
        System.out.println("What pizza do you like?");
        commandPrompt.getKeyboard().nextLine();
        String pizzaName = commandPrompt.getKeyboard().nextLine();
        if (commandPrompt.getMenu().get(pizzaName) != null) {
            return (Pizza) commandPrompt.getMenu().get(pizzaName).clone();
        }
        return null;
    }
}