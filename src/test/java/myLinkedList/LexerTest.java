package myLinkedList;


import lexer.Lexer;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static lexer.Lexer.lex;
import static lexer.Type.*;
import static org.assertj.core.api.Assertions.assertThat;

class LexerTest {


    @Test
    void lex_foo_thenEquals() {
        List<Lexer.Token> actual = lex("(foo)");
        List<Lexer.Token> expected = Arrays.asList(
                new Lexer.Token(LPAREN, "("),
                new Lexer.Token(ATOM, "foo"),
                new Lexer.Token(RPAREN, ")") );
        assertThat(actual.equals(expected));
    }

    @Test
    void lex_foo1_thenNotEquals() {
        List<Lexer.Token> actual = lex("(foo)");
        List<Lexer.Token> expected = Arrays.asList(
                new Lexer.Token(LPAREN, "("),
                new Lexer.Token(RPAREN, ")") );
        assertThat(!actual.equals(expected));
    }

}
