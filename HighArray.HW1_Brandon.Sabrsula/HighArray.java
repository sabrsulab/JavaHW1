//highArray.java
//demonstrates array class with high-level interface
//to run this program: C>java HighArrayApp
///////////////////////////////////////////////////////////////////
//highArray.java
class HighArray {
    private long[] a;                 // ref to array a
    private int nElems;               // number of data items

    public HighArray(int max)         // constructor
    {
        a = new long[max];                 // create the array
        nElems = 0;                        // no items yet
    }
//-----------------------------------------------------------------
    public void insert(long value)    // put element into array
    {
        a[nElems] = value;             // insert it
        nElems++;                      // increment size
    }

//-----------------------------------------------------------------
    public boolean removeMin(long value)
    {
      int j;
      for(j=0; j<nElems; j++) // look for it
        if( value == a[j] )
        break;
      if(j==nElems) // can't find it
        return false;
      else // found it
      {
        for(int k=j; k<nElems; k++) // move higher ones down
          a[k] = a[k+1];
        nElems--; // decrement size
        return true;
}
} // end delete()
//-----------------------------------------------------------
    public long getMin() {
        if (nElems == 0) {
            return -1;
        } else {
            long min = a[0];
            for (int i = 0; i < nElems; i++) {
                if (a[i] < min) {
                    min = a[i];
                }
            }
            return min;
        }
    }
//--------------------------------------------------------------------
    public void display()             // displays array contents
    {
        for (int j = 0; j < nElems; j++)       // for each element,
            System.out.print(a[j] + " "); // display it
        System.out.println(" ");
    }
//--------------------------------------------------------------------
    public static void main(String[] args) {
        int maxSize = 100;            // array size
        HighArray arr;                // reference to array
        
        System.out.println("These are the numbers generated into the array:");
        arr = new HighArray(maxSize); // create the array
        arr.insert(77);               // insert 10 items
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(66);
        arr.insert(00);
        arr.insert(33);
        
        arr.display();                // display items

        System.out.println("Current min is " + arr.getMin() + ".");
        arr.removeMin(arr.getMin());               // remove lowest item
        arr.display();                // display items again

        System.out.println("Minimum number in array after removal is " + arr.getMin() + ".");
    } // end main()
}