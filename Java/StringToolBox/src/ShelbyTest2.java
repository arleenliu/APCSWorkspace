
/*

 This class tests all methods of the StringToolBox class.

 To use this, comment out all methods that you haven't finished yet. Then
 run - you should see the output on the left and right of all lines match!

*/

public class ShelbyTest2 {

	public static void main(String[] args) {

		System.out.println("***Testing: boolean endsWithStar(String s)***");
		System.out.println("true = " + StringToolBox.endsWithStar("abcd*"));
		System.out.println("false = " + StringToolBox.endsWithStar(""));

		System.out.println("***Testing: boolean endsWithTwoStars(String s)***");
		System.out.println("true = " + StringToolBox.endsWithTwoStars("abcd**"));
		System.out.println("false = " + StringToolBox.endsWithTwoStars("*"));
		System.out.println("false = " + StringToolBox.endsWithTwoStars(""));

		System.out.println("***Testing: String last4(String s)***");
		System.out.println("3456 = " + StringToolBox.last4("1234 5678 9012 3456"));

		System.out.println("***Testing: String last5(String s)***");
		System.out.println("23456 = " + StringToolBox.last5("1234 5678 9012 3456"));

		System.out.println("***Testing: String scroll(String s)***");
		System.out.println("23451 = " + StringToolBox.scroll("12345"));

		System.out.println("***Testing: String convertName(String s)***");
		System.out.println("Albert Einstein = " + StringToolBox.convertName("Einstein, Albert"));
		
		System.out.println("***Testing: String removeDashes(String str)***");
		System.out.println("123456789 = " + StringToolBox.removeDashes("123-45-6789"));

		System.out.println("***Testing: String dateStr(String s)***");
		System.out.println("10-02-2011 = " + StringToolBox.dateStr("02/10/2011"));

		try {
			System.out.println("***Testing: String dateStr(String s) (Challenge version)***");
			System.out.println("10-02-2010 = " + StringToolBox.dateStr("2/10/2010"));
			System.out.println("02-10-2010 = " + StringToolBox.dateStr("10/2/2010"));
			System.out.println("02-01-2010 = " + StringToolBox.dateStr("1/2/2010"));
		} catch (Exception e) { System.out.println("No dateStr EC"); }

		System.out.println("***Testing: String negativeBits(String s)***");
		System.out.println("0101 = " + StringToolBox.negativeBits("1010"));
		System.out.println("1111 0000 = " + StringToolBox.negativeBits("0000 1111"));

		System.out.println("***Testing: boolean containsSameChar(String s)***");
		System.out.println("false = " + StringToolBox.containsSameChar("1010"));
		System.out.println("true = " + StringToolBox.containsSameChar("1111111"));

		System.out.println("***Testing: String removeComments(String s)***");
		System.out.println("The hippo is native to Western Africa. = " + StringToolBox.removeComments("The hippo is native to Western Africa."));
		System.out.println("The pygmy hippo is native to Western Africa. = " + StringToolBox.removeComments("The pygmy hippo is /*a reclusive and nocturnal animal */native to Western Africa."));
		System.out.println("The hippo is native to Western Africa. = " + StringToolBox.removeComments("The hippo is nat/**/ive to Western Africa."));

	}


}