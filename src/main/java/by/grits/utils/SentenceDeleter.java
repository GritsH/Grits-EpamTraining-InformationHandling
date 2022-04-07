package by.grits.utils;

import by.grits.entity.CompositeType;
import by.grits.entity.Text;
import by.grits.entity.TextComposite;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class SentenceDeleter {
  private static final Logger LOGGER = LogManager.getLogger(SentenceDeleter.class);

  public String deleteSentences(Text text, int wordsAmount) {
    List<Text> paragraphs = text.getTextComponents();
    List<Text> sentences = new ArrayList<>();
    for (Text paragraph : paragraphs) {
      sentences.addAll(paragraph.getTextComponents());
    }

    for (int i = 0; i < sentences.size(); i++) {
      if (sentences.get(i).getTextComponents().size() < wordsAmount + 4) {
        sentences.remove(i);
      }
    }

    TextComposite deletedText = new TextComposite(sentences);
    return deletedText.getContents();
  }
}
