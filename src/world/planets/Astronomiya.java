package world.planets;

import character.NPCharacter;
import common.enums.Speciality;
import world.Location;

public class Astronomiya extends Location {
    public Astronomiya(String name) {
        super(name);
        this.character = new NPCharacter("Galilo", Speciality.ASTRONOMY);

    }
}
