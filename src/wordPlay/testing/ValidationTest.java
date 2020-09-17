package wordPlay.testing;

import wordPlay.util.FileProcessor;
import wordPlay.util.Result;
import wordPlay.util.SentenseProcessor;
/**
 * @author kumudinithote
 * 
 */
public class ValidationTest {
	public static void main(String[] args) {
		System.out.println("Creating valid FileProcessor object");
		try {
			new FileProcessor("input.txt", "output.txt", "matrix.txt"); // Valid FileProcessor object.
			System.out.println("passed");
		} catch (Exception e) {
			// Printing the error message.
			System.out.println(e.getMessage());
		}
		
		System.out.println("-------------------------------------");
		System.out.println("Check for special character in word");
		try {
			SentenseProcessor  sentenseProcessor = new SentenseProcessor();
			sentenseProcessor.reverseWordsInSentense("Kumudinithote");
			System.out.println("passed");
		} catch (Exception e) {
			// Printing the error message.
			System.out.println(e.getMessage());
		}
	}
	
}
