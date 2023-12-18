/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Manager;
import util.MyUtil;

/**
 *
 * @author Nhatthang
 */
public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu("Fruit Management Program");
        menu.add("1. Create Fruit");
        menu.add("2. View orders");
        menu.add("3. Shoping");
        menu.add("4. Exit");
        
        Manager manager = new Manager();
        int choice;
        do {
            menu.displayAllOption();
            choice = MyUtil.inputAnInteger("Choose (1 -> " + menu.size() + "): ", "Invalid!", 1, menu.size());
            switch(choice) {
                case 1:
                    manager.createFruit();
                    break;
                case 2:
                    manager.viewOrder();
                    break;
                case 3:
                    manager.shopping();
                    break;
                case 4:
                    System.out.println("Thank You");
                    break;
            }
        } while(choice != 4);        
    }
}
