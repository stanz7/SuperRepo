//Team CandyWrapper - Shariar Kabir, Stanley Zeng
//APCS1 PD5
//HW #40: Array of Grade 316
//2015-12-1

/*****************************
 * SKELETON for
 * class SuperArray --  A wrapper class for an array. 
 * Maintains functionality:
 *  access value at index
 *  overwrite value at index
 *  report number of meaningful items
 * Adds functionality to std Java array:
 *  resizability
 *  ability to print meaningfully
 *  add item (at end)
 *  insert item
 *  remove item (while maintaining "left-justification")
 *****************************/

public class SuperArray implements ListInt{
  
    //~~~~~INSTANCE VARS~~~~~
    //underlying container, or "core" of this data structure:
    private int[] _data;
  
    //position of last meaningful value
    private int _lastPos;
  
    //size of this instance of SuperArray
    private int _size;
  
  
    //~~~~~METHODS~~~~~
    //default constructor â€“ initializes 10-item array
    public SuperArray() 
    { 
	_data = new int[10];
	_lastPos = -1; //flag to indicate no lastpos yet
	_size = 0; 
    }
  
  
    //output array in [a,b,c] format, eg
    // {1,2,3}.toString() -> "[1,2,3]"
    public String toString() 
    { 
	String foo = "[";
	for( int i = 0; i < _size; i++ ) {
	    foo += _data[i] + ",";
	}
	//shave off trailing comma
	if ( foo.length() > 1 )
	    foo = foo.substring( 0, foo.length()-1 );
	foo += "]";
	return foo;
    }
  
  
    //double capacity of this SuperArray
    private void expand() 
    { 
	int[] temp = new int[ _data.length * 2 ];
	for( int i = 0; i < _data.length; i++ )
	    temp[i] = _data[i];
	_data = temp;
    }
  
  
    //accessor -- return value at specified index
    public int get( int index ) { return _data[index]; }
  
  
    //mutator -- set value at index to newVal, 
    //           return old value at index
    public int set( int index, int newVal ) 
    { 
	int temp = _data[index];
	_data[index] = newVal;
	return temp;
    }
  
  
    // ~~~~~~~~~~~~~~ PHASE II ~~~~~~~~~~~~~~
    //adds an item after the last item
    public int add( int o ) { //After the last meaningful index it adds it
	_lastPos+=1;
	_data[_lastPos]= o;
    
    
	return size();
    }
  
  
    //inserts an item at index
    //shifts existing elements to the right
    public int add( int i, int o ) { //Adds in the index, has boolean value to see if it has changed a val
	int[] tempora = new int[_data.length + 1];
	boolean done = false;
	for (int x =0; x < _data.length  ; x++){
	    if (x!=i){tempora[x]=_data[x];}
	    else if (x == i && done == false){
		tempora[i]=o;
		x-=1;
		done = true;       
	    }
	}
	_data=tempora;
	return size(); 
    }
  
  
    //removes the item at index
    //shifts elements left to fill in newly-empted slot
    public int remove( int i ) { //It removes it, but resets x and then adds the rest back. 
	int[] tempora = new int[_data.length];
	if (_data[i]!=0){
	    _size-=1;
    
	}
	for (int x = 0; x < _data.length  ; x++){
	    if (x != i){
		tempora[x]=_data[x];
       
	    }
	    else if(x == i){
		if (x == _data.length-1){
		    tempora[x]=0;
        
		}
		else{
		    tempora[x]=_data[x+1]; 
		    x+=1;}
	    }
      
	}
    
	tempora[tempora.length-1]=0; //Changes last index to 0
	_data=tempora;
	return size();
    
    
    }
  
  
    //return number of meaningful items in _data
    public int size() {  //returns all non 0 ints
	_size=0;
	for (int x = 0 ; x < _data.length ; x++){
	    if (_data[x] != 0){
		_size+=1;
	    }
	    else{}
	}
	return _size;
    
    
    }

  
    //main method for testing
    public static void main( String[] args ) 
    {
	SuperArray curtis = new SuperArray();
	System.out.println("Printing empty SuperArray curtis...");
	System.out.println(curtis);
    
	for( int i = 0; i < curtis._data.length; i++ ) {
	    curtis.set(i,i*2);
	    curtis._size++; //necessary bc no add() method yet
	}
    
	System.out.println("Printing populated SuperArray curtis...");
	System.out.println(curtis);
    
	System.out.println("testing get()...");
	for( int i = 0; i < curtis._size; i++ ) {
	    System.out.print( "item at index" + i + ":\t" );
	    System.out.println( curtis.get(i) );
	}
    
	System.out.println("Expanded SuperArray curtis:");
	curtis.expand();
	System.out.println(curtis);
    
   
	SuperArray mayfield = new SuperArray();
	System.out.println("Printing empty SuperArray mayfield...");
	System.out.println(mayfield);

	mayfield.add(5);
     
	mayfield.add(4);
	mayfield.add(3);
	mayfield.add(2);
	mayfield.add(1);
     
     
	System.out.println("Printing populated SuperArray mayfield...");
	System.out.println(mayfield);
    
     
	mayfield.remove(3);
      
	System.out.println("Printing SuperArray mayfield post-remove...");
	System.out.println(mayfield);
	mayfield.remove(3);
	System.out.println("Printing SuperArray mayfield post-remove...");
	System.out.println(mayfield);
     
	mayfield.add(3,99);
	for (int x = 0 ; x< mayfield._data.length ; x++){ //Just to test for myself
	    System.out.print(mayfield.get(x)+" ");
     
	}
	System.out.println("Printing SuperArray mayfield post-insert...");
	System.out.println(mayfield);
	mayfield.add(2,88);
	System.out.println("Printing SuperArray mayfield post-insert...");
	System.out.println(mayfield);
	mayfield.add(1,77);
	System.out.println("Printing SuperArray mayfield post-insert...");
	System.out.println(mayfield);

    }//end main
  
}//end class
