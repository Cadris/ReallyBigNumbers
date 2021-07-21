import java.util.Scanner;

public class ReallyBigDecimal {
    private int arr[];
    private int length,maxLength;

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
        if(number.length()>100) this.maxLength=number.length()+100;
        else this.maxLength=100;

        arr = new int[maxLength];
        this.assign(number);

        this.length = number.length();
    }

    public void assign(String number){
        for(int i=0;i<number.length();i++){            
            this.arr[i]=Integer.parseInt(""+number.charAt(number.length()-(i+1)));
        }
    }
    public String toString(){
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<this.length;i++) sb.append(arr[i]);
        return sb.reverse().toString();
    }

    private void printArr(){
        for(int i=this.length-1;i>=0;i--) System.out.print(arr[i]+" ");
    }


    //Main Driver Function
    public static void main(String args[]){
        Scanner sc  = new Scanner(System.in);
        ReallyBigDecimal num1 = new ReallyBigDecimal(sc.next());
        sc.close();
        
        System.out.println("Answer : "+num1);
        num1.printArr();
    }
}
