
public class Square extends Rectangle {

	public Square(int height, int width) {
		super(height, width);
	}

	public void setHeight(int value) {
        this.width = value;
        this.height = value;
    }
 
    public void setWidth(int value) {
    	this.width = value;
     	this.height = value;
    }

	
}
