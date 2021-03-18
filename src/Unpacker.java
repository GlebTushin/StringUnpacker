import java.util.Scanner;

public class Unpacker {
    public static void main(String args[]){
        Scanner input= new Scanner(System.in);
        String s=input.nextLine();
        if (validation(s)){
        while (s.indexOf(']')>0){
           s=Unpack(s);
        }
        System.out.println(s);}
        else System.out.println("String is not valid");
    }
    public static String Unpack(String input){
        // number of string multiply
        int num=0;
        // index of '['
        int left=0;
        //index of ']'
        int right=0;
        //number of '['
        int schetl=0;
        //number of ']'
        int schetr=0;
        //length of number
        int index=0;
        String result="";
        for (int i=0;i<input.length();i++) {
            if ((input.charAt(i) >='0') && (input.charAt(i) <= '9')){
                if (schetl==schetr){
                num = num * 10 + (int) input.charAt(i) - (int) '0';
                index++;}}
            if (input.charAt(i) == '[') {
                if (schetl==0)
                left = i;
                schetl++;
            }
            if (input.charAt(i) == ']') {
                right = i;
                schetr++;
                if (schetr == schetl){if (schetl>1){
                   input=input.substring(0,left+1)+Unpack( input.substring(left+1, right))+input.substring(right) ;
               return input; }
                else{
                input=input.substring(0,left-index)+Multiply(num, input.substring(left+1, right))+input.substring(right+1);
               return input; }
                }
            }
            result = input;

        }
     return result;
    }

    public static String Multiply(int num ,String  input){
        String result="";
        for (int i=0;i<num;i++){
            result=result+input;
        }
        return result;
    }
    // String validation
    public static boolean validation(String input){
        // number of ']'
        int numr=0;
        //number of '['
        int numl=0;
        if (input.length()==0)
            return false;
        for (int i=0;i<input.length();i++){
            if (!(((input.charAt(i)>=48)&&(input.charAt(i)<=57))||((input.charAt(i)>=65)&&(input.charAt(i)<=91))||((input.charAt(i)>=97)&&(input.charAt(i)<=122))||(input.charAt(i)==93)))
             return false;
            if (((input.charAt(i) >='0') && (input.charAt(i) <= '9'))&&(i<input.length()-1))
                if (!(((input.charAt(i+1) >='0') && (input.charAt(i+1) <= '9'))||(input.charAt(i+1)=='[')))
                    return false;
                if(input.charAt(i)=='['){
                    if (((input.charAt(i-1) >='0') && (input.charAt(i-1) <= '9'))&&(i>0))
            numl++;}
            if (input.charAt(i)==']'){
                numr++;
                if (numr>numl)
                    return false;
                if (i<input.length()-1)
                if (input.charAt(i+1)=='[')
                    return false;
            }

        }
        if ((numr>numl)||(numl>numr))
            return false;
        return true;
    }
}
