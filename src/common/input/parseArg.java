package common.input;

import common.enums.ANSIColor;
import common.enums.Argument;

import java.util.AbstractMap;
import java.util.Map;
import java.util.Scanner;

public class parseArg {
    private static Scanner s = new Scanner(System.in);

    public static Map.Entry<Argument, String> parseArgs() throws UnrecognizableArgumentException, IncorrectNumberOfParameterException {
        System.out.println(ANSIColor.ANSI_GREEN + "Valid answers are:\nYES, NO, GO <arg>, HELP, LOOK<arg>, ATTACK <arg>, TAKE <arg>, USE <arg>, QUIT" + ANSIColor.ANSI_RESET);
        String[] tmp = s.nextLine().split("\s");
        String[] line;
//        s.close();
        if (tmp.length > 1) {
            line = tmp;
            if (!enumContains(line[0])) throw new UnrecognizableArgumentException("Unidentified argument");
            //Si c'est la commande go
            if (line[0].equals(Argument.GO.name()) && line.length == 2)
                return new AbstractMap.SimpleEntry<>(Argument.GO, line[1]);
            if (line[0].equals(Argument.LOOK.name()))
                return new AbstractMap.SimpleEntry<>(Argument.LOOK, line[1]); //TODO renvoyer une le tableau complet moins le premier element
            if (line[0].equals(Argument.TAKE.name()) && line.length == 2)
                return new AbstractMap.SimpleEntry<>(Argument.TAKE, line[1]);
            if (line[0].equals(Argument.USE.name()) && line.length == 2)
                return new AbstractMap.SimpleEntry<>(Argument.USE, line[1]);//TODO renvoyer une le tableau complet moins le premier element
        }
        if (!enumContains(tmp[0])) throw new UnrecognizableArgumentException("Unidentified argument");
        if (tmp[0].equals(Argument.HELP.name())) return new AbstractMap.SimpleEntry<>(Argument.HELP, "");
        if (tmp[0].equals(Argument.QUIT.name())) System.exit(0);
        if (tmp[0].equals(Argument.YES.name())) return new AbstractMap.SimpleEntry<>(Argument.YES, "");
        if (tmp[0].equals(Argument.NO.name())) return new AbstractMap.SimpleEntry<>(Argument.NO, "");
        else {
            throw new IncorrectNumberOfParameterException("Number of parameter is incorrect");
        }
    }

    public static int parseAnswer() throws IncorrectNumberOfParameterException, UnrecognizableArgumentException {
        Scanner s = new Scanner(System.in);
        String[] line = s.nextLine().split(" ");
        if (line.length > 1) throw new IncorrectNumberOfParameterException("Incorrect number of parameters");
        int res;
        try {
            res = Integer.parseInt(line[0]);
            if (res < 0 || res > 1) throw new UnrecognizableArgumentException("Argument must be between 0 and 1");
        } catch (NumberFormatException e) {
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
