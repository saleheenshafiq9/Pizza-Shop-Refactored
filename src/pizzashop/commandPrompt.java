package pizzashop;

import ingredients.*;
import java.util.Scanner;

public class commandPrompt {
    private final MakeDecision makeDecision = new MakeDecision(this);
    private final pizzashop.orderPizza orderPizza = new orderPizza(this);
    private final pizzashop.removeTopping removeTopping = new removeTopping(this);
    private final pizzashop.addTopping addTopping = new addTopping(this);
    private final pizzashop.changeSize changeSize = new changeSize(this);
    private final pizzashop.changeBase changeBase = new changeBase(this);
    private final pizzashop.choosePizza choosePizza = new choosePizza(this);
    private Scanner keyboard;
    private final FoodSet ingredients;
    private final PizzaMenu menu;

    public commandPrompt() {
        this.ingredients = new FoodSet();
        this.menu = new PizzaMenu();
        this.setKeyboard(new Scanner(System.in));
        pizzashop.loadIngredients loadIngredients = new loadIngredients(this);
        loadIngredients.loadIngredients();
        pizzashop.loadMenu loadMenu = new loadMenu(this);
        loadMenu.loadMenu();
    }

    public void changeBase(Pizza pizza) {
        changeBase.changeBase(pizza);
    }

    public void changeSize(Pizza pizza) {
        changeSize.changeSize(pizza);
    }

    public void addTopping(Pizza pizza) {
        addTopping.addTopping(pizza);
    }

    public void removeTopping(Pizza pizza) {
        removeTopping.removeTopping(pizza);
    }

    public void commandPromptView() {
        this.setKeyboard(new Scanner(System.in));
        System.out.println("Welcome to the pizza shop!");
        boolean exit = false;
        while(!exit) {
            System.out.println("1. Order Pizza");
            System.out.println("2. Exit");
            System.out.println("How may I help you: ");
            int orderDecision = -1;
            boolean complete = false;
            while(!complete){
                while(!getKeyboard().hasNextInt()) {
                    System.out.println("Invalid choice: ");
                    getKeyboard().nextLine();

                }
                orderDecision = Integer.parseInt(getKeyboard().next());
                if(orderDecision == 1 || orderDecision == 2){
                    complete = true;
                }
                else{
                    System.out.println("Enter again: ");
                }
            }

            if(orderDecision == 1) {
                Pizza userPizza = choosePizza.choosePizza();
                if(userPizza == null){
                    System.out.println("We do not make that kind of pizza.");
                }
                else {
                    System.out.println("Your pizza: ");
                    System.out.println(userPizza);
                    System.out.println("1. Change Size");
                    System.out.println("2. Change Pizza Base");
                    System.out.println("3. Add Topping");
                    System.out.println("4. Remove Topping");
                    System.out.println("5. Order");
                    System.out.println("6. Cancel");
                    System.out.println("What would you like to do: ");
                    while(!getKeyboard().hasNextInt()) {
                        System.out.println("Invalid choice: ");
                        getKeyboard().nextLine();
                    }
                    int additionalDecision = Integer.parseInt(getKeyboard().nextLine());
                    while(additionalDecision != 5 && additionalDecision != 6) {

                        makeDecision.MakeDecision(userPizza, additionalDecision);
                        System.out.println("Your pizza: ");
                        System.out.println(userPizza);
                        System.out.println("1. Change Size");
                        System.out.println("2. Change Pizza Base");
                        System.out.println("3. Add Topping");
                        System.out.println("4. Remove Topping");
                        System.out.println("5. Order");
                        System.out.println("6. Cancel");
                        if(additionalDecision < 1 || additionalDecision > 6) {
                            System.out.println("Please enter your decision again: ");
                        }
                        else {
                            System.out.println("What would you like to do next: ");
                        }
                        while(!getKeyboard().hasNextInt()) {
                            System.out.println("Invalid choice: ");
                            getKeyboard().nextLine();
                        }
                        additionalDecision = Integer.parseInt(getKeyboard().nextLine());
                    }
                    if(additionalDecision == 5) {
                        orderPizza.orderPizza(userPizza);
                    }
                    else {
                        System.out.println("Goodbye! ");
                    }
                }
            }
            else {
                System.out.println("Have a good day! :)");
                exit = true;
            }
        }
    }
    public void setUserPizza() {
    }

    public void setAdditionalDecision() {
    }

    public Scanner getKeyboard() {
        return keyboard;
    }

    public void setKeyboard(Scanner keyboard) {
        this.keyboard = keyboard;
    }

    public FoodSet getIngredients() {
        return ingredients;
    }

    public FoodSet getMenu() {
        return menu;
    }
}
