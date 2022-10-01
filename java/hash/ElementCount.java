import java.util.Arrays;
public class ElementCount {

    //hash function to get the index of char
    public int getIndex(char c) {
        return c-'a';
    }

    public void countElement(String elem) {
        int countArr[] = new int[26];
        Arrays.fill(countArr,0);
        for(int i=0; i<elem.length(); i++) {
            int index = getIndex(elem.charAt(i));
            countArr[index]++;
        }

        //print the count
        for(int i=0; i<countArr.length; i++) {
            if(countArr[i] != 0) {
                System.out.println((char)(i+'a')+" ->"+ countArr[i]);
            }
        }
    }

    //main method
    public static void main(String []args) {
        ElementCount elementCount = new ElementCount();
        elementCount.countElement("dsfgsdgfas");
    }
}