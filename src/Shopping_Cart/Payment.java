/**
 * To change this template file, choose Settings | Editor | File and Code Templates
 * and change the template in the editor.
 */

package Shopping_Cart;

/**
 * @author AHMED ABUWARDA.
 */
public abstract class Payment {

    // Data fields.
    private String cardNumber;
    private String expDate;
    private int ccv;

    // Abstract method.
    public abstract void paymentMethod();

    /**
     * @return The cardNumber.
     */
    public String getCardNumber() {
        return cardNumber;
    }

    /**
     * @param cardNumber The cardNumber to set.
     */
    protected void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    /**
     * @return The expDate.
     */
    public String getExpDate() {
        return expDate;
    }

    /**
     * @param expDate The expDate to set.
     */
    protected void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    /**
     * @return The ccv.
     */
    public int getCcv() {
        return ccv;
    }

    /**
     * @param ccv The ccv to set.
     */
    protected void setCcv(int ccv) {
        this.ccv = ccv;
    }

}