package world.planets;

import character.NPCharacter;
import common.enums.Speciality;
import world.Location;

public class Enoplos extends Location {
    public Enoplos(String name) {
        super(name);
        this.character = new NPCharacter("Rambaw", Speciality.WEAPON);
    }
}
