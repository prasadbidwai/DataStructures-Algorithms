// A Simple Java program to show working of user defined Generic classes

// Example to show user defined generics function: 

public class Test
{
   // generic method printArray                         
   public static < E > void printArray( E[] inputArray )
   {
      // Display array elements              
         for ( E element : inputArray ){        
            System.out.printf( "%s ", element );
         }
         System.out.println();
    }

    public static void main( String args[] )
    {
        // Create arrays of Integer, Double and Character
        Integer[] intArray = { 1, 2, 3, 4, 5 };
        Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4 };
        Character[] charArray = { 'H', 'E', 'L', 'L', 'O' };

        System.out.println( "Array integerArray contains:" );
        printArray( intArray  ); // pass an Integer array

        System.out.println( "\nArray doubleArray contains:" );
        printArray( doubleArray ); // pass a Double array

        System.out.println( "\nArray characterArray contains:" );
        printArray( charArray ); // pass a Character array
    } 
}
  
// We use < > to specify Parameter type
class Test<T>
{
    // An object of type T is declared
    T obj;
    Test(T obj) {  this.obj = obj;  }  // constructor
    public T getObject()  { return this.obj; }
}
  
// Driver class to test above
class Main
{
    public static void main (String[] args)
    {
        // instance of Integer type
        Test <Integer> iObj = new Test<Integer>(15);
        System.out.println(iObj.getObject());
  
        // instance of String type
        Test <String> sObj =
                          new Test<String>("Test String");
        System.out.println(sObj.getObject());
    }
}

/*
Output:

15
Test String

*/


//We can also pass multiple Type parameters in Generic classes.

// A Simple Java program to show multiple
// type parameters in Java Generics
 
// We use < > to specify Parameter type
class Test<T, U>
{
    T obj1;  // An object of type T
    U obj2;  // An object of type U
 
    // constructor
    Test(T obj1, U obj2)
    {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }
 
    // To print objects of T and U
    public void print()
    {
        System.out.println(obj1);
        System.out.println(obj2);
    }
}
 
// Driver class to test above
class Main
{
    public static void main (String[] args)
    {
        Test <String, Integer> obj =
            new Test<String, Integer>("GfG", 15);
 
        obj.print();
    }
}


/*
Output:

15
Test String
*/

// A Simple Java program to show working of user defined Generic functions
  
class Test
{
    // A Generic method example
    static <T> void genericDisplay (T element)
    {
        System.out.println(element.getClass().getName() +
                           " = " + element);
    }
  
    // Driver method
    public static void main(String[] args)
    {
         // Calling generic method with Integer argument
        genericDisplay(11);
  
        // Calling generic method with String argument
        genericDisplay("Test String");
  
        // Calling generic method with double argument
        genericDisplay(1.0);
    }
}


/*
Output :

java.lang.Integer = 11
java.lang.String = Test String
java.lang.Double = 1.0

*/