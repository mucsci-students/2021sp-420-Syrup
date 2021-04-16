package edu.millersville.uml_editor.model;

/**
 * A class that contains the state of an object to be restored.
 * 
 * @author TeamSyrup
 *
 */
public class Memento {

    private UMLModel m;

    /**
     * Initializes an empty memento.
     */
    public Memento() {
    }

    /**
     * Initializes a memento object with a UML model.
     * @param m the model
     */
    public Memento(UMLModel m) {
    	set(m);
    }

    /**
     * A mutator method that changes the old model to the new model.
     * @param m the new model.
     */
    public void set(UMLModel m) {
    	this.m = m;
    }

    /**
     * A getter method that returns the current model (current state).
     * @return the model
     */
    public UMLModel getModel() {
    	return this.m;
    }
  
}
