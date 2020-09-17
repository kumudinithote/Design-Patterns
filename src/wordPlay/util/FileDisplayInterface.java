package wordPlay.util;

import java.io.File;
/**
 * @author kumudinithote
 * 
 */

public interface FileDisplayInterface {

		public void readInputFile(FileProcessor fileProcessor) throws Exception;
		public String reverseWordsInSentense(String sentnese) throws Exception;
		public void writeOutput(String info, File outputFile);
}
