package frc.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import frc.robot.Constants;


public class Logger implements Constants {
	private File file;
	private FileWriter fw;
	private FileReader fr;
	private BufferedWriter bw;
	private BufferedReader br;
	private boolean fileSelected = false;
	//Restricted Files List
	private final List<File> restrictedFilesList = new ArrayList<File>();
	
	public Logger() {
		// Adding Restricted Files
		// TODO make these files on the rio
		// restrictedFilesList.add(new File(outputPath +"/README_File_Paths.txt"));
		// restrictedFilesList.add(new File(outputPath +"/crash_tracking.txt"));
	}
	
	public void createNewFile(String name) {
		File newFile = new File(outputPath +"/" + name + ".txt");
		if(newFile != null && !newFile.exists())
			try {
				newFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		else
			System.out.println("This file already exists so a new" +
					           " one will not be created.");		
	}
	
	public void deleteFile(String path) {
		File file = new File(path);
		System.out.println(file.getName());
		System.out.println(file.exists());
		if(file != null && file.exists())
			file.delete();
		System.out.println(file.exists());
	}
	
	public void writeLine(String line) {
		try {
			if(bw != null) {
				bw.write(line);
				bw.newLine();
				bw.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}			
	}
	
	public String readLine() {
		String line = "";
		try {
			if(br != null)
				line = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return line;
	}	
	
	public void changePath(String nameOrPath, boolean useFileLookup) {
		//If useFileLookup is true then it will search for the specified
		//fileName and get its path.
		//---------------------useFileLookup currently unused
		//---------------------Only pass this method (path, false) or (name, true)
		if(useFileLookup) {
			if(nameOrPath == "00000000000000000000000000000000000000000000000000000000000")
				fileSelected = false;
			else
				for(File file: new File(outputPath).listFiles())
					if(file.getName().equals(nameOrPath))
						changePath(file.getPath(), false);
		}
		else {
			file = new File(nameOrPath);	
			fileSelected = true;
		}
	}
	
	public void resetForRead() {
		if (file != null) {
			try {
				fr = new FileReader(file);
				if (fr != null) br = new BufferedReader(fr);
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}		
	}
	
	public void resetForWrite() {
		if (file != null) {
			try {
				fw = new FileWriter(file);
				if (fw != null) bw = new BufferedWriter(fw);
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}		
	}

	public File[] getFiles(String path) {
		List<File> textFiles = new ArrayList<File>();
		File dir = new File(path + "/");
		for (File file : dir.listFiles()) {
			if (file.getName().toLowerCase().endsWith((".txt")) && !fileInRestrictedList(file)) {
				textFiles.add(file);
			}
		}
		
		File[] allFiles = new File[textFiles.size()];
		for(int i = 0; i < textFiles.size(); i++)
			allFiles[i] = textFiles.get(i);
		
		return allFiles;
	}
	
	private boolean fileInRestrictedList(File file) {
		for(File f: restrictedFilesList)
			if(f.getName().toLowerCase().equals(file.getName().toLowerCase()))
				return true;
		return false;
	}
	
	public String getWorkingFile() {
		if(file != null && fileSelected)
			return file.getName();	
		else return "No File Selected";
	}
}
