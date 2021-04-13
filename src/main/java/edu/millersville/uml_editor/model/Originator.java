package edu.millersville.uml_editor.model;

public class Originator {

	private UMLModel state;

	   public void setState(UMLModel state){
	      this.state = state;
	   }

	   public UMLModel getState(){
	      return state;
	   }

	   public Memento saveStateToMemento(){
	      return new Memento(state);
	   }

	   public void getStateFromMemento(Memento memento){
	      state = memento.getState();
	   }
}
