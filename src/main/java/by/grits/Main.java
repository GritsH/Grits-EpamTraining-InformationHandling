package by.grits;

import by.grits.entity.Text;
import by.grits.parsers.IParser;
import by.grits.parsers.TextParser;
import by.grits.utils.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class Main {
  private static final Logger LOGGER = LogManager.getLogger(Main.class);

  public static void main(String[] args) throws IOException {
    String inputText;
    FileReader fileReader = new FileReader();
    inputText = fileReader.readFromFile("TextToParse.txt");
    LOGGER.info("Text from file: \n" + inputText);

    IParser textParser = new TextParser();

    Text textComposite = textParser.parseText(inputText);

    LOGGER.info("Parsed text:\n" + textComposite.getContents());

    ParagraphSorter paragraphSorter = new ParagraphSorter();
    paragraphSorter.sort(textComposite);

    SentenceDeleter sentenceDeleter = new SentenceDeleter();
    sentenceDeleter.deleteSentences(textComposite, 3);

    WordFinder wordFinder = new WordFinder();
    Text word = wordFinder.findLongestWord(textComposite);
    LOGGER.info("Longest word: \n" + word.getContents());

    EqualWordsFinder equalWordsFinder = new EqualWordsFinder();
    equalWordsFinder.findEqualWords(textComposite);

    VowelCounter vowelCounter = new VowelCounter();
    vowelCounter.countVowels(textComposite);
  }
}
