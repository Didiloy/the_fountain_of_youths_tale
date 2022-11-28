package world.planets;

import character.NPCharacter;
import common.enums.Speciality;
import player.Player;
import world.Location;

public class Enoplos extends Location {
    public Enoplos(String name) {
        super(name);
        this.character = new NPCharacter("Rambaw", Speciality.WEAPON);
    }

    @Override
    public void createExits() {
        this.exits.replace("Astronomiya", true);
        this.exits.replace("Dimidium", true);
    }

    @Override
    public void tellStory(Player p, String cameFrom) {

    }
}
