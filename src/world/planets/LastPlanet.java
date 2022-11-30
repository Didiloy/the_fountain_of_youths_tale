package world.planets;

import items.Item;
import items.Weapon;
import player.Player;
import world.Location;

public class LastPlanet extends Location {
    public LastPlanet(String name) {
        super(name);
    }

    @Override
    public void createExits() {

    }

    @Override
    public void tellStory(Player p, String cameFrom) {
        System.out.println(this.lore.get("story0"));
        fillChoice();
        switch (this.choice) {
            case GO:
                System.out.println(this.lore.get("end01"));
                break;
            case USE:
                System.out.println(this.lore.get("story1"));
                fillChoice();
                switch (this.choice) {
                    case ATTACK:
                        System.out.println(this.lore.get("end01"));
                        break;
                    case USE:
                        System.out.println(this.lore.get("story2"));
                        if(hasWeapon(p)){
                            System.out.println(this.lore.get("win"));
                        }
                        else {
                            System.out.println(this.lore.get("loose"));
                        }
                        break;
                    default:
                        System.out.println("choisissez un autre argument");
                }
                break;
            default:
                System.out.println("choisissez un autre argument");
        }
    }

    private boolean hasWeapon(Player p) {
        boolean hasWeapon = false;
        for (Item i:p.getItems()) {
            if (i instanceof Weapon){
                if(i.getQuantity() > 1){
                    hasWeapon = true;
                    break;
                }
            }
        }
        return hasWeapon;
    }
}
