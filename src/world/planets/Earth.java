package world.planets;

import character.NPCharacter;
import common.enums.Speciality;
import player.Player;
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
    public void tellStory(Player p, String cameFrom) {
        System.out.println(this.lore.get("story"));
        fillChoice();
        switch (this.choice) {
            case YES:
                System.out.println(this.lore.get("Earth001"));
                fillChoice();
                switch (this.choice) {
                    case GO:
                        System.out.println(this.lore.get("Earth011"));
                        fillChoice();
                        switch (this.choice) {
                            case GO:
                                //TODO changer de planete en fonction du deuxiéme argument
                            default:
                                System.out.println("choisissez un autre argument");
                        }
                        break;
                    case USE:
                        System.out.println(this.lore.get("Earth021"));
                        break;
                    default:
                        System.out.println("choisissez un autre argument");
                }
                break;
            case NO:
                System.out.println(this.lore.get("Earth002"));
                break;
            default:
                System.out.println("choisissez un autre argument");

        }
    }
}
