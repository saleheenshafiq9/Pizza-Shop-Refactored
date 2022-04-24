package pizzashop;

import ingredients.Pizza;
import ingredients.PizzaBase;

public record addTopping(pizzashop.commandPrompt commandPrompt) {

    public void addTopping(Pizza pizza) {
        if (pizza != null) {
            System.out.println("Toppings: ");
            for (int i = 0; i < commandPrompt.getIngredients().count(); i++) {
                if (!(commandPrompt.getIngredients().get(i) instanceof PizzaBase)) {
                    System.out.println(commandPrompt.getIngredients().get(i));
                }
            }
            System.out.println("What topping would you like to add: ");
            String newTopping = commandPrompt.getKeyboard().nextLine();
            try {
                if (!(commandPrompt.getIngredients().get(newTopping) instanceof PizzaBase) &&
                        commandPrompt.getIngredients().getPositionSameName(newTopping) != -1) {
                    pizza.add(commandPrompt.getIngredients().get(newTopping));
                } else {
                    System.out.println("Could not find " + newTopping);
                }
            } catch (NullPointerException e) {
                System.out.println("Could not find " + newTopping);
            }
        } else {
            System.out.println("Invalid pizza input");
        }
    }
}