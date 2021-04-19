package edu.millersville.uml_editor.view;

import java.io.IOException;

public class CLIView implements ViewInterface{

	
    public CLIView() {
    }

    public void printIntro() throws IOException {
    	System.out.println("Welcome to Syrup's UML Editor!");
    	System.out.println("Type 'help' to see list of commands.\n");
	}
    	   
    public void printInvalidCommand() {
    	System.out.println("\nInvalid command.\nType help to see a list of all commands.\n");
    }

    public void printError(String e) {
    	System.out.println("\nERROR: " + e);
    }
}
