/**
 * @author: Jeremy Brothers
 * @version: 1/9/2018
 * Title: Lab2
 * Description: This class stores data points for a given inventory item.
 */
public class InventoryItem {
    private int stockUnit = 0;
    private String itemDescription = "";
    private double unitPrice = 0.0;
    private int stockQuantity = 0;

    /**
     * This constructor initializes a new InventoryItem with each private member.
     * 
     * @param itemDescription : The name of the item
     * @param stockUnit : The id code assocciated with the item
     * @param unitPrice : the price for each unit
     * @param stockQuantity : the number units available in the warehouse
     */
    public InventoryItem( String itemDescription,  int stockUnit, double unitPrice, int stockQuantity ) {
        this.itemDescription = itemDescription;
        this.stockUnit = stockUnit;
        this.unitPrice = unitPrice;
        this.stockQuantity = stockQuantity;
    }

    /**
     * Returns the stock unit
     * @return stockUnit (int)
     */
    public int GetStockUnit() { return stockUnit; }

    /**
     * Returns the item description
     * @return itemDescription (string)
     */
    public String GetItemDescription() { return itemDescription; };

    /**
     * Returns the unit price
     * @return unitPrice (double)
     */
    public double GetUnitPrice() { return unitPrice; }

    /**
     * Returns the quantity
     * @return stockQuantity (int)
     */
    public int GetStockQuantity() { return stockQuantity; }

    /**
     * Takes an int paramter and sets it to the corresponding private member
     * @param stockUnit : The id number for the item
     */
    public void SetStockUnit( int stockUnit ) { stockUnit = this.stockUnit; }

    /**
     * Takes an String paramter and sets it to the corresponding private member
     * @param itemDescription : the name of the item
     */
    public void SetItemDescription( String itemDescription ) { itemDescription = this.itemDescription; }

    /**
     * Takes an double paramter and sets it to the corresponding private member
     * @param unitPrice : The price for each unit
     */
    public void SetUnitPrice( double unitPrice ) { unitPrice = this.unitPrice; }

    /**
     * Takes an int paramter and sets it to the corresponding private member
     * @param stockQuantity : The number of items in stock
     */
    public void SetStockQuantity( int stockQuantity ) { stockQuantity = this.stockQuantity; }

    /**
     * Concantonates the selected private members arnd rturns them as a single string.
     * @return a string describing the item.
     */
    public String ToString() {
        return (
            itemDescription + " " +
            stockUnit + " " +
            unitPrice + " " +
            stockQuantity
        );
    }
}