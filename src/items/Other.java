package items;

public class Other extends Items{
    String utilityType;
    int power;

    public Other(int ItemID, String ItemType, int price, String utilityType, int power) {
        super(ItemID, ItemType, price);
        this.utilityType=utilityType;
        this.power=power;
    }

    public String getUtilityType() {
        return utilityType;
    }

    public void setUtilityType(String utilityType) {
        this.utilityType = utilityType;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
    @Override
    public void generateItem(int ItemID, String ItemType, int price, int block) {
        new Armors(ItemID, ItemType, price, block);
    }


}
