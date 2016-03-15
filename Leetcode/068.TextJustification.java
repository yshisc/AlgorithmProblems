package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiangfeidong
 *
 * 68.Text Justification
 */
public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<String>();

        int i = 0;
        while (i < words.length) {
            int count = words[i].length();
            int j = i + 1;
            while (j < words.length && words[j].length() + count + 1 <= maxWidth) {
                count += words[j].length() + 1;
                j++;
            }

            StringBuilder builder = new StringBuilder();
            int diff = j - i - 1;
            if (j == words.length || diff == 0) {
                //Last line, just add extra spaces to end.
                for (int k = i; k < j; k++) {
                    builder.append(words[k] + " ");
                }
                builder.deleteCharAt(builder.length() - 1);
                for (int k = builder.length(); k < maxWidth; k++) {
                    builder.append(" ");
                }
            } else {
                //Not last Line.
                int spaces = (maxWidth - count) / diff;
                int longerCount = (maxWidth - count) % diff;
                for (int k = i; k < j; k++) {
                    builder.append(words[k]);
                    if (k < j - 1) {
                        for (int s = 0; s <= (spaces + ((k - i) < longerCount ? 1 : 0)); s++) {
                            builder.append(" ");
                        }
                    }
                }
            }
            res.add(builder.toString());
            i = j;
        }


        return res;
    }
}
