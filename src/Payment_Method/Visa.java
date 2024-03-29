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
public class Visa extends Payment {

    @Override
    public void paymentMethod() {

        System.out.print(Carts.box("\n\t*** Visa Card ***") + "\n>> Enter your card number: ");
        super.setCardNumber(Carts.getInput().next());

        System.out.print(">> Exp Date: ");
        super.setExpDate(Carts.getInput().next());

        System.out.print(">> CCV: ");
        super.setCcv(Carts.getInput().nextInt());

        System.out.print(">> Enter amount of money: ");
        int price = Carts.getInput().nextInt();

        System.out.println(Carts.pay(price));

    }

}