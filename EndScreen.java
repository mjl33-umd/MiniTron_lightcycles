import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;


public class EndScreen implements drawable{

	private Cycle winner;
	private String message;
	private int messageX;
	
	public EndScreen()
	{
		winner = null;
	}

	public void setWinner(Cycle w){
		winner = w;
		setMessage();
	}
	
	private void setMessage(){
		
		String msg = "Something went wrong";//default
		
		if(Window.mode.getGameType().equals("One Player"))
		{
			messageX = 460;
			if(winner.getID() == 1){//player won
				msg = "YOU WIN";
			}
			else if(winner.getID() == 3){//cpu won
				msg = "YOU LOSE";
			}
		}
		else if(Window.mode.getGameType().equals("Two Player"))
		{
			messageX = 325;
			if(winner.getID() == 1){//player one wins
				msg = "PLAYER ONE WINS";
			}
			else if(winner.getID() == 2){//player two wins
				msg = "PLAYER TWO WINS";
			}
		}
		
		message = msg;
		
	}
	
	public void draw(Graphics g) {
		
		//DRAWS BOX///////
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Tron.getFrameWidth(), Tron.getFrameHeight());
		g.setColor(Color.CYAN);
		g.fillRect(200, 300, 20, 300);
		g.fillRect(980, 300,20,300);
		g.fillRect(220,300,760,20);
		g.fillRect(220, 580, 760, 20);
		////////////////////////////////
		
		//DRAWS MESSAGE//////////
		g.setColor(Color.WHITE);
		g.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 60));
		g.drawString(message, messageX, 450);
		///////////////////////////
		
		//DRAWS RESET HELP///////
		g.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 30));
		g.drawString("PRESS [R] TO RESET", 415, 700);
		///////////////////////////
		
		//DRAWS ESCAPE HELP///////
		g.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 30));
		g.drawString("PRESS [ESC] TO EXIT", 405, 750);
		///////////////////////////
		
	}

}
