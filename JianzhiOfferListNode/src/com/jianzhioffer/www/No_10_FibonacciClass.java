package com.jianzhioffer.www;

public class No_10_FibonacciClass {
    public int Fibonacci(int n) {
//        if (n == 0) {
//        	return 0;
//        }
//        
//        if (n <= 2) {
//            return 1;
//        }
//        
//        return Fibonacci(n - 1) + Fibonacci(n - 2);
    	
    	if (n == 0) {
    		return 0;
    	}
    	
    	int one = 1;
    	int two = 1;
    	int fib = one;
    	
    	for (int i = 3; i <= n; i++) {
    		fib = one + two;
    		
    		one = two;
    		two = fib;
    	}
    	
    	return fib;

    }
}
