import java.util.Scanner;

public class ReallyBigDecimal {

    //Instance Variables
    private int arr[];
    private int length,maxLength;

    //Constructors
    public ReallyBigDecimal(){
        this.maxLength=100;
        this.arr = new int[maxLength];
        length = 0;
    }
    public ReallyBigDecimal(int maxLength){
        this.maxLength=maxLength;
        this.arr=new int[maxLength];
        this.length=0;
    }
    public ReallyBigDecimal(String number){
        if(number.length()>=100) this.maxLength=number.length()+100;
        else this.maxLength=100;

        arr = new int[maxLength];
        this.assign(number);

        this.length = number.length();
    }

    //To Display
    public String toString(){
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<this.length;i++) sb.append(this.arr[i]);
        return sb.reverse().toString();
    }

    //Private Functions
    private void printArr(){
        for(int i=this.length-1;i>=0;i--) System.out.print(this.arr[i]+" ");
        System.out.println();
        for(int i=0;i<this.length;i++) System.out.print(this.arr[i]+" ");
        System.out.println();
    }
    private boolean put(int number, int position){
        try {
            if(number<0 || number>9) throw new Exception();
            if(position>this.maxLength) throw new Exception();

            this.arr[position] = number;
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    private int getNumberAt(String number,int i){
        return Integer.parseInt(""+number.charAt(number.length()-(i+1)));
    }
    

    //Getters
    public int getLength(){
        return this.length;
    }
    public int getMaxLength(){
        return this.maxLength;
    }
    public int[] getRawArray(){
        return this.arr.clone();
    }

    //Setters
    public boolean setMaxLength(int newLength){
        //Todo
        return true;
    }

    //Operations
    public void assign(String number){
        for(int i=0;i<number.length();i++){            
            this.arr[i]=this.getNumberAt(number, i);
        }
    }

    public boolean add(String number){
        int ans=0,carry=0;
        int i=0,j=0;
        int operationLength=0;
        //String tempAnswer="";
        try {
            while (true) {
                if(j>=number.length()){
                    if(carry==0)
                        break;
                }
                if(i==maxLength) return false;

                int temp = this.arr[i];i++;

                if(j<number.length()) {
                    temp+=this.getNumberAt(number, j);
                    j++;
                }
                if(carry!=0){
                    temp+=carry;
                    carry=0;
                }

                ans = temp%10;
                carry = temp/10;

                this.put(ans, i-1);
                operationLength++;
            }
        } catch (Exception e) {
            return false;
        }

        this.length=operationLength;
        return true;
    }

    //Public Static Functions
    public static void printStatus(ReallyBigDecimal number){
        System.out.println("Answer : "+number);
        number.printArr();
        System.out.println("Length : "+number.getLength());
        System.out.println("Max Length : "+number.getMaxLength());
    }

    //Main Driver Function
    public static void main(String args[]){
        Scanner sc  = new Scanner(System.in);
        ReallyBigDecimal num1 = new ReallyBigDecimal(sc.next());
        sc.close();
        
        printStatus(num1);
        boolean success = num1.add("23");
        System.out.println("\nAdd Status : "+success);
        printStatus(num1);
        
    }
}
