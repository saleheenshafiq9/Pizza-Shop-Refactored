package pizzashop;

import ingredients.FoodSet;
import ingredients.Pizza;
import ingredients.PizzaBase;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public record loadMenu(pizzashop.commandPrompt commandPrompt) {

    public int IngredientStartPosition(String line) {
        int start = line.indexOf("$");
        int result = -1;
        int i = start;
        while(result == -1 && i<line.length()) {
            if(line.charAt(i) == ' ') {
                result = i;
            }
            i++;
        }
        return result;
    }

    public int countIngredient(String line) {
        int count = 0;
        for(int i=0; i<line.length(); i++) {
            if(line.charAt(i) == ',') {
                count++;
            }
        }
        return count+1;
    }
    public int getCommaPosition(String line, int number) {
        int i = 0;
        int count = 0;
        int position = -1;
        while(i < line.length() && position == -1) {
            if(line.charAt(i) == ',') {
                count++;
            }
            if(count == number) {
                position = i;
            }
            i++;
        }
        return position;
    }


    void loadMenu() {
        try {
            File menu = new File("files/menu.txt");
            Scanner readMenu = new Scanner(menu);
            while (readMenu.hasNextLine()) {
                String line = readMenu.nextLine();
                String name = line.substring(0, line.indexOf("$") - 1);
                double price = Double.parseDouble(line.substring(line.indexOf("$") + 1,
                        IngredientStartPosition(line)));
                FoodSet toppings = new FoodSet();
                int startPosition = IngredientStartPosition(line) + 1;
                for (int i = 0; i < countIngredient(line) - 1; i++) {
                    toppings.add(commandPrompt.getIngredients().get(line.substring(startPosition,
                            getCommaPosition(line, i + 1))));
                    startPosition = getCommaPosition(line, i + 1) + 2;
                }
                toppings.add(commandPrompt.getIngredients().get(line.substring(startPosition)));
                PizzaBase base = new PizzaBase((PizzaBase) commandPrompt.getIngredients().get("thin crust"), "large");
                Pizza newPizza = new Pizza(name, price, toppings, base);
                commandPrompt.getMenu().add(newPizza);
            }
            readMenu.close();
        } catch (FileNotFoundException e) {
            System.out.println("Cannot find the file!");
            e.printStackTrace();
        }
    }
}