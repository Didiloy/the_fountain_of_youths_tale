package player;

import character.NPCharacter;
import items.Item;
import world.Location;
import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<NPCharacter> crew =  new ArrayList();
    private List<Item> items = new ArrayList();
    private Location currentLocation;

    public Player(){
//        this.currentLocation = world.getName();
    }

    public void add_crew(NPCharacter npc){
        this.crew.add(npc);
    }

    public List<NPCharacter> getCrew(){
        return this.crew;
    }
}

