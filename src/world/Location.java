package world;

import character.NPCharacter;
import common.enums.Argument;
import common.input.IncorrectNumberOfParameterException;
import common.input.UnrecognizableArgumentException;
import player.Player;

import java.util.HashMap;
import java.util.Map;
import static common.files.FileHelper.parseCsvFile;
import static common.input.parseArg.parseArgs;

public abstract class Location {
    protected String name;
    public static String START_LOCATION = "Earth";
    public Map<String, Boolean> exits;
    protected NPCharacter character;
    protected Argument choice = null;
    protected Map.Entry<Argument, String> answer = null;

    public Map<String, String> lore;

    public Location(String name) {
        this.name = name;
        this.lore = parseCsvFile("./src/resource/" + this.name + ".csv", this.name);
        this.exits = new HashMap<>(){{
            put("Astronomiya", false);
            put("Belli", false);
            put("Dimidium", false);
            put("Earth", false);
            put("Enoplos", false);
            put("Farmako", false);
            put("LastPlanet", false);
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
    public void fillChoice(){
        this.choice = null;
        this.answer = null;
        while (choice == null) {
            try {
                this.answer = parseArgs();
                this.choice = answer.getKey();
            } catch (UnrecognizableArgumentException | IncorrectNumberOfParameterException e) {
                System.out.println("You must enter a valid answer");
            }
        }
    }
}
