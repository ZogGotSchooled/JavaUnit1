public class As4_BinarySearch {
    // https://owlcation.com/stem/Ten-Creepy-Deep-Sea-Creatures
    static String[] creatures = {"Blue-Ringed Octopus", "Chimaera", "Fangtooth", "Giant Grenadier", "Giant Isopod", "Giant Squid", "Goblin Shark", "Northern Stargazer", "Sarcastic Fringehead", "Viper Fish"};
    static String[] types = {"Cephalopod", "Fish", "Fish", "Fish", "Crustacean", "Shark", "Fish", "Blenny", "Fish"};
    static boolean[] endangered = {false, true, false, false, false, false, false, false, false, false};

    public static void run(){
        for (String creature:creatures) {
            System.out.println(creature);
        }
        while (true){
            System.out.println(Search.binarySearch(creatures, "Viper Fish"));
            break;
        }
    }
}
