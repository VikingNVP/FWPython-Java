package ToyShopJava;

public class Toy {
    private int id;
    private String name;
    private int count;
    private int probability;

    public Toy(int id, String name, int count, int probability){
        this.id = id;
        this.name = name;
        this.count = count;
        this.probability = probability;
    }

    public void setID(int id){
        this.id = id;
    }
    public void setNAME(String name){
        this.name = name;
    }
    public void setCOUNT(int count){
        this.count = count;
    }
    public void setPROBABILITY(int probability){
        this.probability = probability;
    }

    public int getID(){
        return id;
    }
    public String getNAME(){
        return name;
    }
    public int getCOUNT(){
        return count;
    }
    public int getPROBABILITY(){
        return probability;
    }
    
}
