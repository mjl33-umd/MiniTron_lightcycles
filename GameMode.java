
public class GameMode {

	private String gameType;
	private Thread t1,t2;
	private Cycle cycle1, cycle2;
	
	public GameMode(String gt, Cycle c1, Cycle c2)
	{
		gameType = gt;
		cycle1 = c1;
		cycle2 = c2;
		t1 = new Thread(c1);
		t2 = new Thread(c2);
	}
	
	public Cycle getC1(){
		return cycle1;
	}
	
	public Cycle getC2(){
		return cycle2;
	}
	
	public Cycle getOtherC(Cycle current){
		if(current.equals(cycle1)){
			return cycle2;
		}
		else{
			return cycle1;
		}
	}
	
	public String getGameType(){
		return gameType;
	}
	
	public void printGameType(){
		System.out.println("gameType: " + gameType);
	}
	
	public void startCycleThreads(){
		System.out.println("Cycle threads started");
		t1.start();
		t2.start();
	}
	
	public void stopCycleThreads(){
		System.out.println("Cycle threads stopped");
		t1.interrupt();
		t2.interrupt();
	}
}
