package world.planets;

import character.NPCharacter;
import common.enums.Speciality;
import items.Drug;
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
        this.exits.replace("????", true);
    }

    @Override
    public void tellStory(Player p, String cameFrom) {
        System.out.println(this.lore.get("F000"));
        fillChoice(new String[]{"go","look"});
        switch (this.choice){
            case GO: // Suivre Dr Who
                System.out.println(this.lore.get("F001"));
                fillChoice(new String[]{"yes","no"});
                switch (this.choice){
                    case NO: // Suivre DR WHO
                    System.out.println(this.lore.get("F010"));
                    fillChoice(new String[]{"yes","no"});
                    switch (this.choice) {
                        case NO: // Se reposer !!!!!! Si on utilise un systeme de pt vie alors restore les pt vie
                            System.out.println(this.lore.get("F111")); // Pasteur join the crew
                            fillChoice(new String[]{"yes","no"});
                            switch (this.choice) {
                                case YES:
                                    System.out.println("You have hired Pasteur");
                                    p.add_crew(this.character); // ajout de pasteur
                                    break;
                            }
                            break;
                        case YES:
                            System.out.println(this.lore.get("F112"));
                            fillChoice(new String[]{"yes","no"});
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
                        fillChoice(new String[]{"use","take"});
                        switch (this.choice){
                            case USE:
                                System.out.println(this.lore.get("F121"));
                                p.addItems(new Drug());
                                fillChoice(new String[]{"yes","no"});
                                switch (this.choice){
                                    case YES:
                                        System.out.println("You have hired Pasteur");
                                        p.add_crew(this.character); // ajout de pasteur
                                        break;
                                }
                                break;
                            case TAKE:
                                System.out.println(this.lore.get("F122"));
                                fillChoice(new String[]{"yes","no"});
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
                fillChoice(new String[]{"go","use"});
                switch (this.choice){
                    case GO:
                        System.out.println(this.lore.get("F011"));
                        fillChoice(new String[]{"use","take"});
                        switch (this.choice){
                            case USE:
                                System.out.println(this.lore.get("F121"));
                                p.addItems(new Drug());
                                fillChoice(new String[]{"yes","no"});
                                switch (this.choice){
                                    case YES:
                                        System.out.println("You have hired Pasteur");
                                        p.add_crew(this.character); // ajout de pasteur
                                        break;
                                }
                                break;
                            case TAKE:
                                System.out.println(this.lore.get("F122"));
                                fillChoice(new String[]{"yes","no"});
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
