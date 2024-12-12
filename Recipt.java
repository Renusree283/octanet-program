import java.util.*;
class Recipt {
    boolean veg;
    String premium;
    double cost;
    Recipt(boolean veg) {
        this.veg = veg;
    }
    double getCost() {
        cost = 0; 
        if (veg) {
            cost += 250;
            if (premium != null && premium.equals("yes")) {
                cost += 300;
            }
        } else {
            cost += 300;
        }
        return cost;
    }
    double addTopping(double cost, String topping) {
        if (topping.equals("cheese")) {
            cost += 20;
        } else if (topping.equals("chicken")) {
            cost += 50;
        } else if (topping.equals("onion")) {
            cost += 15;
        }
        return cost;
    }
    double addTax(double cost) {
        return cost + cost * 0.05;
    }
    double addDiscount(double cost, double discount) {
        return cost - (cost * discount);
    }
    public static void main(String[] args) {
        Scanner aa = new Scanner(System.in);
        String topping = "";
        double cost;
        System.out.println("\tWelcome to New Pizza");
        System.out.println("Choices :-");
        System.out.println("1. Veg Pizza");
        System.out.println("2. Non-Veg Pizza");
        System.out.print("Enter your choice: ");
        int choice = aa.nextInt();
        aa.nextLine();  
        Recipt recipt;
        if (choice == 1) {
            System.out.print("Do you want to go premium (yes or no): ");
            String premium = aa.nextLine();
            recipt = new Recipt(true);
            recipt.premium = premium;
        } else {
            recipt = new Recipt(false);
        }
        cost = recipt.getCost();
        System.out.println("Do you want to add toppings?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        System.out.print("Enter your option: ");
        int opt = aa.nextInt();
        if (opt == 1) {
            System.out.println("Toppings :-");
            System.out.println("1. Cheese");
            System.out.println("2. Chicken");
            System.out.println("3. Onion");
            System.out.print("Enter your choice: ");
            int ch = aa.nextInt();
            switch (ch) {
                case 1:
                    topping = "cheese";
                    break;
                case 2:
                    topping = "chicken";
                    break;
                case 3:
                    topping = "onion";
                    break;
                default:
                    topping = "";
                    break;
            }
            if (!topping.equals("")) {
                cost = recipt.addTopping(cost, topping);
            }
        } else {
            System.out.println("No topping is added");
        }
        System.out.println("Do you have any discount coupon?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        System.out.print("Enter your choice: ");
        int op = aa.nextInt();
        if (op == 1) {
            System.out.print("Enter the discount percentage (e.g. 0.10 for 10%): ");
            double discount = aa.nextDouble();
            cost = recipt.addDiscount(cost, discount);
        }
        cost = recipt.addTax(cost);
        System.out.println("Total cost: " + cost);
    }
}
