/* Andy Liang, Stanley Zeng - Team DysfunctionalJumperCable
   APCS1 pd5
   HW 33 -- Do You Even Add, Bro?
   2015-11-17 */

public class Rational implements Comparable{

    public double numerator, denominator, number;
    
    public Rational(){
	numerator = 0;
	denominator = 1;
	number = numerator/denominator;
    }

    public Rational(double numerator, double denominator){
        if(denominator == 0){
	    System.err.println("Cannot divide by 0");
	    numerator = 0;
	    denominator = 1;
	    number = numerator / denominator;
	}
	else{
	    number = numerator/denominator;
	}
    }

    public static String toString(double x){
	return Double.toString(x);
    }

    public double floatValue () {
	return number;
    }

    public void multiply ( Rational multiple ) {
	
	numerator = numerator * multiple.numerator;
	denominator = denominator * multiple.denominator;
	number = number * multiple.number;

    }

    public void divide ( Rational divisor ) {
	
	numerator = numerator * divisor.denominator;
	denominator = denominator * divisor.numerator;
	number = number / divisor.number;

    }

    public double gcdER(double a, double b){ //Taken from Stats.java and converted to accept double
	if (a == b) return a;
	double greater = Stats.max(a,b); //Calls the Stats.java methods
	double smaller = Stats.min(a,b);
	if (greater%smaller == 0) return smaller;
	else {
	    return gcdER(smaller,greater%smaller);
	}
    }

    public void add(Rational object){ //Takes a rational object and adds it to current rational number object
	this.numerator = this.numerator * object.denominator + object.denominator * this.denominator;
	this.denominator = this.denominator * object.denominator;
    }

    public void subtract(Rational object){
	this.numerator = this.numerator * object.denominator - object.denominator * this.denominator;
	this.denominator = this.denominator * object.denominator;
    }

    public double gcd(){
	return gcdER(this.numerator, this.denominator);
    }

    public void reduce(){
	this.numerator /= gcd();
	this.denominator /= gcd();
    }
    
    public int compareTo (Rational another) {
	if (this.floatValue() == another.floatValue() ){
	    return 0;
	}
	else if (this.floatValue() > another.floatValue() ){
	    return 1;
	}
	else {
	    return -1;
	}
    }
    
    public static int gcdstatic(int a, int b) {
	int c = 0; //temporarily store the smaller number
	if ( a < b ) {
	    a = c;
	    a = b;
	}
	b = c;

	while (a % b != 0) {
	    int i = a; //temporarily store a
	    int f = b; //temporarily store b
	    a = b; 
	    b = i % f; //b is remainder of a and b
	}
	return b;
    }


    public boolean equals(Object o){
	this.reduce(); // reduce to get in simplest forms
	((Rational) o).reduce();
	
	// check for aliasing.
	boolean retVal = this == o;
 
	
	if ( !retVal ){
	        
	    //check to see if input Object is a Rational
	        retVal = o instanceof Rational
		    
		    //...and that its state variables match those of this Tile
		    && this.numerator == ((Rational)o).numerator
		    && this.denominator == ((Rational)o).denominator;
		System.out.println(o);
		System.out.println(this);
		System.out.println(this.numerator);
		System.out.println(((Rational)o).numerator);
		System.out.println(this.denominator);
		System.out.println(((Rational)o).denominator);
		    
	}
	return retVal;

    }
    
    
    public static void main(String[] args){
	Rational x = new Rational();
	Rational y = new Rational (3.5, 7);
	Rational z = new Rational (7, 3.5);
	
	System.out.println(toString(x.number));
	System.out.println(toString(y.number));
	System.out.println(toString(z.number));
	System.out.println(x.floatValue());
	System.out.println(y.floatValue());
	System.out.println(z.floatValue());
	x.multiply(y);

	System.out.println(y.numerator + "," + y.denominator + "," + y.number);

	z.divide(y);

	System.out.println(y.numerator + "," + y.denominator + "," + y.number);
	System.out.println(x.compareTo(z));
	System.out.println(z.compareTo(y));
	System.out.println(y.compareTo(y));
	System.out.println(gcdstatic(100,4));
	System.out.println(gcdstatic(125,5));


	Rational bb = new Rational(1,2);
	Rational aa = new Rational(2,4);

	System.out.println(aa.equals(bb));
    }
}
