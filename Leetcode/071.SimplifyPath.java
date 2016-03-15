package Leetcode;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class SimplifyPath {
    //Solution 1
    public String simplifyPath1(String path) {
        //Store all directories into a list, including "." and ".."
        List<String> directories = new LinkedList<>();
        for (String s : path.split("/")) {
            if (!s.trim().isEmpty()) {
                directories.add(s);
            }
        }

        //Delete redundant directories.
        int i = 0;
        while (i < directories.size()) {
            if (directories.get(i).equals(".")) {
                directories.remove(i);
            } else if (directories.get(i).equals("..")) {
                directories.remove(i);
                //Check if there prevoius directory before this ".."
                if (i != 0) {
                    directories.remove(--i);
                }
            } else {
                i++;
            }
        }

        //Convert valid directories to a string.
        StringBuilder sb = new StringBuilder();
        for (String directory : directories) {
            sb.append("/").append(directory);
        }

        return sb.length() == 0 ? "/" : sb.toString();
    }

    //Solution 2: Use a deque.
    public String simplifyPath2(String path) {
        //cannot use Stack because stack iterator will not iterate in order
        Deque<String> deque = new LinkedList<>();
        Set<String> skip = new HashSet<>(Arrays.asList("", ".", ".."));
        for (String s : path.split("/")) {
            if (s.equals("..") && !deque.isEmpty()) {
                deque.removeLast();
            } else if (!skip.contains(s)) {
                deque.addLast(s);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String s : deque) {
            sb.append("/");
            sb.append(s);
        }

        String res = sb.toString();
        return res.isEmpty() ? "/" : res;
    }
}
