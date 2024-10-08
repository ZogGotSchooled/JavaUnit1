public class Ex1_QuickTests {
    public static void run(){
        String[] test = {"apple","banana","band","ant","art","dog","bog","boot","foot","Foot","FooT" };
        for(int i = 0; i < test.length-1; i++){
            System.out.println(test[i] +" vs "+test[i+1]+": "+test[i].compareTo(test[i+1]));
        }

    }
}
