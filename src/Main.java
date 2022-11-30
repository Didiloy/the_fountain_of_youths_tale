import common.files.NotAllFilesException;
import player.Player;
import world.World;

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
        World w = new World();
        Player p = new Player();
        w.start(p);
    }
}
