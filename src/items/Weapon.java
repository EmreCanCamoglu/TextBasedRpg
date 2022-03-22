package items;

public class Weapon extends Items{
    private final int damage;
    private final String Item_Type= "Weapon";

    public Weapon(int ItemID, String ItemType, int price, int damage) {
        super(ItemID, ItemType, price);
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }


    public void generateItem(int ItemID, String ItemType, int price, int damage) {
        new Weapon(ItemID,ItemType,price,damage);

    }
}
