package cs2410.assn7;


public abstract class Smarty extends Race{
	protected int iQ;
	
	public int getIQ(){
		return iQ;
	}
	
	public void setIQ(int iQ){
		this.iQ = iQ;
	}
	
	public abstract int getIncome();
	
}
