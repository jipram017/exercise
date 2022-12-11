package exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// Time complexity : O(c1+c2) where c1 = length of first list and c2 = length of second list
// Space complexity: O(c1+c2) since we have a merged of two lists
public class CalendarMatching {
	
	 static List<String[]> getAvailableTimeslots(List<String[]> calendar1, String[] boundary1,
			                                     List<String[]> calendar2, String[] boundary2,
			                                     int meetingDuration)
	 {
		List<String[]> updatedCalendar1 = getUpdatedCalendar(calendar1, boundary1);
		List<String[]> updatedCalendar2 = getUpdatedCalendar(calendar2, boundary2);
		
		List<String[]> mergedCalendar = mergeTwoCalendars(updatedCalendar1, updatedCalendar2);
		
		List<String[]> flattenedCalendar = getFlattenedCalendar(mergedCalendar);
		List<String[]> matchingAvailabilities =  getMatchingAvailabilities(flattenedCalendar, meetingDuration);
		
		return matchingAvailabilities;
	}
	
	static String timeToMinutes(String time) {
		String[] hours = time.split(":");
		int minutes = 60*Integer.parseInt(hours[0]) + Integer.parseInt(hours[1]);
		return Integer.toString(minutes);
	}
	
	static String minutesToTime(String minutes) {
		int hours = Integer.parseInt(minutes) / 60;
		int minute = Integer.parseInt(minutes) % 60;
		return Integer.toString(hours) + ":" + (minute >= 10? Integer.toString(minute) : ("0" + Integer.toString(minute)));
	}
	
	static List<String[]> getUpdatedCalendar(List<String[]> calendar, String[] boundary){
		List<String[]> updatedCalendar = calendar;
		updatedCalendar.add(0, new String[] {"0:00", boundary[0]});
		updatedCalendar.add(new String[] {boundary[1], "23:59"});
		return updatedCalendar;
	}
	
	static List<String[]> mergeTwoCalendars(List<String[]> calendar1, List<String[]> calendar2){
		// Transform each String[] time into minutes
		calendar1 = calendar1.stream()
				             .map( m -> new String[] {timeToMinutes(m[0]), timeToMinutes(m[1])} )
				             .collect(Collectors.toList());
		calendar2 = calendar2.stream()
                             .map( m -> new String[] {timeToMinutes(m[0]), timeToMinutes(m[1])} )
                             .collect(Collectors.toList());
		
		List<String[]> mergedCalendar = new ArrayList<String[]>();
		int i = 0;
		int j = 0;
		while(i < calendar1.size() && j < calendar2.size()) {
			int startMeeting1 = Integer.parseInt(calendar1.get(i)[0]);
			int startMeeting2 = Integer.parseInt(calendar2.get(j)[0]);
			if(startMeeting1 < startMeeting2) {
				mergedCalendar.add(calendar1.get(i));
				i++;
			} else {
				mergedCalendar.add(calendar2.get(j));
				j++;
			}
		}
		
		while(i < calendar1.size()) {
			mergedCalendar.add(calendar1.get(i));
			i++;
		}
		while(j < calendar2.size()) {
			mergedCalendar.add(calendar2.get(j));
			j++;
		}
		
		return mergedCalendar;
	}
	
	static List<String[]> getFlattenedCalendar(List<String[]> calendar){
		List<String[]> flattened = new ArrayList<String[]> ();
		flattened.add(calendar.get(0));
		for (int i = 1; i < calendar.size(); i++) {
			String[] currentMeeting = calendar.get(i);
			String[] previousMeeting = flattened.get(flattened.size()-1);
			
			int previousStart = Integer.parseInt(previousMeeting[0]);
			int previousEnd = Integer.parseInt(previousMeeting[1]);
			
			int currentStart = Integer.parseInt(currentMeeting[0]);
			int currentEnd = Integer.parseInt(currentMeeting[1]);
			
			if(currentStart <= previousEnd) {
				String[] newPreviousMeeting = new String[] {Integer.toString(previousStart), Integer.toString(Integer.max(currentEnd, previousEnd))};
				flattened.set(flattened.size()-1, newPreviousMeeting);
			} else {
				flattened.add(currentMeeting);
			}
		}
		
		return flattened;
	}
	
	static List<String[]> getMatchingAvailabilities(List<String[]> calendar, int duration){
		List<String[]> availableSlots = new ArrayList<String[]>();
		for (int i = 1; i < calendar.size(); i++) {
			int end = Integer.parseInt(calendar.get(i)[0]);
			int start = Integer.parseInt(calendar.get(i-1)[1]);
			if (end - start >= duration) {
				String startMeeting = Integer.toString(start);
				String endMeeting = Integer.toString(end);
				availableSlots.add(new String[] {startMeeting, endMeeting});
			}
		}
		
		// Transform back each String[] minutes to time
		availableSlots = availableSlots.stream()
				                       .map( m -> new String[] {minutesToTime(m[0]), minutesToTime(m[1])} )
				                       .collect(Collectors.toList());
		return availableSlots;
	}
	
	public static void main(String[] args) {
		List<String[]> calendarA = new ArrayList<String[]>();
		calendarA.add(new String[] {"9:00", "10:30"});
		calendarA.add(new String[] {"12:00", "13:00"});
		calendarA.add(new String[] {"16:00", "18:00"});
		
		String[] boundaryA = new String[] {"9:00", "20:00"};
		
		List<String[]> calendarB = new ArrayList<String[]>();
		calendarB.add(new String[] {"10:00", "11:30"});
		calendarB.add(new String[] {"12:30", "14:30"});
		calendarB.add(new String[] {"14:30", "15:00"});
		calendarB.add(new String[] {"16:00", "17:00"});
		
		String[] boundaryB = new String[] {"10:00", "18:30"};
		
		int meetingDuration = 30;
		
		List<String[]> result = getAvailableTimeslots(calendarA, boundaryA, calendarB, boundaryB, meetingDuration);
		
		System.out.println("\n");
		for(String[] arr: result) {
			System.out.println(Arrays.toString(arr));
		}
	}

}
