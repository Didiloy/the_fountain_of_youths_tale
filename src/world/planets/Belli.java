package world.planets;

import character.NPCharacter;
import common.enums.Speciality;
import character.Player;
import world.Location;

public class Belli extends Location {
    public Belli(String name) {
        super(name);
        this.character = new NPCharacter("Napologon", Speciality.STRATEGY);

    }

    @Override
    public void createExits() {
        this.exits.replace("????", true);
        this.exits.replace("Najemnik", true);
    }

    @Override
    public void tellStory(Player p, String cameFrom) {
        System.out.println(this.lore.get("Belli000"));
        fillChoice(new String[]{"go", "look"});
        switch (this.choice) {
            case GO:
                System.out.println(this.lore.get("Belli001"));
                break;
            case LOOK:
                System.out.println(this.lore.get("Belli002"));
                fillChoice(new String[]{"use", "go"});
                switch (this.choice) {
                    case USE:
                        System.out.println(this.lore.get("Belli021"));
                        fillChoice(new String[]{"take", "go"});
                        switch (this.choice){
                            case TAKE:
                                System.out.println(this.lore.get("Belli022"));
                                System.exit(0);
                                break;
                            case GO:
                                System.out.println(this.lore.get("Belli001"));
                                break;
                        }
                        break;
                    case GO:
                        System.out.println(this.lore.get("Belli001"));
                        break;
                }
                break;
        }
    }

}
