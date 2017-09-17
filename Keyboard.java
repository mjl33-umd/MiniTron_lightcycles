import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class Keyboard extends KeyAdapter implements keyable{

	private Window window;
	
	public Keyboard(Window win)
	{
		window = win;
	}
	
	@Override
	public void keyPressed(KeyEvent e)
	{
		if(e.getKeyCode() == e.VK_ESCAPE)//universal keyboard inputs
		{
			System.exit(1);
		}
		if(e.getKeyCode() == e.VK_R)//universal keyboard inputs
		{
			window.resetGame();
		}
		window.keyPressed(e);
		
	}
}
