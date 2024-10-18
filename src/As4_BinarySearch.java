public class As4_BinarySearch {
    // https://owlcation.com/stem/Ten-Creepy-Deep-Sea-Creatures
    static String[] creatures = {"Blue-Ringed Octopus", "Chimaera", "Fangtooth", "Giant Grenadier", "Giant Isopod", "Giant Squid", "Goblin Shark", "Northern Stargazer", "Sarcastic Fringehead", "Viper Fish"};
    static String[] types = {"Cephalopod", "Fish", "Fish", "Fish", "Crustacean", "Cephalopod", "Shark", "Fish", "Blenny", "Fish"};
    static boolean[] endangered = {false, true, false, false, false, false, false, false, false, false};

    public static void run(){
        for (String creature:creatures) {
            System.out.println(creature);
        }

        for (int i = 0; i < creatures.length; i++) {
            System.out.println(creatures[i]+types[i]+endangered[i]);
        }
        while (true){
            //System.out.println(Search.binarySearch(creatures, "Viper Fish"));
            System.out.println("What creature do you want to search for? (or, type 'exit' to exit)");
            String input = Library.input.nextLine();
            int index = Search.binarySearch(creatures, input);

            if(input.equals("exit")){
                break;
            }

            if(index == -1) {
                System.out.println("I couldn't find "+input+" in the list.");
                continue;
            }

            System.out.println("I found it! A "+creatures[index]+" is a type of "+types[index]+". It "+(endangered[index] ? "*IS* endangered." : "is not endangered."));


        }
    }
}
