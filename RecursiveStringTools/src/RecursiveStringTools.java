import java.util.Scanner;

public class RecursiveStringTools {

	// Example
	public static int length(String in) {
		if (in.equals("")) {
			return 0;
		} else {
			return length(in.substring(1)) + 1;
		}
	}

	// Example
	public static boolean equals(String in1, String in2) {
		if (length(in1) != length(in2)) {
			return false;
		} else if (in1.length() == 0 && in2.length() == 0) {
			return true;
		} else {
			boolean eq = in1.charAt(0) == in2.charAt(0);
			String s1 = in1.substring(1);
			String s2 = in2.substring(1);
			return eq && equals(s1, s2);
		}
	}

	// Exercise #1
	public static boolean matches(String in1, String in2) {
		if (length(in1) != length(in2)) {
			return false;
		} else if (in1.length() == 0 && in2.length() == 0) {
			return true;
		} else {
			boolean eq = in1.charAt(0) == in2.charAt(0) || in1.charAt(0) == '?' || in2.charAt(0) == '?';
			String s1 = in1.substring(1);
			String s2 = in2.substring(1);
			return eq && matches(s1, s2);
		}
	}

	// Exercise #2
	public static boolean isPalindrome(String in) {
		in = in.toLowerCase();
		in = in.trim();
		in = in.replace(" ", "");

		if (in.charAt(0) < 97 || in.charAt(0) > 122) {
			return isPalindrome(in.substring(1));
		}

		if (in.charAt(in.length() - 1) < 97 || in.charAt(in.length() - 1) > 122) {
			return isPalindrome(in.substring(0, in.length() - 1));
		}

		if (in.length() <= 2) {
			char c1 = in.charAt(0);
			char c2 = in.charAt(in.length() - 1);
			return c1 == c2;
		} else {
			char c1 = in.charAt(0);
			char c2 = in.charAt(in.length() - 1);
			if (c1 == c2) {
				return isPalindrome(in.substring(1, in.length() - 1));
			} else {
				return false;
			}
		}
	}

	// Exercise #3
	public static void printPermutations(String in) {
		printPermutations("", in);
	}

//	private static void printPermutations(String in, String prefix, int length) {
//		String pref = prefix;
//		if (in.length() == 1) {
//			System.out.println(in);
//		} else {
//			System.out.print("" + in.substring(0, 1));
//			printPermutations(in.substring(1), pref + in.substring(0, 1), length);
//		}
//		if (in.length() == length && pref.indexOf(in.charAt(0)) == -1) {
//			printPermutations(in.substring(1) + in.substring(0, 1), (in.substring(1)).substring(0, 1), length);
//		}
//
//	}
	
	private static void printPermutations(String prefs, String in) {
		int length = in.length();
		if (length <= 1) {
			System.out.println(prefs + in);
		}  else {
			forLoop(0, in.length(), prefs, in);
		}
	}

	private static void forLoop(int i, int n, String prefs, String in) {
		if (i >= n) {
			return;
		} else {
			printPermutations(prefs + in.charAt(i), in.substring(0, i) + in.substring(i+1));
			
			i++;
			forLoop(i, n, prefs, in);
		}
	}

	public static String piglatinate(String in) {
		return "";
	}

	public static void main(String[] args) {
		printPermutations("luck");

		Scanner kboard = new Scanner(System.in);
		System.out.println("Please enter a string:");
		String s = kboard.nextLine();

		String out = RecursiveStringTools.isPalindrome(s) + "";
		System.out.print("\n\nThe result is --> " + out + "\n\n");
	}
}
