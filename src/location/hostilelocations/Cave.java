package location.hostilelocations;

import GameCharacter.GameCharacter;
import location.hostilelocations.enemy.Zombie;

public class Cave extends HostileLocation {


    public Cave(GameCharacter c1) {
        super(c1);
        setName("Cave");
        setEnemy(new Zombie());
        setQuestItem("Food");
        setQuestItemPlace(0);
        setLuck(40);

    }
}
