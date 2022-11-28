package world.planets;

import character.NPCharacter;
import common.enums.Speciality;
import player.Player;
import world.Location;

public class Dimidium extends Location {
    //TODO

    public Dimidium(String name) {
        super(name);
        this.character = new NPCharacter("None", Speciality.NONE);

    }

    @Override
    public void createExits() {
        this.exits.replace("Farmako", true);
        this.exits.replace("Belli", true);
        this.exits.replace("Najemnik", true);
    }

    @Override
    public void tellStory(Player p, String cameFrom) {

    }
}
