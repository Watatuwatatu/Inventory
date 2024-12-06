
public class Toner {
    //String toner;
    //oolean isUsed;
    private int id;
    private String tonerName;
    private boolean isUsed;
    //Toner(String tonerName){
    //    this.toner = tonerName;
    //    this.isUsed = false;

    public Toner(int id, String tonerName, boolean isUsed) {
        this.id = id;
        this.tonerName = tonerName;
        this.isUsed = isUsed;
    }
    public int getId(){
        return id;
    }
    public String getTonerName(){
        return tonerName;
    }
    public boolean getIsUsed(){
        return isUsed;
    }
    public void markAsUsed(){
        this.isUsed = true;
    }
    @Override
    public String toString(){
        return (isUsed ? "[Used] " : "[Unused] ") + tonerName;
    }
        
}
