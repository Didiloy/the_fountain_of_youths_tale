package world;

import character.NPCharacter;

import java.util.Map;
import java.util.HashMap;

public abstract class Location {
    protected String name;
    public static String START_LOCATION = "Earth";
    public Map<Location, Boolean> exits;
    private NPCharacter character;

    public Map<String, String> lore;

    public Location(String name) {
        this.name = name;
        //TODO parse les fichier appelé par le nom de la planete pour avoir le lore;
        this.lore = new HashMap<String, String>();
        String fileName = "./resource/" + this.name + ".csv";
        String line = "";
        String splitBy = ",";
        try {
            //parsing a CSV file into BufferedReader class constructor
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                String[] lineSplit = line.split(splitBy);    // use comma as separator
                this.lore.put();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public NPCharacter getCharacter() {
        return character;
    }

    public String getName() {
        return name;
    }
}
