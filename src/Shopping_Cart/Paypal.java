/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Shopping_Cart;

/**
 * @author AHMED ABUWARDA
 */
public class Paypal extends Payment {

    private String email;

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void paymentMethod() {

        System.out.print(Carts.box("\n\t*** Paypal ***")
                + "\n>> Enter your E-mail: ");
        setEmail(Carts.getInput().next());
        System.out.print(">> Enter amount of money: ");
        int price = Carts.getInput().nextInt();
        System.out.println(Carts.pay(price));

    }
}
