package by.grits.parsers;

import by.grits.entity.CompositeType;
import by.grits.entity.Text;
import by.grits.entity.TextComposite;

public class TextParser implements IParser {
  @Override
  public Text parseText(String inputText) {
    TextComposite textComposite = new TextComposite();
    Text paragraphComposite;
    IParser paragraphParser = new ParagraphParser();
    String[] paragraphs = inputText.split(CompositeType.PARAGRAPH.getTypeRegExp());
    for (String paragraph : paragraphs) {
      paragraphComposite = paragraphParser.parseText(paragraph);
      textComposite.addComponent(paragraphComposite);
    }
    return textComposite;
  }
}
