
public class BuildingTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Bricks bricks = new Bricks(24,25,"rectangle","silica",1000,54000);
        Metal metal = new Metal(3000,"steel",30000);
        Builder builder = new Builder();
        Building building = builder.build(bricks,metal);
        
        System.out.println("cost of the building: "+building.getCost()+" Time to build in days: "+building.getTimeInDays()+" Type of the Building:"+building.getTypeOfBuilding());
        
        
        
        
	}

}

class Bricks {
	private int length;
	private int breadth;
	private String shape;
	private String composition ;
	private int quantity;
	private int costOfBrick;
	
	public Bricks(int length,int breadth,String shape,String composition,int quantity,int costOfBrick) {
		this.length =length;
		this.breadth =breadth;
		this.shape =shape;
		this.composition =composition;
		this.quantity = quantity;
		this.costOfBrick = costOfBrick;
	}
    
	public int getCostOfBrick() {
		return costOfBrick;
	}

	public void setCostOfBrick(int costOfBrick) {
		this.costOfBrick = costOfBrick;
	}

	public Bricks(int quantity) {
		super();
		this.quantity = quantity;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getBreadth() {
		return breadth;
	}

	public void setBreadth(int breadth) {
		this.breadth = breadth;
	}

	public String getShape() {
		return shape;
	}

	public void setShape(String shape) {
		this.shape = shape;
	}

	public String getComposition() {
		return composition;
	}

	public void setComposition(String composition) {
		this.composition = composition;
	}

	@Override
	public String toString() {
		return "Bricks [length=" + length + ", breadth=" + breadth + ", shape=" + shape + ", composition=" + composition
				+ ", quantity=" + quantity + "]";
	}

	
	
		
}

class Metal{
	private int quantity;
	private String type;
	private int costOfMetal;
	
	public Metal(int quantity,String type,int costOfMetal){
		this.quantity = quantity;
		this.type = type;
		this.costOfMetal =costOfMetal;
		
	}
    
	public int getCostOfMetal() {
		return costOfMetal;
	}

	public void setCostOfMetal(int costOfMetal) {
		this.costOfMetal = costOfMetal;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Metal [quantity=" + quantity + ", type=" + type + ", costOfMetal=" + costOfMetal + "]";
	}

	
}

class Builder{
	Building build(Bricks bricks,Metal metal) {
		Building building = new Building();
		int cost = bricks.getCostOfBrick()*metal.getCostOfMetal();
		building.setCost(cost);
		building.setTimeInDays(55);
		building.setTypeOfBuilding("Duplex");
		
		return building;
		
		
	}

	
}
class Building{
	private int cost;
	private int TimeInDays;
	private String TypeOfBuilding;
	Building(){
		
	}
	Building(int cost,int TimeInDays,String TypeOfBuilding){
		this.cost = cost;
		this.TimeInDays = TimeInDays;
		this.TypeOfBuilding = TypeOfBuilding;
		
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getTimeInDays() {
		return TimeInDays;
	}

	public void setTimeInDays(int timeInDays) {
		TimeInDays = timeInDays;
	}

	public String getTypeOfBuilding() {
		return TypeOfBuilding;
	}

	public void setTypeOfBuilding(String typeOfBuilding) {
		TypeOfBuilding = typeOfBuilding;
	}

	@Override
	public String toString() {
		return "Building [cost=" + cost + ", TimeInDays=" + TimeInDays + ", TypeOfBuilding=" + TypeOfBuilding + "]";
	}
	
	
	
}