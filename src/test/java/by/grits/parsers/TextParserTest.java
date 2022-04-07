package by.grits.parsers;

import by.grits.entity.Text;
import by.grits.utils.FileReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TextParserTest {
  private IParser parser;
  private String filePath;
  private String originalText;
  private FileReader fileReader;

  @BeforeEach
  void setUp() {
    fileReader = new FileReader();
    parser = new TextParser();
    filePath = "src/test/resources/TestFile.txt";
  }

  @Test
  void shouldParseText() throws IOException {
    originalText = fileReader.readFromFile(filePath);
    Text parsedText = parser.parseText(originalText);
    assertEquals(originalText, parsedText.getContents());
  }

  @Test
  void shouldHaveSameAmountOfParagraphs() throws IOException {
    originalText = fileReader.readFromFile(filePath);
    Text parsedText = parser.parseText(originalText);
    assertEquals(3, parsedText.getTextComponents().size());
  }

  @Test
  void shouldHaveSameAmountOfSentences() throws IOException {
    originalText = fileReader.readFromFile(filePath);
    Text parsedText = parser.parseText(originalText);
    int parsedSentencesCounter = 0;
    for (int i = 0; i < parsedText.getTextComponents().size(); i++) { 
      Text parsedSentences = parsedText.getTextComponents().get(i);
      for (int j = 0; j < parsedSentences.getTextComponents().size(); j++) {
        parsedSentencesCounter = parsedSentencesCounter + 1;
      }
    }
    assertEquals(3, parsedSentencesCounter);
  }
}
