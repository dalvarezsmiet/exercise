package com.example.exercise.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.json.JSONException;
import org.json.simple.parser.ParseException;

import com.example.exercise.model.GroupResult;
import com.example.exercise.model.User;

public class UserService {

	// Implement a Guava Loading cache to load the user list from FIle and store it
	// in the cache

	/**
	 * Exercise 1: Return a list of user
	 * 
	 * @return
	 * @throws IOException
	 * @throws ParseException
	 * @throws JSONException
	 * @throws ExecutionException
	 */
	public static List<User> loadUser() throws IOException, ParseException, JSONException, ExecutionException {
		// Try to use the Guava Loading cache
		return new ArrayList<User>();
	}

	/**
	 * This method should be called by loading cache to load the user from file
	 * 
	 * @return
	 * @throws JSONException
	 * @throws IOException
	 * @throws ParseException
	 */
	public static List<User> loadUserIfCacheMiss() throws JSONException, IOException, ParseException {
		// Step1: Read the user.json file

		// Step2: Convert the user JSON string to java object

		return new ArrayList<User>();
	}

	/**
	 * Exercise 2: Group user by last name and count adult and children
	 * 
	 * @return
	 * @throws IOException
	 * @throws ParseException
	 * @throws JSONException
	 */
	public static List<GroupResult> loadSortedUserGroup() throws IOException, ParseException, JSONException {
		// Step1: Load the user and group them by last name, count adult and children
		// and then return the list sorted by last name.
		return new ArrayList<>();
	}

	/**
	 * Exercise 3: Load list of user and find the one with email supplied
	 * 
	 * @param email
	 * @return
	 * @throws ParseException
	 * @throws IOException
	 * @throws JSONException
	 */
	public static User getUserByEmail(final String email) throws JSONException, IOException, ParseException {
		// Step1: Load the users

		// Step2. Filter the user based on email address, if more than one return the
		// oldest
		return null;
	}
}
