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
            this.number = _number.substring(1, number.length());
        }else if(_number.length()>0){
            this.sign = '+';
            this.number = _number.substring(1, number.length());
        }else if(_number.length()==0){
            this.sign = '+';
            this.number = "";
        }
    }
}
