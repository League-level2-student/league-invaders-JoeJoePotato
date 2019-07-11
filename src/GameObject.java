import java.awt.Rectangle;

public class GameObject {
int x;
int y;
int width;
int height;
Rectangle collisionbox;
GameObject(int x, int y, int width, int height){
	this.x=x;
	this.y=y;
	this.height=height;
	this.width=width;
	collisionbox=new Rectangle( x,y,width,height);
}
 void Cupdate(){
	
}
}
