/**
 * To change this template file, choose Settings | Editor | File and Code Templates
 * and change the template in the editor.
 */

package Shopping_Cart;

/**
 * @author AHMED ABUWARDA.
 */
public class Products {

    private int ID;
    private String name;
    private String description;
    private int price;
    private int quantity;

    /**
     * no-arguments Constructor
     */
    public Products() {
        this(0, "Unknown", "Unknown", 0, 0);
    }

    /**
     * @param ID
     * @param name
     * @param description
     * @param price
     * @param quantity
     */
    public Products(int ID, String name, String description, int price, int quantity) {
        setID(ID);                    // this.ID = ID;
        setName(name);                // this.name = name;
        setDescription(description);  // this.description = description;
        setPrice(price);              // this.price = price;
        setQuantity(quantity);        // this.quantity = quantity;
    }

    /**
     * @return ID
     */
    public int getID() {
        return ID;
    }

    /**
     * @param ID
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * @return Name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return Description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return Price
     */
    public int getPrice() {
        return price;
    }

    /**
     * @param price
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * @return Quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
