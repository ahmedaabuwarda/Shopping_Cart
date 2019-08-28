/**
 * To change this template file, choose Settings | Editor | File and Code Templates
 * and change the template in the editor.
 */

package Shopping_Cart;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author AHMED ABUWARDA.
 */
public class Carts extends Products {

    // Create ArrayList from class Products to store products objects.
    private static ArrayList<Products> products = new ArrayList<>();

    // Create ArrayList from class Products to store products object to cartobject.
    private static ArrayList<Products> cart = new ArrayList<>();

    // Create Scanner to take the input from the user.
    private static Scanner input = new Scanner(System.in);

    // no-argument constructor.
    public Carts() {

        this(0, "Unknown", "Unknown", 0, 0);

    }

    /**
     * @param ID          Any int number.
     * @param name        Any String.
     * @param description Any String.
     * @param price       Any int number.
     * @param quantity    Any int number.
     */
    private Carts(int ID, String name, String description, int price, int quantity) {

        super(ID, name, description, price, quantity);

    }

    /**
     * @return The products.
     */
    public static ArrayList<Products> getProducts() {
        return products;
    }

    /**
     * @param aProducts The products to set.
     */
    public static void setProducts(ArrayList<Products> aProducts) {
        products = aProducts;
    }

    /**
     * @return The cart.
     */
    public static ArrayList<Products> getCart() {
        return cart;
    }

    /**
     * @param aCart The cart to set.
     */
    public static void setCart(ArrayList<Products> aCart) {
        cart = aCart;
    }

    /**
     * @return The input.
     */
    public static Scanner getInput() {
        return input;
    }

    /**
     * @param aInput The input to set.
     */
    public static void setInput(Scanner aInput) {
        input = aInput;
    }

    /**
     * @param input A scanner input.
     * @return Print main menu list and return input.nextInt().
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
     * @return Title.
     */
    public static String title() {
        return "\nID\tName\tPrice\tQuantity\tDescription";
    }

    /**
     * @return String line of "----".
     */
    private static String line() {
        return "\n---------------------------------------------------";
    }

    /**
     * @param string Any String.
     * @return Box header to any table or value.
     */
    public static String box(String string) {
        return line() + string + line();
    }

    /**
     * @param i Any int number.
     */
    public static void addProduct(int i) {

        getCart().add(new Carts(getProducts().get(i).getID(), getProducts().get(i).getName(),
                getProducts().get(i).getDescription(), getProducts().get(i).getPrice(),
                getProducts().get(i).getQuantity()));

    }

    /**
     * @param id Remove product with specific ID NO.
     */
    public static void removeProduct(int id) {
        getCart().remove(id);
    }

    // Clear all cart products list.
    public static void emptyCart() {
        getCart().clear();
    }

    /**
     * Method to Filter products and product details.
     *
     * @param name Any String
     * @param from Any int number.
     * @param to   Any int number.
     * @param id   Any int number.
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
     * Method to list cart products and list products.
     *
     * @param array An ArrayList.
     * @param title Any string.
     * @param body  Any string.
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
     * @param i     Any int number.
     * @param array An ArrayList.
     * @return list of all products or specific one.
     */
    private static String print(int i, ArrayList<Products> array) {

        return array.get(i).getID() + "\t" + array.get(i).getName()
                + "\t" + array.get(i).getPrice()
                + "\t" + array.get(i).getQuantity()
                + "\t\t" + array.get(i).getDescription();

    }

    /**
     * @param price Any int number.
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
     * @param input A scanner input.
     * @return input.nextInt().
     */
    public static int paymentMethod(Scanner input) {

        System.out.print(box("\n*** You can pay by three payment method ***")
                + "\n1: Visa Card.\n2: Master Card.\n3: Paypal.\n0: Exit" + line() + "\nEnter your choice: ");
        return input.nextInt();

    }

}