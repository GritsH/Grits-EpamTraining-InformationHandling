package by.grits.entity;

import java.util.Objects;

public enum CompositeType {
  LETTER("[A-Za-z]+"),
  WORD("(?<=\\s)"),
  SENTENCE("^\\s+[A-Za-z,;'\"\\s]+[.?!]$"),
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
