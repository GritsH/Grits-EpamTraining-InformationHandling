package by.grits.entity;

public enum CompositeType {
  LETTER(),
  WORD("(?<=\\s)"),
  SENTENCE("(?<!\\w\\.\\w.)(?<![A-Z][a-z]\\.)(?<=\\.|\\?|!)[\\p{Zs}|\\n]"),
  PARAGRAPH("(?<=\\n)"),
  LEXEME(" "),
  TEXT();

  String typeRegExp;

  CompositeType() {}

  CompositeType(String typeRegExp) {
    this.typeRegExp = typeRegExp;
  }

  public String getTypeRegExp() {
    return typeRegExp;
  }
}
