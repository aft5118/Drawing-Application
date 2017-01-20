package DrawingApplication;
import java.awt.Color;
import java.awt.Graphics;


abstract class MyShape
{
    private int x1,y1,x2,y2; //coordinates of shape
    private Color color; // color of shape
    private Color color2;

  
    private boolean filled;
    private boolean gradient;
    private boolean dashed;
    private int widthLeng;
    private int dashLeng;
    
    
    public MyShape() {
        x1 = 0;
        y1 = 0;
        x2 = 0;
        y2 = 0;
        color = Color.BLACK;
    }
    
    
    public MyShape(int x1, int y1, int x2, int y2, Color color, Color color2, boolean filled, boolean dashed, 
            boolean gradient, int widthLeng, int dashLeng)
    {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.color = color;
        this.filled = filled;
        this.gradient = gradient;
        this.dashed = dashed;
        this.color2 = color2;
        this.widthLeng = widthLeng;
        this.dashLeng = dashLeng;
    }
    
    
    public void setX1(int x1) {
        this.x1=x1;
    }   
    
    
    public void setY1(int y1) {
        this.y1=y1;
    }   
    
    
    public void setX2(int x2) {
        this.x2=x2;
    }   
    
    
    public void setY2(int y2) {
        this.y2=y2;
    }   
    
    
    public void setColor(Color color) {
        this.color=color;
    }
    
    public int getX1() {
        return x1;
    }
    
    
    public int getY1() {
        return y1;
    }
    
    
    public int getX2() {
        return x2;
    }
    
    
    public int getY2() {
        return y2;
    }
    
    
    public Color getColor() {
        return color;
    }
    
      public Color getColor2() {
        return color2;
    }

    public void setColor2(Color color2) {
        this.color2 = color2;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public boolean isGradient() {
        return gradient;
    }

    public void setGradient(boolean gradient) {
        this.gradient = gradient;
    }

    public boolean isDashed() {
        return dashed;
    }

    public void setDashed(boolean dashed) {
        this.dashed = dashed;
    }

    public int getWidthLeng() {
        return widthLeng;
    }

    public void setWidthLeng(int widthLeng) {
        this.widthLeng = widthLeng;
    }

    public int getDashLeng() {
        return dashLeng;
    }

    public void setDashLeng(int dashLeng) {
        this.dashLeng = dashLeng;
    }
    
    abstract public void draw( Graphics g );

}
