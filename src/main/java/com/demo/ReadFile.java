package com.demo;

import java.util.Collections;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

public class ReadFile {
	private static final String FILENAME = "C:\\Users\\'la\\Desktop\\unsorted-name-list.txt"; //source disesuaikan
	public void sortLast(ArrayList<String> al) {
		Collections.sort(al, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				String[] split1 = o1.split(" ");
				String[] split2 = o2.split(" ");
				String lastName1 = split1[split1.length - 1];
				String lastName2 = split2[split2.length - 1];
				if (lastName1.compareTo(lastName2) > 0) {
					return 1;
				} else {
					return -1;
				}
			}
		});
		System.out.println(al);
	}

	public static void main(String[] args) {
		BufferedReader br = null;
		FileReader fr = null;
		ArrayList<String> rows = new ArrayList<String>();
		try {
			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);
			String sCurrentLine;
			while ((sCurrentLine = br.readLine()) != null) {
				rows.add(sCurrentLine);
			}
			Collections.sort(rows);
			ReadFile i = new ReadFile();
			System.out.println("Sorted using Last Name");
			i.sortLast(rows);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
				if (fr != null)
					fr.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}
