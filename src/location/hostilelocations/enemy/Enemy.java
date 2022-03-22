package location.hostilelocations.enemy;

public abstract class Enemy {
    private String name;
    private int health, damage, coin;

    public Enemy(){

    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getDamage() {
        return damage;
    }

    public int getCoin() {
        return coin;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }



}
