
package cs2410.assn7;


public class ContractWorker extends Smarty {
	private int contractsCompleted;

	public ContractWorker(String name,  int iQ, int contractsCompleted){
		this.contractsCompleted = contractsCompleted;
		this.name = name;
		this.iQ = iQ;
	}
	
	public int getContractsCompleted() {
		return contractsCompleted;
	}

	public void setContractsCompleted(int contractsCompleted) {
		this.contractsCompleted = contractsCompleted;
	}

	@Override
	public int getIncome() {
		return (contractsCompleted);
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String doMath() {
		return "144 / 12 = 12";
	}

	@Override
	public String saySomethingSmart() {
		return "The stars are giants balls of burning gas.";
	}
	

}
