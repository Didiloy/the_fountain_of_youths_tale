package common.input;

import common.enums.ANSIColor;
import common.enums.Argument;

import java.util.AbstractMap;
import java.util.Map;
import java.util.Scanner;

public class parseArg {
    private static Scanner s = new Scanner(System.in);

    public static Argument parseArgs() throws UnrecognizableArgumentException, IncorrectNumberOfParameterException {
        System.out.println(ANSIColor.ANSI_GREEN + "Valid answers are:\nyes, no, go , help, look ,attack, take, use, QUIT" + ANSIColor.ANSI_RESET);
        String line = s.nextLine().toUpperCase();
//        s.close();
        if (!enumContains(line)) throw new UnrecognizableArgumentException("Unidentified argument");
        if(line.contains(" ")) throw new IncorrectNumberOfParameterException("Incorrect number of parameter");
        return Argument.valueOf(line);
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
