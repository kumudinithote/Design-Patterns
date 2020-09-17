package wordPlay.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @author kumudinithote
 *
 */
public class SentenseProcessor implements FileDisplayInterface{
	//what if sentense has semicolon, question mark and !, we are just considering fullstop
	
	private final static String pattern = "[a-zA-Z0-9]*";
	Result result = new Result();
	
	private static class ValidatorFetcher {
		
		/**
		 * @param	word	String to verify if it has any special character	
		 * @throws	Exception in case of invalid characters or special characters
		 *
		 */
		public static StdoutDisplayInterface wordValidator(String word) {
			return new StdoutDisplayInterface() {
				@Override
				public void run() throws Exception {
					
					Pattern p = Pattern.compile(pattern);
				    Matcher m = p.matcher(word);
					if (!m.matches()) {
						throw new Exception("Word has special characters.");
					}
				}
			};
		}
	}
	/**
	 * @param	fileProcessor	FileProcessor class object 
	 * 		
	 *
	 */
	
	public void readInputFile(FileProcessor fileProcessor) throws Exception{
		try {
			Scanner input = new Scanner(fileProcessor.getInputFile());
			while (input.hasNext()) {
			    String test = input.nextLine();
			    
			    result.setNumberOfCharacters(result.getNumberOfCharacters()+test.length());
			    
			    String[] sentenses = test.split("\\.");
			    
			    result.setNumberOfSentenses(result.getNumberOfSentenses()+sentenses.length);
			    
			    for(String sentense : sentenses){
			    	
			    	String reverseSentense = reverseWordsInSentense(sentense);
			    	writeOutput(reverseSentense, fileProcessor.getOutputFile());
			    }
			    writeOutput("\n", fileProcessor.getOutputFile());
			 }
			
			writeMatrixOut(fileProcessor.getMatrixFile());
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} 
		
	}
	
	/**
	 * @param	matrixFile	File which has result matrix.
	 * 
	 *
	 */
	
	private void writeMatrixOut(File matrixFile) {
		
		double AVG_NUMBER_WORDS_PER_SENTENCE = (double)result.getNumberOfWords()/result.getNumberOfSentenses();
		double AVG_NUM_CHARS_PER_SENTENCE = (double)result.getNumberOfCharacters()/result.getNumberOfSentenses();
		
		writeOutput("AVG_NUMBER_WORDS_PER_SENTENCE ="+AVG_NUMBER_WORDS_PER_SENTENCE+"\n",  matrixFile);
		writeOutput("AVG_NUM_CHARS_PER_SENTENCE ="+AVG_NUM_CHARS_PER_SENTENCE+"\n",  matrixFile);
		writeOutput("MAX_FREQ_WORD ="+result.getHighestFrequencyWord()+"\n", matrixFile);
		writeOutput("LONGEST_WORD ="+result.getCurrentLongestWord(), matrixFile);
	}
	/**
	 * @param	sentnese	String to reverse
	 * @throws	Exception when special characters are present
	 * @return	String	reversed words
	 *
	 */
		
	public String reverseWordsInSentense(String sentnese) throws Exception{
		String[] words = sentnese.trim().split(" "); //created a string array
		
		result.setNumberOfWords(result.getNumberOfWords() + words.length);
		
		StringBuilder reversedString = new StringBuilder(); 
		
		for (int i = 0; i < words.length; i++)  //for sentence
        {
            String word = words[i];
            
            ValidatorUtil.validate("failed",
	    			ValidatorFetcher.wordValidator(word));	
            
            updateLongestWord(word);
            updateWordFrequency(word);
            
            StringBuilder reverseWord = new StringBuilder();
            for (int j = word.length() - 1; j >= 0; j--) {
                reverseWord = reverseWord.append(word.charAt(j));
            }
            if(i == words.length -1){
            	reversedString = reversedString.append(reverseWord).append(".");
            }else{
            	reversedString = reversedString.append(reverseWord).append(" ");
            }
            
        }
		
		return reversedString.toString();
	}
	/**
	 * @param	info	reversed sentence
	 * @param	outputFile	file where reverse sentense has to be written
	 * 
	 *
	 */
	public void writeOutput(String info, File outputFile){
	     try{
	    	 if(!outputFile.exists()){
	    		 Files.write(Paths.get(outputFile.getAbsolutePath()), info.getBytes());	
	    	 }else{
	    		 Files.write(Paths.get(outputFile.getAbsolutePath()), info.getBytes(), StandardOpenOption.APPEND);	
	    	 }
	    	 
	     }catch (IOException e) {
	            e.printStackTrace();
	        }
	}
	/**
	 * @param	word	reversed word to find out the longest word in input file
	 * 
	 *
	 */
	private void updateLongestWord(String word){
		if(result.getHighestWordLenght() < word.length()){
			result.setHighestWordLenght(word.length());
			result.setCurrentLongestWord(word);
		}
	}
	/**
	 * @param	word	reversed word to find out the maximum frequency of the word
	 * 
	 *
	 */
	private void updateWordFrequency(String word){
		int count = 1;
		if(result.getWordFrequecy().containsKey(word.toLowerCase())){
			count = result.getWordFrequecy().get(word.toLowerCase()) + count;
			result.getWordFrequecy().put(word.toLowerCase(), count);
		}else{
			result.getWordFrequecy().put(word.toLowerCase(), count);
		}
		
		if(result.getHighestFrequency() < count){
			result.setHighestFrequency(count);
			result.setHighestFrequencyWord(word);
		}
	}
}
