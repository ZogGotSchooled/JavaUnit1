public class As5_Haiku {

    public static String[] allLines = MyFiles.loadStringArr("Intellij_DataSet/Haikus/Haiku_FlyingSquirrels");
    public static void run(){
        for (int i = 0; i < allLines.length; i++){
            System.out.println(allLines[i]);

        }
    }
}
