package vikas;

class Human{
	   private String name; 
	   public int age;
	   private double height;
	   private int weight;
	   
	   Human(String name,int age,double height,int weight) {
		   this.name = name;
		   this.age = age;
		   this.height = height;
		   this.weight = weight;
	   }
	   //Human(int age,double height,int weight){
		  // this.age = age;
		 //  this.height = height;
		//   this.weight = weight;
	   //}
	   
	   void HumanWord() {
		   System.out.println("Hello");
		   
	   }
	   
	   void HumanWord(String name) {
		   System.out.println("Hello "+name);
		   
	   }
	   
	   void HumanWord(String name,int weight) {
		   System.out.println("Hello "+name+" your weight is "+weight);
		   
	   }
	   void HumanWord(String name,double height) {
		   System.out.println("Hello "+name+" your height is "+height);
		   
	   }
	   void HumanWord(double height,String name) {
		   System.out.println("Hello "+name+" your height is "+height);
		   
	   }
	   
	   public void getHuman() { //1
		   
		   System.out.println("Name:"+name);
		   System.out.println("age:"+age);
		   System.out.println("height:"+height);
		   System.out.println("weight:"+weight);
	   }
	   void changeHeight(int newHeight) { //2
		   height = newHeight;
	   }
	   double heightInMts(double height){ //3
		   return height*0.3048;
	   }
	   double bmi() { //4
		   return (weight / (heightInMts(height)*heightInMts(height))) ;
	   }
}

class SuperHuman extends Human{
	String superPower;
	
	SuperHuman(String name,int age,double height,int weight,String superPower){
		super(name,age,height,weight);
		this.superPower = superPower;
	}
}

class Hero extends SuperHuman{
	int rating;
	Hero(String name,int age,double height,int weight,String superPower,int rating){
		super(name,age,height,weight,superPower);
		this.rating = rating;
	}
	
	public void getHuman() { //1
		   
		   System.out.println("Name: "+name);
		   System.out.println("age: "+age);
		   System.out.println("height: "+height);
		   System.out.println("weight: "+weight);
		   System.out.println("SuperPower: "+superPower);
		   System.out.println("Rating out of 10: "+rating);
	   }
}
public class FirstProject {
	public static void main(String[] args) {
		Human person1 = new Human("vikas",21,5.6,64);
		
		Hero hero1 = new Hero("vikas",21,5.6,64,"speed",8);
		
		
		double bmi = person1.bmi();
		//System.out.println("BMI:"+bmi);
		//person1.HumanWord();
		//person1.HumanWord("vikas");
		//person1.HumanWord("vikas",62);
		//person1.HumanWord("vikas",5.6);
		//person1.HumanWord(5.6,"vikas");
		
		hero1.getHuman();
		
		
	}
}
