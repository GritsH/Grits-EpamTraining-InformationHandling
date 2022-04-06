package by.grits.utils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class FileReader {
  public String readFromFile(String path) throws IOException {
    Scanner scanner = null;
    scanner = new Scanner(new File(path), StandardCharsets.UTF_8);
    return scanner.useDelimiter("\\A").next();
  }
}
