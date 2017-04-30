package sports.model;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class reads in a file that is specified.
 * @author obinnaasinugo
 *
 */
public class FileReaderv3 {
	private int counter; 
	private String filename;
	private ArrayList<String> lines;
	
	/**
	 * The constructor
	 * @param file the file to read
	 */
	public FileReaderv3(String file) {
		filename = file;
		
		lines = new ArrayList<String>();
		counter = 0; 
		
		readFile();
	}
	
	/**
	 * This will read in the entire file.
	 * It will store the contents in the lines ArrayList.
	 */
	private void readFile() {
		
		try {
			File inputFile = new File(filename);
			Scanner in = new Scanner(inputFile);
			
			while (in.hasNextLine()) {
				
				// skips storing the first line of the text/ column labels  
				if(counter == 0){
					counter+=1; 
					in.nextLine(); 
					continue; 
				}
				
				
				String line = in.nextLine();
				lines.add(line);
				//System.out.println(line);
			}
			
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * The accessor method for lines
	 * @return the lines arraylist
	 */
	public ArrayList<String> getLines() {
		return lines;
	}

}
