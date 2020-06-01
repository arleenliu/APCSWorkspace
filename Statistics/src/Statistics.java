import java.util.Arrays;

public class Statistics {

	private int[] data;
	private int realLength;

	public Statistics(int maxLength) {
		data = new int[maxLength];
		realLength = 0;
	}

	public void readData(String filename) {
		ArrayReader ar = new ArrayReader(filename);
		realLength = ar.fillArray(data);
		System.out.println(realLength);
		// for (int i = realLength; i < data.length; i++) {
		// data[i] = -1;
		// }
	}

	public void printData() {
		System.out.println(Arrays.toString(data));
		// for (int datum : data) {
		// if (datum != -1) {
		// System.out.println(datum);
		// }
		// }
	}

	public double calcAvg() {
		long sum = 0;
		for (int i = 0; i < realLength; i++) {
			sum += data[i];
		}
		return sum / (double) (realLength);
	}

	public double calcStanDev() {
		double avg = calcAvg();
		long sum = 0;
		for (int i = 0; i < realLength; i++) {
			sum += (Math.pow(data[i] - avg, 2));
		}
		long avgSD = sum / (realLength);
		return Math.sqrt(avgSD);
	}

	public int[] calcMode() {
		int[] modes = new int[101];
		int[] freq = new int[101];

		// int count1 = 0;
		// int count2 = 0;
		// count1 checks the number of times a number repeats
		// count 2 keeps track of the last greatest count
		// val 1 = current value
		// val 2 = last greatest value
		int val1 = Integer.MIN_VALUE;
		// int val2 = data[0];

		// test set 4,4,5,5,5,6,6,6,7,8,9,9,9,9,9
		for (int i = 0; i < realLength; i++) {
			freq[data[i]]++;
		}

		for (int i = 0; i < freq.length; i++) {
			if (freq[i] > val1) {
				val1 = freq[i];
			}
		}

		for (int y = 0; y < freq.length; y++) {
			if (freq[y] == val1) {
				modes[y] = y;
				System.out.println(y);
			} else {
				modes[y] = -1;
			}
		}
		// if the current number is greater than the past number, used to check when
		// number
		// changes
		// if (data[i] > val1) {
		// if the number of times it currently repeated is greater than the last one
		// if (count1 > count2) {
		// if the number of times they repeated are equal
		// if (count1 == count2) {
		// sets modes[i] to the last greatest value
		// modes[i] = val2;
		// }
		// sets the last greatest count equal to the current greatest count
		// becomes 3
		// count2 = count1;
		// last greatest value = current greatest value
		// becomes 6
		// val2 = val1;
		// }
		// sets the number of times the number repeated to zero
		// count1 = 0;
		// gets the next number
		// val1 = data[i];
		// }
		// keeps count of the repeating number
		// else {
		// count1++;
		// }

		// }

		return modes;
	}

	public void compactArray() {
		int count = 0;
		int freq = 0;
		System.out.println("RealLength: " + realLength);
		
		for (int i = 0; i < realLength; i++) {
			if (data[i] == 0) {
				freq++;
			}
		}
		System.out.println("Freq: " + freq);
		
		for (int i = 0; i < realLength - freq; i++) {
			if (data[i] == 0) {
				System.out.println(i);
				for (int x = i; x < realLength - count; x++) {
					data[x] = data[x + 1];
				}
				data[realLength - count] = data[i];
				count++;
				
				i-=1;
				
				//System.out.println("Data: " + Arrays.toString(data));
			}
		}
		System.out.println("Count: " + count);
		
		realLength -= freq;
	}

}
