/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import model.Fruit;
import util.MyUtil;

/**
 *
 * @author Nhatthang
 */
public class Manager {

    private ArrayList<Fruit> fruitList;
    private Hashtable<String, ArrayList<Fruit>> orderList;

    public Manager() {
        fruitList = new ArrayList<>();
        orderList = new Hashtable<>();
    }

    public void displayAllFruit() {
        for (Fruit fruit : fruitList) {
            System.out.println(fruit);
        }
    }

    public String getOrderHeader() {
        return String.format("|%-15s|%-8s|%-7s|%-6s|",
                "Product", "Quantity", "Price", "Amount");
    }

    public String orderToString(Fruit x) {
        return String.format("|%-15s|%-8s|%-7s|%-6.2f|",
                x.getName(), x.getQuantity(), x.getPrice(), x.getPrice() * x.getQuantity());
    }

    public void createFruit() {
        do {
            int id = fruitList.size() + 1;
            String name = MyUtil.inputAString("Fruit name: ");
            String origin = MyUtil.inputAString("Origin: ");
            double price = MyUtil.inputADouble("Price: ", "Price must be positive number!", 0);
            fruitList.add(new Fruit(id, name, price, 0, origin));
            System.out.println("Create Fruit successfully");

            if (!MyUtil.selectYesNo("Do you want to continue (Y/N): ", "Y/N only!", "Y", "N")) {
                System.out.println("List of fruit: ");
                System.out.println(Fruit.getHeader());
                displayAllFruit();
                break;
            }
        } while (true);

    }

    public void shopping() {
        do {
            System.out.println("List of fruit: ");
            System.out.println(Fruit.getHeader());
            displayAllFruit();
            int maxItem = fruitList.size();
            int itemSelected = MyUtil.inputAnInteger("Choose an item you want to buy (1 -> " + maxItem + ") : ",
                    "Item must be an integer in (1 -> " + maxItem + ") : ", 1, maxItem);
            Fruit fruitSelected = fruitList.get(itemSelected - 1);
            System.out.println("You selected: " + fruitSelected.getName());
            int quantity = MyUtil.inputAnInteger("Please input quantity: ", "Quantity must be an positive integer", 0);
            fruitSelected.setQuantity(quantity);

            if (MyUtil.selectYesNo("Do you want to order now (Y/N): ", "Y/N only!", "Y", "N")) {
                System.out.println(getOrderHeader());
                System.out.println(orderToString(fruitSelected));
                System.out.println("Total: " + fruitSelected.getQuantity() * fruitSelected.getPrice());

                String costumerName = MyUtil.inputAString("Input your name: ");
                if (!orderList.containsKey(costumerName)) {
                    orderList.put(costumerName, new ArrayList<>());
                }
                ArrayList<Fruit> curList = orderList.get(costumerName);
                curList.add(fruitSelected);
                break;
            }
        } while (true);
    }

    public void viewOrder() {
        if (orderList.isEmpty()) {
            System.out.println("List is empty");
            return; 
        }
        for (String name : orderList.keySet()) {
            System.out.println("Customer: " + name);
            System.out.println(getOrderHeader());
            double total = 0;
            for (Fruit fruit : orderList.get(name)) {
                System.out.println(orderToString(fruit));
                total += fruit.getQuantity() * fruit.getPrice();
            }
            System.out.println("Total: " + total);
        }
    }
}
