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
        boolean astronomy = false;
        boolean weapon = false;
        boolean food = false;
        for ( NPCharacter caracter: p.getCrew()) {
            switch (caracter.getSpeciality()){
                case ASTRONOMY:
                    astronomy = true;
                    break;
                case WEAPON:
                    weapon = true;
                    break;
                case FOOD:
                    food = true;
            }
            if(astronomy && weapon && food){
                break;
            }


        }
        if (!astronomy){
            System.out.println(this.lore.get("exit_01"));
            System.exit(0);
        } else if (!weapon) {
            System.out.println(this.lore.get("exit_02"));
            System.exit(0);
        } else if (!food) {
            System.out.println(this.lore.get("exit_03"));
            System.exit(0);
        }else {
            System.out.println(this.lore.get("success"));
        }

    }
}
