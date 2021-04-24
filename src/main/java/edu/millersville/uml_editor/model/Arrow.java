package edu.millersville.uml_editor.model;

import java.awt.BasicStroke;
import java.awt.Point;

import javax.swing.JPanel;
import edu.millersville.uml_editor.*;

public class Arrow extends JPanel {
	
    final static float THICKNESS = 2;
    final static float DASH_ARRAY[] = {15};
    
    final static BasicStroke SOLIDLINE = new BasicStroke(THICKNESS);
    final static BasicStroke DASHEDLINE = new BasicStroke(THICKNESS, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 15, DASH_ARRAY, 0);
    
    final static int CAP_MAJOR_LENGTH = 16;
    final static int CAP_MINOR_LENGTH = 8;
    
    Boolean right;
    Boolean left;
	
	private JPanel sourcePanel;
	private JPanel destPanel;
	private String type;
	private Point sourcePoint;
	private Point destPoint;
	
	public Arrow(JPanel source, JPanel dest, String relType) {
		sourcePanel = source;
		destPanel = dest;
		type = relType;
		sourcePoint = new Point();
		destPoint = new Point();
		
		lineLength();
	}
	
	public void lineLength() {
        int x = destPanel.getX() - sourcePanel.getX();
        int y = destPanel.getY() - sourcePanel.getY();
        
        //check to see where line is pointing
        if(Math.abs(x) < Math.abs(y)) {
        	right = false;
        	if(y < 0) {
        		//destination is at the bottom
        		left = true;
        		sourcePoint.y = sourcePanel.getY();
        		destPoint.y = destPanel.getHeight() + destPanel.getY();
        	}
        	else {
        		//destination is at the top
        		left = false;
        		sourcePoint.y =  sourcePanel.getHeight() + sourcePanel.getY();
        		destPoint.y = destPanel.getY();
        	}
        	//sets the x values of the source and destination
        	sourcePoint.x = (sourcePanel.getWidth() / 2) + sourcePanel.getX();
        	destPoint.x = (destPanel.getWidth() / 2) + destPanel.getX();
        }
        //if line is pointing left or right
        else {
        	right = true;
        	if(x < 0) {
        		//destination is to the left
        		left = true;
        		sourcePoint.x = sourcePanel.getX();
        		destPoint.x = destPanel.getWidth() + destPanel.getX();
        	}
        	else {
        		//destination is to the right
        		left = false;
        		sourcePoint.x = sourcePanel.getWidth() + sourcePanel.getX();
        		destPoint.x = destPanel.getX();
        	}
        	//sets the y values of the source and destination
        	sourcePoint.y = (sourcePanel.getHeight() / 2) + sourcePanel.getY();
        	destPoint.y = (destPanel.getHeight() / 2) + destPanel.getY();
        }
	}
	
	
}
