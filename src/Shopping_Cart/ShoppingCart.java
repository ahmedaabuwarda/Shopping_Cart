/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Shopping_Cart;

import static Shopping_Cart.Carts.*;

/**
 * @author AHMED ABUWARDA
 */
public class ShoppingCart {

    /**
     * @param args
     */
    public static void main(String[] args) {

        getProducts().add(new Products(0, "imac", "computer", 700, 16));
        getProducts().add(new Products(1, "iphone", "mopile", 620, 11));
        getProducts().add(new Products(2, "m701", "phone", 300, 19));
        getProducts().add(new Products(3, "sony", "cinema", 100, 5));
        getProducts().add(new Products(4, "mouse", "computer", 50, 6));

        int choice = 1;
        try {
            while (choice != 0) {

                choice = mainMenu(getInput());
                switch (choice) {
                    case 0: {
                        System.err.println(box("\nYou have terminate the program!, Thank You for using our program."));
                        break;
                    }
                    case 1: {
                        System.out.print(box("\n*** You are in list product option ***") + "\n");
                        list(getProducts(), box(title()), "products");
                        break;
                    }
                    case 2: {
                        System.out.print(box("\n*** You are in product details option ***")
                                + "\n>> Enter ID of product(0-" + (getProducts().size() - 1) + "): ");
                        int productID = getInput().nextInt();
                        if (productID >= 0 && productID <= (getProducts().size() - 1)) {
                            filterAndProductDetails("", 0, 0, productID);
                        } else {
                            System.out.println(box("\n*** Oops!, There is no such an product with this ID. ***"));
                        }
                        break;
                    }
                    case 3: {
                        System.out.print(box("\n*** You are in filter product option ***")
                                + "\n>> Enter name or part of name: ");
                        String name = getInput().next();
                        System.out.print(">> From: ");
                        int from = getInput().nextInt();
                        System.out.print(">> To: ");
                        int to = getInput().nextInt();
                        filterAndProductDetails(name, from, to, getProducts().size() + 1);
                        break;
                    }
                    case 4: {
                        System.out.println(box("\n*** You are in \"list product from cart\" option ***"));
                        list(getCart(), box(title() + "\tnew ID"), "cart");
                        break;
                    }
                    case 5: {
                        System.out.print(box("\n*** You are in \"adding product to cart\" option ***")
                                + "\n>> Enter product ID to add to cart(0-" + (getProducts().size() - 1) + "): ");
                        int productID = getInput().nextInt();
                        if (productID >= 0 && productID <= (getProducts().size() - 1)) {
                            addProduct(productID);
                            System.out.println(box("\n*** Product added to cart successfully ***"));
                        } else {
                            System.out.println(box("\n*** Oops!, there is no such an product with this ID NO. ***"));
                        }
                        break;
                    }
                    case 6: {
                        if (getCart().isEmpty()) {
                            System.out.println(box("\n*** You can not remove any product,"
                                    + " becouse the cart is already empty! ***"));
                        } else {
                            System.out.print(box("\n*** You are in \"remove product from cart\" option ***")
                                    + "\nEnter product ID to delete(0-" + (getCart().size() - 1) + "): ");
                            int id = getInput().nextInt();
                            if ((getCart().size() - 1) >= id && 0 <= id) {
                                removeProduct(id);
                                System.out.println(box("\n*** Product ID NO (" + id + ") was removed successfully ***"));
                            } else {
                                System.out.println(box("\n*** Invalid id, or the cart is empty ***"));
                            }

                        }
                        break;
                    }
                    case 7: {
                        if (getCart().isEmpty()) {
                            System.out.println(box("\n*** The cart is already empty! ***"));
                        } else {
                            emptyCart();
                            System.out.println(box("\n*** The cart have been emptied! ***"));
                        }
                        break;
                    }
                    case 8: {
                        if (getCart().isEmpty()) {
                            System.out.println(box("\n*** Your cart is empty, you need to add products to cart "
                                    + "in order to perform this operation. ***"));
                        } else {
                            int choi = paymentMethod(getInput());
                            switch (choi) {
                                case 0: {
                                    System.out.println(box("\n*** Thank you for using our payment methods ***"));
                                    break;
                                }
                                case 1: {
                                    Payment visa = new Visa();
                                    visa.paymentMethod();
                                    break;
                                }
                                case 2: {
                                    Payment master = new MasterCard();
                                    master.paymentMethod();
                                    break;
                                }
                                case 3: {
                                    Payment paypal = new Paypal();
                                    paypal.paymentMethod();
                                    break;
                                }
                            }
                            break;
                        }
                        break;
                    }
                    default: {
                        System.out.println(box("\nInvalid input!, Please try again."));
                        break;
                    }
                }
            }
        } catch (Exception e) {
            System.err.println(box("\nInvalid input!, Please try to enter "
                    + "integer number, not a string characters."));
        }

    }
}
