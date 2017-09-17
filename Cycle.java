import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;


public abstract class Cycle implements Runnable{

	private final int CycleID;
	
	protected int xDirection;
	protected int yDirection;
	
	private int listCounter = 0;
	private Trail blockTrail;
	
	protected Rectangle cyc;
	
	protected ArrayList<Trail> lightTrail = new ArrayList<Trail>();//this cycles lightTrail
	
	public Cycle(int xi, int yi, int widt, int heit, int id)
	{	
		CycleID = id;
		cyc = new Rectangle(xi,yi,widt,heit);
		blockTrail = new Trail(cyc.x,cyc.y);
		lightTrail.add(blockTrail);//sets a base so set method will work
	}
 
	public int getID(){
		return CycleID;
	}
	
	public void run() {

		try{

			while(true)
			{		
				move();
				checkCollision(lightTrail,Window.mode.getOtherC(this).lightTrail);
				Thread.sleep(8);
			}

		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public abstract void draw(Graphics g);
	
	protected void move()
	{
		cyc.x += xDirection;
		cyc.y += yDirection;
		blockTrail.setTHeight(yDirection);
		blockTrail.setTWidth(xDirection);
		lightTrail.set(listCounter,blockTrail);
	}
	
	protected void setXYDirection(int xdir, int ydir)
	{
		if((xDirection != (xdir * -1) && xDirection != (xdir)) || (yDirection != (ydir * -1) && yDirection != (ydir)))//checks if cycle is trying to go backwards or forwards
		{
			xDirection = xdir;
			yDirection = ydir;	
			listCounter++;
			blockTrail = new Trail(cyc.x,cyc.y);
			lightTrail.add(blockTrail);//sets a base so set method will work
		}
	}
	
	private void checkCollision(ArrayList<Trail> LT1, ArrayList<Trail> LT2)
	{
		boolean stop = false;
		
		if(!Grid.getWallBounds(cyc)){
			stop = true;
		}
		
		Rectangle tester = new Rectangle(cyc.x + ( -1 * 7 * xDirection),cyc.y + (-1* 7 * yDirection),cyc.width,cyc.height);//7 is then removed for testing behind
		
		for(int one = 0; one<LT1.size(); one++)
		{
			if(cyc.intersects(LT1.get(one).getRec()) && !tester.intersects(LT1.get(one).getRec())){
				stop = true;
			}
		}
		
		for(int two = 0; two<LT2.size(); two++)
		{
			if(cyc.intersects(LT2.get(two).getRec())){
				stop = true;
			}
		}
		
		if(stop){
			Window.stopGame(Window.mode.getOtherC(this));
		}
	}
	
}
