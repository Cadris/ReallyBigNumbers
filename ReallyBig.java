import java.util.Scanner;
public class ReallyBig {
    private static boolean debug = true;

    public static ReallyBigDecimal add(ReallyBigDecimal num1, ReallyBigDecimal num2){
        ReallyBigDecimal ret = null;
        if(num1.getSign()=='-' && num2.getSign()=='+')
            ret = subtract(num2,num1);
        if(num2.getSign()=='-' && num1.getSign()=='+')
            ret =  subtract(num1, num2);
        else{
            ret = new ReallyBigDecimal();
            int len1 = num1.getLength();
            int len2 = num2.getLength();

            int i=0, j=0, ans=0, carry=0,temp=0;
            while(true){
                try {

                    // if(i>len1 || j>len2){
                    //     if(carry==0){
                    //         String allElse = "";
                    //         if(i>len1 && j>len2) break;
                    //         else if(i>len1 && j<len2) allElse = num2.getAllFromStartTo(j-1);
                    //         else if(i<len1 && j>len2) allElse = num1.getAllFromStartTo(i-1);
                    //         ret.addAtFront(allElse);
                    //         break;
                    //     }
                    // } 

                    if(j>=len2 && carry==0){
                        String allElse;
                        if(carry==0){
                            int end = len1-i;
                            allElse = num1.getAllFromStartTo(end);
                            ret.addAtFront(allElse);
                        }
                        break;
                    }

                    if(i<len1)
                        temp = num1.getFromBack(i);i++;
                    if(j<len2)
                        temp += num2.getFromBack(j);j++;

                    if(carry!=0) temp+= carry;

                    ans = temp%10;
                    carry = temp/10;

                    ret.addAtFront(ans+"");

                } catch (Exception e) {
                    if(debug == true) System.out.println("\n============\nError\n============\n");
                    return null;
                }
            }
        }
        return ret;
    }

    private static ReallyBigDecimal subtract(ReallyBigDecimal num1, ReallyBigDecimal num2) {
        return null;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter 1st Number : ");
        ReallyBigDecimal num1 = new ReallyBigDecimal(sc.nextLine());

        System.out.println("Enter 2nd Number : ");
        ReallyBigDecimal num2 = new ReallyBigDecimal(sc.nextLine());

        ReallyBigDecimal answer = ReallyBig.add(num1, num2);
        if(answer == null) System.out.println("Its Null");
        else answer.displayStatus();
        
        sc.close();
    } 
}
