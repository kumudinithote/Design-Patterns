package wordPlay.driver;

import wordPlay.util.FileProcessor;
import wordPlay.util.SentenseProcessor;


public class Driver {

	public static void main(String[] args) {

		if(validateArguments(args)){
			try {
				FileProcessor fileProcessor = new FileProcessor(args[0], args[1], args[2]);
				
				SentenseProcessor sentenseProcessor = new SentenseProcessor();
				sentenseProcessor.readInputFile(fileProcessor);
				
				System.out.println("Success!!!!");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
		}else{
			System.out.println("Please check command line arguments for validity");
		}
	}
	
	/**
	 * @author	Kumudini
	 * @param	args	array of String as command line argument
	 * @return	boolean based on validity of input array
	 */
	public static boolean validateArguments(String[] args){
		return args != null && args.length == 3 ? true : false;
	}

}
