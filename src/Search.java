public class Search {
    public static int binarySearch(int arr[], int searchTerm){
        int start = 0;
        int end = arr.length-1;

        while (start <= end){
            int mid = (start + end)/2;
            if(searchTerm == arr[mid]){
                return mid;
            }
            else if(searchTerm > arr[mid]){
                start = mid + 1;
            }
            else {
                end = mid-1;
            }
        }
        return -1;
    }

    public static int binarySearch(double arr[], double searchTerm){
        int start = 0;
        int end = arr.length-1;

        while (start <= end){
            int mid = (start + end)/2;
            if(searchTerm == arr[mid]){
                return mid;
            }
            else if(searchTerm > arr[mid]){
                start = mid + 1;
            }
            else {
                end = mid-1;
            }
        }
        return -1;
    }

    public static int binarySearch(String arr[], String searchTerm){
        int start = 0;
        int end = arr.length-1;

        while (start <= end){
            int mid = (start + end)/2;
            if(searchTerm.equalsIgnoreCase(arr[mid])){
                return mid;
            }
            else if(searchTerm.compareToIgnoreCase(arr[mid]) > 0){
                start = mid + 1;
            }
            else {
                end = mid-1;
            }
        }
        return -1;
    }

    public static int sigmaSearch(int sigmas[], int rizzler){
        int nikado_avacado = 0;
        int ninja_low_taper_fade = sigmas.length-1;

        while (nikado_avacado <= ninja_low_taper_fade){
            int mid = (nikado_avacado + ninja_low_taper_fade)/2;
            if(rizzler == sigmas[mid]){
                return mid;
            }
            else if(rizzler > sigmas[mid]){
                nikado_avacado = mid + 1;
            }
            else {
                ninja_low_taper_fade = mid-1;
            }
        }
        return -1;
    }
}
