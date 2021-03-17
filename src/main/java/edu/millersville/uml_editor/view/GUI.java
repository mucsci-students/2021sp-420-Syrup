package edu.millersville.uml_editor.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import edu.millersville.uml_editor.model.*;
import edu.millersville.uml_editor.controller.*;
import java.io.IOException;



public class GUI {
    private JFrame umlEditor = null;
    private JPanel menuPanel = null;

    private boolean isMethod = false;

    private UMLController controller;
    private UMLModel model;

    public GUI(UMLModel m) {
        this.model = m;
        this.controller = null;
    }

    public void changePanel(JPanel newPanel) {
        umlEditor.setContentPane(newPanel);
        umlEditor.validate();
        umlEditor.repaint();
    }

    public void panelCheck(JPanel checkPanel){
        /*Checks to see if the panel is already created
        * If the panel is created go to that panel
        * If not then proceed and create the panel
        */
       if (checkPanel != null) {
           changePanel(checkPanel);
           return;
       }
   }
    public void menuPanel(){

    }

}
