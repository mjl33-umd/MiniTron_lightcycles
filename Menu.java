import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;


public class Menu implements drawable, keyable{

	private int menuTicker = 1;

	private int titleSize = 350;
	private Font titleFont = new Font(Font.SANS_SERIF,Font.PLAIN,titleSize);
	
	private int selectionSize = 40;
	private Font selectionFont = new Font(Font.MONOSPACED, Font.PLAIN, selectionSize);
	
	private int xCenter = 506;
	private int yCenter = 592;

	@Override
	public void draw(Graphics g) 
	{
		
		//Tron Title
		g.setColor(Color.CYAN);
		g.setFont(titleFont);
		g.drawString("TRON",110, 400);
		//////////////////////////
		
		g.setColor(Color.WHITE);
		g.setFont(selectionFont);
		g.drawString("ONE PLAYER", xCenter, yCenter);
		g.drawString("TWO PLAYER", xCenter, yCenter + 75);

		if(menuTicker == 1)//menu ticker triangles
		{
			g.drawLine(450, 571, 450, 591);
			g.drawLine(450, 571, 467, 581);
			g.drawLine(450, 591, 467, 581);
		}
		else
		{
			g.drawLine(450, 646, 450, 666);
			g.drawLine(450, 646, 467, 656);
			g.drawLine(450, 666, 467, 656);
		}


	}

	@Override
	public void keyPressed(KeyEvent e) {

		if(e.getKeyCode() == e.VK_UP)
		{
			menuTicker = 1;
		}
		if(e.getKeyCode() == e.VK_DOWN)
		{
			menuTicker = 2;
		}
	}

	protected GameMode getMode()
	{
		Cycle p1, p2, ai;

		switch(menuTicker)//These are the game options from the menu
		{
		case 1:
			p1 = new PlayerOne(525,800);
			ai = new AI(575,800);
			return new GameMode("One Player", p1,ai);
		case 2:
			p1 = new PlayerOne(525,800);
			p2 = new PlayerTwo(575,800);
			return new GameMode("Two Player", p1,p2);
		default:
			System.out.println("Hacking the system.........");
			return null;

		}
	}


}
