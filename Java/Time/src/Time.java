
public class Time {

	//FIELDS

	private int hours;
	private int minutes;
	public final static int HOURS_IN_DAY = 24;
	public final static int MINUTES_IN_HOUR = 60;
	private String time;
	private boolean isTime24 = true; //where is this changed?



	//CONSTRUCTORS

	public Time (){
		hours = 0;
		minutes = 0;
		//System.out.print(time);
	}

	public Time (int h, int m){
		hours = h;
		minutes = m;
		fixMinutes();
		fixHours();

		/*time = hours + ":" + minutes;
		System.out.print(time);*/
	}


	public Time (int m){
		minutes = m%60;
		hours = (m-minutes)/60;

		fixMinutes();
		fixHours();

	}

	public Time (int h, int m, boolean isAM ){
		
		if (isAM){
			if (h == 12){
				h = 0;
			} else {
				
			}
			
		} else {
			if (h == 12){
				
			} else{
				h += 12;
			}
			
		}
		hours = h;
		minutes = m;
		isTime24 = false;
		fixMinutes();
		fixHours();
		
	}

	//METHODS


	public String toString(){
		int h1 = hours;
		int m1 = minutes;
		String timeOfDay;
		String sHours;
		String sMinutes;
		String AMorPM;
		
		if (isTime24){

			if (h1 < 10){
				sHours = "0" + h1;
			} else {
				sHours = "" + h1;
			}
			if (m1 < 10){
				sMinutes = "0" + m1;
			} else{
				sMinutes = "" + m1;
			}

			time = sHours + ":" + sMinutes;

		} else {

			if (h1 >= 12){
				if (h1 == 12){

				} else {
					h1 = h1 - 12;	
					//this.isAM = false;
				}
				AMorPM = "PM";
			} else {
				//this.isAM = true;
				if (h1 == 0){
					h1 = 12;
				}
				AMorPM = "AM";
			}

			if (h1 < 10){
				sHours = "0" + h1;
			} else {
				sHours = "" + h1;
			}
			if (m1 < 10){
				sMinutes = "0" + m1;
			} else{
				sMinutes = "" + m1;
			}

			time = sHours + ":" + sMinutes + " " + AMorPM;


		}

		return time;
	}
	
	private void fixHours (){
		if (hours < 0){
			//throw new IllegalArgumentException("Please enter a different hour.");
			hours = 24+hours;
		} else if (hours > 23){
			hours = hours%HOURS_IN_DAY;
		} else{

		}

	}
	private void fixMinutes(){
	
		if (minutes < 0) {
			minutes = (-1)*minutes;
			hours = hours - (((minutes - minutes % MINUTES_IN_HOUR))/ MINUTES_IN_HOUR) - 1; //check for errors
			
			minutes = MINUTES_IN_HOUR - (minutes % MINUTES_IN_HOUR);
		} else if (minutes > 59){
			while (minutes > 59){
				minutes = minutes - MINUTES_IN_HOUR;    
				hours++;
			}
		} else {

		}

	}

	public int toMins(){   // should be private
		int minutes = this.hours*60 + this.minutes;
		return minutes;
	}

	public int compareTo(Time t){

		int min1 = this.toMins();
		int min2 = t.toMins();
		int result;
		if (min1 == min2){
			result = 0;
		} else if (min1 <= min2){
			result = -1;
		} else {
			result = 1;
		}
		return result;
	}

	public int elapsedSince(Time t){

		int min1 = t.toMins();
		int min2 = this.toMins();
		int difference;

		if (min1 < min2){
			difference = min2-min1;
		} else if (min1 > min2){
			min1 = 24*60 - min1;
			difference = min2+min1;
		} else{
			difference = 0;
		}

		return difference;
	}

	public void increment(){

		if (minutes == 59){
			minutes = 0;
			hours++;
			if (hours == 24){
				hours = 0;
			}
		} else {
			minutes++;
		}

	}
	
	public void setPrintAMPM(boolean isAMPM){
		isTime24 = !isAMPM;
	}
	
	public void offSetMinutes(int m){
		minutes +=m;
		fixMinutes();
		fixHours();
	}
	
	public int toSeconds(){
		int seconds = 60*60*hours + minutes*60;
		return seconds;
	}
	
	

}
