public class InventoryItem {
    private int stockUnit = 0;
    private String itemDescription = "";
    private double unitPrice = 0.0;
    private int stockQuantity = 0;

    public InventoryItem(
        int stockUnit, String itemDescription,
        double unitPrice, int stockQuantity
    ) {
        stockUnit = this.stockUnit;
        itemDescription = this.itemDescription;
        unitPrice = this.unitPrice;
        stockQuantity = this.stockQuantity;
    }

    public int GetStockUnit() { return stockUnit; }

    public String GetItemDescription() { 
        return itemDescription
    };

    public double GetUnitPrice() { return unitPrice; }

    public int GetStockQuantity() { return stockQuantity; }

    public void SetStockUnit( int stockUnit ) {
        stockUnit = this.stockUnit;
    }

    public void SetItemDescription( 
        String itemDescription 
    ) {
        itemDescription = this.itemDescription;
    }

    public void SetUnitPrice( double unitPrice ) {
        unitPrice = this.unitPrice;
    }

    public void SetStockQuantity( int stockQuantity ) {
        stockQuantity = this.stockQuantity;
    }
}