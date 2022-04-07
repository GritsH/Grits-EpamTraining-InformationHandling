package by.grits.entity;

import java.util.Objects;

public enum CompositeType {
  LETTER(),
  WORD("(?<=\\s)"),
  SENTENCE("(?<!\\w\\.\\w.)(?<![A-Z][a-z]\\.)(?<=\\.|\\?|!)[\\p{Zs}|\\n]"),
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
