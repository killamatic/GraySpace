package todo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class Add {
	String priorityStr, string;
	static String[] holder;
	static int priority;
	static boolean first = true;
	String[] arrOfStr;
	
	public Add(){}
	String inputStr(String prompt){//prints prompt then takes user input and returns it
		Scanner input = new Scanner(System.in);
		System.out.println(prompt);
		return input.nextLine();
	}
	int inputInt(String prompt){//prints prompt then takes user input and returns it
		Scanner input = new Scanner(System.in);
		System.out.println(prompt);
		return input.nextInt();
	}
	void createFile(File file) throws IOException{//makes a file if there is not one already made
		if(file.exists()){
			System.out.println("File already exists");
		}
		else{
			file.createNewFile();
			System.out.println("File created");
		}
	}
//	Old appendFile
	void appendStringEndOfFile(File file) throws IOException{
		FileWriter fileWriter = new FileWriter(file, true);//boolean to ask if you want to append the file or not
		BufferedWriter buffer = new BufferedWriter(fileWriter);
		PrintWriter printWriter = new PrintWriter(buffer);
		printWriter.println(inputStr("What is your addition: "));
		printWriter.close();
	}
	static void addStringAfterPriority(String insertLine, int priority) {
	    try {
	    	String line;
	        int urgency;
	        BufferedReader file = new BufferedReader(new FileReader("FileRead.txt"));
	        StringBuffer inputBuffer = new StringBuffer();
	        
	        while ((line = file.readLine()) != null) {//this takes the file into the inputBuffer
	        	urgency = Integer.parseInt(line.substring(0, 1));
	        	if(urgency<= priority || (urgency > priority && !first)){
	        		inputBuffer.append(line);
	        		inputBuffer.append('\n');
	        	}
	        	else if(urgency > priority && first){//if it is after where the priority needs to go
	        		inputBuffer.append(priority + " " + insertLine + '\n');//my inserted line
	        		inputBuffer.append(line + '\n');//the line I was on already
	        		first = false;
	        	}
	        }
	        String inputStr = inputBuffer.toString();
	        file.close();
	        
	        System.out.println(inputStr); // check that it's inputted right

	        
	        
//	        // this if structure determines whether or not to replace "0" or "1"
//	        if (Integer.parseInt(intStr) == 0) {
//	            inputStr = inputStr.replace(replaceWith + "1", replaceWith + "0"); 
//	        }
//	        else if (Integer.parseInt(intStr) == 1) {
//	            inputStr = inputStr.replace(replaceWith + "0", replaceWith + "1");
//
//	        } 
//
//	        // check if the new input is right
//	        System.out.println("----------------------------------\n"  + inputStr);
//
	        // write the new String with the replaced line OVER the same file
	        FileOutputStream fileOut = new FileOutputStream("FileRead.txt");
	        fileOut.write(inputStr.getBytes());
	        fileOut.close();

	    } catch (Exception e) {
	        System.out.println("Problem reading file.");
	    }
	}
	
//	String readLineNumber(File file,int lineNum) throws FileNotFoundException{
//		String str= "";
//		try {
//			Scanner sc = new Scanner(file);
//
//			while (sc.hasNextLine()) {
//	            int curLine = sc.nextInt();
//	            if(curLine == lineNum){
//	            	str = sc.nextLine();
//	            }
//				
//	        }
//			
//	        sc.close();
//	    } 
//	    catch (FileNotFoundException e) {
//	        e.printStackTrace();
//	    }
//		return str;
//	}
	public String toString(){
		String str;
		str = "lol";
		return str;
	}
	public static void main(String[] args) throws IOException{
		Add add = new Add();
//		File file = new File(add.input("Title")); //prompt user for file
		File file = new File("LevelOneValues.txt"); //hardcode
		add.createFile(file);//should print File already exists
//		add.appendStringEndOfFile(file);
//		addStringAfterPriority("I need to feed my dog when I get home", 1);
	}
	void notes(){
		/*So I know of a bug in this program, if for any reason there is an extra line other than the one that is always there 
		 * the program will spit out a exception "can't read file"*/
	}
}
/*need to make a method to throw whats in the file to temp until it is at the point where you need to add it in, 
then add it it temp and the rest of the file, then overwrite the old file with all that data

template:
1 1
1 1
2 2
2 2
3 3
3 3
4 final
*/
