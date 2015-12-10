

//skeleton file for class Binary

public class Binary implements Comparable {

    private int _decNum;
    private String _binNum;


    /*=====================================
            default constructor
	          pre:  n/a
		        post: initializes _decNum to 0, _binNum to "0"
			=====================================*/
    public Binary() {
	_decNum = 0;
	_binNum = "0";
    }


    /*=====================================
            overloaded constructor
	          pre:  n >= 0
		        post: sets _decNum to n, _binNum to equiv string of bits
			=====================================*/
    public Binary( int n ) {
	_decNum = n;
	_binNum = decToBin(n);
    }


    /*=====================================
            overloaded constructor
	          pre:  s is String representing non-negative binary number
		        post: sets _binNum to input, _decNum to decimal equiv
			=====================================*/
    public Binary( String s ) {
	try{	
	    _decNum = binToDec(s);
	    _binNum = s;
	}
	catch (NullPointerException e){
	    System.out.println("null");
	}
    }


    /*=====================================
            String toString() -- returns String representation of this Object
	          pre:  n/a
		        post: returns String of 1's and 0's representing value of this Object
			=====================================*/
    public String toString() {
	return _binNum;
    }


    /*=====================================
            String decToBin(int) -- converts base-10 input to binary
	          pre:  n >= 0
		        post: returns String of bits
			      eg  decToBin(0) -> "0"
			            decToBin(1) -> "1"
				          decToBin(2) -> "10"
					        decToBin(3) -> "11"
						      decToBin(14) -> "1110"
						      =====================================*/
    public static String decToBin( int n ) {

	String ret = "";
	if( n == 0 )
	    return "0";
	else {
	    while( n > 0 ) {
		ret = n % 2 + ret;
		n /= 2;
	    }
	}
	return ret;
    }


    /*=====================================
            String decToBinR(int) -- converts base-10 input to binary, recursively
	          pre:  n >= 0
		        post: returns String of bits
			      eg  decToBinR(0) -> "0"
			            decToBinR(1) -> "1"
				          decToBinR(2) -> "10"
					        decToBinR(3) -> "11"
						      decToBinR(14) -> "1110"
						      =====================================*/

    public static String decToBinR( int n ) {

	String ret; //because declared but not initialized, not changed

	if( n == 0 )
	    ret = "0";
	else if( n == 1 )
	    ret = "1";
	else
	    ret = decToBin( n / 2 ) + n % 2; //string rep of int
	return ret;

    }


    /*=====================================
            String binToDec(String) -- converts base-10 input to binary
	          pre:  s represents non-negative binary number
		        post: returns String of bits
			      eg
			            binToDec("0") -> 0
				          binToDec("1") -> 1
					        binToDec("10") -> 2
						      binToDec("11") -> 3
						            binToDec("1110") -> 14
							          =====================================*/

    public static int binToDec( String s ) {

	int decVal = 0;
	int placeVal=0;

	//iterate L->R, adding each digit*place value
	try{
	    for( int i=0; i < s.length(); i++ ) {
		placeVal = s.length() - 1 - i;
		decVal += Integer.parseInt( s.substring(i,i+1) )
		    * Math.pow(2,placeVal);
	    }
	}
	catch (NullPointerException e){
	    System.out.println("Null!");
	}
	    
	    return decVal;
	}



    /*=====================================
            String binToDecR(String) -- converts base-10 input to binary, recursively
	          pre:  s represents non-negative binary number
		        post: returns String of bits
			      eg
			            binToDecR("0") -> 0
				          binToDecR("1") -> 1
					        binToDecR("10") -> 2
						      binToDecR("11") -> 3
						            binToDecR("1110") -> 14
							    =====================================*/

    public static int binToDecR( String s ) {

	int n = Integer.parseInt(s);
	try{
	if( n == 0 )
	    return 0;
	}
    
    catch (NullPointerException e) {
	System.out.println("null");
    }
	return 2 * binToDecR( "" + n/10 ) + n%10;

    }


    /*=============================================
            boolean equals(Object) -- tells whether 2 Objs are equivalent
	          pre:  other is an instance of class Binary
		        post: Returns true if this and other are aliases (pointers to same
			      Object), or if this and other represent equal binary values
			      =============================================*/
    public boolean equals( Object other ) {

	Binary otherbin = (Binary)(other);
	if (this.compareTo(otherbin) == 0) {
	    return true;
	}
	else {
	    return false;
	}

    }


    /*=============================================
            int compareTo(Object) -- tells which of two Binary objects is greater
	          pre:  other is instance of class Binary
		        post: Returns 0 if this Object is equal to the input Object,
			      negative integer if this<input, positive integer otherwise
			      =============================================*/
    public int compareTo( Object other ) {
	if (! ( other instanceof Binary) ) {
	    throw new ClassCastException( "\nMy first error message!" + "compareTo() input not a Binary.");
	}
	if (this.equals((Binary)other)) {
	    return 0; }
	else if (this._decNum < ((Binary)other)._decNum) {
	    return -1; }
	else return 1;
    }
    
     


    //main method for testing
    public static void main( String[] args ) {

	System.out.println();
	System.out.println( "Testing ..." );

	Binary b1 = new Binary(5);
	Binary b2 = new Binary(5);
	Binary b3 = b1;
	Binary b4 = new Binary(7);

	System.out.println( b1 );
	System.out.println( b2 );
	System.out.println( b3 );
	System.out.println( b4 );

	System.out.println( "\n==..." );
	System.out.println( b1 == b2 ); //should be false
	System.out.println( b1 == b3 ); //should be true

	System.out.println( "\n.equals()..." );
	System.out.println( b1.equals(b2) ); //should be true
	System.out.println( b1.equals(b3) ); //should be true
	System.out.println( b3.equals(b1) ); //should be true
	System.out.println( b4.equals(b2) ); //should be false
	System.out.println( b1.equals(b4) ); //should be false

	System.out.println( "\n.compareTo..." );
	System.out.println( b1.compareTo(b2) ); //should be 0
	System.out.println( b1.compareTo(b3) ); //should be 0
	System.out.println( b1.compareTo(b4) ); //should be neg
	System.out.println( b4.compareTo(b1) ); //should be pos

    }//End main()

 //end class
