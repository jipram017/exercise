package exercise;

import java.util.ArrayList;

public class LowestCommonManager {
	public static class orgInfo{
		Person lowestCommonManager;
		int numImportantReports;
		public orgInfo(Person lowestCommonManager, int numImportantReports){
			this.lowestCommonManager = lowestCommonManager;
			this.numImportantReports = numImportantReports;
		}
	}
	
	public static class Person{
		int id;
		String name;
		ArrayList<Person> directReports;
		public Person(int id, String name, ArrayList<Person> list) {
			this.id = id;
			this.name = name;
			this.directReports = list;
		}
	}
	
	public static Person getLowestCommonManager(Person topManager, Person p, Person q) {
		return getOrgInfo(topManager, p, q).lowestCommonManager;
	}
	
	public static orgInfo getOrgInfo(Person manager, Person p, Person q) {
		int numImportantReports = 0;
		Person lowestCommonManager = null;
		for (Person directReport : manager.directReports) {
			orgInfo orgStructure = getOrgInfo(directReport, p, q);
			if(orgStructure.lowestCommonManager != null) return orgStructure;
			numImportantReports += orgStructure.numImportantReports;
		}
		if(manager.name == p.name || manager.name == q.name) {
			numImportantReports += 1;
		}
		if(numImportantReports == 2) {
			lowestCommonManager = manager;
		}
		return new orgInfo(lowestCommonManager, numImportantReports);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
