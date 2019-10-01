

//calculate the angle between hour and minute hand
public class ClockAngle {

	
	public static void main(String r[]) {
		
		int hour = 7;
		int minute = 25;
		float angle =	calculateAngleBetweenHourMinuteHand(hour, minute);
		System.out.println(angle);
		
	}

	private static float calculateAngleBetweenHourMinuteHand(int hour, int minute) {

		float hourAngleUnit  = 360/12;
		float additionalHourAngleUnit = hourAngleUnit/60; 
		float minutAngleUnit = 360/60;
		
		float hourAngle = 0;
		if(hour != 0 && hour != 12) {
			hourAngle = hour * hourAngleUnit;
			if(minute > 0 ) {
				hourAngle = hourAngle + (additionalHourAngleUnit * minute);
			}
		}
		
		float minuteAngle = 0;
		if(minute != 0 && hour != 60) {
			minuteAngle = minute * minutAngleUnit;
		}
		
		float diffAngle = Math.abs(hourAngle - minutAngleUnit);
		return Math.min(360 - diffAngle, diffAngle);
	}
	
}
