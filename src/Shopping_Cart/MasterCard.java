/**
 * To change this template file, choose Settings | Editor | File and Code Templates
 * and change the template in the editor.
 */

package Shopping_Cart;

/**
 * @author AHMED ABUWARDA.
 */
public class MasterCard extends Payment {

    @Override
    public void paymentMethod() {

        System.out.print(Carts.box("\n\t*** Master Card ****")
                + "\n>> Enter your card number: ");
        super.setCardNumber(Carts.getInput().next());
        System.out.print(">> Exp Date: ");
        super.setExpDate(Carts.getInput().next());
        System.out.print(">> CCV: ");
        super.setCcv(Carts.getInput().nextInt());
        System.out.print(">> Enter amount: ");
        int price = Carts.getInput().nextInt();
        System.out.println(Carts.pay(price));


    }
}