import java.util.Locale;

public class As5_Haiku {

    public static String[] allLines;

    public static void run(){



//        Sort.selectionSortStringsArr(allLines);
//        printHaiku();



        while(true){
            System.out.println("What haiku do you want to select? (enter 1, 2, or 3)");
            int choice = -1;
            try {
                choice = Library.input.nextInt();
                Library.input.nextLine();
                allLines = MyFiles.loadStringArr(getFileName(choice));
            } catch (Exception e){
                System.out.println("Invalid Haiku choice!");
                Library.input.nextLine();
                continue;
            }
            printHaiku();

            System.out.println("\n Sorting using insertion sort...");
            Sort.insertionSortStringArr(allLines);
            printHaiku();



            System.out.println("Would The Master like to change a word? (y/n)");
            String answer = Library.input.nextLine();
            if(answer.equals("y")){
                System.out.println("Change which word?");
                String change = Library.input.nextLine();
                System.out.println("Replace with what?");
                String replacement = Library.input.nextLine();

                for(int i = 0; i < allLines.length; i++){
                    allLines[i] = allLines[i].toLowerCase().replaceAll(change.toLowerCase(), replacement);
                }
                printHaiku();
                System.out.println("\n It is done.");

            } else {
                System.out.println("I am honored to know that this haiku need'nt not be grace'd further by the hands of the master.");

            }

            System.out.println("Shall the 'ku be immortaliz'd?");
            answer = Library.input.nextLine();
            if(answer.equals("y")) {
                MyFiles.saveStringArray(getFileName(choice), allLines);
            }

        }


//        System.out.println("Used insertion sort to sort!");

    }

   static String getFileName(int haikuNumber){
        return "Intellij_DataSet/Haikus/haikupoem" + haikuNumber;
    }

    public static void printHaiku(){
        for (int i = 0; i < allLines.length; i++){
            System.out.println(allLines[i]);
        }
    }


}
