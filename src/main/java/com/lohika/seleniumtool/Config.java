package com.lohika.seleniumtool;

import java.io.*;

public class Config {

	public String name = "";
	public String pass = "";
	public String url = "";
	
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
		
		String line = "";
		while ((line = in.readLine()) != null){
			String[] parameter = line.split("\\s+");
			switch (parameter[0]){
				case "Login": name = parameter[2]; break;
				case "Password": pass = parameter[2]; break;
				case "URL": url = parameter[2]; break;
			}
		}
		in.close(); 
	}
	
}
