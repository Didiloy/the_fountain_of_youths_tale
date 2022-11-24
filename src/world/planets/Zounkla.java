package world.planets;

import character.NPCharacter;
import common.enums.Speciality;
import world.Location;

public class Zounkla extends Location {
    public Zounkla(String name) {
        super(name);
        this.character = new NPCharacter("Diana", Speciality.FOOD);

    }
}
