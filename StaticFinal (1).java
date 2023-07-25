public class StaticFinal{
	public static void main(String[] args) {
	    NikeShoe.showShoeCount();
	    NikeShoe Shoe1 = new NikeShoe("Red",8);
	    NikeShoe Shoe2 = new NikeShoe("Black",10);
	    
	    
	    Shoe1.showShoe();
	    Shoe2.showShoe();
	    NikeShoe.showShoeCount();
	}
    
}

class NikeShoe{
    private static final String logo = "Nike";
    private static int shoeCount;
    private String color;
    private int size;
    
    NikeShoe(String color,int size){
        this.color = color;
        this.size = size;
        shoeCount++;
    }
    
    void showShoe(){
        System.out.println("shoe Brand logo: "+logo);
        System.out.println("Shoe color : "+color);
		System.out.println("Shoe Size  : "+size);
    }
    public static void showShoeCount(){
        System.out.println("Shoe Count: "+shoeCount);
    }
}