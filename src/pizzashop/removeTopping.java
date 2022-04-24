package pizzashop;

import ingredients.Pizza;
import ingredients.PizzaBase;

public record removeTopping(pizzashop.commandPrompt commandPrompt) {

    public void removeTopping(Pizza pizza) {
        if (pizza != null) {
            System.out.println("Toppings: ");
            for (int i = 0; i < pizza.getToppings().count(); i++) {
                System.out.println(pizza.getToppings().get(i).getName());
            }
            System.out.println("What topping would you like to remove: ");
            String removeTopping = commandPrompt.getKeyboard().nextLine();
            try {
                if (!(commandPrompt.getIngredients().get(removeTopping) instanceof PizzaBase) &&
                        commandPrompt.getIngredients().getPositionSameName(removeTopping) != -1) {
                    pizza.remove(removeTopping);
                } else {
                    System.out.println("Could not find " + removeTopping);
                }
            } catch (NullPointerException e) {
                System.out.println("Could not find " + removeTopping);
            }
        } else {
            System.out.println("Invalid pizza input!");
        }
    }
}