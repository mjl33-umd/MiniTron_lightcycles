import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;


public class PlayerTwo extends Cycle implements keyable{

	private static Color wheel = CustomColor.ModGray;
	private static Color outWheel = Color.RED;
	private static Color inMainOval = CustomColor.DarkGray;
	private static Color outMainOval = Color.RED;
	private static Color inOval = CustomColor.ModGray;
	private static Color outOval = Color.RED;

	public PlayerTwo(int xi, int yi)
	{
		super(xi,yi,Tron.cycleWidth,Tron.cycleHeight,2);
		xDirection = 0;
		yDirection = -1;
	}

	@Override
	public void draw(Graphics g) {

		//Drawing Trail
		g.setColor(Color.RED);//Color of Trail
		for(int tr = 0; tr < lightTrail.size();tr++)
		{
			Trail trtemp = lightTrail.get(tr);
			if(trtemp != null)
			{
				trtemp.draw(g);
			}
			else{
				System.out.println("null");
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
	
	@Override
	public void keyPressed(KeyEvent e) {

		int keyCode = e.getKeyCode();

		if(keyCode == e.VK_A){
			setXYDirection(-1,0);
		}
		if(keyCode == e.VK_D){
			setXYDirection(1,0);
		}
		if(keyCode == e.VK_W){
			setXYDirection(0,-1);
		}
		if(keyCode == e.VK_S){
			setXYDirection(0,1);
		}


	}




}
