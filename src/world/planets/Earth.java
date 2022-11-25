package world.planets;

import character.NPCharacter;
import common.enums.Speciality;
import world.Location;

public class Earth extends Location {
    public Earth(String name){
        super(name);
        this.character = new NPCharacter("McGryver", Speciality.NONE);
    }

    @Override
    public void createExits() {
        this.exits.replace("Enoplos", true);
        this.exits.replace("Zounkla", true);
        this.exits.replace("Astronomiya", true);
    }

    @Override
    public void tellStory() {

    }
}
