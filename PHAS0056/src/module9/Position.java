package module9;

public class Position {
	// x,y coordinates on panel 
	private int x;
	private int y;

	Position(int x, int y){
		this.x=x;
		this.y=y;
	}
	// Setter methods 
	void setX(int x){this.x = x;}
	void setY(int y){this.y = y;}
	// getter methods 
	int x(){return this.x;}
	int y(){return this.y;}
}

