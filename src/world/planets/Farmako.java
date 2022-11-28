package world.planets;

import character.NPCharacter;
import common.enums.Speciality;
import player.Player;
import world.Location;

public class Farmako extends Location {
    public Farmako(String name) {
        super(name);
        this.character = new NPCharacter("Pastor", Speciality.MEDICINE);
    }

    @Override
    public void createExits() {
        this.exits.replace("Belli", true);
        this.exits.replace("LastPlanet", true);
    }

    @Override
    public void tellStory(Player p, String cameFrom) {

    }
}
