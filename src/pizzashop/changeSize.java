package pizzashop;

import ingredients.Pizza;
import ingredients.PizzaBase;

public record changeSize(pizzashop.commandPrompt commandPrompt) {

    public void changeSize(Pizza pizza) {
        System.out.println("What size pizza would you like (small/medium/large): ");
        String name = commandPrompt.getKeyboard().nextLine();
        while (!name.equals("small") && !name.equals("medium") &&
                !name.equals("large")) {
            System.out.println("Must be one of small, medium, or large");
            System.out.println("What size pizza would you like (small/medium/large): ");
            name = commandPrompt.getKeyboard().nextLine();
        }
        PizzaBase newBase = new PizzaBase(pizza.getBase(), name);
        pizza.setBase(newBase);
    }
}