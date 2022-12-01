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
        fillChoice(new String[]{"GO","LOOK"});
        switch (this.choice){
            case GO: // Suivre Dr Who
                System.out.println(this.lore.get("F001"));
                fillChoice(new String[]{"Yes","No"});
                switch (this.choice){
                    case NO: // Suivre DR WHO
                    System.out.println(this.lore.get("F010"));
                    fillChoice(new String[]{"Yes","No"});
                    switch (this.choice) {
                        case NO: // Se reposer !!!!!! Si on utilise un systeme de pt vie alors restore les pt vie
                            System.out.println(this.lore.get("F111")); // Pasteur join the crew
                            fillChoice(new String[]{"Yes","No"});
                            switch (this.choice) {
                                case YES:
                                    System.out.println("You have hired Pasteur");
                                    p.add_crew(this.character); // ajout de pasteur
                                    break;
                            }
                            break;
                        case YES:
                            System.out.println(this.lore.get("F112"));
                            fillChoice(new String[]{"Yes","No"});
                            switch (this.choice) {
                                case YES:
                                    System.out.println("You have hired Pasteur");
                                    p.add_crew(this.character);
                                    break;
                            }
                            break;
                    }
                    break;
                    case YES: // Aller en ville
                        System.out.println(this.lore.get("F011"));
                        fillChoice(new String[]{"USE","TAKE"});
                        switch (this.choice){
                            case USE:
                                System.out.println(this.lore.get("F121"));
                                fillChoice(new String[]{"Yes","No"});
                                switch (this.choice){
                                    case YES:
                                        System.out.println("You have hired Pasteur");
                                        p.add_crew(this.character); // ajout de pasteur
                                        break;
                                }
                                break;
                            case TAKE:
                                System.out.println(this.lore.get("F122"));
                                fillChoice(new String[]{"Yes","No"});
                                switch (this.choice){
                                    case YES:
                                        System.out.println("You have hired Pasteur");
                                        p.add_crew(this.character); // ajout de pasteur
                                        break;
                                }
                                break;
                        }
                        break;
                }
                break;
            case LOOK: // Ne pas le suivre
                System.out.println(this.lore.get("F002"));
                fillChoice(new String[]{"GO","USE"});
                switch (this.choice){
                    case GO:
                        System.out.println(this.lore.get("F011"));
                        fillChoice(new String[]{"USE","TAKE"});
                        switch (this.choice){
                            case USE:
                                System.out.println(this.lore.get("F121"));
                                fillChoice(new String[]{"Yes","No"});
                                switch (this.choice){
                                    case YES:
                                        System.out.println("You have hired Pasteur");
                                        p.add_crew(this.character); // ajout de pasteur
                                        break;
                                }
                                break;
                            case TAKE:
                                System.out.println(this.lore.get("F122"));
                                fillChoice(new String[]{"Yes","No"});
                                switch (this.choice) {
                                    case YES:
                                        System.out.println("You have hired Pasteur");
                                        p.add_crew(this.character); // ajout de pasteur
                                        break;
                                }
                                break;
                        }
                        break;
                    case USE:
                        System.out.println(this.lore.get("F222"));
                        System.exit(0);
                        break;
                }
        }
    }
}
