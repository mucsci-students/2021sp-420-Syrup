package edu.millersville.uml_editor.view;
import java.io.Console;
import java.util.ArrayList;
import java.util.Scanner;

import org.w3c.dom.CDATASection;

public class CLI {
    
    public static void main(String[] args) {
        CLI test = new CLI();
        test.promptUser();
    }

    public void promptUser() {
        Scanner console = new Scanner(System.in);
        System.out.print("umleditor> ");
        String[] inputs = console.nextLine().split(" ");

        switch(inputs[0]) {
            case "add":
                System.out.println("Suck my sack");
                break;
            case "remove":
                // to be implemented
                break;
            case "help":
                // to be implemented
                break;
        }
    }
}
