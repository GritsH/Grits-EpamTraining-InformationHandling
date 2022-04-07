package by.grits.utils;

import by.grits.entity.Text;
import by.grits.parsers.IParser;
import by.grits.parsers.TextParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class EqualWordsFinderTest {
    private String originalText = "\tA a. B b b. C c c c.";
    private EqualWordsFinder equalWordsFinder;
    private Text text;

    @BeforeEach
    void setUp(){
        IParser parser = new TextParser();
        text = parser.parseText(originalText);
        equalWordsFinder = new EqualWordsFinder();
    }

    @Test
    void shouldFindAmountOfWords(){
        Map<String, Integer> expectedWords = new HashMap<>();
        expectedWords.put("a", 2);
        expectedWords.put("b", 3);
        expectedWords.put("c", 4);

        Map<String, Integer> result = equalWordsFinder.findEqualWords(text);

        assertEquals(expectedWords, result);
    }

}