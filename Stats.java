/*Andy Liang
  APCS1 pd05
  HW17 -- GCD Three Ways
  2015-10-18*/

public class Stats{
    public static int mean(int a, int b){ //method for finding the mean between two integers
	return (a + b) / 2; //returning the answer after using the formula for mean
    }
    public static double mean(double a, double b){ //method for finding the mean between two doubles
	return (a + b) / 2; //returning the answer after using the formula for mean
    }
    public static int max(int a, int b){ //method for finding the bigger number between two integers
	if (a > b){ //boolean expression if a is greater than b
	    return a; //return a if a is greater than b
	}
	else{
	    return b; //return b if b is greater than a
	}
    }
    public static double max(double a, double b){ //method for finding the bigger number between two doubles
	if (a > b){ //boolean expression if a is greater than b
	    return a; //return a if a is greater than b
	}
	else{
	    return b; //return b if b is greater than a
	}
    }
    public static int geoMean(int a, int b){ //method for finding the geometric mean between two integers
	return (int)Math.sqrt(a * b); //returns the rounded integer version of the geometric mean since the method expects an integer 
    }
    public static double geoMean(double a, double b){ //method for finding the geometric mean between two doubles
	return Math.sqrt(a * b); // returns the geometric mean
    }
    public static double max(double a, double b, double c){// method for finding the biggest of three doubles
	if (a > b){//first boolean test
	    if (a > c){//second boolean test
		return a; //if a is bigger than b and c, then it's the largest double
	    }
	    else{
		return c; //if a is bigger than b, but not bigger than c, then c is the biggest double
	    }
	}
	else{
	    if (b > c){//third boolean test
		return b; //if b is greater than a and c, then it's the biggest double
	    }
	    else{
		return c; //if b is greater than a, but less than c, then c is the biggest double
	    }
	}
    }
    public static int geoMean(int a, int b, int c){
	return (int)Math.pow(a + b + c, 1/3); //uses method pow from class Math
	                                      //also converts to int to satisfy method output requirements
    }
    public static double geoMean(double a, double b, double c){
	return Math.pow(a + b + c, 1/3); //uses method pow from class Math
    }

    /*public static int gcdER(int a, int b){
      if(a > b){
          if (a % b == 0){
	  return b;
	      }
	          else{
		  return gcdER(a % b, b);
		      }
		      }
		      else{
		          if( b % a == 0){
			  return a;
			      }
			          else{
				  return gcdER(a , b % a);
				      }
				      }
    }
    public static int gcd(int a, int b){
    if (a % b == 0 &&
        b % a == 0){
	    return a;
	    }
	    if(a > b){
	        int gcDenom = b;
		    while (a % gcDenom != 0 ||
		       b % gcDenom != 0){
		       gcDenom -= 1;
		           }
			       return gcDenom;
}
else{
    int gcDenom = a;
    while (b % gcDenom != 0 ||
	a % gcDenom != 0){
    gcDenom -= 1;
}
    return gcDenom;
}
}
    
    public static void main(String[] args){
    System.out.println(gcd(32,24));
    System.out.println(gcd(24,32));
    System.out.println(gcd(11,7));
    System.out.println(gcd(7,11));
    System.out.println(gcdER(32,24));
    System.out.println(gcdER(24,32));
    System.out.println(gcdER(11,7));
    System.out.println(gcdER(7,11));
}*/
    //smallest of given numbers
    public static int min(int a, int b){//using integer inputs
	if (a < b) return a;
	return b;
    }

    public static double min(double a, double b){//using integer inputs
	if (a < b) return a;
	return b;
    }

    //using while, using bruteforce method
    public static int gcd(int a, int b){
	if (a == b) return a;
	int greater = max(a,b);
	int smaller = min(a,b);
	int GCD = smaller;
	while (greater%GCD != 0 || smaller%GCD != 0){
	    GCD -= 1;
	}
	return GCD;
    }
    
    /*SUMMARIZING OUR EUCLID ALGORITHM
      1. Divide the greater number by the smaller number, keep track of the remainder.
      2. Divide the smaller number by the remainder, keep track of the remainder.
      3. Repeat until the remainder becomes 0 and the GCD will be the smaller number that is divided to yield 0.
      EX:
      210/45 = 4 R 30
      45/30 = 1 R 15
      30/15 = 2 R 0
      Therefore the GCD is 15
    */

    //using recursion for Euclid's algorithm
    public static int gcdER(int a, int b){
	if (a == b) return a;
	int greater = max(a,b);
	int smaller = min(a,b);
	if (greater%smaller == 0) return smaller;
	else {
	    return gcdER(smaller,greater%smaller);
	}
    }

    //using while for  Euclid's algorithm
    public static int gcdEW(int a, int b){
	if (a == b) return a;
	int greater = max(a,b);
	int smaller = min(a,b);
	int GCD = smaller;
	while (greater%GCD != 0 || smaller%GCD != 0){
	    GCD = greater%smaller;
	    greater = smaller;
	}
	return GCD;
    }
    

    public static void main(String[] args){
	System.out.println(gcd(12,10)); //2
	System.out.println(gcd(5,5)); //5
	System.out.println(gcd(12,36)); //12
	System.out.println();
	
	System.out.println(gcdER(12,10)); //2
	System.out.println(gcdER(5,5)); //5
	System.out.println(gcdER(12,36)); //12
	System.out.println();
	
	System.out.println(gcdEW(12,10)); //2
	System.out.println(gcdEW(5,5)); //5
	System.out.println(gcdEW(12,36)); //12
    }
}
