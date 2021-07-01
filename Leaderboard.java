package Project;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Leaderboard {
	// hashmap which stores names as keys and points as values
	static HashMap<String, Integer> leaderboardList = new HashMap<String, Integer>();

	// show method which calls the reads from file and sorts the leaderboard list
	// methods
	public void show() {
		System.out.println("==============LeaderBoard ==============");
		System.out.println("Name: \t\t Points:");
		readFromFile();
		sortList(false);
		System.out.println("========================================");
	}

	// sort list method which takes in whether u want it false for descending or
	// true for ascending
	public void sortList(boolean order) {
		// change hashmap to a List
		List<Entry<String, Integer>> list = new LinkedList<Entry<String, Integer>>(leaderboardList.entrySet());
		// call the collections.sort method to compare entries in the list
		Collections.sort(list, new Comparator<Entry<String, Integer>>() {
			public int compare(Entry<String, Integer> num1, Entry<String, Integer> num2) {
				// compare each number in the list
				return num2.getValue().compareTo(num1.getValue());
			}
		});
		// creates a new map thats sorted
		Map<String, Integer> sortedHashMap = new LinkedHashMap<String, Integer>();
		for (Entry<String, Integer> entry : list) {
			sortedHashMap.put(entry.getKey(), entry.getValue());
		}
		// once sorted print the map by calling the print map
		printMap(sortedHashMap);
	}

	// method for printing the keys and values intake a map
	public void printMap(Map<String, Integer> sortedMap) {
		// iterate through the entries in the map
		for (Entry<String, Integer> entry : sortedMap.entrySet()) {
			// calculate the length of each key to format where the points are placed
			int spacesFull = 20;
			String name = entry.getKey();
			int lengthName = name.length();
			// the amount of spaces will be the set full spaces - the length of their name
			int spaces = (spacesFull - lengthName);
			// increment the spacePadding dependant on the users name
			String spacePadding = "";
			for (int i = 0; i <= spaces; i++) {
				spacePadding += " ";
			}
			// print the key , the space and the value
			System.out.println(entry.getKey() + spacePadding + entry.getValue());
		}

	}
	//method to appent players to the file, takes in a file name and player details
	public static void addPlayersToFile(String fileName, String playerdetails) {
		//try catch to catch any IO exceptions
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(fileName, true));
			out.write(playerdetails);
			out.close();
		} catch (IOException e) {
			System.out.println("OOps an error occured." + e);
		}
	}
	//method to read details from file
	public static void readFromFile() {
		//try catch to catch any file not found errors
		try {
			File file = new File("leaderboard_101.txt");
			Scanner myReader = new Scanner(file);
			//read the data into a string until no lines left
			String data = "";
			while (myReader.hasNextLine()) {
				data += myReader.nextLine();

			}
			//split the string by the specific seperator set, which seperates players
			String[] words = data.split("[|]");
			for (int i = 0; i < words.length; i++) {
				//for each string in the array increment the hashmap using the first index as the key the name, and the second split as value the points
				String[] splitted = words[i].split("-");
				for (int j = 0; j < splitted.length; j += 2) {
					leaderboardList.put(splitted[j], Integer.parseInt(splitted[j + 1]));
				}
			}
			//close the reader and catch any exceptions
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");

		}
	}
	//method to write to file.. it calles the addPlayerstoFile method and throws IO excpetions
	public void writeToFile(String playerDetails) throws IOException {
		String filename = "leaderboard_101.txt";
		addPlayersToFile(filename, playerDetails);
	}

}
