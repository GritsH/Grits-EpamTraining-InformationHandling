package by.grits.utils;

import by.grits.entity.Text;

import java.util.Comparator;

public class WordFinder {
  public Text findLongestWord(Text text) {
    return text.getTextComponents().stream()
        .flatMap(p -> p.getTextComponents().stream())
        .flatMap(s -> s.getTextComponents().stream())
        .max(Comparator.comparing(w -> w.getTextComponents().size()))
        .get();
  }
}
