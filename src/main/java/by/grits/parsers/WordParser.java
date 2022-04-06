package by.grits.parsers;

import by.grits.entity.CompositeType;
import by.grits.entity.Letter;
import by.grits.entity.Text;
import by.grits.entity.TextComposite;

public class WordParser implements IParser {

  @Override
  public Text parseText(String inputWord) {
    TextComposite word = new TextComposite(CompositeType.WORD);
    for (int i = 0; i < inputWord.length(); i++) {
      Text letter = new Letter(inputWord.charAt(i));
      word.addComponent(letter);
    }
    return word;
  }
}
