
package cs2410.assn7;


public abstract class Race {
    protected String name;
    protected String somethingSmart;

    public abstract String getName();

    public void setName(String name){
        this.name = name;
    }

    public abstract String doMath();

    public abstract String saySomethingSmart();

    public void setSomethingSmart(String somethingSmart){
        this.somethingSmart = somethingSmart;
    }

}
