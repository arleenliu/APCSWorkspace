
public class DiplomaWithHonors extends Diploma{

	private String studentName;
	private String courseName;
	
	public DiplomaWithHonors(String name, String className) {
		super(name, className);
		// TODO Auto-generated constructor stub
		
		studentName = name;
		courseName = className;
	}
	
	public String toString (){
		String diploma = super.toString();
		String honors =  "\n" + "*** with honors ***";
		
		return diploma + honors;
		
	}
	
	
}
