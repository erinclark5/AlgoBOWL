
public class Rectangle {
	protected int topLeft;
    protected int width;
    protected int height;
 
    public Rectangle(int height, int width) {
    	this.width = width;
    	this.height = height;
    }
    
    public void setHeight(int height) {
       this.height = height;
    }
 
    public int getHeight() {
        return this.height;
    }
 
    public void setWidth(int width) {
        this.width = width;
    }
 
    public int getWidth() {
        return this.width;
    }

}
