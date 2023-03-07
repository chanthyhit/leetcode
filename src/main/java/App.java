import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class App {
    public static void main(String[] args) {
        int[] arrays = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        //int r = binarySearch(arrays,8);
        int r = binarySearchRecursive(arrays, 8, 0, arrays.length-1);
        //System.out.println(r);
        getDiff();
    }

    private static void getDiff() {
        System.out.println(new Date());
        Date dateTime = new Date();
        Date dateTime1 = new Date();
        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            dateTime = df.parse("2022-03-02 14:05:51");
            dateTime1 = df.parse("2022-03-03 14:05:51");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        //Date dateTime1 = new Date(System.currentTimeMillis() + 120000);
        long diff = (dateTime1.getTime() - dateTime.getTime())/(60*1000);
        System.out.println(diff);
    }
    private static int binarySearch(int[] arrays, int num){
        int low = 0;
        int high = arrays.length - 1;
        while(low <= high){
            int midP = (low + high) / 2;
            System.out.println(midP+"-");
            if(num == arrays[midP]) return midP;
            else if(num < arrays[midP]) high = midP - 1;
            else low = midP + 1;
        }
        return -1;
    }

    private static int binarySearchRecursive(int[] arr, int target, int left, int right){
        if(left>right) return -1;
        int mid = left + (right - left) / 2; //to avoid potential integer overflow issues.
        System.out.println(String.format("%s = %s + (%s - %s) / 2", mid, left, right, left));
        if(arr[mid] == target) return mid;
        else if(arr[mid] < target) return binarySearchRecursive(arr, target, mid + 1, right);
        else return binarySearchRecursive(arr, target, left, mid - 1);

    }
}
