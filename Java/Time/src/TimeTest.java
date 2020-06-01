
public class TimeTest {

	public static void testConstructors(){
		Time t1 = new Time();
		Time t2 = new Time(13,5);
		Time t3 = new Time(24,0);
		//Time t4 = new Time(-1,30);
		Time t5 = new Time (2, 15);
		Time t6 = new Time (0, 20);
		Time t7 = new Time (2, 100);

		
		System.out.println(t1);
		System.out.println(t2);
		System.out.println(t3);
		//System.out.println(t4);
		System.out.println(t5);
		System.out.println(t6);
		System.out.println(t7);

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testConstructors();
	}

}
