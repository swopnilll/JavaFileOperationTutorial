



/**
 * The class represents a part offered by a Computer Shop.
 *
 * To create a part use the following constructor:
 *    new Part(String name, String description, double price, int quantityInStock)
 *
 */
public class Part
{
    private String name, description;
    private double price;
    private int quantityInStock;

    /**
     * Initialises a newly created Part object so that it represents an item in the Computer Shop
     */
    public Part()
    {
        this.name = "";
        this.description = "";
        this.price = 0;
        this.quantityInStock = 0;
    }

    /**
     * Constructs a new part object with the value of the passed in parameters
     *
     * @param name - the initial value of name
     * @param description - the initial value of description
     * @param price - the initial value of price
     * @param quantityInStock - how much is initially in stock at the shop
     */
    public Part(String name, String description, double price, int quantityInStock)
    {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantityInStock = quantityInStock;
    }

    /**
     * Return the description of the part
     *
     * @return the value of attribute description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the description of part to a new value
     *
     * @param description - new value of description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Return the name of the part
     *
     * @return the value of attribute name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of part to a new value
     *
     * @param name - new value of name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Return the price of the part
     *
     * @return the value of attribute price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Set the price of food to a new value
     *
     * @param price - new value of price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Return the quantity of stocks held
     *
     * @return the value of attribute quantityInStock
     */
    public int getQuantityInStock() {
        return quantityInStock;
    }

    /**
     * Consider one more has been sold hereafter, reducing the quantityInStock.
     *
     */
    public boolean sellOne()
    {
        boolean succeeded = false;
        if (quantityInStock > 0) {
            quantityInStock--;
            succeeded = true;
        }
        return succeeded;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    /**
     * Return a String representation of the object in a presentable format
     *
     * @return a String representation of the object
     */
    public String toString() {
        return "Name: " + name +
                "\nDescription: " + description +
                "\nPrice: " + price +
                "\nQuantity: " + quantityInStock;
    }
}
