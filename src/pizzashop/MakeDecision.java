package pizzashop;

import ingredients.Pizza;

public record MakeDecision(pizzashop.commandPrompt commandPrompt) {

    void MakeDecision(Pizza userPizza, int additionalDecision) {
        commandPrompt.setUserPizza();
        commandPrompt.setAdditionalDecision();
        if (additionalDecision == 1) {
            commandPrompt.changeSize(userPizza);
        } else if (additionalDecision == 2) {
            commandPrompt.changeBase(userPizza);
        } else if (additionalDecision == 3) {
            commandPrompt.addTopping(userPizza);
        } else if (additionalDecision == 4) {
            commandPrompt.removeTopping(userPizza);
        } else {
            System.out.println("Please only enter 1-6");
        }
    }
}