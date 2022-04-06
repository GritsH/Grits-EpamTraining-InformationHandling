package by.grits.entity;

import java.util.List;

public class Letter implements Text{
    private char letter;

    public Letter(char letter) {
        this.letter = letter;
    }

    @Override
    public String getContents() {
        return String.valueOf(letter);
    }

    @Override
    public List<Text> getTextComponents() {
        return null;
    }

    @Override
    public CompositeType getType() {
        return CompositeType.LETTER;
    }
}
