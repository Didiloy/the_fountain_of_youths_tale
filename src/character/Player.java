package character;

import items.Item;
import world.Location;

import java.util.ArrayList;

public class Player {
    private ArrayList<Item> _items;
    private Location _currentLocation;
    private ArrayList<NPCharacter> _crew;

    private String _name;
    public Player(){}

    public ArrayList<Item> getItems() {
        return _items;
    }

    public ArrayList<NPCharacter> getCrew() {
        return _crew;
    }

    public String getName() {
        return _name;
    }

    public Location getCurrentLocation() {
        return _currentLocation;
    }
}
