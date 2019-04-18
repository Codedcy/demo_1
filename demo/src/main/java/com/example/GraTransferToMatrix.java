package com.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

public class GraTransferToMatrix {
	private String inputPath;
	private String outputPath;
	
	public GraTransferToMatrix(String inputPath, String outputPath) {
		this.inputPath = inputPath;
		this.outputPath = outputPath;
	}
	public void tranferTo() {
		File inputFile = new File(inputPath);
		File outputFile = new File(outputPath);
		if(!outputFile.exists()) {
			outputFile.mkdir();
		}
		try {
			FileReader fr = new FileReader(inputFile);
			BufferedReader br = new BufferedReader(fr);
			FileWriter fw = new FileWriter(outputFile);
			BufferedWriter bw = new BufferedWriter(fw);
			
		} catch (Exception e) {
			e.toString();
		}
		
	}
}
