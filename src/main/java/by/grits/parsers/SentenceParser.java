package by.grits.parsers;

import by.grits.entity.CompositeType;
import by.grits.entity.Text;
import by.grits.entity.TextComposite;

public class SentenceParser implements IParser {
  @Override
  public Text parseText(String inputSentence) {
    TextComposite sentence = new TextComposite(CompositeType.SENTENCE);
    Text wordComposite;
    IParser wordParser = new WordParser();
    String[] words = inputSentence.split(CompositeType.WORD.getTypeRegExp());
    for (String word : words) {
      wordComposite = wordParser.parseText(word);
      sentence.addComponent(wordComposite);
    }
    return sentence;
  }
}
