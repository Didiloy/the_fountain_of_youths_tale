package world.planets;

import character.NPCharacter;
import common.enums.Speciality;
import world.Location;

public class Najemnik extends Location {
    public Najemnik(String name) {
        super(name);
        this.character = new NPCharacter("Army", Speciality.NONE);
    }

}
