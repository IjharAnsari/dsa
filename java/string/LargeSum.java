/* 
 * Find the sum of extremly large number.
 */
public class LargeSum {
    public String sum(String number1, String number2) {
        String sumNumber = null;
        if(number1.length()> number2.length()) {
            sumNumber = calculateSum(number1, number2);
        }else {
            sumNumber = calculateSum(number2, number1);
        }
        return sumNumber;
        
    }
    public String calculateSum(String number1, String number2) {
        int num1Index = number1.length()-1;
        int num2Index = number2.length()-1;

        StringBuilder stringBuilder = new StringBuilder();
        int num1 =0, num2=0;
        int sum = 0 , carry=0;
        while(num1Index > -1) {
            num1 = Character.getNumericValue(number1.charAt(num1Index));
            if(num2Index >-1) {
                num2 = Character.getNumericValue(number2.charAt(num2Index));
            }else {
                num2 = 0;
            }
            sum = num1 + num2 + carry;
            if(sum > 9) {
                stringBuilder.append((sum-10)+"");
                carry = 1;
            }else {
                stringBuilder.append((sum)+"");
                carry = 0;
            }
            num1Index--;
            num2Index--;
        }

        return stringBuilder.reverse().toString();
    }

    public static void main(String []args) {
        LargeSum largeSum = new LargeSum();
        String number1 = "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999";
        String number2 = "1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111";
        String sum = largeSum.sum(number1, number2);
        System.out.println(sum);
    }
}
