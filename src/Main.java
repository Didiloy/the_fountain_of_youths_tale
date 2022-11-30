import common.files.NotAllFilesException;
import player.Player;
import world.Location;
import world.planets.*;

import static common.files.FileHelper.verifyFiles;

public class Main {
    public static void main(String[] args) {
        //Verify that all files needed are there
        try {
            verifyFiles();
        }catch(NotAllFilesException e){
            System.out.println("========= Some of the game's story files are missing ");
            System.out.println("========= Make sure you have all the needed files and try again ");
            System.exit(1);
        }
        Location l = new Astronomiya("Astronomiya");
        Location l2 = new Zounkla("Zounkla");
        Location l3 = new Najemnik("Najemnik");
        Location l4 = new Belli("Belli");
        Location l5 = new Farmako("Farmako");
        Location l6 = new Enoplos("Enoplos");
        Location l7 = new Earth("Earth");
        Location l8 = new Dimidium("Dimidium");
        l7.createExits();
        l7.tellStory(new Player(),"Earth");
    }
}
