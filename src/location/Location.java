package location;

import GameCharacter.GameCharacter;

public abstract class Location {
private String name;
private GameCharacter c1;

    public Location(GameCharacter c1) {
        this.c1 = c1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GameCharacter getChar() {
        return c1;
    }


}
