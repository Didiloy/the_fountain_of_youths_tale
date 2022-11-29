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
        System.out.println(this.lore.get("F000"));
        fillChoice();
        switch (this.choice){
            case GO: // Suivre Dr Who
                System.out.println(this.lore.get("F001"));
                fillChoice();
                switch (this.choice){
                    case NO: // Suivre DR WHO
                    System.out.println(this.lore.get("F010"));
                    fillChoice();
                    switch (this.choice){
                        case NO: // Se reposer !!!!!! Si on utilise un systeme de pt vie alors restore les pt vie
                        System.out.println(this.lore.get("F111")); // Pasteur join the crew
                            fillChoice();
                            switch (this.choice){
                                case YES:
                                    p.add_crew(this.character); // ajout de pasteur
                                    break;
                            }
                        case YES:
                            System.out.println(this.lore.get("F112"));
                            fillChoice();
                            switch (this.choice){
                                case YES:
                                    p.add_crew(this.character);
                                    break;
                            }
                    }

                    case YES: // Aller en ville
                        System.out.println(this.lore.get("F011"));
                        fillChoice();
                        switch (this.choice){
                            case USE:
                                System.out.println(this.lore.get("F121"));
                                switch (this.choice){
                                    case YES:
                                        p.add_crew(this.character); // ajout de pasteur
                                        break;
                                }
                            case TAKE:
                                System.out.println(this.lore.get("F122"));
                                switch (this.choice){
                                    case YES:
                                        p.add_crew(this.character); // ajout de pasteur
                                        break;
                                }
                        }
                }
            case LOOK: // Ne pas le suivre
                System.out.println(this.lore.get("F002"));
                fillChoice();
                switch (this.choice){
                    case GO:
                        System.out.println(this.lore.get("F011"));
                        fillChoice();
                        switch (this.choice){
                            case USE:
                                System.out.println(this.lore.get("F121"));
                                switch (this.choice){
                                    case YES:
                                        p.add_crew(this.character); // ajout de pasteur
                                        break;
                                }
                            case TAKE:
                                System.out.println(this.lore.get("F122"));
                                switch (this.choice) {
                                    case YES:
                                        p.add_crew(this.character); // ajout de pasteur
                                        break;
                                }
                        }
                    case USE:
                        System.out.println(this.lore.get("F222"));
                        break;
                }
        }
    }
}
