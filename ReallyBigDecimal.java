import java.util.Scanner;

public class ReallyBigDecimal {
    private String number;
    private char sign;
    private int length;

    //Constructors
    public ReallyBigDecimal(){
        this.number = "";
        this.sign = '+';
        this.length = 0;
    }
    public ReallyBigDecimal(String _number){
        if(_number.length()>0 && _number.charAt(0)=='-'){
            this.sign='-';
            this.number = _number.substring(1, _number.length());
            this.length = _number.length()-1;
        }else if(_number.length()>0){
            this.sign = '+';
            this.number = _number;
            this.length = _number.length();
        }else if(_number.length()==0){
            this.sign = '+';
            this.number = "";
            this.length = 0;
        }        
    }
    public ReallyBigDecimal(ReallyBigDecimal obj){
        this.length = obj.getLength();
        this.number = obj.getNumber();
        this.sign = obj.getSign();
    }

    //Getters
    public char getSign(){ return this.sign; }
    public String getNumber(){ return this.number; }
    public int getLength(){ return this.length; }

    //Display Methods
    @Override
    public String toString() {
        if (this.sign == '-') {
            return this.sign+this.number;
        }else{
            return this.number;
        }
    }
    public void displayStatus() {
        System.out.println("Sign : "+this.sign);
        System.out.println("Number : "+this.number);
        System.out.println("Length : "+this.length);
        if (this.sign == '-') {
            System.out.println("The Full Number : "+this.sign+""+this.number);
        }
    }

    //Validators
    public static boolean validate(String _number) {
        for(int i = 0;i<_number.length();i++) 
            if(Character.isDigit(_number.charAt(i))==false) 
                return false;

        return true;
    }

    //Main Driver
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a Number : ");
        ReallyBigDecimal num = new ReallyBigDecimal(sc.next());

        num.displayStatus();

        sc.close();
    }
}
