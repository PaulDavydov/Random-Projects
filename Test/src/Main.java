import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] A = {1,3,6,4,1,2};
        System.out.println(solution(A));
    }

    public static int solution(int[] A) {
        // write your code in Java SE 11
        int smallest = 1;
        Arrays.sort(A);
        for (int i =0; i < A.length;i++) {
            if(A[i] == smallest) {
                smallest++;
            } else if (A[i] > smallest){
                break;
            }
        }
        return smallest;
    }
}
