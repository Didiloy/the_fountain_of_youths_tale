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
        fillChoice(new String[]{"go","use"});
        switch (this.choice) {
            case GO:
                System.out.println(this.lore.get("end01"));
                System.exit(0);
                break;
            case USE:
                System.out.println(this.lore.get("story1"));
                fillChoice(new String[]{"attack","use"});
                switch (this.choice) {
                    case ATTACK:
                        System.out.println(this.lore.get("end01"));
                        System.exit(0);
                        break;
                    case USE:
                        System.out.println(this.lore.get("story2"));
                        if(hasWeapon(p)){
                            System.out.println(this.lore.get("win"));
                            System.exit(0);
                        }
                        else {
                            System.out.println(this.lore.get("loose"));
                            System.exit(0);
                        }
                        break;
                }
                break;
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
