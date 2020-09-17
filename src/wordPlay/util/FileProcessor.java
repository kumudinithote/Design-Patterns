package wordPlay.util;

import java.io.File;


public class FileProcessor{
	private File inputFile;
	private File outputFile;
	private File matrixFile;
	
	/**
	 * @author kumudinithote
	 *
	 */
	
	private static class ValidatorFetcher  {
		/**
		 * 
		 * @param	p	FileProcessor class object
		 * @throws	Exception in case of invalid file location	
		 */
		
		public static StdoutDisplayInterface inputFileValidator(FileProcessor p) {
			return new StdoutDisplayInterface() {
				@Override
				public void run() throws Exception {
					
					if (!p.inputFile.exists()) {
						throw new Exception("Provide valid input file name");
					}
					if (p.inputFile.length() == 0) {
						throw new Exception("Input file is empty");
					}
				}
			};
		}
	}
	/**
	 * 
	 * @param	inputFile will contain the text which needs to be revered
	 * @param	outputFile will show/display reversed words 
	 * @param	matrixFile will show/display Average number of words and char per sentence, max frequency word and longest word
	 * @throws	Exception in case of invalid inputfile
	 */
	public FileProcessor(String inputFile, String outputFile, String matrixFile) throws Exception {
		this.inputFile = new File(inputFile);
		this.outputFile = new File(outputFile);
		this.matrixFile = new File(matrixFile);
		
		// Validating members.
		ValidatorUtil.validate("failed",
			ValidatorFetcher.inputFileValidator(this));	
	}
	
	public File getOutputFile() {
		return outputFile;
	}

	public void setOutputFile(File outputFile) {
		this.outputFile = outputFile;
	}

	public File getMatrixFile() {
		return matrixFile;
	}

	public void setMatrixFile(File matrixFile) {
		this.matrixFile = matrixFile;
	}

	public File getInputFile() {
		return inputFile;
	}

	public void setInputFile(File inputFile) {
		this.inputFile = inputFile;
	}
	
	
	@Override
	public String toString() {
		return String.format("inputFile: %s, outputFile: %s, matrixFile: %s", 
				inputFile.toString(), outputFile.toString(), matrixFile.toString());
	}
}
