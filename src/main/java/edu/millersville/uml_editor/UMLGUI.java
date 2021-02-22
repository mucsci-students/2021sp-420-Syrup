import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UMLGUI {

        public static void main(String[] args) {
            ///////////////
            // Heading/Labels
            ///////////////
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
            JMenuBar menuBar = new JMenuBar();
            JMenu menu = new JMenu("File");
            JMenuItem save = new JMenuItem ("Save");
            JMenuItem load = new JMenuItem ("Load");
            menu.add(save);
            menu.add(load);
            menuBar.add(menu);

            ///////////////
            // Buttons
            ///////////////
            JButton classButton = new JButton("Class");
            JButton attrButton = new JButton("Attribute");
            JButton relButton = new JButton("Relationship");
            JButton printButton = new JButton("Print");
            JButton helpButton = new JButton("Help");

            ///////////////
            // Panel
            ///////////////
            JPanel menuPanel = new JPanel(new GridLayout(8, 1, 8, 8));
            //adds everything to the panel
            menuPanel.add(welcome);
            menuPanel.add(select);
            menuPanel.add(classButton);
            menuPanel.add(attrButton);
            menuPanel.add(relButton);
            menuPanel.add(printButton);
            menuPanel.add(helpButton);
            menuPanel.setBorder(BorderFactory.createEmptyBorder(10, 8, 10, 8));

            ///////////////
            // Frame
            ///////////////
            JFrame mm = new JFrame("UML Editor");
            mm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mm.setJMenuBar(menuBar);
            mm.setContentPane(menuPanel);
            mm.setSize(400, 600);
            mm.setVisible(true);

        }
    }


