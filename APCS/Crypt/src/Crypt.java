import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * 
 * This class encrypts and decrypts text files using one of 3 algorithms: Random
 * monoalphabet, Vigenere, or Playfair
 * 
 * 
 * @author
 * @version
 * 
 */
public class Crypt {

	public static final String lineSeparator = System.getProperty("line.separator");
	private char[] key;
	private static final int lowerStart = 'a';
	private static final int upperStart = 'A';
	
	/**
	 * 
	 * An integer representing the algorithm chosen. Set to: 1 for random
	 * monoalphabet 2 for Vigenere 3 for Playfair
	 * 
	 */
	public static final int algorithm = 2;
	
	public Crypt(String keyword) {
		key = keyword.toCharArray();
	}

	/**
	 * Reads from the file specified, and writes out an encrypted version of the
	 * file. If the output file already exists, overwrite it.
	 * 
	 * @param inputFilename
	 *            The path of the file to be encrypted.
	 * @param outputFilename
	 *            The path of the encrypted file to be saved.
	 * @param keyword
	 *            The keyword to be used in the encryption algorithm.
	 * 
	 */
	public void encrypt(String inputFilename, String outputFilename, String keyword) {
		BufferedWriter writer = null;
		BufferedReader br = null;
		 

		try {

			br = new BufferedReader(new FileReader(inputFilename));
			writer = new BufferedWriter(new FileWriter(outputFilename));
			
			// a = 97, A = 65

			// offset = letter - lower/upperstart
			// access alphabet = lower/upperstart + ([(letter - lower/upperstart) + offset] % 26)

			int x = 0;
			
			while (br.ready()) {
				String line = br.readLine();

				// encrypt..................
				
				char[] lineArray = line.toCharArray();

				
				int offset = 0;
				
				for (int i = 0; i < lineArray.length; i++) {
					char c = lineArray[i];
					
					if (c >= 97 && c < 123) {
						offset = key[x] - lowerStart;
						c = (char) (lowerStart + ((c - lowerStart + offset) % 26));
						x++;
						x = x % key.length;
						
					} else if (c >= 65 && c < 91) {
						offset = key[x] - lowerStart;
						c = (char) (upperStart + ((c - upperStart + offset) % 26));
						x++;
						x = x % key.length;
					}
					
					
					lineArray[i] = c;
					// x++, x%key.length (inside of if statements)
				}
				
				//..........................
				
				writer.write(new String(lineArray));
				writer.write(lineSeparator);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			try {
				if (writer != null) {
					writer.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	/**
	 * Reads from the (previously encrypted) file specified, and writes out a
	 * decrypted version of the file. If the output file already exists, overwrite
	 * it.
	 * 
	 * @param inputFilename
	 *            The path of the encrypted file.
	 * @param outputFilename
	 *            The path of the decrypted file to be saved.
	 * @param keyword
	 *            The keyword to be used in the decryption algorithm.
	 * 
	 */
	public void decrypt(String inputFilename, String outputFilename, String keyword) {
		BufferedWriter writer = null;
		 

		try {

			BufferedReader br = new BufferedReader(new FileReader(inputFilename));
			writer = new BufferedWriter(new FileWriter(outputFilename));
			
			// a = 97, A = 65

			// offset = letter - lower/upperstart
			// access alphabet = lower/upperstart + ([(letter - lower/upperstart) + offset] % 26)

			int x = 0;
			
			while (br.ready()) {
				String line = br.readLine();

				// encrypt..................
				
				char[] lineArray = line.toCharArray();
				
				int offset = 0;
				
				for (int i = 0; i < lineArray.length; i++) {
					char c = lineArray[i];
					
					if (c >= 97 && c < 97 + 26) {
						offset = lowerStart - key[x];
						c = (char) (lowerStart + ((26 + c - lowerStart + offset) % 26));
						x++;
						x = x % key.length;
						
					} else if (c >= 65 && c < 65 + 26) {
						offset = lowerStart - key[x];
						c = (char) (upperStart + ((26 + c - upperStart + offset) % 26));
						x++;
						x = x % key.length;
					}
					
					
					lineArray[i] = c;
					// x++, x%key.length (inside of if statements)
				}
				
				//..........................
				
				writer.write(new String(lineArray));
				writer.write(lineSeparator);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			try {
				if (writer != null) {
					writer.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
