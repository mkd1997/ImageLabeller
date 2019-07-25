package com.imagelabeller.backend;

import java.io.File;
import java.util.*;

public class SizeComparator implements Comparator<File> {
    @Override
    public int compare(File f1, File f2) {
        return (int)(f1.length() - f2.length());
    }
}