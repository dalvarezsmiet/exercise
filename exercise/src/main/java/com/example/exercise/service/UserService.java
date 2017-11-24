package com.example.exercise.service;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import org.json.JSONException;
import org.json.simple.parser.ParseException;

import org.apache.commons.io.FileUtils;

import com.example.exercise.model.GroupResult;
import com.example.exercise.model.User;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

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
	
	private static LoadingCache<Integer,List<User>> userCache;

	static {
		userCache = CacheBuilder.newBuilder()
			       .maximumSize(1000)
			       .expireAfterWrite(1, TimeUnit.HOURS)
			       .build(
			    		   new CacheLoader<Integer, List<User>>() {
							@Override
							public List<User> load(Integer id) throws Exception {
								return loadUserIfCacheMiss();
							}
			           }
			       ); 
	}
	
	public static List<User> loadUser() throws IOException, ParseException, JSONException, ExecutionException {
		// Try to use the Guava Loading cache
		return getUserListUsingGuava();
	}
	
	
    public static LoadingCache<Integer, List<User>> getLoadingCache() {
    	return userCache;
    }
	
    private static List<User> getUserListUsingGuava() throws ExecutionException {
    	LoadingCache<Integer, List<User>> userCache = getLoadingCache();
    	System.out.println(userCache.stats());
    	System.out.println("Cache Size:" + userCache.size());
    	return userCache.get(0);
      }
    
	/**
	 * This method should be called by loading cache to load the user from file
	 * 
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public static List<User> loadUserIfCacheMiss() throws JsonParseException, JsonMappingException, IOException {
        List<User> userList = new ArrayList<User>();
		String json="";
        //Create a new ObjectMapper, for mapping data
        ObjectMapper mapper = new ObjectMapper();

        try
        {
            // Step1: Read the user.json file
	    //TODO: This is hard-coded and totally ugly. Has to be changed to a relative path that works!
            json = FileUtils.readFileToString(new File("C:\\Users\\damian\\develop\\exercise\\exercise\\user.json"));
            // Step2: Convert the user JSON string to java object     
            User[] userDetails = mapper.readValue(json, User[].class);
            
            //Print the user details
            for (User user : userDetails) {
            	System.out.println(user);
            	userList.add(user);
			}
        } catch (JsonParseException e)
        {
            e.printStackTrace();
        } catch (JsonMappingException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }

		return userList;
	}

	/**
	 * Exercise 2: Group user by last name and count adult and children
	 * 
	 * @return
	 * @throws IOException
	 * @throws ParseException
	 * @throws JSONException
	 * @throws ExecutionException 
	 */
	public static List<GroupResult> loadSortedUserGroup() throws IOException, ParseException, JSONException, ExecutionException {
		// Step1: Load the user and group them by last name, count adult and children
		// and then return the list sorted by last name.
		System.out.println("--Executing loadSortedUserGroup--");
		GroupResult groupResult = new GroupResult(); 
		
		List<User> users = getUserListUsingGuava();
		
		TreeMap<String, GroupResult> map = new TreeMap<String, GroupResult>();
		
		for (User user : users) {
			Boolean adult = getAge(user.getDateOfBirth()) > 18;
			
			
			GroupResult group = map.get(user.getLastname());
			if(group != null) {
				if(adult) {
					group.setAdult(group.getAdult() + 1);
				}
				else {
					group.setChildren(group.getChildren() + 1);
				}
				
			}
			else {
				if (adult){
					group = new GroupResult(user.getLastname(), 1, 0);
				} else{
					group = new GroupResult(user.getLastname(), 0, 1);
				}
				
				map.put(user.getLastname(), group);
			}
		}
		
		
		List<GroupResult> groupResults = new ArrayList<>(map.values());
		
		return groupResults;
	}
	
	@SuppressWarnings("deprecation")
	public static int getAge(Date birthDate) {
	    long ageInMillis = new Date().getTime() - birthDate.getTime();

	    Date age = new Date(ageInMillis);

	    return age.getYear();
	}

	/**
	 * Exercise 3: Load list of user and find the one with email supplied
	 * 
	 * @param email
	 * @return
	 * @throws ParseException
	 * @throws IOException
	 * @throws JSONException
	 * @throws ExecutionException 
	 */
	public static User getUserByEmail(final String email) throws JSONException, IOException, ParseException, ExecutionException {
		// Step1: Load the users
		System.out.println("--Executing getUserByEmail--");
		List<User> users = getUserListUsingGuava();
		
		// Step2. Filter the user based on email address, if more than one return the
		// oldest
		
		User matchUser = null;
		for(User user : users) {
			if(user.getEmail().equals(email)) {
				if (matchUser == null) {
					matchUser = user;
				}
				else if(user.getDateOfBirth().compareTo(matchUser.getDateOfBirth()) < 0 ) {
					matchUser = user;
				}
			}
		}
		
		return matchUser;
	}
}
