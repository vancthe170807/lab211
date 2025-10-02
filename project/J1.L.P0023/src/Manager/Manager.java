package Manager;

import Entity.Fruit;
import Entity.Order;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 * @author THAYCACAC
 */
public class Manager {

    //display menu
    static int menu() {
        //loop until user want to exit
        System.out.println("========= [LAB211] J1.L.P0023 - MANAGE FRUIT SHOP =========");
        System.out.println("========= FRUIT SHOP SYSTEM =========");
        System.out.println("1. Create Fruit");
        System.out.println("2. View orders");
        System.out.println("3. Shopping (for buyer)");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
        int choice = Validation.checkInputIntLimit(1, 4);
        return choice;
    }

    //allow user create fruit
    static void createFruit(ArrayList<Fruit> lf) {
        //loop until user don't want to create fruit
        while (true) {
            System.out.print("Enter fruit id: ");
            String fruitId = Validation.checkInputString();
            //check id exist
            if (!Validation.checkIdExist(lf, fruitId)) {
                System.err.println("Id exist");
                return;
            }
            System.out.print("Enter fruit name: ");
            String fruitName = Validation.checkInputString();
            System.out.print("Enter price: ");
            double price = Validation.checkInputDouble();
            System.out.print("Enter quantity: ");
            int quantity = Validation.checkInputInt();
            System.out.print("Enter origin: ");
            String origin = Validation.checkInputString();
            lf.add(new Fruit(fruitId, fruitName, price, quantity, origin));
            //check user want to continue or not
            if (!Validation.checkInputYN()) {
                return;
            }
        }
    }

    //allow user show view order
    static void viewOrder(Hashtable<String, ArrayList<Order>> ht) {
        for (String name : ht.keySet()) {
            System.out.println("Customer: " + name);
            ArrayList<Order> lo = ht.get(name);
            displayListOrder(lo);
        }
    }

    //allow user buy items
    //allow user buy items
    static void shopping(ArrayList<Fruit> lf, Hashtable<String, ArrayList<Order>> ht) {
        //check list empty user can't buy
        if (lf.isEmpty()) {
            System.err.println("No have item.");
            return;
        }

        //loop until user don't want to buy continue
        ArrayList<Order> lo = new ArrayList<>();
        while (true) {
            displayListFruit(lf);

            // nếu toàn bộ quantity = 0 thì không còn hàng
            boolean hasFruit = false;
            for (Fruit f : lf) {
                if (f.getQuantity() > 0) {
                    hasFruit = true;
                    break;
                }
            }
            if (!hasFruit) {
                System.err.println("All fruits are sold out.");
                break;
            }

            System.out.print("Enter item from 1 to " + lf.size() + ": ");
            int item = Validation.checkInputIntLimit(1, lf.size());
            Fruit fruit = getFruitByItem(lf, item);

            // kiểm tra null an toàn
            if (fruit == null) {
                System.err.println("Invalid item. Please try again.");
                continue;
            }

            //display fruit user choose
            System.out.println("You choose: " + fruit.getFruitName());

            //check quantity of fruit
            System.out.print("Enter quantity: ");
            int quantity = Validation.checkInputIntLimit(1, fruit.getQuantity());
            fruit.setQuantity(fruit.getQuantity() - quantity);

            //check item exist or not
            if (Validation.checkItemExist(lo, fruit.getFruitId())) {
                updateOrder(lo, fruit.getFruitId(), quantity);
            } else {
                lo.add(new Order(fruit.getFruitId(), fruit.getFruitName(),
                        quantity, fruit.getPrice()));
            }

            if (!Validation.checkInputYN()) {
                break;
            }
        }

        if (lo.isEmpty()) {
            System.err.println("No order created.");
            return;
        }

        displayListOrder(lo);
        System.out.print("Enter name: ");
        String name = Validation.checkInputString();
        ht.put(name, lo);
        System.err.println("Add successful");
    }


    //display list fruit in shop
    static void displayListFruit(ArrayList<Fruit> lf) {
        int countItem = 1;
        String border = "+------------+--------------------+------------------+-------------------+";
        String header = String.format("|%-12s|%-20s|%-18s|%-19s|", "Item", "Fruit name", "Origin", "Price");
        System.out.println(border);
        System.out.println(header);
        System.out.println(border);
        for (Fruit fruit : lf) {
            if (fruit.getQuantity() != 0) {
                System.out.printf("|%-12d|%-20s|%-18s|%-18.0f$|\n",
                        countItem++, fruit.getFruitName(), fruit.getOrigin(), fruit.getPrice());
            }
        }
        System.out.println(border);
    }

    //get fruint user want to by
    static Fruit getFruitByItem(ArrayList<Fruit> lf, int item) {
        int countItem = 1;
        for (Fruit fruit : lf) {
            if (fruit.getQuantity() != 0) {
                if (countItem == item) {
                    return fruit;
                }
                countItem++;
            }
        }
        return null;
    }


    static void displayListOrder(ArrayList<Order> lo) {
        double total = 0;
        String border = "+----------------+----------+----------+----------+";
        String header = String.format("|%-16s|%-10s|%-10s|%-10s|", "Product", "Quantity", "Price", "Amount");
        System.out.println(border);
        System.out.println(header);
        System.out.println(border);
        for (Order order : lo) {
            double amount = order.getPrice() * order.getQuantity();
            System.out.printf("|%-16s|%-10d|%-9.0f$|%-9.0f$|\n",
                    order.getFruitName(), order.getQuantity(), order.getPrice(), amount);
            total += amount;
        }
        System.out.println(border);
        System.out.printf("|%-38s|%-9.0f$|\n", "Total", total);
        System.out.println(border);
    }


    //if order exist then update order
    static void updateOrder(ArrayList<Order> lo, String id, int quantity) {
        for (Order order : lo) {
            if (order.getFruitId().equalsIgnoreCase(id)) {
                order.setQuantity(order.getQuantity() + quantity);
                return;
            }
        }
    }
}
