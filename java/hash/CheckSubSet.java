import java.util.Set;
import java.util.HashSet;
public class CheckSubSet {
    public boolean ifSubset(int[]arr1, int[]arr2) {
        Set<Integer> set = new HashSet<>();
        for(Integer ar: arr1) {
            set.add(ar);
        }
        for(Integer ar2: arr2) {
            if(!set.contains(ar2)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CheckSubSet cs = new CheckSubSet();
        int[] arr1 = {1,16,12,3,4,5,6,7,8};
        int[] arr2 = {5,1,16,7,8};
        boolean ifSubset = cs.ifSubset(arr1, arr2);
        if(ifSubset) {

            System.out.println("It's a subset");
        }else {
            System.out.println("It's not a subset");
        }
    }
}
