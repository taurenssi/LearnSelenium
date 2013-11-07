package com.lohika.seleniumtool;

import java.io.*;

public class Config {

	public String name = "";
	public String pass = "";
	
	public Config(String file){
		System.out.println("Loading configuration data from " + file);
		try{
			loadCredentials(file);
			System.out.println("Configuration data is loaded successfully");
		}
		catch (IOException e){
			System.out.println("ERROR: Error while loading config from " + file + "\n" + e.toString());
		}
	}
	
	public void makeInvalidData(){
		name = "! " + name;
		pass = pass.replaceAll("//w", "1") + "0";
	}
	
	private void loadCredentials(String file) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader(file)); 
		name = in.readLine();
		pass = in.readLine();
		in.close(); 
	}
}

