package by.grits;

import by.grits.entity.Text;
import by.grits.entity.TextComposite;
import by.grits.parsers.IParser;
import by.grits.parsers.TextParser;
import by.grits.utils.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.Map;

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
    TextComposite sorted = paragraphSorter.sort(textComposite);
    LOGGER.info("Sorted:\n" + sorted.getContents());

    SentenceDeleter sentenceDeleter = new SentenceDeleter();
    String deletedText = sentenceDeleter.deleteSentences(textComposite, 3);
    LOGGER.info("Text with deleted sentences:\n" + deletedText);

    WordFinder wordFinder = new WordFinder();
    Text word = wordFinder.findLongestWord(textComposite);
    LOGGER.info("Longest word: \n" + word.getContents());

    EqualWordsFinder equalWordsFinder = new EqualWordsFinder();
    Map<String, Integer> words = equalWordsFinder.findEqualWords(textComposite);
    LOGGER.info("Repeated words:\n" + words);

    VowelCounter vowelCounter = new VowelCounter();
    vowelCounter.countVowels(textComposite);
  }
}
