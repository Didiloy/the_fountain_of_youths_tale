package common.output;

public class Out {
    public static void printCharByChar(String s){
        String[] tmp = s.split("\s");
        for(String s2 : tmp){
            try{
                Thread.sleep(100);
                System.out.print(s2 + " ");
            } catch (InterruptedException e) {
                System.out.print(s2 + " ERROR ");
            }
        }
//        for(char c : s.toCharArray()){
//            try{
//                Thread.sleep(250);
//                System.out.print(c);
//                System.out.flush();
//            } catch (InterruptedException e) {
//                System.out.print(c);
//                System.out.flush();
//            }
//        }
        System.out.println();
    }
}
