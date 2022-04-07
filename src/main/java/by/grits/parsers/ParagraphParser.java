package by.grits.parsers;

import by.grits.entity.CompositeType;
import by.grits.entity.Text;
import by.grits.entity.TextComposite;

public class ParagraphParser implements IParser {
  @Override
  public Text parseText(String inputParagraph) {
    TextComposite paragraphComposite = new TextComposite(CompositeType.PARAGRAPH);
    Text sentenceComposite;
    IParser sentenceParser = new SentenceParser();
    String[] sentences = inputParagraph.split(CompositeType.SENTENCE.getTypeRegExp());
    for (String sentence : sentences) {
      sentenceComposite = sentenceParser.parseText(sentence);
      paragraphComposite.addComponent(sentenceComposite);
    }
    return paragraphComposite;
  }
}
