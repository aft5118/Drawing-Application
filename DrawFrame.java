package DrawingApplication;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.JColorChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class DrawFrame extends JFrame
{
  
    private DrawPanel panel; 
    
    private JButton undo; 
    private JButton clear;
    
    
    private JButton colorOne;
    private JButton colorTwo;
    
   
    
    
    private JComboBox shapes; 
    
   
    private String shapeOptions[]= {"Line","Rectangle","Oval"};
    
    private JCheckBox filled; 
    private JCheckBox gradient;
    private JCheckBox dashed;
    
    private final JTextField widthLength;
    private final JTextField dashLength;
    private final JLabel widthLabel;
    private final JLabel dashLabel;
        
    
    
    private Color color;
    private JPanel shapePanel;
    private JPanel colorPanel;
    private JPanel thirdPanel;
    
   
    
  
    public DrawFrame()
    {
        super("Drawing Aplication"); 
        
        JLabel statusLabel = new JLabel( "" ); 
        
        panel = new DrawPanel(statusLabel); 
        
        shapePanel = new JPanel();
        colorPanel = new JPanel();
        thirdPanel = new JPanel();
        
        thirdPanel.setLayout(new BorderLayout());
        shapePanel.setLayout(new FlowLayout());
        colorPanel.setLayout(new FlowLayout());
        
        
        
        undo = new JButton( "Undo" );
        clear = new JButton( "Clear" );
        
        colorOne = new JButton("First Color");
        colorTwo = new JButton("Second Color");
        
        
       
        shapes = new JComboBox( shapeOptions );
        
        widthLength = new JTextField(5);
        dashLength = new JTextField(5);
      
        
       widthLabel = new JLabel("Width Length: ");
       dashLabel = new JLabel("Dash Length: ");
        
        
        //create checkbox
        filled = new JCheckBox( "Filled" );
        gradient = new JCheckBox( "Gradient ");
        dashed = new JCheckBox( "Dashed ");
        
      
        
    
      shapePanel.add(undo);
      shapePanel.add(clear);
      shapePanel.add(shapes);
      shapePanel.add(filled);
      colorPanel.add(gradient);
      colorPanel.add(colorOne);
      colorPanel.add(colorTwo);
      colorPanel.add(widthLabel);
      colorPanel.add(widthLength);
      colorPanel.add(dashLabel);
      colorPanel.add(dashLength);
      colorPanel.add(dashed);
       
       thirdPanel.add(shapePanel, BorderLayout.NORTH);
       thirdPanel.add(colorPanel, BorderLayout.SOUTH);
       add(thirdPanel, BorderLayout.NORTH);
        
       
        add( panel, BorderLayout.CENTER);
        
       
        ButtonHandler buttonHandler = new ButtonHandler();
        undo.addActionListener( buttonHandler );
        clear.addActionListener( buttonHandler );
        colorOne.addActionListener( buttonHandler);
        colorTwo.addActionListener( buttonHandler );
        dashLength.addActionListener( buttonHandler );
        widthLength.addActionListener( buttonHandler );
        widthLength.addActionListener( buttonHandler);
        dashLength.addActionListener( buttonHandler);
        
        
        ItemListenerHandler handler = new ItemListenerHandler();
       
        shapes.addItemListener( handler );
        filled.addItemListener( handler );
        gradient.addItemListener( handler );
        dashed.addItemListener( handler );
        
        
       
        
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setSize( 500, 500 );
        setVisible( true );
        
    } 
    
    private class ButtonHandler implements ActionListener
    {
        
        public void actionPerformed( ActionEvent event )
        {
            if (event.getActionCommand().equals("Undo")){
                panel.undo();
            }
            else if (event.getActionCommand().equals("Clear")){
                panel.clearDrawing();
            }
            else if (event.getActionCommand().equals("First Color")) {
                color = JColorChooser.showDialog(DrawFrame.this, "Choose a color", color);
                panel.setFirstColor(color);
            }
            else if(event.getActionCommand().equals("Second Color")) {
                color = JColorChooser.showDialog(DrawFrame.this, "Choose a color", color);
                panel.setSecondColor(color);
            }
            else if (event.getSource() == widthLength) {
            String widthString = "";
            int widthInt = 0;
                try {
                widthString = event.getActionCommand();
                widthInt = Integer.parseInt(widthString);
                if (widthInt <= 0) {
                    JOptionPane.showMessageDialog(null, "The width is out of bounds.", "Draw Error", JOptionPane.ERROR_MESSAGE);
                }
                else {
                    panel.setWidth(widthInt);
                }
                }
                catch (Exception e) {
                  JOptionPane.showMessageDialog(null, "Invalid input.", "Draw Error", JOptionPane.ERROR_MESSAGE);
                }
                
        }
        else if (event.getSource() == dashLength) {
            String dashString = "";
            int dashInt = 0;
                try {
                dashString = event.getActionCommand();
                dashInt = Integer.parseInt(dashString);
                if (dashInt <= 0) {
                    JOptionPane.showMessageDialog(null, "The dash length is out of bounds.", "Draw Error", JOptionPane.ERROR_MESSAGE);
                }
                else {
                    panel.setDash(dashInt); 
                }
                }
                catch (Exception e) {
                  JOptionPane.showMessageDialog(null, "Invalid input.", "Draw Error", JOptionPane.ERROR_MESSAGE);
                }
        }  
             
      } 
    }
    
    
    private class ItemListenerHandler implements ItemListener
    {
        public void itemStateChanged( ItemEvent event )
        {
           
            
            if (event.getSource() == filled) {
                if(filled.isSelected()) {
                        panel.setCurrentShapeFilled(true);
                }
                else {
                        panel.setCurrentShapeFilled(false);
                    }
            }
            else if (event.getSource() == gradient) {
                if(gradient.isSelected()) {
                    panel.setGradient(true);    
                }
                else {
                    panel.setGradient(false);
                }
            }
            else if (event.getSource() == dashed) {
                if(dashed.isSelected()) {
                    panel.setDashed(true);
                }
                else {
                    panel.setDashed(false);
                }
            }
           
            if ( event.getStateChange() == ItemEvent.SELECTED ) {

                if ( event.getSource() == shapes) {
                    panel.setCurrentShape(shapes.getSelectedIndex());
                }
            }
            
        } 
    }
    
} 
