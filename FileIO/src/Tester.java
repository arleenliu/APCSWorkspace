import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Tester {

	public static void main(String[] args) {
		String workingDir = System.getProperty("user.dir");
		
	    JFileChooser chooser = new JFileChooser(workingDir);
	  //  FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF Images", "jpg", "gif");
	  //  chooser.setFileFilter(filter);
	    int returnVal = chooser.showOpenDialog(null);
	    if(returnVal == JFileChooser.APPROVE_OPTION) {
	       System.out.println("You chose to open this file: " +
	            chooser.getSelectedFile().getName());
	       
	   	// TODO Auto-generated method stub
			ArrayList<String> fileData = FileIO.readFile( chooser.getSelectedFile().getAbsolutePath());
			System.out.println(fileData);
			
			FileIO.writeFile("testFile", fileData);
	       
	    }
		
	
	}

}
