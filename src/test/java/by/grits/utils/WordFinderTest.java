package by.grits.utils;

import by.grits.entity.Text;
import by.grits.parsers.IParser;
import by.grits.parsers.TextParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WordFinderTest {
  private WordFinder wordFinder;
  private String originalText =
      "\tGgggg. Jjiji jjj, jj.\r\n\tKkkkk. Njnjnjjnjnnjnjnj, njnj, njnjn. Lollo lolol.\r\n\tBbb.";
  private String expectedWord = "Njnjnjjnjnnjnjnj, ";
  private Text text;

  @BeforeEach
  void setUp() {
    IParser parser = new TextParser();
    text = parser.parseText(originalText);
    wordFinder = new WordFinder();
  }

  @Test
  void shouldFindLongestWord() {
    Text word = wordFinder.findLongestWord(text);
    assertEquals(expectedWord, word.getContents());
  }
}
