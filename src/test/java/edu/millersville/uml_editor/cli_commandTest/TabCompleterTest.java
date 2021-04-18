package edu.millersville.uml_editor.cli_commandTest;

import org.junit.Test;

import edu.millersville.uml_editor.cli_command.TabCompleter;
import edu.millersville.uml_editor.model.UMLModel;

public class TabCompleterTest {

    @Test
    public void updateTest() {
		UMLModel model = new UMLModel();
		TabCompleter tab = new TabCompleter();
		
		model.createNewClassGUI("class1");
		model.createNewClassGUI("class2");
		model.addField("class1", "field1", "int");
		model.addMethod("class1", "method1", "int");
		model.addParameter("class1", "method1", "param1", "int");
		model.createRelationshipGUI("class1", "class2", "ID1", "Aggregation");
		tab.updateCompleter(model);
    }
}
