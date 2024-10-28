/*
All functions working well
Search and Sort algorithms correctly used
100%
*/


import java.util.Locale;

public class Exam_ZJ {
    static String[] allAbbreviations = { "CHF",  "CZK",  "EUR",  "JPY",  "MAD" };
    static String[] allLongNames = { "Swiss Franc",  "Czech Koruna",  "Euro",  "Japanese Yen", "Moroccan Dirham" };
    static double[] allValues = { 0.65,  16.47,  0.68,  109.97,  7.40 };
    public static void run(){

        while(true) {

            System.out.println("Press 1 to print all\nPress 2 to find average \nPress 3 to search by value\nPress 4 to search by abbreviation \nPress 5 to filter long names \nPress 6 to sort by values. \nPress 7 to print unofficial abbreviations \nPress 8 to exit.");

            // int choice = 2;//to be removed

            int choice = -1;
            try{
                choice = Library.input.nextInt();
                Library.input.nextLine();
            }
            catch (Exception e){
                System.out.println("That is not a valid int choice");
                Library.input.nextLine(); //flush out newline character in catch if above is not reached
                continue;
            }

            if (choice == 1) {
                System.out.println("print all");
                printAllNames(false);
            }
            if (choice == 2) {
                System.out.println("find average");
                averageAndPrint();
            }
            if (choice == 3) {
                System.out.println("search by value");
                searchByValue();
            }
            if (choice == 4) {
                System.out.println("search by abbreviation");
                searchByAbbreviation();
            }
            if (choice == 5) {
                System.out.println("filter long names");
                filterBySubstring();
            }
            if (choice == 6) {
                System.out.println("sorting by values...");
                parallelSortByValue();
            }
            if (choice == 7) {
                System.out.println("print unofficial abbreviations");
                printAllNames(true);
            }
            if (choice == 8) {
                System.out.println("exit");
                break;
            }
            System.out.println();

        }//while

        System.out.println("Good bye");

    }//run

    private static void printAllNames(boolean includeUnofficialAbbreviation){
        for(int i = 0; i < allLongNames.length; i++){
            printNameAtIndex(i, includeUnofficialAbbreviation);
        }
    }

    private static void printNameAtIndex(int index, boolean includeUnofficialAbbreviation){
        String officialAbbreviation = "";
        if(includeUnofficialAbbreviation)
            officialAbbreviation = allLongNames[index].substring(0, 3);

        System.out.println(allAbbreviations[index]+" "+allLongNames[index]+" "+allValues[index]+" "+officialAbbreviation);
    }

    private static void averageAndPrint(){
        double total = 0;
        for(int i = 0; i < allValues.length; i++){
            total += allValues[i];
        }

        System.out.println("The average value of the currencies is: "+total/allValues.length);
    }

    private static void searchByValue(){

        System.out.println("What currency do you want to search for?");
        double searchInput = 0.0;
        try{
            searchInput = Library.input.nextDouble();
            Library.input.nextLine();
        }
        catch (Exception e){
            System.out.println("That is not a valid double input.");
            Library.input.nextLine(); //flush out newline character in catch if above is not reached
            return;
        }

        int foundIndex = -1;
        for(int i = 0; i < allValues.length; i++){
            if(allValues[i] == searchInput){
                foundIndex = i;
                break;
            }
        }
        if(foundIndex == -1)
        {
            System.out.println("There is no currency with a value of "+searchInput);
            return;
        }

        System.out.println("One Canadian dollar is worth "+allValues[foundIndex]+" "+allAbbreviations[foundIndex]);
    }

    private static void searchByAbbreviation(){

        System.out.println("What currency do you want to search for?");
        String searchInput = "";
        try{
            searchInput = Library.input.nextLine();
        }
        catch (Exception e){
            System.out.println("That is not a valid string input.");
            return;
        }

        int foundIndex = Search.binarySearch(allAbbreviations, searchInput);


        if(foundIndex == -1)
        {
            System.out.println("There is no currency with a value of "+searchInput);
            return;
        }

        System.out.println("One Canadian dollar is worth "+allValues[foundIndex]+" "+allAbbreviations[foundIndex]);
    }

    private static void filterBySubstring(){
        System.out.println("What currency name do you want to filter by? (enter character sequence)");
        String searchInput = "";
        try{
            searchInput = Library.input.nextLine().toLowerCase();
        }
        catch (Exception e){
            System.out.println("That is not a valid string input.");
            return;
        }

        for(int i = 0; i < allLongNames.length; i++){
            if(allLongNames[i].toLowerCase().contains(searchInput)){
                printNameAtIndex(i, false);
            }
        }
    }

    private static void parallelSortByValue(){

        double[] arr = allValues;
        for(int i=0; i<arr.length-1; i++){
            int lowestIndex = i;
            for(int j=i+1; j<arr.length; j++){
                if(arr[j] < arr[lowestIndex]){
                    lowestIndex = j;
                }
            }
            //swaps the lowest to the beginning
            swapElements(i, lowestIndex);
        }


        System.out.println("Data sorted by value!");
    }

    private static void swapElements(int index1, int index2){
        String nameTemp = allLongNames[index1];
        allLongNames[index1] = allLongNames[index2];
        allLongNames[index2] = nameTemp;

        String abbrTemp = allAbbreviations[index1];
        allAbbreviations[index1] = allAbbreviations[index2];
        allAbbreviations[index2] = abbrTemp;

        double valueTemp = allValues[index1];
        allValues[index1] = allValues[index2];
        allValues[index2] = valueTemp;
    }
}
