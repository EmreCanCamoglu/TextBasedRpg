package items;

public abstract class Items {

    private final int ItemID;
    private final String ItemType;
    private int price;




    public Items(int ItemID, String ItemType, int price) {
        this.ItemID = ItemID;
        this.ItemType = ItemType;
        this.price = price;
    }

    public int getItemID() {
        return ItemID;
    }

    public String getItemType() {
        return ItemType;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void generateItem(int ItemID, String ItemType, int price, int block) {
        new Armors(ItemID,ItemType,price,block);
    }
}


