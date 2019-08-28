/**
 * To change this template file, choose Settings | Editor | File and Code Templates
 * and change the template in the editor.
 */

package Payment_Method;

import Shopping_Cart.Carts;
import Shopping_Cart.Payment;

/**
 * @author AHMED ABUWARDA.
 */
public class Paypal extends Payment {

    private String email;

    /**
     * @return The email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    private void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void paymentMethod() {

        System.out.print(Carts.box("\n\t*** Paypal ***") + "\n>> Enter your E-mail: ");
        setEmail(Carts.getInput().next());

        System.out.print(">> Enter amount of money: ");
        int price = Carts.getInput().nextInt();

        System.out.println(Carts.pay(price));

    }

}