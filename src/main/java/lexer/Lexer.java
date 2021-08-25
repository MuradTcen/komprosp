package lexer;

import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

public class Lexer {

    @ToString
    @RequiredArgsConstructor
    public static class Token {
        public final Type t;
        public final String content;
    }

    public static String getAtom(String s, int i) {
        int j = i;
        for( ; j < s.length(); ) {
            if(Character.isLetter(s.charAt(j))) {
                j++;
            } else {
                return s.substring(i, j);
            }
        }
        return s.substring(i, j);
    }

    public static List<Token> lex(String input) {
        List<Token> result = new ArrayList<Token>();
        for(int i = 0; i < input.length(); ) {
            switch(input.charAt(i)) {
                case '(':
                    result.add(new Token(Type.LPAREN, "("));
                    i++;
                    break;
                case ')':
                    result.add(new Token(Type.RPAREN, ")"));
                    i++;
                    break;
                default:
                    if(Character.isWhitespace(input.charAt(i))) {
                        i++;
                    } else {
                        String atom = getAtom(input, i);
                        i += atom.length();
                        result.add(new Token(Type.ATOM, atom));
                    }
                    break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Lexer.Token> tokens = lex("(foo)");
        for(Lexer.Token t : tokens) {
            System.out.println(t);
        }
    }
}
