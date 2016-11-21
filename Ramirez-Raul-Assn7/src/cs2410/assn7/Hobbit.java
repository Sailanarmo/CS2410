
package cs2410.assn7;


public class Hobbit extends Race{
	private int carrotsPicked;
	
	public Hobbit(String name, int carrotsPicked){
		this.name = name;
		this.carrotsPicked = carrotsPicked;
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public String doMath() {
		return "3 + 12 = 15";
	}

	@Override
	public String saySomethingSmart() {
		return "Tomatoes are fruit";
	}

	public int getCarrotsPicked() {
		return carrotsPicked;
	}

	public void setCarrotsPicked(int carrotsPicked) {
		this.carrotsPicked = carrotsPicked;
	}

}
