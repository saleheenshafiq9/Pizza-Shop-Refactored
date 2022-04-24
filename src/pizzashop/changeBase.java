package pizzashop;

import ingredients.Pizza;
import ingredients.PizzaBase;

public record changeBase(pizzashop.commandPrompt commandPrompt) {

    public void changeBase(Pizza pizza) {
        System.out.println("Base: ");
        for (int i = 0; i < commandPrompt.getIngredients().count(); i++) {
            if (commandPrompt.getIngredients().get(i) instanceof PizzaBase) {
                System.out.println(commandPrompt.getIngredients().get(i).getName());
            }
        }
        System.out.println("What base would you like: ");
        String baseName = commandPrompt.getKeyboard().nextLine();
        try {
            PizzaBase newBase = (PizzaBase) commandPrompt.getIngredients().get(baseName).clone();
            newBase.setSize(pizza.getBase().getSizeString());
            pizza.setBase(newBase);
        } catch (ClassCastException e) {
            System.out.println(baseName + " is not a pizza base.");
        } catch (NullPointerException e) {
            System.out.println(baseName + " is not a pizza base");
        }
    }
}