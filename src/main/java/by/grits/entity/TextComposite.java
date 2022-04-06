package by.grits.entity;

import java.util.ArrayList;
import java.util.List;

public class TextComposite implements Text {
  private List<Text> textComponents;
  private CompositeType compositeType;

  public TextComposite() {
    textComponents = new ArrayList<>();
  }

  public TextComposite(List<Text> textComponents) {
    this.textComponents = textComponents;
  }

  public TextComposite(CompositeType compositeType) {
    this.compositeType = compositeType;
  }

  public void setTextComponents(List<Text> textComponents) {
    this.textComponents = textComponents;
  }

  public void addComponent(Text textComponent) {
    textComponents.add(textComponent);
  }

  @Override
  public String getContents() {
    StringBuilder content = new StringBuilder();
    for (Text textComponent : textComponents) {
        content.append(textComponent.getContents());
    }
    return content.toString();
  }

  @Override
  public List<Text> getTextComponents() {
    return textComponents;
  }

  @Override
  public CompositeType getType() {
    return compositeType;
  }
}
