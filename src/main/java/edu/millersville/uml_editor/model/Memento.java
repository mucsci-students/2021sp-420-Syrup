package edu.millersville.uml_editor.model;

public class Memento {

    private UMLModel m;

    public Memento() {
    }

    public Memento(UMLModel m) {
    	set(m);
    }

    public void set(UMLModel m) {
    	this.m = m;
    }

    public UMLModel getModel() {
    	return this.m;
    }
}
