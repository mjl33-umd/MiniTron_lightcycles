import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;


public class AI extends Cycle{

	private static Color wheel = CustomColor.ModGray;
	private static Color outWheel = CustomColor.DarkYellow;
	private static Color inMainOval = CustomColor.DarkGray;
	private static Color outMainOval = CustomColor.DarkYellow;
	private static Color inOval = CustomColor.ModGray;
	private static Color outOval = CustomColor.DarkYellow;
	
	public AI(int xi, int yi)
	{
		super(xi,yi,Tron.cycleWidth,Tron.cycleHeight,3);
		xDirection = 0;
		yDirection = -1;
	}

	@Override
	public void run() {//Overrides Cycle class thread

		try{

			while(true)
			{		
				move();
				if(checkAICollision(lightTrail,Window.mode.getOtherC(this).lightTrail)){
					chooseDirection();
				}
				Thread.sleep(8);
			}

		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

	private boolean checkAICollision(ArrayList<Trail> AItrail, ArrayList<Trail> PLT)
	{

		int look = 5;

		Rectangle tester = new Rectangle(cyc.x + ( -1 * 7 * xDirection),cyc.y + (-1* 7 * yDirection),cyc.width,cyc.height);
		Rectangle wallRec = new Rectangle(cyc.x + (look * xDirection),cyc.y + (look * yDirection),cyc.width,cyc.height);

		if(!Grid.getWallBounds(wallRec)){
			return true;
		}

		for(int ai = 0; ai<AItrail.size(); ai++)
		{
			if(wallRec.intersects(AItrail.get(ai).getRec()) && !tester.intersects(AItrail.get(ai).getRec())){
				return true;
			}
		}

		for(int pl = 0; pl<PLT.size(); pl++)
		{
			if(wallRec.intersects(PLT.get(pl).getRec())){
				return true;
			}
		}

		return false;
	}

	private void chooseDirection()
	{	
		Rectangle checker1, checker2;
		int searcher = 26;

		boolean checking = true;

		while(checking)
		{

			checker1 = new Rectangle(cyc.x + (-1 * yDirection * searcher),cyc.y + (-1 * xDirection * searcher),cyc.width,cyc.height);
			checker2 = new Rectangle(cyc.x + (yDirection * searcher),cyc.y + (xDirection * searcher),cyc.width,cyc.height);
			
			if(checkDirection(checker1) || checkDirection(checker2)){
				if(checkDirection(checker1) && checkDirection(checker2) && (lightTrail.size() > 2)){//greater than two fixes bug when AI is in the middle of screen with open walls
					Window.stopGame(Window.mode.getOtherC(this));
				}
				checking = false;
			}
			
			searcher+=26;
		}


	}

	private boolean checkDirection(Rectangle check)
	{
		boolean endCheck = false;

		if(!Grid.getWallBounds(check)){
			endCheck = true;
		}

		for(int l = 0; l<lightTrail.size(); l++){
			if(check.intersects(lightTrail.get(l).getRec())){
				endCheck = true;
			}
		}

		for(int ol = 0; ol<Window.mode.getOtherC(this).lightTrail.size();ol++){
			if(check.intersects(Window.mode.getOtherC(this).lightTrail.get(ol).getRec()) ){
				endCheck = true;
			}
		}

		if(endCheck)//remember directions are flipped because this simulates first crash	
		{
			if(check.x != cyc.x)
			{
				if(check.x <= cyc.x){
					setXYDirection(1,0);
				}
				else{
					setXYDirection(-1,0);
				}
			}
			else
			{
				if(check.y <= cyc.y){
					setXYDirection(0,1);
				}
				else{
					setXYDirection(0,-1);
				}
			}
		}
		return endCheck;
	}

	@Override
	public void draw(Graphics g) {

		//Drawing Trail
		g.setColor(CustomColor.DarkYellow);//Color of Trail
		for(int tr = 0; tr < lightTrail.size();tr++)
		{
			Trail trtemp = lightTrail.get(tr);
			if(trtemp != null)
			{
				trtemp.draw(g);
			}
			else{
				System.out.println("my null");
			}
		}
		///////////////
		
		if(yDirection != 0){//moving up or down
			g.setColor(wheel);//Wheel
			g.fillRect(cyc.x+1,cyc.y+5,23,15);//100,105,23,15
			g.setColor(outWheel);//Outline of Wheel
			g.drawRect(cyc.x+1,cyc.y+5,23,15);
			g.setColor(inMainOval);//Inside of main oval
			g.fillOval(cyc.x+3,cyc.y,19,25);//103,100,19,25
			g.setColor(outMainOval);//Outline of main oval
			g.drawOval(cyc.x+3,cyc.y,19,25);
			g.setColor(inOval);//Inside of inner oval
			g.fillOval(cyc.x+8,cyc.y+5,9,16);//108,105,9,16
			g.setColor(outOval);//Outline of inner oval
			g.drawOval(cyc.x+8,cyc.y+5,9,16);
			}
			else if(xDirection != 0){//moving left or right
			g.setColor(wheel);//Wheel
			g.fillRect(cyc.x+5,cyc.y+1,15,23);
			g.setColor(outWheel);//Outline of Wheel
			g.drawRect(cyc.x+5,cyc.y+1,15,23);
			g.setColor(inMainOval);//Inside of main oval
			g.fillOval(cyc.x,cyc.y+3,25,19);
			g.setColor(outMainOval);//Outline of main oval
			g.drawOval(cyc.x,cyc.y+3,25,19);
			g.setColor(inOval);//Inside of inner oval
			g.fillOval(cyc.x+5,cyc.y+8,16,9);
			g.setColor(outOval);//Outline of inner oval
			g.drawOval(cyc.x+5,cyc.y+8,16,9);
			}

	}

}
