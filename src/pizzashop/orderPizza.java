package pizzashop;

import ingredients.Pizza;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public record orderPizza(pizzashop.commandPrompt commandPrompt) {

    public void orderPizza(Pizza pizza) {
        System.out.println("What is your name?");
        String name = commandPrompt.getKeyboard().nextLine();
        while (name.equals("")) {
            System.out.println("Please enter your name: ");
            name = commandPrompt.getKeyboard().nextLine();
        }
        PrintWriter pw = null;
        try {
            String filename = "files\\receipts\\" + name + ".txt";
            pw = new PrintWriter(new FileWriter(filename, true));
            StringBuilder thePizza = new StringBuilder(pizza.getName() + ", " + pizza.getBase().getSizeString() + ' ' +
                    pizza.getBase().getName() + ' ' + pizza.getFormattedPrice() + ": \n \t");
            for (int i = 0; i < pizza.getToppings().count(); i++) {
                if (i != pizza.getToppings().count() - 1) {
                    thePizza.append(pizza.getToppings().get(i).getName()).append(", ");
                } else {
                    thePizza.append(pizza.getToppings().get(i).getName()).append('.');
                }
            }
            pw.write(thePizza.toString());
            pw.write("\n");
            pw.write("Enjoy your meal " + name + "! :) \n");
        } catch (IOException ioe) {
            System.err.println("IOException: " + ioe.getMessage());
        } finally {
            if (pw != null) {
                pw.close();
            }
        }
    }
}