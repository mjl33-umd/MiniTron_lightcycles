
import java.awt.Graphics;
import java.awt.Rectangle;


public class Trail implements drawable{

	private int tx, ty;
	private int twid = 13, thgt = 13;
	
	public Trail(int x, int y)
	{
		tx = x + 7;
		ty = y + 7;
	}

	@Override
	public void draw(Graphics g) {
		g.fillRect(tx,ty,twid,thgt);
	}
	
	public void setTHeight(int h){
		if(h < 0){//remember h is negative
			thgt += Math.abs(h);
			ty += h;
		}
		else{
		thgt += h;
		}
	}
	
	public void setTWidth(int w){
		if(w < 0){//remember w is negative
			twid += Math.abs(w);
			tx += w;
		}
		else{
		twid += w;
		}

	}
	
	public Rectangle getRec(){
		Rectangle ret = new Rectangle(tx,ty,twid,thgt);
		return ret;
	}
	

}
