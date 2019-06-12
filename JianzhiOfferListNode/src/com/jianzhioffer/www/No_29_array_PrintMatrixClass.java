package com.jianzhioffer.www;

import java.util.ArrayList;

public class No_29_array_PrintMatrixClass {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
    	ArrayList<Integer> arglist = new ArrayList<>();
    	
        if (matrix == null || matrix.length == 0) {
        	return arglist;
        }
        
        int rowStart = 0;
        int rowEnd = matrix.length - 1;
        int colStart = 0;
        int colEnd = matrix[0].length - 1;
        int totalCount = (rowEnd + 1) * (colEnd + 1);
        int count = 0;
        
        while (count < totalCount) {
        	for (int i = colStart; i <= colEnd && count < totalCount; i++) {
        		arglist.add(matrix[rowStart][i]);
        		count++;
        	}
        	
        	for (int i = rowStart + 1; i <= rowEnd && count < totalCount ; i++) {
        		arglist.add(matrix[i][colEnd]);
        		count++;
        	}
        	
        	for (int i = colEnd - 1; i >= colStart && count < totalCount; i--) {
        		arglist.add(matrix[rowEnd][i]);
        		count++;
        	}
        	
        	for (int i = rowEnd - 1; i > rowStart && count < totalCount; i--) {
        		arglist.add(matrix[i][colStart]);
        		count++;
        	}
        	
        	rowStart++;
        	rowEnd--;
        	colStart++;
        	colEnd--;
        }
        
        return arglist;
    }
}
