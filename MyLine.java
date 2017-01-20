package DrawingApplication;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;


public class MyLine extends MyShape
{  
   
    public MyLine()
    {
        super();
    }
    
   
    public MyLine( int x1, int y1, int x2, int y2, Color color, Color color2, boolean filled, boolean dashed, 
            boolean gradient, int widthLeng, int dashLeng)
    {
        super(x1, y1, x2, y2, color, color2, filled, dashed, gradient, widthLeng, dashLeng);
    } 
     
   
    @Override
    public void draw( Graphics g )
    {
        Graphics2D g2D = (Graphics2D) g;
        g2D.setColor( getColor() ); //sets the color
       
        g2D.setStroke(new BasicStroke(getWidthLeng(), BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        if (isGradient()) {
            g2D.setPaint(new GradientPaint(getX1(), getY1(), getColor(), getX2(), getY2(), getColor2(), true));
        }
        if (isDashed()) {
            float[] dashes = new float [1];
            dashes[0] = getDashLeng();
            g2D.setStroke(new BasicStroke(getWidthLeng(), BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 10, dashes, 0));
        }
       g2D.drawLine(getX1(), getY1(), getX2(), getY2());
 
        
    } 
} 
