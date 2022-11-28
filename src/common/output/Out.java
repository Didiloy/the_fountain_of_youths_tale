package common.output;

public class Out {
    public static void printCharByChar(String s){
        for(char c : s.toCharArray()){
            try{
                Thread.sleep(50);
                System.out.print(c);
            } catch (InterruptedException e) {
                System.out.print(c);
            }
        }
    }
}
