package com.jianzhioffer.www;

public class No_16_math_PowerClass {
    public double Power(double base, int exponent) {
        if (base == 0 && exponent < 0) {
        	throw new RuntimeException("分母不能为0"); 
        }
        
        if (exponent < 0) {
        	base = 1.0d / base;
        	exponent = Math.abs(exponent);
        }
        
        double result = 1.0d;
        
        for (int i = 0; i < exponent; i++) {
        	result *= base;
        }
        
        return result;       
  }
}
