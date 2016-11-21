
package cs2410.assn7;


public class HourlyWorker extends Smarty{
	private int hours;
	private int pay;
	
	public HourlyWorker(String name, int iQ, int pay, int hours){
		this.pay = pay;
		this.hours = hours;
		this.name = name;
		this.iQ = iQ;
	}
	
	public int getPay() {
		return pay;
	}

	public void setPay(int pay) {
		this.pay = pay;
	}
	
	public int getHoursWorked(){
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public int getIncome() {
		return(pay*hours);
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String doMath() {
		return "6 * 4 = 24";
	}

	@Override
	public String saySomethingSmart() {
		return "Mammals have fur.";
	}

	
	

}
