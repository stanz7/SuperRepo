//Stanley Zeng and Leith Conybeare
//APCS1 pd 5
//HW44 This or That or Fourteen Other Things
//2015 - 12 - 08
public class Hexadecimal {
    private final static String HEXDIGITS = "0123456789ABCDEF";
    private String _hexNum;
    private int _decNum;
    
    public Hexadecimal() {
	_hexNum = "0";
	_decNum = 0;
    }

    public Hexadecimal( int n ) {
	_hexNum = decToHex( n );
	_decNum = n;
    }

    public Hexadecimal( String s ) {
	_hexNum = s;
	_decNum = hexToDec( s );
    }

    public String toString() {
	return _hexNum;
    }

    
    /*=========================
      String decToHex( int n ) -- converts base 10 to base 16, iteratively
      pre: n >= 0;
      post: returns String of bits;
      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
      1. Divide the decimal number by 16. Treat the division as an integer division.
      2. Write down the remainder (in hexadecimal).
      3. Divide the result again by 16. Treat the division as an integer division.
      4. Repeat step 2 and 3 until result is 0.
      5. The hex value is the digit sequence of the remainders from the last to first.
      =========================*/
    public static String decToHex( int n ) {
	String ret = "";
	if( n == 0 )
	    return "0";
	else {
	    while( n > 0 ) {
        
		//the new hexdig = char at index of HEXDIGITS at the remainder
		ret = HEXDIGITS.substring(n%16,n%16 + 1 ) + ret; 
		n /= 16;
	    }
	}
	return ret;
	
    }

    
    /*=========================
      String hexToDec( int n ) -- converts base 16 to base 10, iteratively
      pre: n >= 0;
      post: returns String of bits;
      =========================*/
    public static int hexToDec( String s ) {
	int x = 0;
	for( int i = 0; i < s.length(); i++ ) {
	    char c = s.charAt( i );
	    int d = HEXDIGITS.indexOf( c );
	    x = 16 * x + d;
	}
	return x;
    }

    public static String decToHexR( int n ) {

	String ret; //because declared but not initialized, not changed
	
	if( n == 0 )
	    ret = "0";
	else if( n == 1 )
	    ret = "1";
	else
	    ret = decToHex( n / 16 ) + n % 16; //string rep of int
	return ret;

    }
    public static int hexToDecR( String s ) { 

	int n = Integer.parseInt(s);
	if( n == 0 )
	    return 0;
	return 16 * hexToDecR( "" + n/10 ) + n%10;
	
    }

    public boolean equals( Object other ) {
	
        Hexadecimal otherHex = ( Hexadecimal )( other );
	if( this.compareTo( otherHex ) == 0 ) {
	    return true;
	}
	else {
	    return false;
	}
    }
    public int compareTo( Object other ) {

	Hexadecimal otherHex = (Hexadecimal)(other);
	int dif = this._decNum - otherHex._decNum;
	if (dif > 0) {
	    return 1;
	}
	else if (dif == 0) {
	    return 0;
	}
	else {
	    return -1;
	}
	
    }

    
    public static void main( String[] args ) {

	System.out.println();
	System.out.println( "Testing ..." );

	Hexadecimal b1 = new Hexadecimal(5);
	Hexadecimal b2 = new Hexadecimal(5);
        Hexadecimal b3 = b1;
        Hexadecimal b4 = new Hexadecimal(7);

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
	System.out.println( decToHexR(5));
	System.out.println( hexToDecR("5"));
    }
    

}
