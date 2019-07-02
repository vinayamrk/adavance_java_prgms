

import javax.swing.*;


/**
 * The MetricConverter class lets the user enter a distance in kilometers. Radio
 * buttons can be selected to convert the kilometers to miles, feet, or inches.
 */


public class TabbedPane extends JFrame {

   private final int WINDOW_WIDTH = 400;  // Window width
    private final int WINDOW_HEIGHT = 200; // Window height

    private JTabbedPane jtp;

    /**
     * Constructor
     */
    public TabbedPane() {
        // Set the title.
        setTitle("TabbedPanes");

        // Set the size of the window.
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        // Specify an action for the close button.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Build the panel and add it to the frame.
        buildPanel();

        // Add the panel to the frame's content pane.
        // add(panel);
        add(jtp);

        // Display the window.
        setVisible(true);
    }

    /**
     * The buildPanel method adds a label, text field, and and three buttons to
     * a panel.
     */
    private void buildPanel() {
        // Create the label, text field, and radio buttons.
        
        // Create a panel and add the components to it.
        
        jtp = new JTabbedPane();

        jtp.addTab("Cities", new CitiesPanel());
        jtp.addTab("Colors", new ColorsPanel());
        jtp.addTab("Flavors", new FlavorsPanel());

    }

    
    public static void main(String[] args) {
        new TabbedPane();
    }
}

class CitiesPanel extends JPanel {

    public CitiesPanel() {
        JButton b1 = new JButton("New York");
        add(b1);
        JButton b2 = new JButton("London");
        add(b2);
        JButton b3 = new JButton("Hong Kong");

        add(b3);
        JButton b4 = new JButton("Tokyo");
        add(b4);
    }
}

class ColorsPanel extends JPanel {

    public ColorsPanel() {
        JCheckBox cb1 = new JCheckBox("Red");
        add(cb1);
        JCheckBox cb2 = new JCheckBox("Green");
        add(cb2);
        JCheckBox cb3 = new JCheckBox("Blue");
        add(cb3);
        
        
    }
}

class FlavorsPanel extends JPanel {

    public FlavorsPanel() {
        JComboBox jcb = new JComboBox();
        jcb.addItem("Vanilla");
        jcb.addItem("Chocolate");
        jcb.addItem("Strawberry");
        add(jcb);
    }
}
