import java.util.*;

/**
 * @author Jom Papyrus
 *
 */
public class UML {
	
	private static Map<String, ArrayList<String>> theMap = new HashMap<String, ArrayList<String>>();
	
	
	public static void addClass(String key)
	{
		if ( theMap.containsKey(key) == false )
		{
			ArrayList<String> temp = new ArrayList<String>();
			
			theMap.put(key, temp);
		}
		else
			System.out.println("There's already a class named " + key);
	}
	
	public static void addAttribute(String key, String element) {
		if ( theMap.containsKey(key) )
		{
			ArrayList<String> temp = theMap.get(key);
			temp.add(element);
			theMap.put(key, temp);
		}
		else
			System.out.println("Class " + key + " doesn't exist.");
	}
	
	public static void compute(String text)
	{
		if (text.equals("help"));
		{
			System.out.println();
			System.out.println("- addClass(String className) -> adds a class with name 'className'");
			System.out.println();
			System.out.println("- addAttribute(String className, String attr) -> adds an attribute 'attr' to class 'className'");
			System.out.println();
		}
	}

///////////////////////////////////////////////////////////
	
	public static void main(String[] args) 
	{
		System.out.println("Hello, and welcome to this UML interface.");
		
		Scanner userInput = new Scanner(System.in);
		
		String text = "";
		
		while (true)
		{
			System.out.print("<UML> -> ");
			text = userInput.next();
			if (text.equals("exit"))
			{
				break;
			}
			
			//compute(text);
			addClass("book");
			addAttribute("book", "pages");
			addAttribute("book", "paper");
			addAttribute("book", "page");
			
			System.out.println(theMap.get("book"));
		}
		System.out.print("Have a good one!");
	}

///////////////////////////////////////////////////////////

}
