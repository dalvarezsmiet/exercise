package com.example.exercise.data;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

import com.example.exercise.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
public class DateGenerator {
	private static final String lexiconNum = "0123456789";
	private static final Set<String> identifiers = new HashSet<String>();
	private static final java.util.Random rand = new java.util.Random();
	private static final List<String> towns = new ArrayList<String>(
			Arrays.asList("Lausanne", "Renens", "Ecublens", "Prilly", "Malley", "Cully", "Saint Sphorine", "Lutry"));
	private static final List<String> lastNames = new ArrayList<String>(Arrays.asList("SMITH", "JOHNSON", "WILLIAMS",
			"BROWN", "JONES", "MILLER", "DAVIS", "GARCIA", "RODRIGUEZ", "WILSON", "MARTINEZ", "ANDERSON", "TAYLOR",
			"THOMAS", "HERNANDEZ", "MOORE", "MARTIN", "JACKSON", "THOMPSON", "WHITE", "LOPEZ", "LEE", "GONZALEZ",
			"HARRIS", "CLARK", "LEWIS", "ROBINSON", "WALKER", "PEREZ", "HALL", "YOUNG", "ALLEN", "SANCHEZ", "WRIGHT",
			"KING", "SCOTT", "GREEN", "BAKER", "ADAMS", "NELSON", "HILL", "RAMIREZ", "CAMPBELL", "MITCHELL", "ROBERTS",
			"CARTER", "PHILLIPS", "EVANS", "TURNER", "TORRES", "PARKER", "COLLINS", "EDWARDS", "STEWART", "FLORES",
			"MORRIS", "NGUYEN", "MURPHY", "RIVERA", "COOK", "ROGERS", "MORGAN", "PETERSON", "COOPER", "REED", "BAILEY",
			"BELL", "GOMEZ", "KELLY", "HOWARD", "WARD", "COX", "DIAZ", "RICHARDSO", "WOOD", "WATSON", "BROOKS",
			"BENNETT", "GRAY", "JAMES", "REYES", "CRUZ", "HUGHES", "PRICE", "MYERS", "LONG", "FOSTER", "SANDERS",
			"ROSS", "MORALES", "POWELL", "SULLIVAN", "RUSSELL", "ORTIZ", "JENKINS", "GUTIERREZ", "PERRY", "BUTLER",
			"BARNES", "FISHER", "HENDERSON", "COLEMAN", "SIMMONS", "PATTERSON", "JORDAN", "REYNOLDS", "HAMILTON",
			"GRAHAM", "KIM", "GONZALES", "ALEXANDER", "RAMOS", "WALLACE", "GRIFFIN", "WEST", "COLE", "HAYES", "CHAVEZ",
			"GIBSON", "BRYANT", "ELLIS", "STEVENS", "MURRAY", "FORD", "MARSHALL", "OWENS", "MCDONALD", "HARRISON",
			"RUIZ", "KENNEDY", "WELLS", "ALVAREZ", "WOODS", "MENDOZA", "CASTILLO", "OLSON", "WEBB", "WASHINGTO",
			"TUCKER", "FREEMAN", "BURNS", "HENRY", "VASQUEZ", "SNYDER", "SIMPSON", "CRAWFORD", "JIMENEZ", "PORTER",
			"MASON", "SHAW", "GORDON", "WAGNER", "HUNTER", "ROMERO", "HICKS", "DIXON", "HUNT", "PALMER", "ROBERTSON",
			"BLACK", "HOLMES", "STONE", "MEYER", "BOYD", "MILLS", "WARREN", "FOX", "ROSE", "RICE", "MORENO", "SCHMIDT",
			"PATEL", "FERGUSON", "NICHOLS"));
	
	private static final List<String> firstNames = new ArrayList<String>(Arrays.asList("Emily", "Emma", "Madison",
			"Abigail", "Olivia", "Isabella", "Hannah", "Samantha", "Ava", "Ashley", "Sophia", "Elizabeth", "Alexis",
			"Grace", "Sarah", "Alyssa", "Mia", "Natalie", "Chloe", "Brianna", "Lauren", "Ella", "Anna", "Taylor",
			"Kayla", "Hailey", "Jessica", "Victoria", "Jasmine", "Sydney", "Julia", "Destiny", "Morgan", "Kaitlyn",
			"Savannah", "Katherine", "Alexandra", "Rachel", "Lily", "Megan", "Kaylee", "Jennifer", "Angelina",
			"Makayla", "Allison", "Brooke", "Maria", "Trinity", "Lillian", "Mackenzie", "Evan", "Nicholas", "Cody",
			"Zachary", "Chase", "Mike", "Jose", "Steven", "Max", "Ian", "Connor", "Mark", "Cole", "Patrick", "Sean",
			"Samuel", "Gabriel", "Nate", "Devin", "Will", "Alexander", "Jeremy", "Isaac", "Alex", "Mason",
			"Joey", "Carlos", "Bryan", "Jared", "Tanner", "Peter", "Tristan", "Gavin", "Shane", "Seth", "Stephen",
			"Paul", "Makayla", "Elijah", "Brendan", "Zack", "Garrett", "Aidan", "Gabby", "Charles", "Eli",
			"Blake"));
	
	private static final List<String> emailDomains = new ArrayList<String>(Arrays.asList("gmail.com", "yahoo.com",
			"hotmail.com", "facebook.com", "secutix.com", "elca.ch", "swisscom.ch"));
	
	public static void main(String [] args) throws IOException {
		List<User> userList = new ArrayList<User>();
		final ObjectMapper mapper = new ObjectMapper();
		for (int i = 0; i<100; i++) {
			final User u = getUser();
			userList.add(u);
		}
		mapper.writeValue(new File("user.json"), userList);
		final String userJson = mapper.writeValueAsString(userList);
		System.out.println(userJson);
	}
	
	private static User getUser() {
		final User user = new User();
		user.setId(UUID.randomUUID().toString());
		user.setFirstname(getRandomValue(firstNames));
		user.setLastname(getRandomValue(lastNames));
		user.setEmail(user.getFirstname().toLowerCase() + "." + user.getLastname().toLowerCase() + "@" + getRandomValue(emailDomains));
		user.setMobile(randomIdentifier(lexiconNum));
		user.setDateOfBirth(getRandomDate());
		user.setTown(towns.get(rand.nextInt(8)));
		return user;
	}
	private static Date getRandomDate() {
		final Calendar cal = Calendar.getInstance();
		int year = rand.nextInt(15)+ 1985;
		int date = rand.nextInt(25) + 1;
		int month = rand.nextInt(11) + 1;
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month);
		cal.set(Calendar.DATE, date);
		return cal.getTime();
	}
	
	
	public static String randomIdentifier(final String lexicon) {
	    StringBuilder builder = new StringBuilder();
	    while(builder.toString().length() == 0) {
	        int length = rand.nextInt(5)+5;
	        for(int i = 0; i < length; i++) {
	            builder.append(lexicon.charAt(rand.nextInt(lexicon.length())));
	        }
	        if(identifiers.contains(builder.toString())) {
	            builder = new StringBuilder();
	        }
	    }
	    return builder.toString();
	}
	
	private static String getRandomValue(final List<String> list) {
		final Random rand = new Random();
		final int index = rand.nextInt(list.size());
		return list.get(index);
	}
}
