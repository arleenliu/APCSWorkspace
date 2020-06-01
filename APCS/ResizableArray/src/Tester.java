
public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ResizableArray data = new ResizableArray();
		data.add(3);
		data.add(2);
		data.add(10);
		data.add(0);
		data.add(20);
		
		System.out.println(data.toString());
		data.remove(3);
		System.out.println(data.toString());
		System.out.println("Size = " + data.size());
		data.insert(2, 19);
		System.out.println(data.toString());
		

	}

}
