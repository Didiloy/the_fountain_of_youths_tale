package world.planets;

import character.NPCharacter;
import common.enums.Speciality;
import world.Location;

public class Earth extends Location {
    public Earth(String name){
        super(name);
        this.character = new NPCharacter("McGryver", Speciality.NONE);
    }
}
