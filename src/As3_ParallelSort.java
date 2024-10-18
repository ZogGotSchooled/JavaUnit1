//https://www.kaggle.com/datasets/mohamedtarek01234/steam-games-reviews-and-rankings
public class As3_ParallelSort {
    static String[] allNames = MyFiles.loadStringArr("IntelliJ_DataSet/SteamStats/names.txt");
    static double[] allPrices = MyFiles.loadDoubleArr("IntelliJ_DataSet/SteamStats/price.txt");
    static int[] allSales = MyFiles.loadIntArr("IntelliJ_DataSet/SteamStats/copiesSold.txt");
    static int[] allReviewScores = MyFiles.loadIntArr("IntelliJ_DataSet/SteamStats/reviewScores.txt");
    static String[] allStudioSizes = MyFiles.loadStringArr("IntelliJ_DataSet/SteamStats/studioSizes.txt");

    static int listDataLength = 50;
    static int minCopies = 1000;


    public static void run(){

//        printGamesAmount(10);
//        System.out.println("Swap slot 0 and 4");
//        swapElementsInAllLists(0,4);
//        printGamesAmount(10);

        while(true) {

            System.out.println("Press 1 to sort games alphabetically\nPress 2 to sort by review score\nPress 3 to filter by studio size (indie, AA, AAA)\nPress 4 to count the amount of games with more than "+minCopies+" copies. \n Press 5 to search for a game. \n Press 6 to change the print amount (current:"+listDataLength+").\nPress 7 to change the minimum copies for a game to be printed (current:"+minCopies+").\nPress 8 to exit.");

            // int choice = 2;//to be removed
            int choice = Library.input.nextInt();
            Library.input.nextLine();

            if (choice == 1) {
                sortNamesAlpha(allNames);
                printGamesAmount(listDataLength, minCopies);
                System.out.println("Sorted alphabetically!");

            }
            if (choice == 2) {
                sortReviewScoreDescending();
                printGamesAmount(listDataLength, minCopies);
                System.out.println("Sorted by review score!");
            }
            if (choice == 3) {
                System.out.println("What studio size do you want to filter by?");
                String studioSize = Library.input.nextLine();

                printByStudioSize(studioSize, listDataLength, minCopies);

                System.out.println("Printed games made by "+studioSize+" studios.");
            }
            if (choice == 4) {
                int count = tallyAboveCopies(minCopies);
                System.out.println("There are "+count+" games with >"+minCopies+" copies.");

            }
            if (choice == 5) {
                search();

            }
            if(choice == 6)
            {
                System.out.println("How many results do you want to see listed?");
                try{
                    listDataLength = Library.input.nextInt();
                    System.out.println("Future results will only print the top "+listDataLength+" results.");
                }
                catch (Exception e)
                {
                    System.out.println("Not an integer answer!");
                }
            }
            if (choice == 7) {
                System.out.println("What is the minimum copies to consider?");
                try{
                    minCopies = Library.input.nextInt();
                    System.out.println("Future results will only print the top "+minCopies+" results.");
                }
                catch (Exception e)
                {
                    System.out.println("Not an integer answer!");
                }
            }
            if (choice == 8) {
                break;
            }
            System.out.println();

        }//while

        System.out.println("Good bye");

        
    }//run
    
    private static void sortNamesAlpha(String[] arr){
        for(int i=0; i<arr.length-1; i++){
            int lowestIndex = i;
            for(int j=i+1; j<arr.length; j++){
                if(arr[j].compareToIgnoreCase(arr[lowestIndex]) < 0){
                    lowestIndex = j;
                }
            }
//swaps the lowest to the beginning
//            String temp = arr[i];
//            arr[i] = arr[lowestIndex];
//            arr[lowestIndex] = temp;
//
            swapElementsInAllLists(lowestIndex, i);

        }
    }

    private static void sortReviewScoreDescending(){
        int arr[] = allReviewScores;
        for(int i=0; i<arr.length-1; i++) {
            int lowestIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[lowestIndex]) {
                    lowestIndex = j;
                }
            }
//swaps the lowest to the beginning
            swapElementsInAllLists(lowestIndex, i);
        }
    }

    private static void printByStudioSize(String studioSize, int printLimit, int minSales){
        for(int i = 0; i < Math.min(printLimit, allNames.length); i++){
            if(allStudioSizes[i].equalsIgnoreCase(studioSize) && allSales[i] >= minSales){
                printGame(i);
            }
        }
    }

    private static void swapElementsInAllLists(int slot1, int slot2) {
        String temp_name = allNames[slot1];
        allNames[slot1] = allNames[slot2];
        allNames[slot2] = temp_name;
        
        double temp_price = allPrices[slot1];
        allPrices[slot1] = allPrices[slot2];
        allPrices[slot2] = temp_price;
        
        int temp_sale = allSales[slot1];
        allSales[slot1] = allSales[slot2];
        allSales[slot2] = temp_sale;
        
        int temp_reviewScore = allReviewScores[slot1];
        allReviewScores[slot1] = allReviewScores[slot2];
        allReviewScores[slot2] = temp_reviewScore;
        
        String temp_studioSize = allStudioSizes[slot1];
        allStudioSizes[slot1] = allStudioSizes[slot2];
        allStudioSizes[slot2] = temp_studioSize;
    }
    
    private static void printGamesAmount(int amount, int minSales){
        for(int i = 0; i < Math.min(amount, allNames.length); i++){
            if(allSales[i] >= minSales)
                printGame(i);
        }
    }//printGamesAmount
    private static void printGame(int gameIndex){
        System.out.println(allNames[gameIndex]+": price "+allPrices[gameIndex]+": Sales "+allSales[gameIndex]+": Review Score "+allReviewScores[gameIndex]+": Studio Size "+allStudioSizes[gameIndex]);
    }

    private static void search(){
//        sortReviewScoreDescending();
//        Search.binarySearch(allReviewScores, );


        System.out.println("What game do you want to search for?");
        String name = Library.input.nextLine();

        for(int i = 0; i < allNames.length; i++){
            if(name.equalsIgnoreCase(allNames[i])) {
                printGame(i);
                return;
            }
        }
        System.out.println("Did not find: "+name+".");
    }

    private static int tallyAboveCopies(int copies){
        int count = 0;
        for(int i = 0; i < allNames.length; i++){
            if(allSales[i] >= copies)
            {
                count++;
            }
        }
        return count;
    }

}//class

