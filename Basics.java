import java.util.*;

public class Basics {

    public static void printSubsetsHelper(int[] arr,ArrayList<Integer> temp,int i){
        if(i >= arr.length){
            System.out.println(temp);
            return;
        }
        temp.add(arr[i]);
        printSubsetsHelper(arr,temp,i+1);
        temp.remove(temp.size() - 1);
        printSubsetsHelper(arr,temp,i+1);
    }

    public static void printSubsets(int[] a){
        ArrayList<Integer> temp = new ArrayList<>();
        printSubsetsHelper(a,temp,0);
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
        int[] arr = {1,2,3};
        printSubsets(arr);
    }
}
