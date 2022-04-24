package pizzashop;

import ingredients.Food;
import ingredients.PizzaBase;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public record loadIngredients(pizzashop.commandPrompt commandPrompt) {

    void loadIngredients() {
        try {
            File ingredients = new File("files/ingredients.txt");
            Scanner readIngredients = new Scanner(ingredients);
            while (readIngredients.hasNextLine()) {
                String line = readIngredients.nextLine();
                double parseDouble = Double.parseDouble(line.substring(line.indexOf("$") + 1));
                if (!(line.startsWith("base:"))) {
                    Food newFood = new Food(line.substring(0, line.indexOf("$") - 1),
                            parseDouble);
                    commandPrompt.getIngredients().add(newFood);
                } else {
                    PizzaBase newPizzaBase = new PizzaBase(line.substring(6, line.indexOf("$") - 1),
                            parseDouble, "large");
                    commandPrompt.getIngredients().add(newPizzaBase);
                }
            }
            readIngredients.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Cannot find the file!");
        }
    }
}