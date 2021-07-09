package string;

public class PermutationsOfString {
    static void printPermutations(String string, String ans) {
        if(string.length() == 0){
            System.out.print(ans+" ");
            return;
        }
        else{
            for(int i=0; i<string.length(); i++){
                char elem = string.charAt(i);
                String restOfString = string.substring(0,i) + string.substring(i+1);
                printPermutations(restOfString, ans+elem);
            }
        }
    }

    public static void main(String[] args){
        printPermutations("ABC", "");
    }
}
