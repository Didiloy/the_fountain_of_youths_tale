package common.input;

import common.enums.ANSIColor;
import common.enums.Argument;

import java.util.*;

public class ParseArg {
    private static final Scanner s = new Scanner(System.in);

    public static Argument parseArgs(String[] args) throws UnrecognizableArgumentException, IncorrectNumberOfParameterException {
        List<String> listeArguments = new ArrayList<>(Arrays.stream(args).toList());
        if(args.length == 0) throw new IncorrectNumberOfParameterException("The args parameter of the parseArgs function is incorrect");
        System.out.println(ANSIColor.ANSI_GREEN + "Valid answers are:");
        listeArguments.forEach(s -> System.out.print(s + ", "));
        System.out.print("QUIT\n"+ ANSIColor.ANSI_RESET);
        listeArguments.add("quit");

        String line = s.nextLine().toUpperCase();
//        s.close();
        if(!listeArguments.contains(line.toLowerCase())) return parseArgs(args);
//        if (!enumContains(line)) throw new UnrecognizableArgumentException("Unidentified argument");
        if (!enumContains(line))return parseArgs(args);
//        if(line.contains(" ")) throw new IncorrectNumberOfParameterException("Incorrect number of parameter");
        if(line.contains(" ")) return parseArgs(args);
        if(line.equalsIgnoreCase("quit")) System.exit(0);
        return Argument.valueOf(line);
    }

    public static String parseTransition() throws IncorrectNumberOfParameterException, UnrecognizableArgumentException {
        System.out.println(ANSIColor.ANSI_GREEN + "Valid answers are: GO <arg> ,QUIT" + ANSIColor.ANSI_RESET);
        String[] line = s.nextLine().split(" ");
        if (line.length > 2) throw new IncorrectNumberOfParameterException("Incorrect number of parameters");
        if (!enumContains(line[0].toUpperCase())) throw new UnrecognizableArgumentException("Unidentified argument");
        if(line[0].toUpperCase().equals(Argument.QUIT.name())) System.exit(0);
        if(line[0].toUpperCase().equals(Argument.GO.name())) return line[1];
        else throw new UnrecognizableArgumentException("Unidentified argument");
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
