package common.input;
import common.enums.Argument;

import java.util.AbstractMap;
import java.util.Map;
import java.util.Scanner;

public class parseArg {


    public static Map.Entry<Argument, String> parseArgs() throws UnrecognizableArgumentException, IncorrectNumberOfParameterException {
        Scanner s = new Scanner(System.in);
        String[] line = s.nextLine().split(" ");
        if(!enumContains(line[0])) throw new UnrecognizableArgumentException("Unidentified argument");
        s.close();
        //Si c'est la commande go
        if(line[0].equals(Argument.GO.name()) && line.length == 2) return new AbstractMap.SimpleEntry<>(Argument.GO, line[1]);
        if(line[0].equals(Argument.HELP.name())) return new AbstractMap.SimpleEntry<>(Argument.HELP, "");
        if(line[0].equals(Argument.LOOK.name()) && line.length >= 2) return new AbstractMap.SimpleEntry<>(Argument.LOOK, line[1]); //TODO renvoyer une le tableau complet moins le premier element
        if(line[0].equals(Argument.TAKE.name()) && line.length == 2) return new AbstractMap.SimpleEntry<>(Argument.TAKE, line[1]);
        if(line[0].equals(Argument.QUIT.name()) && line.length == 2) System.exit(0);
        if(line[0].equals(Argument.USE.name()) && line.length == 2) return new AbstractMap.SimpleEntry<>(Argument.USE, line[1]);//TODO renvoyer une le tableau complet moins le premier element
        else {
            throw new IncorrectNumberOfParameterException("Number of parameter is incorrect");
        }
    }

    public static int parseAnswer() throws IncorrectNumberOfParameterException, UnrecognizableArgumentException{
        Scanner s = new Scanner(System.in);
        String[] line = s.nextLine().split(" ");
        if(line.length > 1 )throw new IncorrectNumberOfParameterException("Incorrect number of parameters");
        int res;
        try {
            res = Integer.parseInt(line[0]);
            if(res < 0 || res > 1) throw new UnrecognizableArgumentException("Argument must be between 0 and 1");
        }catch(NumberFormatException e){
            throw new UnrecognizableArgumentException("Argument is not an integer");
        }
        s.close();
        return res;
    }

    public static boolean enumContains(String test) {

        for (Argument c : Argument.values()) {
            if (c.name().equals(test)) {
                return true;
            }
        }
        return false;
    }
}
