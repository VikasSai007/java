/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

public class InstrumentTest{
	public static void main(String[] args) {
		
	/*	Guitar guitar = new Guitar();
		guitar.use();
		guitar.tuneStrings();
		guitar.play();
		guitar.pluck();
	
		Violin violin = new Violin();
		violin.use();
		violin.tuneStrings();
		violin.play();
		violin.bow();
	    	
	    Flute flute = new Flute();
	    flute.use();
	    flute.play();
	    flute.blowAir();
	    flute.movingFingers();
	*/
	Tabla tabla = new Tabla();
	tabla.use();
	tabla.play();
	tabla.tuneSurface();
	tabla.hittingTabla();
	
	
//The method pluck() is undefined for the 
		//type StringBasedMusicalInstrument		
		
	}
}

interface Instrument
{
	void use(); //by default method is public and abstract
}
abstract class MusicalInstrument implements Instrument
{
	abstract void play();
}
abstract class StringBasedMusicalInstrument extends MusicalInstrument
{
	abstract void tuneStrings();
}
class Guitar extends StringBasedMusicalInstrument
{
	public void use() {
		System.out.println("Using Guitar...");
	}
	void play() {
		System.out.println("Playing Guitar...");

	}
	void tuneStrings() {
		System.out.println("Tuning Strings of Guitar...");

	}
	void pluck() {
		System.out.println("Plucking Strings of Guitar...");

	}
}


class Violin extends StringBasedMusicalInstrument
{
	public void use() {
		System.out.println("Using Violin...");
	}
	void play() {
		System.out.println("Playing Violin...");

	}
	void tuneStrings() {
		System.out.println("Tuning Strings of Violin...");

	}
	void bow() {
		System.out.println("Bowing Strings of Violin...");

	}
}

//AirBasedMusicalInstrument
abstract class AirBasedMusicalInstrument extends MusicalInstrument{
    abstract void blowAir();
}

class Flute extends AirBasedMusicalInstrument{
    public void use(){
        System.out.println("using Flute...");
    }
    void play() {
		System.out.println("Playing Flute...");

	}
	void blowAir(){
	    System.out.println("Blow Air of Flute...");
	}
	void movingFingers(){
	    System.out.println("Moving the Fingers on the Flute...");
	}
    
} 
class Harmonium extends AirBasedMusicalInstrument{
    public void use(){
        System.out.println("using Harmonium...");
    }
    void play() {
		System.out.println("Playing Harmonium...");

	}
	void blowAir(){
	    System.out.println("Blow Air of Harmonium...");
	}
	void pressingKeys(){
	    System.out.println("pressing keys on the Harmonium...");
	}
} 

//DrumBasedMusicalInstrument

abstract class DrumBasedMusicalInstrument extends MusicalInstrument{
    abstract void tuneSurface();
} 

class Tabla extends DrumBasedMusicalInstrument{
    public void use(){
        System.out.println("using Tabla...");
    }
    void play() {
		System.out.println("Playing Tabla...");
	}
	void tuneSurface(){
	    System.out.println("Tune surfacing Tabla...");
	}
	void hittingTabla(){
	    System.out.println("hitting Tabla...");
	}
}

class Dhol extends DrumBasedMusicalInstrument{
    public void use(){
        System.out.println("using Tabla...");
    }
    void play() {
		System.out.println("Playing Tabla...");
	}
	void tuneSurface(){
	    System.out.println("Tune surfacing Tabla...");
	}
	void hittingDhol(){
	    System.out.println("hitting Dhol...");
	}
}


//MedicalInstrument


abstract class MedicalInstrument implements Instrument{
    abstract void operate();
}

// SurgicalInstrument 


abstract class SurgicalInstrument extends MedicalInstrument{
    abstract void sterile();
} 

class SurgicalCutter extends SurgicalInstrument{
    public void use(){
        System.out.println("using SurgicalCutter....");
    }
   
    void operate(){
        System.out.println("operating using SurgicalCutter....");
    }
     void sterile(){
        System.out.println("steriling SurgicalCutter....");
    }
    void cutting(){
        System.out.println("Cutting SurgicalCutter....");
    }
}

class SurgicalNeedle extends SurgicalInstrument{
    public void use(){
        System.out.println("using SurgicalNeedle....");
    }
   
    void operate(){
        System.out.println("operating using SurgicalNeedle....");
    }
     void sterile(){
        System.out.println("steriling SurgicalNeedle....");
    }
    void stiching(){
        System.out.println("stiching SurgicalNeedle....");
    }
}


//PathologicalInstrument
abstract class PathologicalInstrument extends MedicalInstrument{
    abstract void reader();
} 

class Glucometer extends PathologicalInstrument{
    public void use(){
        System.out.println("using Glucometer....");
    }
   
    void operate(){
        System.out.println("operatin using Glucometer....");
    }
    void reader(){
        System.out.println("operating using Glucometer....");
    }
    void bloodSugarLevels(){
       System.out.println("Showing Blood sugar levels in Glucometer");
    }
}

class ECGMachine extends PathologicalInstrument{
    public void use(){
        System.out.println("using ECGMachine....");
    }
   
    void operate(){
        System.out.println("operatin using ECGMachine....");
    }
    void reader(){
        System.out.println("operating using ECGMachine....");
    }
    void heartBeatLevel(){
       System.out.println("Showing heart beat level in ECGMachine....");
    }
}