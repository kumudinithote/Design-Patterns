package wordPlay.util;

import java.util.HashMap;
/**
 * @author kumudinithote
 * 
 */
public class Result {
	private int numberOfCharacters = 0;
	private int numberOfSentenses = 0;
	private int numberOfWords = 0;
	private int highestWordLenght = 0;
	private String currentLongestWord = "";
	private HashMap <String, Integer> wordFrequecy = new HashMap <String, Integer>();
	private int highestFrequency = 0;
	private String highestFrequencyWord = "";
	
	
	public int getNumberOfWords() {
		return numberOfWords;
	}

	public void setNumberOfWords(int numberOfWords) {
		this.numberOfWords = numberOfWords;
	}
	
	public int getHighestFrequency() {
		return highestFrequency;
	}

	public void setHighestFrequency(int highestFrequency) {
		this.highestFrequency = highestFrequency;
	}

	public String getHighestFrequencyWord() {
		return highestFrequencyWord;
	}

	public void setHighestFrequencyWord(String highestFrequencyWord) {
		this.highestFrequencyWord = highestFrequencyWord;
	}

	public  int getNumberOfCharacters() {
		return numberOfCharacters;
	}

	public void setNumberOfCharacters(int numberOfCharacters) {
		this.numberOfCharacters = numberOfCharacters;
	}

	public int getNumberOfSentenses() {
		return numberOfSentenses;
	}

	public void setNumberOfSentenses(int numberOfSentenses) {
		this.numberOfSentenses = numberOfSentenses;
	}

	public int getHighestWordLenght() {
		return highestWordLenght;
	}

	public void setHighestWordLenght(int highestWordLenght) {
		this.highestWordLenght = highestWordLenght;
	}

	public String getCurrentLongestWord() {
		return currentLongestWord;
	}

	public void setCurrentLongestWord(String currentLongestWord) {
		this.currentLongestWord = currentLongestWord;
	}

	public HashMap<String, Integer> getWordFrequecy() {
		return wordFrequecy;
	}

	public void setWordFrequecy(HashMap<String, Integer> wordFrequecy) {
		this.wordFrequecy = wordFrequecy;
	}

	public String toString(){
		return String.format("numberOfCharacters: %d, numberOfSentenses: %d, highestWordLenght: %d, currentLongestWord: %s", 
				numberOfCharacters, numberOfSentenses, highestWordLenght, currentLongestWord);
	}
}
