/**
 * To change this template file, choose Settings | Editor | File and Code Templates
 * and change the template in the editor.
 */

package Shopping_Cart;

/**
 * @author AHMED ABUWARDA.
 */
public class Products {

    // Data fields.
    private int ID;
    private String name;
    private String description;
    private int price;
    private int quantity;

    // no-arguments Constructor.
    public Products() {

        this(0, "Unknown", "Unknown", 0, 0);

    }

    /**
     * @param ID          Any int number.
     * @param name        Any String.
     * @param description Any String.
     * @param price       Any int number.
     * @param quantity    Any int number.
     */
    public Products(int ID, String name, String description, int price, int quantity) {

        setID(ID);                    // this.ID = ID;
        setName(name);                // this.name = name;
        setDescription(description);  // this.description = description;
        setPrice(price);              // this.price = price;
        setQuantity(quantity);        // this.quantity = quantity;

    }

    /**
     * @return ID.
     */
    int getID() {
        return ID;
    }

    /**
     * @param ID The ID to set.
     */
    private void setID(int ID) {
        this.ID = ID;
    }

    /**
     * @return Name.
     */
    String getName() {
        return name;
    }

    /**
     * @param name Set name.
     */
    private void setName(String name) {
        this.name = name;
    }

    /**
     * @return The description.
     */
    String getDescription() {
        return description;
    }

    /**
     * @param description Set description.
     */
    private void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return The price.
     */
    int getPrice() {
        return price;
    }

    /**
     * @param price Set the price.
     */
    private void setPrice(int price) {
        this.price = price;
    }

    /**
     * @return The quantity.
     */
    int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity Set Quantity.
     */
    private void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}