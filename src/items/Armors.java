package items;

public class Armors extends Items {
    private final int block;

    public Armors(int ItemID, String ItemType, int price, int block) {
        super(ItemID, ItemType, price);
        this.block = block;
    }

    public int getBlock() {
        return block;
    }

    @Override
    public void generateItem(int ItemID, String ItemType, int price, int block) {
        new Armors(ItemID, ItemType, price, block);
    }
}
