package world;

import character.NPCharacter;
import common.enums.Argument;
import common.input.IncorrectNumberOfParameterException;
import common.input.UnrecognizableArgumentException;
import character.Player;

import java.util.HashMap;
import java.util.Map;
import static common.files.FileHelper.parseCsvFile;
import static common.input.ParseArg.parseArgs;

public abstract class Location {
    protected String name;
    public static String START_LOCATION = "Earth";
    public Map<String, Boolean> exits;
    protected NPCharacter character;
    protected Argument choice = null;

    public Map<String, String> lore;

    public Location(String name) {
        this.name = name;
        this.lore = parseCsvFile("./src/resource/" + (this.name.equals("????") ? "LastPlanet" : this.name) + ".csv", this.name);
        if(this.lore.size() == 0) System.exit(1);
        this.exits = new HashMap<>(){{
            put("Astronomiya", false);
            put("Belli", false);
            put("Dimidium", false);
            put("Earth", false);
            put("Enoplos", false);
            put("Farmako", false);
            put("????", false);
            put("Najemnik", false);
            put("Zounkla", false);
        }};
    }

    public abstract void createExits();

    public NPCharacter getCharacter() {
        return character;
    }

    public String getName() {
        return name;
    }

    public abstract void tellStory(Player p, String cameFrom);
    public void fillChoice(String[] args){
        this.choice = null;
        while (choice == null) {
            try {
                this.choice = parseArgs(args);
            } catch (UnrecognizableArgumentException | IncorrectNumberOfParameterException e) {
                System.out.println(e.getMessage() + "\nYou must enter a valid answer");
            }
        }
    }

    public Map<String, Boolean> getExits(){
        return this.exits;
    }
}
