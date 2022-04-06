package by.grits.utils;

import by.grits.entity.Text;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class EqualWordsFinder {
  private static final Logger LOGGER = LogManager.getLogger(EqualWordsFinder.class);

  public void findEqualWords(Text text) {
    Map<String, Integer> words = new HashMap<>();
    List<Text> textWords =
        text.getTextComponents().stream()
            .flatMap(p -> p.getTextComponents().stream())
            .flatMap(s -> s.getTextComponents().stream())
            .toList();
    List<String> stringWords =
        textWords.stream().map(Text::getContents).collect(Collectors.toList());

    stringWords.replaceAll(String::trim);

    IntStream.range(0, stringWords.size())
        .forEachOrdered(
            i ->
                stringWords.set(
                    i, stringWords.get(i).replaceAll("\\p{Punct}", "").toLowerCase(Locale.ROOT)));
    int count;
    for (String word : stringWords) {
      count = Collections.frequency(stringWords, word);
      if (count > 1) {
        words.put(word, count);
      }
    }
    LOGGER.info("Repeated words:\n" + words);
  }
}
