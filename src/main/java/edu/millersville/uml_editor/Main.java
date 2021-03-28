package edu.millersville.uml_editor;

import edu.millersville.uml_editor.model.UMLModel;
import edu.millersville.uml_editor.view.CLIView;
import edu.millersville.uml_editor.view.GUIView;
import edu.millersville.uml_editor.view.View;

public class Main {
    
    public static void main(String[] args) {
        UMLModel model = new UMLModel();

        if(args.length == 1 && args[0].equals("--cli")) {
            CLIView view = new CLIView();
        }
        else if(args.length == 0) {
            GUIView view = new GUIView(model);
        }
        else {
            System.out.println("Invalid argument");
        }
    }
}
