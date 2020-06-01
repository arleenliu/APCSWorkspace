public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Statistics s = new Statistics(10000);
		s.readData("numbers4.txt");
		s.compactArray();
		s.printData();
		System.out.println("Avg: " + s.calcAvg());
		System.out.println("Standard Deviation: " + s.calcStanDev());
		
		int[] modes = s.calcMode();
		
		System.out.print("Modes: ");
		for (int i = 0; i < modes.length; i++) {
			if (modes[i] != -1) {
				System.out.print(modes[i] + " ");
			}
			
		}
		
		// System.out.println("Modes: " + Arrays.toString(s.calcMode()));
	}

}
