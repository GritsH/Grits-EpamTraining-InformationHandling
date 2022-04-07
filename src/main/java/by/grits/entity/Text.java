package by.grits.entity;

import java.util.List;

public interface Text {
  String getContents();

  List<Text> getTextComponents();

  CompositeType getType();
}
