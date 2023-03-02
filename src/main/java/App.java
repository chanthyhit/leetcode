import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        int[] arrays = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        //int r = binarySearch(arrays,8);
        int r = binarySearchRecursive(arrays, 8, 0, arrays.length-1);
        System.out.println(r);
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
