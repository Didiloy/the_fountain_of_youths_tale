package world.planets;

import character.NPCharacter;
import common.enums.Speciality;
import player.Player;
import world.Location;

public class Najemnik extends Location {
    public Najemnik(String name) {
        super(name);
        this.character = new NPCharacter("Army", Speciality.NONE);
    }

    @Override
    public void createExits() {
        this.exits.replace("Farmako", true);
        this.exits.replace("LastPlanet", true);
    }

    @Override
    public void tellStory(Player p, String cameFrom) {
        System.out.println(this.lore.get("N000"));
        fillChoice();
        switch (this.choice){
            case GO: // FUIR DE LA 1ere Bataille
                System.out.println(this.lore.get("N001"));
                fillChoice();
                switch (this.choice){
                    case GO: // Fuir de la 2nd bataille
                        System.out.println(this.lore.get("N011"));
                        break;
                    case USE: // Attaquer la base
                        System.out.println(this.lore.get("N012"));
                        fillChoice();
                        switch (this.choice){
                            case ATTACK ->{
                                System.out.println(this.lore.get("N021"));
                                p.add_crew(this.character);
                                break;
                            }
                            case GO -> {
                                System.out.println(this.lore.get("N021"));
                                //SI NOUS FAISON UN SYSTEME D'ARMEE IL FAUT ENLEVER DES UNITES A CES ARMEES
                                break;
                            }
                        }
                }

            case USE: // Engager la 1ere bataille
                System.out.println(this.lore.get("N002"));
                fillChoice();
                switch (this.choice){
                    case ATTACK -> {
                        System.out.println(this.lore.get("N021"));
                        p.add_crew(this.character);
                        break;
                    }
                    case GO -> {
                        System.out.println(this.lore.get("N022"));
                        fillChoice();
                        switch (this.choice) {
                            case ATTACK -> {
                                System.out.println(this.lore.get("N021"));
                                p.add_crew(this.character);
                                break;
                            }
                            case GO ->{
                                System.out.println(this.lore.get("N021"));
                                //SI NOUS FAISON UN SYSTEME D'ARMEE IL FAUT ENLEVER DES UNITES A CES ARMEES
                                break;
                        }
                    }
                }
            }
        }
    }
}
