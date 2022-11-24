package world;

import character.NPCharacter;
import java.util.Map;
import static common.files.FileHelper.parseCsvFile;

public abstract class Location {
    protected String name;
    public static String START_LOCATION = "Earth";
    public Map<Location, Boolean> exits;
    protected NPCharacter character;

    public Map<String, String> lore;

    public Location(String name) {
        this.name = name;
        this.lore = parseCsvFile("./src/resource/" + this.name + ".csv", this.name);
    }

    public NPCharacter getCharacter() {
        return character;
    }

    public String getName() {
        return name;
    }
}
