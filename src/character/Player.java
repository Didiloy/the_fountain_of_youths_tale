package character;

import items.Item;
import world.Location;
import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<NPCharacter> crew =  new ArrayList();
    private List<Item> items = new ArrayList();
    private Location currentLocation;

    public Player(){}

    public void add_crew(NPCharacter npc){
        this.crew.add(npc);
    }

    public List<NPCharacter> getCrew(){
        return this.crew;
    }

    public List<Item> getItems(){
        return  this.items;
    }
    public void addItems(Item i){
        this.items.add(i);
    }
}

