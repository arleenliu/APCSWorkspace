import java.util.Arrays;

public class ResizableArray {
	private int[] data;
	private int size;
	private final int DEFAULT_LENGTH = 100;
	
	public ResizableArray() {
		data = new int[DEFAULT_LENGTH];
		size = 0;
	}
	
	public void add(int newData) {
		if (data.length == size) {
			resize();
		}
		
		data[size] = newData;
		size++;
	}
	
	public void compactArray(int value) {
		int newSize = size;
		
		for (int i = 0; i < newSize; i++) {
			if (data[i] == value) {
				for (int x = i; x < newSize - 1; x++) {
					data[x] = data[x + 1];
				}
				newSize--;
				i--;
				
				//System.out.println("Data: " + Arrays.toString(data));
			}
		}
	}
	
	public int remove(int index) {
		
		if (index >= size) {
			throw new ArrayIndexOutOfBoundsException();
		}
		
		int value = data[index];
		for (int i = index; i < size - 1; i++) {
			data[i] = data[i+1];
		}
		size--;
		return value;
	}
	
	public int size() {
		return size;
	}
	
	public String toString() {
		String arr = "[";
		arr += data[0];
		for (int i = 1; i < size; i++) {
			arr += ", ";
			arr += data[i];
		}
		arr += "]";
		
		return arr;
	}
	
	public void insert(int index, int value) {
		if (data.length == size) {
			resize();
		}
		
		if (index > size) {
			throw new ArrayIndexOutOfBoundsException();
		}
		
		size++;
		for (int i = size - 1; i > index; i--) {
			data[i] = data[i - 1];
		}
		data[index] = value;
	}
	
	public void set(int index, int value) {
		
		if (index >= size) {
			throw new ArrayIndexOutOfBoundsException();
		}
		
		data[index] = value;
	}
	
	public int get(int index) {
		if (index >= size) {
			throw new ArrayIndexOutOfBoundsException();
		}
		
		return data[index];
	}
	
	public boolean equals(Object other) {
		if (other instanceof ResizableArray) {
			ResizableArray other1 = (ResizableArray) other;
			
			if (other1.size() != this.size()) {
				return false;
			}
			
			for (int i = 0; i < size; i++) {
				if (other1.get(i) != data[i]) {
					return false;
				}
			}
			
			return true;
		} else {
			return false;
		}
	}
	
	public int indexOf(int value) {
		for (int i = 0; i < size; i++) {
			if (data[i] == value) {
				return i;
			}
		}
		
		return -1;
	}
	
	public void sort() {
		Arrays.sort(data, 0, size);
	}
	
	private void resize() {
		int[] newData = new int[data.length + 100];
		for (int i = 0; i < size; i++) {
			newData[i] = data[i];
		}
		
		data = newData;
		
	}
	
	public void clear() {
		size = 0;
	}
	
	public void reverse() {
		
		for (int i = 0; i < size / 2; i++) {
			int temp = data[i];
			data[i] = data[size - i - 1];
			data[size - i - 1] = temp;
		}
		
	}
	
	public int[] toArray() {
		int[] newData = new int[size];
		for(int i = 0; i < size; i++) {
			newData[i] = data[i];
		}
		return newData;
	}

	
	/*
	 * String toString()
	 * int getSize()
	 * int[] subArray(index1, index2)
	 * int get(int index)
	 * int getIndexOf(int value)
	 * void insert(int index)
	 * int remove(int index)
	 * void replace(int index, int value)
	 * void sort()
	 * void swap(int index1, int index2)
	 * boolean contains(int value)
	 * void clear()
	 * boolean equals(Object other)
	 * int[] toArray();
	 */
	
}	