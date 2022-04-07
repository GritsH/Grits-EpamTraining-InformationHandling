package by.grits.utils;

import by.grits.entity.Text;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class VowelCounter {
  private static final Logger LOGGER = LogManager.getLogger(VowelCounter.class);

  public void countVowels(Text text) {
    long vowelsLettersCount =
        text.getTextComponents().stream()
            .flatMap(paragraph -> paragraph.getTextComponents().stream())
            .flatMap(sentence -> sentence.getTextComponents().stream())
            .flatMap(word -> word.getTextComponents().stream())
            .filter(letter -> letter.getContents().matches("[aeiou]|[уеэоаыи]"))
            .count();
    LOGGER.info("Vowels: " + vowelsLettersCount);

    long consonantsLettersCount =
        text.getTextComponents().stream()
            .flatMap(paragraph -> paragraph.getTextComponents().stream())
            .flatMap(sentence -> sentence.getTextComponents().stream())
            .flatMap(word -> word.getTextComponents().stream())
            .filter(
                letter ->
                    letter.getContents().matches("[bcdfghjklmnpqrstvwxyz]|[йцкнгшщзхфвпрлджчсмтб]"))
            .count();
    LOGGER.info("Consonants: " + consonantsLettersCount);
  }
}
