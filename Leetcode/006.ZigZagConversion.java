package Leetcode;

import java.util.ArrayList;
import java.util.List;
/**
 * @author xiangfeidong
 *
 * 6. ZigZag Conversion
 *
 * Keep a list for each row in zigzag.
 * Keep a pointer swing between 0 ~ numRows-1
 * Go through each character of the string, add each character to a row.
 */
public class ZigZagConversion {
    public String convert(String s, int numRows) {
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
}
