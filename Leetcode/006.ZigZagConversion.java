package Leetcode;

import java.util.ArrayList;
import java.util.List;
/**
 * @author xiangfeidong
 *
 * 6. ZigZag Conversion
 *
 */
public class ZigZagConversion {
    /**
     * Solution 1:
     *
     * Keep a list for each row in zigzag.
     * Keep a pointer swing between 0 ~ numRows-1
     * Go through each character of the string, add each character to a row.
     *
     */
    public String convert1(String s, int numRows) {
        if (numRows == 1) { //No need for convert.
            return s;
        }

        //Init lists of row numbers.
        List<List<Character>> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new ArrayList<>());
        }

        //dicrection controls that pointer increments or decrements.
        int pointer = 0, direction = 1;
        for (int i = 0; i < s.length(); i++) {
            //Add character to relative row
            rows.get(pointer).add(s.charAt(i));
            //Change direction when pointer = 0 or numRows-1.
            if (pointer == 0) {
                direction = 1;
            } else if (pointer == numRows - 1) {
                direction = -1;
            }
            //Increment or decrement pointer.
            pointer += direction;
        }

        //convert output.
        StringBuilder sb = new StringBuilder();
        for (List<Character> row : rows) {
            for (char c : row) {
                sb.append(c);
            }
        }

        return sb.toString();
    }
    
     /**
     * Solution 2:
     *
     * Keep a list for each row in zigzag.
     * Use two loops to swing down and up.
     *
     */
    public String convert2(String s, int numRows) {
        if (numRows < 1) {
            throw new IllegalArgumentException("Number of rows should be larger than 0!");
        }
        
        final List<List<Character>> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new ArrayList<>());
        }
        
        int i = 0;
        while (i < s.length()) {
            for (int j = 0; i < s.length() && j < numRows; i++, j++) {
                rows.get(j).add(s.charAt(i));
            }
            for (int j = numRows - 2; i < s.length() && j > 0; i++, j--) {
                rows.get(j).add(s.charAt(i));
            }
        }
        
        final StringBuilder sb = new StringBuilder();
        for (final List<Character> row : rows) {
            for (final char c : row) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
