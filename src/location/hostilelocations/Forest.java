package location.hostilelocations;

import GameCharacter.GameCharacter;
import location.hostilelocations.enemy.Vampire;

public class Forest extends HostileLocation {

    public Forest(GameCharacter c1) {
        super(c1);
        setName("Forest");
        setEnemy(new Vampire());
        setQuestItem("Wood");
        setQuestItemPlace(1);
        setLuck(35);
    }
}
