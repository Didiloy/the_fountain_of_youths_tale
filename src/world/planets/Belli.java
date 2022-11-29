package world.planets;

import character.NPCharacter;
import common.enums.Speciality;
import player.Player;
import world.Location;

public class Belli extends Location {
    public Belli(String name) {
        super(name);
        this.character = new NPCharacter("Napologon", Speciality.STRATEGY);

    }

    @Override
    public void createExits() {
        this.exits.replace("LastPlanet", true);
        this.exits.replace("Najemnik", true);
    }

    @Override
    public void tellStory(Player p, String cameFrom) {
        System.out.println(this.lore.get("Belli000"));
        fillChoice();
        switch (this.choice) {
            case GO:
                System.out.println(this.lore.get("Belli001"));
                break;
            case LOOK:
                System.out.println(this.lore.get("Belli002"));
                fillChoice();
                switch (this.choice) {
                    case USE:
                        System.out.println(this.lore.get("Belli021"));
                        fillChoice();
                        switch (this.choice){
                            case TAKE:
                                System.out.println(this.lore.get("Belli022"));
                                break;
                            case GO:
                                System.out.println(this.lore.get("Belli001"));
                                break;
                        }
                    case GO:
                        System.out.println(this.lore.get("Belli001"));
                        break;
                }
            default:
                System.out.println("choisissez un autre argument");
        }
    }

}
