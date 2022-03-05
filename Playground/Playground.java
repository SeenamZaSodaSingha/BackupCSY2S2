// Java code to illustrate the keySet() method
import java.util.*;

public class Playground {
	public static void main(String[] args)
	{
        List<Integer> list = new ArrayList<Integer>();
		// Creating an empty HashMap
		HashMap<Integer, String> hash_map = new HashMap<Integer, String>();

		// Mapping string values to int keys
		hash_map.put(10, "Geeks");
		hash_map.put(15, "4");
		hash_map.put(20, "Geeks");
		hash_map.put(25, "Welcomes");
		hash_map.put(30, "You");

		// Displaying the HashMap
		System.out.println("Initial Mappings are: " + hash_map);

		// Using keySet() to get the set view of keys
        // arr = hash_map.keySet();
        list.addAll(hash_map.keySet());
		// System.out.println("The set is: " + hash_map.keySet());
        System.out.println("The set is: " + list);
        System.out.println(list.get(2));
	}
}
