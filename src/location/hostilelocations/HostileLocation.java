package location.hostilelocations;

import GameCharacter.GameCharacter;
import location.Location;
import location.hostilelocations.enemy.Enemy;

public abstract class HostileLocation extends Location {
    private Enemy enemy;
    private String questItem;
    private int questItemPlace, luck;


    public HostileLocation(GameCharacter c1) {
        super(c1);
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }

    public String getQuestItem() {
        return questItem;
    }

    public void setQuestItem(String questItem) {
        this.questItem = questItem;
    }

    public int getQuestItemPlace() {
        return questItemPlace;
    }

    public void setQuestItemPlace(int questItemPlace) {
        this.questItemPlace = questItemPlace;
    }

    public int getLuck() {
        return luck;
    }

    public void setLuck(int luck) {
        this.luck = luck;
    }
}
