import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UMLGUI {

        public static void main(String[] args) {
            //creates the first line of text and changes the font
            JLabel welcome = new JLabel("Welcome to our UML Editor!", SwingConstants.CENTER);
            welcome.setFont(new Font("Serif", Font.BOLD, 20));

            //creates the second line of text and changes the font
            JLabel select = new JLabel("Select an Option!", SwingConstants.CENTER);
            select.setFont(new Font("Serif", Font.BOLD,16));

            welcome.setVerticalAlignment(SwingConstants.BOTTOM);
            select.setVerticalAlignment(SwingConstants.BOTTOM);
            ///////////////
            // MENU
            ///////////////
            JMenuBar umlMenu = new JMenuBar();

            //create all the buttons of main menu
            JButton classButton = new JButton("Class");
            JButton attrButton = new JButton("Attribute");
            JButton relButton = new JButton("Relationship");
            JButton loadButton = new JButton("Load");
            JButton saveButton = new JButton("Save");
            JButton printButton = new JButton("Print");
            JButton helpButton = new JButton("Help");



            JFrame mm = new JFrame("UML Editor");
            mm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel menuPanel = new JPanel(new GridLayout(10, 1, 8, 8));

            //adds everything to the panel
            menuPanel.add(welcome);
            menuPanel.add(select);
            menuPanel.add(classButton);
            menuPanel.add(attrButton);
            menuPanel.add(relButton);
            menuPanel.add(loadButton);
            menuPanel.add(saveButton);
            menuPanel.add(printButton);
            menuPanel.add(helpButton);

            menuPanel.setBorder(BorderFactory.createEmptyBorder(20, 8, 20, 8));
            
            mm.add(umlMenu);
            mm.setContentPane(menuPanel);
            mm.setSize(400, 600);
            mm.setVisible(true);
            umlMenu.setVisible(true);
        }
    }