package DrawingApplication;
import java.util.Arrays;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;



public class DrawPanel extends JPanel
{
    
    private ArrayList<MyShape> myShapes;
    private int currentShapeType; 
    private MyShape currentShapeObject; 
    private Color firstColor; 
    private boolean filled; 
    private boolean gradient;
    private boolean dashed;
    private int width;
    private int dash;
    private Color color2;
    private int shapeCounter;
    
    JLabel statusLabel; 
    
   
    public DrawPanel(JLabel statusLabel){
        
        myShapes = new ArrayList<MyShape>();
        currentShapeType = 0;
        currentShapeObject = null;
        firstColor = Color.BLACK;
        color2 = Color.BLACK;
        filled = false;
        gradient = false;
        dashed = false;
        width = 1;
        dash = 10;
        
        this.statusLabel = statusLabel; 
        
        setLayout(new BorderLayout()); 
        setBackground( Color.WHITE ); 
        add( statusLabel, BorderLayout.SOUTH );  
        
       
        MouseHandler handler = new MouseHandler();                                    
        addMouseListener( handler );
        addMouseMotionListener( handler ); 
    }
    
    
    public void paintComponent( Graphics g ) {
        super.paintComponent( g );
        
        for ( int counter = 0; counter<= myShapes.size()-1; counter++) {
           myShapes.get(counter).draw(g);
        }
       
    }
    
    
    public void setCurrentShape(int shape) {
        currentShapeType = shape;
    }
    
    
    public void setFirstColor(Color color) {
        firstColor=color;
    }
    
    public void setCurrentShapeFilled(boolean filled) {
        this.filled=filled;
    }
    
    public void setGradient(boolean gradient) {
        this.gradient = gradient;
    }

    public void setDashed(boolean dashed) {
        this.dashed = dashed;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setDash(int dash) {
        this.dash = dash;
    }
     
    public void setSecondColor(Color color2) {
        this.color2 = color2;
    }
    
    
    public void undo() {
        if (! myShapes.isEmpty()) {
            if (shapeCounter > 0) {
            int shapeIndex = shapeCounter-1;
            myShapes.remove(shapeIndex);
            shapeCounter--;
            repaint();
            }
        }
    }
    
    
    public void clearDrawing() {
        myShapes.clear();
        shapeCounter = 0;
        repaint();
    }
    
    
    private class MouseHandler extends MouseAdapter {
        
        public void mousePressed( MouseEvent event ) {
           
            switch (currentShapeType) {
                case 0:
                    
                    currentShapeObject = new MyLine (event.getX(), event.getY(), 
                                                   event.getX(), event.getY(), firstColor, color2,  filled, dashed, gradient, width, dash);
                    break;
                case 1:
                    
                    currentShapeObject = new MyRectangle(event.getX(), event.getY(), 
                                                   event.getX(), event.getY(), firstColor, color2, filled, dashed, gradient, width, dash);
                    break;
                case 2:
                   
                    currentShapeObject = new MyOval(event.getX(), event.getY(), 
                                                   event.getX(), event.getY(), firstColor, color2, filled, dashed, gradient, width, dash);
                    break;
                    
            }
            myShapes.add(currentShapeObject); 
            shapeCounter++;
            
        } 
        
        public void mouseReleased( MouseEvent event ) {
           
            currentShapeObject.setX2(event.getX());
            currentShapeObject.setY2(event.getY());
            currentShapeObject = null; 
            
            repaint();
            
        } 
        
        
        public void mouseMoved( MouseEvent event ) {
            statusLabel.setText(String.format("X: %d Y: %d",event.getX(),event.getY()));
        } 
        
        
        public void mouseDragged( MouseEvent event ) {
            
            currentShapeObject.setX2(event.getX());
            currentShapeObject.setY2(event.getY());
            
            
            statusLabel.setText(String.format("X: %d Y: %d",event.getX(),event.getY()));
            
            repaint();
            
        } 
        
    }
    
} 
