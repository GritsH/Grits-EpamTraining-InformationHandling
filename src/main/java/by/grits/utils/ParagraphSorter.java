package by.grits.utils;

import by.grits.entity.Text;
import by.grits.entity.TextComposite;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class ParagraphSorter {
  private static final Logger LOGGER = LogManager.getLogger(ParagraphSorter.class);

  public TextComposite sort(Text text) {
    TextComposite sorted = new TextComposite();
    List<Text> paragraphs = text.getTextComponents();
    for (int i = 0; i < paragraphs.size() - 1; i++) {
      for (int j = 0; j < paragraphs.size() - i - 1; j++) {
        if (paragraphs.get(j).getTextComponents().size()
            < paragraphs.get(j + 1).getTextComponents().size()) {
          Text temp = paragraphs.get(j);
          paragraphs.set(j, paragraphs.get(j + 1));
          paragraphs.set(j + 1, temp);
        }
      }
    }
    sorted.setTextComponents(paragraphs);
    return sorted;
  }
}
