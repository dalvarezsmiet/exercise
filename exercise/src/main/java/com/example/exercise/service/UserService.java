package com.example.exercise.service;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import org.json.JSONException;
import org.json.simple.parser.ParseException;

import com.example.exercise.model.AgeGroup;
import com.example.exercise.model.GroupResult;
import com.example.exercise.model.User;

public class UserService {
	
	private static final String userKey = "STX-COMMUNE";
	
	// Create a loading cache here and load the user in the list if its empty. Use the key userKey	
	// Resource https://github.com/google/guava/wiki/CachesExplained
	//TODO: Implement a guava Loading cache to load the user list from FIle and store it in the cache

	/**
	 * Service to return a list of user 
	 * @return
	 * @throws IOException
	 * @throws ParseException
	 * @throws JSONException
	 * @throws ExecutionException 
	 */
	public static List<User> loadUser() throws IOException, ParseException, JSONException, ExecutionException{
		// TODO: Try to use the Guava Loading cache 
		return new ArrayList<User>();
	}
	
	/**
	 * This method should be called by loading cache to load the user from file
	 * @return
	 * @throws JSONException
	 * @throws IOException
	 * @throws ParseException
	 */
	public static List<User> loadUserIfCacheMiss() throws JSONException, IOException, ParseException{
		return new ArrayList<User>();
	}
	
	/**
	 * Service to return a list of Sorted user 
	 * @return
	 * @throws IOException
	 * @throws ParseException
	 * @throws JSONException
	 */
	public static List<GroupResult> loadSortedUserGroup() throws IOException, ParseException, JSONException{
		
		// TODO: Load the user and group them by last name, count adult and children and then return the list sorted by last name.
		return new ArrayList<>();
	}
	
	/**
	 * Exercise 2: Load list of user and find the one with email supplied
	 * @param email
	 * @return
	 * @throws ParseException 
	 * @throws IOException 
	 * @throws JSONException 
	 */
	public static User getUserByEmail(final String email) throws JSONException, IOException, ParseException {
		// Step1: Load the users
		// TODO: write the code to load the users 
	
		// Step2. Filter the user based on email address, if more than one return the oldest
		// TODO:_ Filter using email 
		return null;
	}
	
	
	// Read the file "user.json" and convert the JSON object into Java object
	private static final List<User> getUserListFromFile() throws IOException, ParseException, JSONException{
		// Step1: Read the user.json file 
		
		// Step2: Convert the user JSON string to java object
		// Hint: You can look at ObjectMapper provided by Jackson library
		
		return new ArrayList<User>();
	}
}
