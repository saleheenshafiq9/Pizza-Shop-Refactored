package ingredients;

public class PizzaBuilder {
    private final ingredients.showMenu showMenu = new showMenu();

    public SelectPizza MargaritaPizza() {
        SelectPizza pizza = new SelectPizza();
        pizza.addItem(new TomatoSauce());
        pizza.addItem(new MozzarellaCheese());
        pizza.addItem(new CheddarCheese());
        return pizza;
    }

    public SelectPizza HawaiianPizza() {
        SelectPizza pizza = new SelectPizza();
        pizza.addItem(new TomatoSauce());
        pizza.addItem(new MozzarellaCheese());
        pizza.addItem(new Pineapples());
        return pizza;
    }

    public SelectPizza MeatLoversPizza() {
        SelectPizza pizza = new SelectPizza();
        pizza.addItem(new BbqSauce());
        pizza.addItem(new MozzarellaCheese());
        pizza.addItem(new Onion());
        return pizza;
    }

    public SelectPizza SupremePizza() {
        SelectPizza pizza = new SelectPizza();
        pizza.addItem(new TomatoSauce());
        pizza.addItem(new MozzarellaCheese());
        pizza.addItem(new Olives());
        pizza.addItem(new Mushrooms());
        pizza.addItem(new Capsicum());
        pizza.addItem(new Salami());
        pizza.addItem(new Pineapples());
        return pizza;
    }

    public SelectPizza BbqChickenPizza() {
        SelectPizza pizza = new SelectPizza();
        pizza.addItem(new BbqSauce());
        pizza.addItem(new MozzarellaCheese());
        pizza.addItem(new Onion());
        pizza.addItem(new Chicken());
        return pizza;
    }

    public SelectPizza SpicySeafoodPizza() {
        SelectPizza pizza = new SelectPizza();
        pizza.addItem(new SweetChiliSauce());
        pizza.addItem(new MozzarellaCheese());
        pizza.addItem(new Onion());
        pizza.addItem(new Prawns());
        pizza.addItem(new Capsicum());
        return pizza;
    }

    public SelectPizza ChickenPrawnPizza() {
        SelectPizza pizza = new SelectPizza();
        pizza.addItem(new SweetChiliSauce());
        pizza.addItem(new Chicken());
        pizza.addItem(new Prawns());
        return pizza;
    }

    public void showMenu() {
        showMenu.showMenu();
    }
}
