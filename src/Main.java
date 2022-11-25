import common.files.NotAllFilesException;
import world.Location;
import world.planets.Earth;
import world.planets.Zounkla;

import static common.files.FileHelper.verifyFiles;

public class Main {
    public static void main(String[] args) {
        //Verify that all files needed are there
        try {
            verifyFiles();
        }catch(NotAllFilesException e){
            System.out.println("========= Somes of the game's story files are missing ");
            System.out.println("========= Make sure the file you have all the needed files and try again ");
            System.exit(1);
        }
        Location l = new Earth("Earth");
        Location l2 = new Zounkla("Zounkla");
        l2.createExits();
        l2.tellStory();
    }
}
