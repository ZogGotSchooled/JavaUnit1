public class Ex2_Files {
    public static void run(){
        String[] allCountries = MyFiles.loadStringArr("IntelliJ_DataSet/Populations/countries.txt");
        int[] allPops = MyFiles.loadIntArr("IntelliJ_DataSet/Populations/populations.txt");

        allCountries[0] = "Afghanistan";

//        Enhanced For loop
//        for(String country: allCountries){
//            System.out.println(country);
//        }
//
//        for(int pop: allPops){
//        }
//        System.out.println(pop);
//        System.out.println(allCountries.length);
//        System.out.println(allPops.length);

        int lowestIndex = 0;
        for(int j = 0; j < allCountries.length; j++)
        {
            if(allPops[j] < allPops[lowestIndex]) {
                lowestIndex = j;
            }
        }

        System.out.println("Lowest populated country: "+allCountries[lowestIndex]+" With a population of "+allPops[lowestIndex]);

        Sort.selectionSortIntArr(allPops);

        for(int i = 0; i < allPops.length; i++){
            System.out.println(allPops[i] + " is the population of " + allCountries[i]);
        }
    }//run
}//class
