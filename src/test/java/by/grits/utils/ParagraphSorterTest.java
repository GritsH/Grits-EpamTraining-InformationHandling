package by.grits.utils;

import by.grits.entity.Text;
import by.grits.entity.TextComposite;
import by.grits.parsers.IParser;
import by.grits.parsers.TextParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ParagraphSorterTest {
  private ParagraphSorter paragraphSorter;
  private String originalText =
      "\tGgggg. Jjiji jjj, jj.\r\n\tKkkkk. Njnjnj, njnj, njnjn. Lollo lolol.\r\n\tBbb.";
  private String expectedText =
      "\tKkkkk.Njnjnj, njnj, njnjn.Lollo lolol.\r\n\tGgggg.Jjiji jjj, jj.\r\n\tBbb.";
  private Text text;

  @BeforeEach
  void setUp() {
    IParser parser = new TextParser();
    text = parser.parseText(originalText);
    paragraphSorter = new ParagraphSorter();
  }

  @Test
  void shouldSortParagraphs() {
    TextComposite sortedText = paragraphSorter.sort(text);
    assertEquals(expectedText, sortedText.getContents());
  }
}
