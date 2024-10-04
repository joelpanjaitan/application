public class App {
    void start() {
            Two t  = new Two();
            System.out.print(t.x+"");
            Two t2 = fix(t);    
            System.out.println(t.x+""+t2.x);
	}
    Two fix (Two tt){
            tt.x = 42;
            return tt;
    }
    public static void main(String[] args) throws Exception {
        App p = new App();
        p.start();       
        // System.out.println((3*4)==(3<<2));
        // System.out.println(3 << 2 | 3);
        // String str1= "hello";
        // String str2 = new String("he")+new String("llo");
        // System.out.println(str1==str2);
        // System.out.println(str1.equals(str2));
        // B b = new B();
		// System.out.println("x="+b.GetResult(0,1));
        // Float f = new Float("12");
        //     switch (f){
        //         case 12: System.out.println("Twelve");
        //         case 12: System.out.println("Twelve");
        //         case 12: System.out.println("Twelve");
        //     }
        // try {
        //     aMethod();
        // }
        // catch(Exception e){
        //     System.out.println("exception");
        // }
        // System.out.println("finished");
    }
    public static void aMethod() throws Exception {
        try {
            throw new Exception();
        }
        finally{
            System.out.println("finally");
        }
    }
}

class Two {
    byte x;
}
class PassO{
        interface Base {
        boolean m1();
        byte m2(short s);
        }
        abstract class Class2 {public Boolean m1(){
        return true;
        }}
    	public static void main(String[] args) throws Exception {
            PassO p = new PassO();
            p.start();
            String a = "ABCD";
            String b = a.toLowerCase();
            b.replace('a','d');
            b.replace('b','d');
            System.out.println(b);
    	}
    	void start() {
            Two t  = new Two();
            System.out.print(t.x+"");
            Two t2 = fix(t);    
            System.out.println(t.x+""+t2.x);
	    }
        Two fix (Two tt){
            tt.x = 42;
            return tt;
        }
}


class MiniMaxSum {
    public static void miniMaxSum(long[] arr) {
          // Write your code here
        long minimumCount = arr[0];
        long maximumCount = 0;
        long totalCount = 0;
        long minTotal = 0;
        long maxTotal = 0;
        
        for (long number:arr){
            totalCount += number;
            if (minimumCount>number)  minimumCount = number;
            if (maximumCount<number) maximumCount = number;
            
        }
        maxTotal = totalCount - minimumCount;
        minTotal = totalCount - maximumCount;
        
        System.out.println(minTotal+" "+maxTotal);
    }

    public static void main(String[] args) {
        long[] arr = {396285104, 573261094, 759641832, 819230764, 364801279}; // Example input

        miniMaxSum(arr); // Call the function with the example input
    }
}

