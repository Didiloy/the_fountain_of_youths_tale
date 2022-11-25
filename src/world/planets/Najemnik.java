package world.planets;

import character.NPCharacter;
import common.enums.Speciality;
import world.Location;

public class Najemnik extends Location {
    public Najemnik(String name) {
        super(name);
        this.character = new NPCharacter("Army", Speciality.NONE);
    }

    @Override
    public void createExits() {
        this.exits.replace("Farmako", true);
        this.exits.replace("LastPlanet", true);
    }

    @Override
    public void tellStory() {

    }

}
