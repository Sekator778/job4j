package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class StartUI {
    public void init(Input input, Tracker tracker, List<UserAction> actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ", actions.size());
            UserAction action = actions.get(select);
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(List<UserAction> actions) {
        System.out.println("Menu.");
        for (int index = 0; index < actions.size(); index++) {
            System.out.println(index + ". " + actions.get(index).name());
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Input validateInput = new ValidateInput(input);
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new CreateAction());
        actions.add(new ShowAllAction());
        actions.add(new ReplaceItemAction());
        actions.add(new DeleteAction());
        actions.add(new FindItemByIdAction());
        actions.add(new FindByNameAction());
        actions.add(new EndAction());
        new StartUI().init(validateInput, tracker, actions);
    }
}