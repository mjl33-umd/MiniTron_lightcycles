import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Window implements keyable{
	
	private Grid grid = new Grid();
	private Menu menu = new Menu();
	private static EndScreen end = new EndScreen();
	
	protected static GameMode mode = null;
	
	private static boolean gameStarted = false;
	private static boolean gameEnded = false;
	
	protected void HandleWindow(Graphics g){
		
		if(gameStarted){//Draws grid and starts drawing cycles
			grid.draw(g);
			(mode.getC1()).draw(g);
			(mode.getC2()).draw(g);
		}
		else if(gameEnded){//Draws ending display
			end.draw(g);
		}
		else{//Draws menu
			menu.draw(g);
		}
		
	}
	
	@Override
	public void keyPressed(KeyEvent e) {//master key handler
		
		if(!gameStarted && !gameEnded)//If game not started user can access menu
		{
			if(e.getKeyCode() == e.VK_ENTER){
				mode = menu.getMode();
				startGame();
			}
			menu.keyPressed(e);
		}
		else if(gameStarted)//keyboard can access movement to certain cycles depending on what mode was selected
		{
			if(mode.getGameType().equals("One Player")){
				((keyable) mode.getC1()).keyPressed(e);
			}
			else{
				((keyable) mode.getC1()).keyPressed(e);
				((keyable) mode.getC2()).keyPressed(e);
			}
		}
		
	}
	
	protected void startGame(){
		mode.printGameType();
		mode.startCycleThreads();
		gameStarted = true;
	}
	
	protected static void stopGame(Cycle wCyc){
		gameStarted = false;
		gameEnded = true;
		end.setWinner(wCyc);
		mode.stopCycleThreads();
	}
	
	protected void resetGame(){
		System.out.println("resetting game");
		grid = new Grid();
		menu = new Menu();
		end = new EndScreen();
		mode = null;
		gameStarted = false;
		gameEnded = false;
	}
	
}
