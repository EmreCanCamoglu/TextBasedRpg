package location.nonhositlelocations;

import GameCharacter.GameCharacter;
import items.Armors;
import items.Items;
import items.Other;
import items.Weapon;

import java.util.ArrayList;
import java.util.Arrays;

public class Store extends NonHostileLocation {

    private final String storeOwner = "Cuma";
    private final Armors[] armorShelf ={new Armors(1,"Light" ,15,1),new Armors(2,"Mediate" ,25,3),new Armors(3,"Heavy" ,40,5)};
    private final Weapon[] weaponShelf ={new Weapon(1,"Pistol",25,2),new Weapon(2,"Sword",35,3),new Weapon(3,"Rifle",45,7)};
    private final Other[] otherShelf ={new Other(1,"Tears of the Godddess", 100 ,"Healing", 4 ),new Other(2,"Wrath of Zeus", 150 ,"Damage", 7 ),new Other(3,"Mysterious Horseshoe", 100 ,"Luck", 15 )};
    private final Items[][] inventories = {armorShelf,weaponShelf,otherShelf};
//ARRAYLIST KULLANMAYA ÇALIŞŞŞŞŞŞŞŞŞŞŞŞŞŞŞŞŞŞŞŞŞŞŞŞ
    public Store(GameCharacter c1) {
        super(c1);
    }
    public void shopping(){
        displayInventory();

    }

    public void displayInventory(){
        ArrayList <Items> inventory = new ArrayList<>();
        for (Items[] items : inventories) {
            inventory.addAll(Arrays.asList(items));
        }
        System.out.println(inventory.toString());

    }
}
