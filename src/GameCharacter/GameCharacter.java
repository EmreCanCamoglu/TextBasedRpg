package GameCharacter;

import items.Armors;
import items.Items;
import items.Other;
import items.Weapon;

import java.util.Scanner;

public class GameCharacter {
    Scanner input = new Scanner(System.in);



    private int damage;
    private int health;
    private int money;
    private  int healthbar;
    private String name;
    private Items[] bag = {new Weapon(0, "empty", 0, 0),
            new Armors(0,"empty", 0,0),
            new Other(0, "empty",0,"empty",0)};
    private Boolean[] questItems = {false,false,false};



    public GameCharacter() {
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Items[] getBag() {
        return bag;
    }

    public void setBag(Items[] bag) {
        this.bag = bag;
    }

    public int getHealthbar() {
        return healthbar;
    }

    public void setHealthbar(int healthbar) {
        this.healthbar = healthbar;
    }

    public Boolean getQuestItems(int place) {
        return questItems[place];
    }

    public Boolean[] getQuestItems() {
        return questItems;
    }

    public void SelectCharacter(int selection) {
        switch (selection) {
            case 1:
                setName("Samurai");
                setDamage(5);
                setHealth(21);
                setHealthbar(21);
                setMoney(15);
                break;
            case 2:
                setName("Archer");
                setDamage(7);
                setHealth(18);
                setHealthbar(18);
                setMoney(20);
                break;
            case 3:
                setName("Knight");
                setDamage(8);
                setHealth(24);
                setHealthbar(24);
                setMoney(5);
                break;
            case 4:
                setName("Godzilla");
                setDamage(50);
                setHealth(50);
                setHealthbar(50);
                setMoney(100);
                break;
            default:
                System.out.println("Wrong choice pal! Try again ;)");
                SelectCharacter(input.nextInt());

        }

    }

    public String[] displayBag(){
        return new String[]{this.bag[0].getItemType(),this.bag[1].getItemType(),this.bag[2].getItemType()};
    }

    public void addMoney(int coin){
        this.money += coin;
    }

    public void gotQuestItem(int place){
        this.questItems[place] = true;
    }


}
