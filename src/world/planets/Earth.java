package world.planets;

import character.NPCharacter;
import common.enums.Speciality;
import character.Player;
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
        fillChoice(new String[]{"yes", "no"});
        switch (this.choice) {
            case YES:
                System.out.println(this.lore.get("Earth001"));
                fillChoice(new String[]{"go", "use"});
                switch (this.choice) {
                    case GO:
                        System.out.println(this.lore.get("Earth011"));
                        p.add_crew(new NPCharacter("Mc Gryver",Speciality.ENGINEERING));
                        break;
                    case USE:
                        System.out.println(this.lore.get("Earth021"));
                        System.exit(0);
                        break;
                    default:
                        System.out.println("choisissez un autre argument");
                }
                break;
            case NO:
                System.out.println(this.lore.get("Earth002"));
                System.exit(0);
                break;
//            default:
//                System.out.println("choisissez un autre argument");

        }
    }
}
