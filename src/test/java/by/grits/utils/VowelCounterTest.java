package by.grits.utils;

import by.grits.entity.Text;
import by.grits.parsers.IParser;
import by.grits.parsers.TextParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VowelCounterTest {
  private VowelCounter vowelCounter;
  private String originalText = "\tAaaa ooooo.\r\n\tKkkkk jjlpn.";
  private Text text;

  @BeforeEach
  void setUp() {
    IParser parser = new TextParser();
    text = parser.parseText(originalText);
    vowelCounter = new VowelCounter();
  }

  @Test
  void shouldCountVowels(){
    List<Long> expected = new ArrayList<>();
    expected.add(9L);
    expected.add(10L);

    List<Long> result = vowelCounter.countVowels(text);
    assertEquals(expected, result);
  }
}
