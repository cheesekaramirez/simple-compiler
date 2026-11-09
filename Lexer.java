import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Lexer {
    static String[] dt = {"int", "double", "String", "boolean","char"};
    static char[] assign_operators = {'+', '-', '*', '/'};
    static char delimiter = ';';

    static String tokens;

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Write a line of code:");
        String rawCode = scn.nextLine();
        StringTokenizer st = new StringTokenizer(rawCode);
        ArrayList<String> tokenizedCode = new ArrayList<>();

        while(st.hasMoreTokens()){
            tokenizedCode.add(st.nextToken());
        }

        for(int i = 0; i < tokenizedCode.size(); i++){
            tokens+=tokenGenerator(tokenizedCode.get(0));
        }

        System.out.println(tokens);

    }

    static String tokenGenerator(String lexeme) {
        for(int i = 0; i < dt.length; i++){
            if(lexeme.equals(dt[i])) {
                return "<data_type>";
            } else if (lexeme instanceof String){
                return "<id>";
            } else if (lexeme.equals(assign_operators[i])){
                return "<assignment_operator>";
            } else if(lexeme.equals(delimiter)) {
                return "<delimiter>";
            } else if(lexeme.equals(" ")){
            }
            return "<value>";
        }

    }
}



