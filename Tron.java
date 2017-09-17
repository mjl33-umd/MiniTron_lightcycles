
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;



public class Tron extends JFrame{
	
	private final static int frameWIDTH = 1200;
	private final static int frameHEIGHT = 925;
	private final Dimension frameDIMENSION = new Dimension(frameWIDTH,frameHEIGHT);
	
	protected final static int cycleWidth = 26;
	protected final static int cycleHeight = 26;
	
	private Image dbImage;
	private Graphics dbg;
	
	private static Window window = new Window();
	
	public Tron()
	{
		super("Mini Tron Lightcycles");
		setSize(frameDIMENSION);
		setLocationRelativeTo(null);//Centers screen
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBackground(Color.BLACK);
		addKeyListener(new Keyboard(window));
	}
	
	public void paint(Graphics g)
	{
		dbImage = createImage(getWidth(), getHeight());
		dbg = dbImage.getGraphics();
		paintComponent(dbg);
		g.drawImage(dbImage, 0, 0, this);
		repaint();
	}
	
	private void paintComponent(Graphics g)
	{	
		window.HandleWindow(g);
	}
	
	protected static int getFrameWidth(){
		return frameWIDTH;
	}
	
	protected static int getFrameHeight(){
		return frameHEIGHT;
	}
	
	protected static int getExtraTop(){
		return 32;//excess space above JFrame
	}
	
	protected static int getExtraLeft(){
		return 3;//excess space left of JFrame
	}
	
	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable(){//Read online that this helps with multiple threads
			public void run() {
	
				new Tron();
			}
		});

	}
	
	

}
