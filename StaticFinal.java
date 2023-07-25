public class StaticFinal{
	public static void main(String[] args) {
	    NikeShoe Shoe1 = new NikeShoe("Red",8);
	    NikeShoe Shoe2 = new NikeShoe("Black",10);
	    
	    Shoe1.showShoe();
	    Shoe2.showShoe();
	}
    
}

class NikeShoe{
    private static final String logo = "Nike";
    
    private String color;
    private int size;
    
    NikeShoe(String color,int size){
        this.color = color;
        this.size = size;
    }
    
    void showShoe(){
        System.out.println("shoe Brand logo: "+logo);
        System.out.println("Shoe color : "+color);
		System.out.println("Shoe Size  : "+size);
    }
}