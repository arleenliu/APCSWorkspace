
public class Diploma {

	//FIELDS
	private String personName;
	private String courseName;

	
	//CONSTRUCTORS
	
	public Diploma(String name, String className){
		personName = name;
		courseName = className;
	}
	

	//METHODS
	

	public String toString (){
		String line1 = "This certifies that" + "\n";
		String line2 = personName + "\n";
		String line3 = "has completed a course in " + courseName;

		
		return line1 + line2 + line3;
	}
	
	
}
