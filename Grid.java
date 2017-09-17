import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


public class Grid implements drawable{

	private final Color GridBlue = new Color(25,0,75);
	private final Color WallColor = new Color(119,149,154);

	private final static int wallWidth = 25;

	@Override
	public void draw(Graphics g) 
	{
		///////Make sure to set Background as Black in the Tron class/////

		//////This is the base of Grid, line gaps and wall sizes might change when it comes to the relativity of the size of the cycles

		//////BASE STATS FOR EACH WALL SIZE/////////
		g.setColor(WallColor);
		g.fillRect(0 + Tron.getExtraLeft(),0 + Tron.getExtraTop(),Tron.getFrameWidth()-(Tron.getExtraLeft()*2),wallWidth);
		g.fillRect(0 + Tron.getExtraLeft(),0 + Tron.getExtraTop(),wallWidth,Tron.getFrameHeight()-Tron.getExtraTop()-Tron.getExtraLeft());//Could be coincidence that 35 was needed
		g.fillRect(0 + Tron.getExtraLeft(),0 + Tron.getFrameHeight() - wallWidth - Tron.getExtraLeft(),Tron.getFrameWidth()-(Tron.getExtraLeft()*2),wallWidth);//Could be coincidence that 53 was needed
		g.fillRect(0 + Tron.getFrameWidth()- wallWidth - Tron.getExtraLeft(),0 + Tron.getExtraTop(),wallWidth,Tron.getFrameHeight()-Tron.getExtraTop()-Tron.getExtraLeft());

		//////GRID LINES/////////////////////
		g.setColor(GridBlue);
		int LineMark = 49;//starting position inside grid 
		for(int grd = 0; grd < 45; grd++)
		{
			g.fillRect(LineMark+Tron.getExtraLeft()-2,(Tron.getExtraTop() + wallWidth),1,(Tron.getFrameHeight()-(wallWidth*2)-Tron.getExtraTop()-Tron.getExtraLeft()));

			if(grd < 33){//horizontal lines 
				g.fillRect((Tron.getExtraLeft()+ wallWidth),LineMark+Tron.getExtraTop()-3,Tron.getFrameWidth()-(wallWidth*2)-(Tron.getExtraLeft()*2),1);
			}
			LineMark+=25;
		}

	}

	public static boolean getWallBounds(Rectangle bike)
	{
		if(bike.x >= (Tron.getFrameWidth() - (wallWidth *2) - Tron.getExtraLeft() - 1)){//right wall
			return false;
		}
		if(bike.x <= (0 + wallWidth + Tron.getExtraLeft())){//left wall
			return false;
		}
		if(bike.y <= (0 + wallWidth + Tron.getExtraTop())){//top wall
			return false;
		}
		if(bike.y >= (Tron.getFrameHeight() - (wallWidth * 2) - Tron.getExtraLeft() -1)){//bottom wall
			return false;
		}
		return true;
	}



}
