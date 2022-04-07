package by.grits.utils;

import by.grits.entity.Text;
import by.grits.entity.TextComposite;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SentenceDeleter {
  private static final Logger LOGGER = LogManager.getLogger(SentenceDeleter.class);

  public void deleteSentences(Text text, int wordsAmount) {
    List<Text> paragraphs = text.getTextComponents();
    List<Text> sentences = new ArrayList<>();
    for (Text paragraph : paragraphs) {
      sentences.addAll(paragraph.getTextComponents());
    }
    for(int i =0; i<sentences.size(); i++){
      if(sentences.get(i).getTextComponents().size() < wordsAmount + 4){
        sentences.remove(i);
      }
    }
    TextComposite deletedText = new TextComposite(sentences);
    LOGGER.info("With deleted sentences:\n" + deletedText.getContents());
    //LOGGER.info("Without some sentences:\n" + new TextComposite(reformattedText).getContents());
  }
}
