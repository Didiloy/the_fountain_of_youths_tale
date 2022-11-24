package common.files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class FileHelper {
    public static void verifyFiles() throws NotAllFilesException {
        ArrayList<String> a = new ArrayList<>() {{
            add("Astronomiya");
            add("Belli");
            add("Dimidium");
            add("Earth");
            add("Enoplos");
            add("Farmako");
            add("LastPlanet");
            add("Najemnik");
            add("Zounkla");
        }};

        for (String s : a) {
            File file = new File("./src/resource/" + s + ".csv");
            if (!file.exists()) {
                throw new NotAllFilesException();
            }
        }
    }

    public static HashMap<String, String> parseCsvFile(String filename, String name) {
        HashMap<String, String> lore = new HashMap<String, String>();
        String line = "";
        String splitBy = "::";
        try {
            //parsing a CSV file into BufferedReader class constructor
            BufferedReader br = new BufferedReader(new FileReader(filename));
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                String[] lineSplit = line.split(splitBy);    // use comma as separator
                lore.put(lineSplit[0], lineSplit[1]);
            }
            br.close();
        } catch (IOException e) {
            System.out.println("========= Impossible to read the lore of the planet " + name);
            System.out.println("========= Maybe the file " + filename + " does not exist ?");
            System.out.println("========= Make sure the file does exist and try again ");
            System.exit(1);
        }
        return lore;
    }
}
