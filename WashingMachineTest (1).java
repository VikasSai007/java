
public class WashingMachineTest {
	public static void main(String[] args) {
	    
	     
		
		
		 
		
		
			
		Cloth[] clothes = new Cloth[5];
		clothes[0] = new Cloth("Cotton", "Blue", 250.99f, "T-Shirt", false);
		clothes[1] = new Cloth("Polyester", "Red", 390.99f, "Dress", true);
		clothes[2] = new Cloth("Denim", "Black", 340.99f, "Jeans", false);
		clothes[3] = new Cloth("Silk", "Green", 190.99f, "Bath Towel", false);
		clothes[4] = new Cloth("Linen", "White", 290.99f, "Pants", true);
		
		try{
		    
		    Electricity electricity = new Electricity("AC", 220.0f, 8, 15, "Mahavitaran");
		    //Electricity electricity = new Electricity("AC", 0, 8, 15, "Mahavitaran");
		    System.out.println("Electricity : "+electricity);
		    
		    WashingPowder washPowder = new WashingPowder(100,"Nirma", "Front Load", true, 10.0f);
		    System.out.println("wash powder : "+washPowder);
		    
		    Water water = new Water("Cold", 40, "20°C");
		    //Water water = new Water("Cold", 20, "20°C");
		    System.out.println("Water : "+water);
		    
		    
		    WashingMachine washingMachine1 = new WashingMachine("Onida",washPowder, water, electricity, clothes,20);
		    WashingMachine washingMachine2 = new WashingMachine("Samsung",washPowder, water, electricity, clothes,30);
		    WashingMachine washingMachine3 = new WashingMachine("LG",washPowder, water, electricity, clothes,15);
		
		
		    washingMachine1.start();
		    washingMachine2.start();
		    washingMachine3.start();
		    
		}
		catch(PowerFailureException ex1){
		    System.out.println("Power Failure Issue : "+ex1);
		}
		catch(WashingPowderQuantityException ex2){
		    System.out.println("Washing Powder Issue : "+ex2);
		}
		catch(WaterQuantityException ex3){
		    System.out.println("Water Quantity Issue : "+ex3);
		}
		catch(OverLoadException ex4){
		    System.out.println("Clothes OverLoad Issue : "+ex4);
		}
	 //toString is invoked
		
		
	
		/*int i=0; 
		for (Cloth cloth : clothes) {
			System.out.println("cloth" + ++i + " : "+   cloth);
        }
		*/
		System.out.println("================================================\n");
  

		/*WashingMachine washingMachine1 = new WashingMachine("Onida",washPowder, water, electricity, clothes,20);
		WashingMachine washingMachine2 = new WashingMachine("Samsung",washPowder, water, electricity, clothes,30);
		WashingMachine washingMachine3 = new WashingMachine("LG",washPowder, water, electricity, clothes,15);
		
		
		washingMachine1.start();
		wsshingMachine2.start();
		washingMachine3.start();*/
		
		
		/*Laundry laundry = washingMachine.wash(washPowder, water, electricity, clothes);
		System.out.println("Number of Clothes : " + laundry.getNumberOfCloths());
		System.out.println("Time Required to wash clothes : " + laundry.getTimeRequired() + " mins");
		System.out.println("Total Cost of Clothes : " + laundry.getTotalCost() + " Rs");
		System.out.println("Water Used for washing clothes : " + laundry.getWaterUsed() + " L");
		System.out.println("Electricity Used for washing clothes : " + laundry.getElectricityUsed() + " kWh");
		System.out.println("Cost of Washing Powder: " + laundry.getCostOfWashingPowder() + " Rs");
		*/
	}
}
class WaterQuantityException extends Exception{
    WaterQuantityException(String msg){
        super(msg);
    }
    
}
class PowerFailureException extends Exception{
    PowerFailureException(String msg){
        super(msg);
    }
    
}

class WashingPowderQuantityException extends Exception{
    WashingPowderQuantityException(String msg){
        super(msg);
    }
}
class OverLoadException extends Exception{
    OverLoadException(String msg){
        super(msg);
    }
}
class TimeExcededException extends RuntimeException{
    TimeExcededException(String msg){
        super(msg);
    }
}

class WashingMachine extends Thread { 
	   String WashingMachineBrand;
       WashingPowder washPowder;
	   Water water;
	   Electricity electricity;
	   Cloth clothes[];
	   int time;
	   WashingMachine(String WashingMachineBrand,WashingPowder washingPowder, Water water, Electricity electricity, Cloth clothes[],int time) throws OverLoadException{
	       this.WashingMachineBrand = WashingMachineBrand;
	       this.washPowder = washingPowder;
	       this.water = water;
	       this.electricity = electricity;
	       if(clothes.length <=5){
	           this.clothes = clothes;
	       }
	       else{
	           throw new OverLoadException("Washing Machine is Overloaded");
	       }
	       if(time<60){
	           this.time = time;
	       }
	       else{
	           throw new TimeExcededException("Time has Exceded.....");
	       }
	       
	   }
	   
	   public void run(){
	       	for(int i=1;i<=time;i++) {
			System.out.println(WashingMachineBrand+" Washing Machine is washing...Time Elapsed: "+i+" Mins");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	       wash( washPowder, water, electricity,clothes);
	   }
		Laundry wash(WashingPowder washPowder, Water water, Electricity electricity, Cloth clothes[])
		{
			
			Laundry laundry = new Laundry();
			laundry.setNumberOfCloths(clothes.length);
			float timeRequired = 60.00f; 
			laundry.setTimeRequired(timeRequired);
			 float entireCost = 0.0f;
		        for (Cloth cloth : clothes) {
		            entireCost += cloth.getCost();
		        }
			laundry.setTotalCost(entireCost);
			laundry.setWaterUsed((float)water.getQuantity());
			
			float electricityUsed = electricity.getUnitUsed() * (timeRequired / 60.0f);
			laundry.setElectricityUsed(electricityUsed);
			laundry.setCostOfWashingPowder(washPowder.getPrice() * ((float)water.getQuantity() + electricityUsed));
			
			return laundry;
		}
}

class Laundry {
	private int numberOfCloths; //cloth.length
	private float timeRequired;
	private float totalCost ;// cloth.length * price per cloth
	private float waterUsed;
	private float electricityUsed;
	private float costOfWashingPowder; //
	public Laundry(){
	    
	}
	public Laundry(int numberOfCloths, float timeRequired, float totalCost, float waterUsed, float electricityUsed,
			float costOfWashingPowder) {
		super();
		this.numberOfCloths = numberOfCloths;
		this.timeRequired = timeRequired;
		this.totalCost = totalCost;
		this.waterUsed = waterUsed;
		this.electricityUsed = electricityUsed;
		this.costOfWashingPowder = costOfWashingPowder;
	}

	@Override
	public String toString() {
		return "Laundry [numberOfCloths=" + numberOfCloths + ", timeRequired=" + timeRequired + ", totalCost="
				+ totalCost + ", waterUsed=" + waterUsed + ", electricityUsed=" + electricityUsed
				+ ", costOfWashingPowder=" + costOfWashingPowder + "]";
	}

	public int getNumberOfCloths() {
		return numberOfCloths;
	}

	public void setNumberOfCloths(int numberOfCloths) {
		this.numberOfCloths = numberOfCloths;
	}

	public float getTimeRequired() {
		return timeRequired;
	}

	public void setTimeRequired(float timeRequired) {
		this.timeRequired = timeRequired;
	}

	public float getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(float totalCost) {
		this.totalCost = totalCost;
	}

	public float getWaterUsed() {
		return waterUsed;
	}

	public void setWaterUsed(float waterUsed) {
		this.waterUsed = waterUsed;
	}

	public float getElectricityUsed() {
		return electricityUsed;
	}

	public void setElectricityUsed(float electricityUsed) {
		this.electricityUsed = electricityUsed;
	}

	public float getCostOfWashingPowder() {
		return costOfWashingPowder;
	}

	public void setCostOfWashingPowder(float costOfWashingPowder) {
		this.costOfWashingPowder = costOfWashingPowder;
	}
	
	
	
	
	
}

class Tub {
	
}

class WashingTub  extends Tub {
	private int capacity;
	private String type; //
	public WashingTub(int capacity, String type) {
		super();
		this.capacity = capacity;
		this.type = type;
	}
	@Override
	public String toString() {
		return "WashingTub [capacity=" + capacity + ", type=" + type + "]";
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}

class Powder {
	
}

class WashingPowder extends Powder { // isA

	private int quantity;
	private String brand;
	private String type;
	private boolean scented;
	private float price;
	
	public WashingPowder(int quantity, String brand, String type, boolean scented, float price) throws WashingPowderQuantityException {
		super();
		if(quantity >50){
		    this.quantity = quantity;
		}
		else{
		    throw new WashingPowderQuantityException("Not Enough Washing Powder");
		}
	
		this.brand = brand;
		this.type = type;
		this.scented = scented;
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "WashingPowder [quantity=" + quantity + ", brand=" + brand + ", type=" + type + ", scented=" + scented
				+ ", price=" + price + "]";
	}
	/*public String toString() {
		String str = (scented) ? "Scented" :"Not Scented";
		return str+ " "+brand+" Washing Powder of "+type+ " type quantity used "+quantity+ " grams ";
	}*/

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isScented() {
		return scented;
	}

	public void setScented(boolean scented) {
		this.scented = scented;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	
}



class Water {
	private String type;
	private int quantity;
	private String temperature;
	
	public Water(String type, int quantity, String temperature) throws WaterQuantityException  {
		super();
		this.type = type;
		if(quantity>30){
		    this.quantity = quantity;
		}
		else{
		    throw new WaterQuantityException("Not Enough Water Quantity");
		}
		
		this.temperature = temperature;
	}
	@Override
	public String toString() {
		return "Water [type=" + type + ", quantity=" + quantity + ", temperature=" + temperature + "]";
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getTemperature() {
		return temperature;
	}
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

}

class Electricity {
	private String type; //ac dc
	private float voltage; 
	private int costPerUnit;
	private int unitUsed;
	private String supplier;
	public Electricity(String type, float voltage, int costPerUnit, int unitUsed, String supplier) throws PowerFailureException {
		super();
		this.type = type;
		if(voltage>0){
		    this.voltage = voltage;
		}
		else{
		    throw new PowerFailureException("No power....");
		}
		this.costPerUnit = costPerUnit;
		this.unitUsed = unitUsed;
		this.supplier = supplier;
	}
	@Override
	public String toString() {
		return "Electricity [type=" + type + ", voltage=" + voltage + ", costPerUnit=" + costPerUnit + ", unitUsed="
				+ unitUsed + ", supplier=" + supplier + "]";
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public float getVoltage() {
		return voltage;
	}
	public void setVoltage(float voltage) {
		this.voltage = voltage;
	}
	public int getCostPerUnit() {
		return costPerUnit;
	}
	public void setCostPerUnit(int costPerUnit) {
		this.costPerUnit = costPerUnit;
	}
	public int getUnitUsed() {
		return unitUsed;
	}
	public void setUnitUsed(int unitUsed) {
		this.unitUsed = unitUsed;
	}
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	
	
	
}

class Cloth {
	private String material; //
	private String color;
	private float cost;
	private String type;
	private boolean clean; //
	
	public Cloth(String material, String color, float cost, String type, boolean clean) {
		super();
		this.material = material;
		this.color = color;
		this.cost = cost;
		this.type = type;
		this.clean = clean;
	}
	@Override
	public String toString() {
		return "Cloth [material=" + material + ", color=" + color + ", cost=" + cost + ", type=" + type + ", clean="
				+ clean + "]";
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public boolean isClean() {
		return clean;
	}
	public void setClean(boolean clean) {
		this.clean = clean;
	}
	

	
}


