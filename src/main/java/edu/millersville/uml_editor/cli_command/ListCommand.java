package edu.millersville.uml_editor.cli_command;

import java.util.ArrayList;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import edu.millersville.uml_editor.model.*;
import edu.millersville.uml_editor.view.*;

public class ListCommand extends Command{

	 public ListCommand(UMLModel m, CLIView v, String[] com, boolean p) {
			super(m, v, com, p);
	 }
  
		      public boolean execute() {
		if (commands.length < 2) {
		    view.printError(errorMessage + commandUsage[16] + commandUsage[17] + "\n");
		    return prompt;
		}
		// get list of classes
		if (commands[1].equals("classes")) {
		    if (commands.length != 2) {
			view.printError(errorMessage + commandUsage[16] + "\n");
			return prompt;
		    } else {
			System.out.println();
			System.out.print(model.getClasses());
			System.out.println();
			return prompt;
		    }
		// get list of relationships
		} else if (commands[1].equals("relationships")) {
		    if (commands.length != 2) {
			view.printError(errorMessage + commandUsage[17] + "\n");
			return prompt;
		    } else {
			System.out.println();
			System.out.print(model.getRelationships());
			System.out.println();
			return prompt;
		    }
		
		} else {
		    view.printError(errorMessage + commandUsage[16] + commandUsage[17] + "\n");
		}
		return prompt;
    }


	/**
	 * Prints classes to terminal
	 */
	private void printClasses() {
		Map<String, ClassObject> classMap = model.getClasses();

		for(ClassObject i : classMap.values()) {
			String divider = "-".repeat(getDivLength(i) + 4);
			String centeredClassName = StringUtils.center(i.getName(), getDivLength(i));

			System.out.println(divider);
			System.out.println(addBorder(centeredClassName));
			System.out.println(divider);
			
			if(!i.getFields().isEmpty()) {
				printFields(i, getDivLength(i));
				System.out.println(divider);
			}
			if(!i.getMethods().isEmpty()) {
				printMethods(i, getDivLength(i));
				System.out.println(divider);
			}
		}

	}

	/**
	 * Adds pipes to either side of a given string
	 * @param inputString
	 * 		String to add pipes to
	 * @return
	 * 		Returns string with pipes on either side
	 */
	private String addBorder(String inputString) {
		return "| " + inputString + " |";
	}

	/**
	 * Prints a list of fields for a given class
	 * @param classEntity
	 * 		The class that the fields will be printed for.
	 */
	private void printFields(ClassObject classEntity, int lineWidth) {
		ArrayList<Field> fields = classEntity.getFields();

		for(Field f : fields) {
			String fieldLine = f.getName() + ":" + f.getType(); // Formats field print line
			fieldLine = StringUtils.rightPad(fieldLine, lineWidth);
			fieldLine = addBorder(fieldLine);
			System.out.println(fieldLine);
		}
	}

	/**
	 * Prints methods for a given class
	 * @param classEntity
	 */
	private void printMethods(ClassObject classEntity, int lineWidth) {
		ArrayList<Method> methods = classEntity.getMethods();

		for(Method m : methods) {
			String methodLine = m.getName() + "():" + m.getType(); // Formats method print line
			methodLine = StringUtils.rightPad(methodLine, lineWidth);
			methodLine = addBorder(methodLine);
			System.out.println(methodLine);
		}
	}

	/**
	 * Finds the longest line that will be printed for a given class
	 * @param classEntity
	 * 		The class to check
	 * @return
	 * 		The length of the longest line that will be printed
	 */
	private int getDivLength(ClassObject classEntity) {
		int divLength = classEntity.getName().length(); // Initializes divider length to length of class name

		for(Field f : classEntity.getFields()) {
			int fieldLineLength = f.getName().length() + 1 + f.getType().length(); // Gets length of field print line field

			if(fieldLineLength > divLength) {
				divLength = fieldLineLength;
			}
		}

		for(Method m : classEntity.getMethods()) {
			int methodLineLength = m.getName().length() + 3 + m.getType().length(); // Gets length of method print line [method]():[method type]

			if(methodLineLength > divLength) {
				divLength = methodLineLength;
			}
		}

		return divLength;
	}
}
