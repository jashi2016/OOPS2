import java.io.*;
import java.util.*;

public class Solution {
    public static int[] zeroSum(int[] arr) {
    List<Integer> l = new ArrayList<>();
    boolean found = zeroSum(arr, 0, 0, l);
    if (found) {
        return l.stream().mapToInt(Integer::intValue).toArray();
    }
    return null;
}

public static boolean zeroSum(int[] arr, int start, int target,
        List<Integer> l) {
    for (int i = start; i < arr.length; i++) {
        int current = arr[i];
        l.add(current);
        int newTarget = target-current;
        if (newTarget == 0) {
            return true;
        }
        boolean found = zeroSum(arr, i+1, newTarget, l);
        if (found) {
            return true;
        }
        l.remove(l.size()-1);
    }
    return false;
}

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        int re[] = zeroSum(a);
        if(re!=null){
        for(int i=0;i<re.length;i++){
            System.out.print(re[i]+" ");
        }
        }
        else{
            System.out.println("No Elements Found");
        }
    }
}
