package world.planets;

import character.NPCharacter;
import common.enums.Speciality;
import world.Location;

public class Belli extends Location {
    public Belli(String name) {
        super(name);
        this.character = new NPCharacter("Napologon", Speciality.STRATEGY);

    }
}
