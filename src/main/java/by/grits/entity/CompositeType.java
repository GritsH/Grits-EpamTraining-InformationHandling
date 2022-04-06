package by.grits.entity;

import java.util.Objects;

public enum CompositeType {
  LETTER(),
  WORD("(?<=\\s)"),
  SENTENCE("([A-Z][^\\.!?]*[\\.!?])[\\\\p{Zs}|\\\\n]"),
  PARAGRAPH("(?<=\\n)"),
  LEXEME(" "),
  TEXT();

  String typeRegExp;

  CompositeType(){}

  CompositeType(String typeRegExp) {
    this.typeRegExp = typeRegExp;
  }

  public String getTypeRegExp() {
    return typeRegExp;
  }
}
