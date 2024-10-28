public class As5_Haiku {

    public static String[] allLines;

    public static void run(){
        int choice;
        allLines = MyFiles.loadStringArr("Intellij_DataSet/Haikus/haikupoem1");
//        allLines = MyFiles.loadStringArr("Intellij_DataSet/Haikus/haikupoem2");
//        allLines = MyFiles.loadStringArr("Intellij_DataSet/Haikus/haikupoem3");

        printHaiku();
//        Sort.selectionSortStringsArr(allLines);
//        printHaiku();
        Sort.insertionSortStringArr(allLines);
        printHaiku();
        System.out.println("Used insertion sort to sort!");
    }

    public static void printHaiku(){
        for (int i = 0; i < allLines.length; i++){
            System.out.println(allLines[i]);
        }
    }
}
