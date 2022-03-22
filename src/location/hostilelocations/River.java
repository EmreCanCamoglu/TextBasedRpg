package location.hostilelocations;

import GameCharacter.GameCharacter;
import location.hostilelocations.enemy.Bear;

public class River extends HostileLocation {

    public River(GameCharacter c1) {
        super(c1);
        setName("River");
        setEnemy(new Bear());
        setQuestItem("Water");
        setQuestItemPlace(2);
        setLuck(30);
    }
}
