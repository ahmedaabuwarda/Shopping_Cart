/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Shopping_Cart;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author AHMED ABUWARDA
 */
public class Carts extends Products {

    /**
     * Create ArrayList from class Products to store products objects.
     */
    private static ArrayList<Products> products = new ArrayList<>();
    /**
     * Create ArrayList from class Products to store products object to cart
     * object.
     */
    private static ArrayList<Products> cart = new ArrayList<>();
    /**
     * Create Scanner to take the input from the user.
     */
    private static Scanner input = new Scanner(System.in);

    /**
     * no-argument constructor
     */
    public Carts() {
        this(0, "Unknown", "Unknown", 0, 0);
    }

    /**
     * @param ID
     * @param name
     * @param description
     * @param price
     * @param quantity
     */
    public Carts(int ID, String name, String description, int price, int quantity) {
        super(ID, name, description, price, quantity);
    }

    /**
     * @return the products
     */
    public static ArrayList<Products> getProducts() {
        return products;
    }

    /**
     * @param aProducts the products to set
     */
    public static void setProducts(ArrayList<Products> aProducts) {
        products = aProducts;
    }

    /**
     * @return the cart
     */
    public static ArrayList<Products> getCart() {
        return cart;
    }

    /**
     * @param aCart the cart to set
     */
    public static void setCart(ArrayList<Products> aCart) {
        cart = aCart;
    }

    /**
     * @return the input
     */
    public static Scanner getInput() {
        return input;
    }

    /**
     * @param aInput the input to set
     */
    public static void setInput(Scanner aInput) {
        input = aInput;
    }

    /**
     * @param input
     * @return print main menu list and return input.nextInt()
     */
    public static int mainMenu(Scanner input) {
        System.out.print("\n" + box("\n|\t\t***** Main Menu *****\t\t|" + line()
                + "\n| 1: List all products.\t\t\t\t|\n| 2: Product details.\t\t\t\t|"
                + "\n| 3: Filter products.\t\t\t\t|\n| 4: List of products from cart.\t\t|"
                + "\n| 5: Add product to cart.\t\t\t|\n| 6: Remove product from cart.\t\t\t|"
                + "\n| 7: Empty cart.\t\t\t\t|\n| 8: Pay method.\t\t\t\t|\n| 0: Exit.\t\t\t\t\t|")
                + "\n>> Enter a choice(0-8): ");
        return input.nextInt();
    }

    /**
     * @return title
     */
    public static String title() {
        return "\nID\tName\tPrice\tQuantity\tDescription";
    }

    /**
     * @return string line of "----"
     */
    public static String line() {
        return "\n---------------------------------------------------";
    }

    /**
     * @param string
     * @return box header to any table or value
     */
    public static String box(String string) {
        return line() + string + line();
    }

    /**
     * @param i
     */
    public static void addProduct(int i) {
        getCart().add(new Carts(getProducts().get(i).getID(), getProducts().get(i).getName(),
                getProducts().get(i).getDescription(), getProducts().get(i).getPrice(),
                getProducts().get(i).getQuantity()));
    }

    /**
     * Remove product with specific ID NO.
     *
     * @param id
     */
    public static void removeProduct(int id) {
        getCart().remove(id);
    }

    /**
     * Clear all cart products list
     */
    public static void emptyCart() {
        getCart().clear();
    }

    /**
     * Method to Filter products and product details
     *
     * @param name
     * @param from
     * @param to
     * @param id
     */
    public static void filterAndProductDetails(String name, int from, int to, int id) {
        int counter = 0;
        System.out.println("\n\t\t*** The result ***" + box(title()));
        for (int i = 0; i < getProducts().size(); i++) {

            // Filter products
            if (Carts.getProducts().get(i).getName().contains(name)
                    && ((Carts.getProducts().get(i).getPrice() >= from)
                    && (Carts.getProducts().get(i).getPrice() <= to))) {
                System.out.println(print(i, getProducts()));
                counter++;

                // Product Details    
            } else if (getProducts().get(i).getID() == id) {
                System.out.println(print(i, getProducts()));
                counter++;
            }
        }
        System.out.println(box("\n" + counter + " item"));
    }

    /**
     * Method to list cart products and list products
     *
     * @param array
     * @param title
     * @param body
     */
    public static void list(ArrayList<Products> array, String title, String body) {
        System.out.println("\n\t\t*** The result ***" + title);
        for (int i = 0; i < array.size(); i++) {

            // List Products just ID and Name
            if (body.equals("products")) {
                System.out.println(array.get(i).getID() + "\t" + array.get(i).getName());

                // List all cart products
            } else if (body.equals("cart")) {
                System.out.println(print(i, array) + "\t\t" + i);
            }
        }
        System.out.println(box("\n" + array.size() + " items"));
    }

    /**
     * @param i
     * @param array
     * @return list of all products or specific one.
     */
    public static String print(int i, ArrayList<Products> array) {
        return array.get(i).getID() + "\t" + array.get(i).getName()
                + "\t" + array.get(i).getPrice()
                + "\t" + array.get(i).getQuantity()
                + "\t\t" + array.get(i).getDescription();
    }

    /**
     * @param price
     * @return payment
     */
    public static String pay(int price) {
        String payment;
        int totalPrice = 0;
        for (int i = 0; i < getCart().size(); i++) {
            totalPrice += getCart().get(i).getPrice();
        }
        if (totalPrice == price || totalPrice <= price) {
            payment = box("\n *** True, Payment Done Successfully ***");
        } else {
            payment = box("\n *** Not enough money to pay ***");
        }
        return payment;
    }

    /**
     * @param input
     * @return input.nextInt()
     */
    public static int paymentMethod(Scanner input) {
        System.out.print(box("\n*** You can pay by three payment method ***")
                + "\n1: Visa Card.\n2: Master Card.\n3: Paypal.\n0: Exit" + line() + "\nEnter your choice: ");
        return input.nextInt();
    }
}
