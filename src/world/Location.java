package world;

import character.NPCharacter;

import java.util.Map;

public abstract class Location {
    protected String name;
    public static String START_LOCATION = "Earth";
    public Map<Location, Boolean> exits;
    private NPCharacter character;

    public Map<String, String> lore;

    public Location(String name){
        this.name = name;
        //TODO parse les fichier appelé par le nom de la planete pour avoir le lore;
    }

    public NPCharacter getCharacter() {
        return character;
    }

    public String getName() {
        return name;
    }
}
