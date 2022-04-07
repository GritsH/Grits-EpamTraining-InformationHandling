package by.grits.utils;

import by.grits.entity.Text;
import by.grits.entity.TextComposite;
import by.grits.parsers.IParser;
import by.grits.parsers.TextParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SentenceDeleterTest {
  private SentenceDeleter sentenceDeleter;
  private String originalText =
      "\tGgggg. Jjiji jjj, jj.\r\n\tKkkkk. Njnjnj, njnj, njnjn.\r\n\tBbb.";
  private String expextedText =
      "Jjiji jjj, jj.\r\nNjnjnj, njnj, njnjn.\r\n";
  private Text text;

  @BeforeEach
  void setUp() {
    IParser parser = new TextParser();
    text = parser.parseText(originalText);
    sentenceDeleter = new SentenceDeleter();
  }
  @Test
  void shouldDeleteSentences(){
    String textWithDeletedSentences = sentenceDeleter.deleteSentences(text, 2);
    assertEquals(expextedText, textWithDeletedSentences);
  }
}
