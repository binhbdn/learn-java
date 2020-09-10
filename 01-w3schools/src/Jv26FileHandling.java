/*Java File Handling:

There are many available classes in the Java API that can be used to read and write files in Java:
    FileReader,
    BufferedReader,
    Files, Scanner,
    FileInputStream,
    FileWriter,
    BufferedWriter,
    FileOutputStream, etc.
Which one to use :
    depends on the Java version you're working with
    and whether you need to read bytes or characters,
    and the size of the file/lines etc.

    The File class has many methods, for example:

    Method	            Type	        Description
    canRead()	        Boolean	        Tests whether the file is readable or not
    canWrite()	        Boolean	        Tests whether the file is writable or not
    createNewFile()	    Boolean	        Creates an empty file
    delete()	        Boolean	        Deletes a file
    exists()	        Boolean	        Tests whether the file exists
    getName()	        String	        Returns the name of the file
    getAbsolutePath()	String	        Returns the absolute pathname of the file
    length()	        Long	        Returns the size of the file in bytes
    list()	            String[]	    Returns an array of the files in the directory
    mkdir()	            Boolean	        Creates a directory
*/

import java.util.Scanner;               // Import the Scanner class to read text files
import java.io.File;                    // Import the File class
import java.io.FileWriter;              // Import the FileWriter class
import java.io.IOException;             // Import the IOException class to handle errors
import java.io.FileNotFoundException;   // Import this class to handle errors

class Jv26FileHandling {
    public static void main(String[] args) {
        System.out.println();

        // Create a File
        System.out.println("Create a File");
        try {
            /* To create a file in a specific directory (requires permission),
            specify the path of the file and use double backslashes to escape the "\" character (for Windows)
            On Mac and Linux you can just write the path, like: /Users/name/filename.txt */
            File myObj = new File("src/Jv26FileHandling-Test.java");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
                /*
                if (myObj.canExecute()) {
                    System.out.println("Testing for canExecute() method. Result: The file can be executed.");
                } else {
                    System.out.println("Testing for canExecute() method. Result: The file can NOT be executed.");
                };

                if (myObj.canRead()) {
                    System.out.println("Testing for canRead() method. Result: The file can be read.");
                } else {
                    System.out.println("Testing for canRead() method. Result: The file can NOT be read.");
                };

                if (myObj.canWrite()) {
                    System.out.println("Testing for canWrite() method. Result: The file can be written.");
                } else {
                    System.out.println("Testing for canWrite() method. Result: The file can NOT be written.");
                };

                if (myObj.exists()) {
                    System.out.println("Testing for exists() method. Result: The file exists.");
                } else {
                    System.out.println("Testing for exists() method. Result: The file DO NOT exists.");
                };

                if (myObj.isDirectory()) {
                    System.out.println("Testing for isDirectory() method. Result: The object is a Directory.");
                } else {
                    System.out.println("Testing for isDirectory() method. Result: The object is NOT a Directory.");
                };

                if (myObj.isFile()) {
                    System.out.println("Testing for isFile() method. Result: The object is a File.");
                } else {
                    System.out.println("Testing for isFile() method. Result: The object is NOT a File.");
                };

                if (myObj.isHidden()) {
                    System.out.println("Testing for isHidden() method. Result: The file is Hidden.");
                } else {
                    System.out.println("Testing for isHidden() method. Result: The file is NOT Hidden.");
                };
                */
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        System.out.println();

        // Write To a File
        System.out.println("Write To a File");
        try {
            FileWriter myWriter = new FileWriter("src/Jv26FileHandling-Test.java");
            myWriter.write("Files in Java might be tricky.\nBut it is fun enough!");
            myWriter.close();
            System.out.println("Successfully wrote to the file \"Jv26FileHandling-Test.java\".");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        System.out.println();

        // Read a File
        System.out.println("Read a File");
        try {
            File myObj = new File("src/Jv26FileHandling-Test.java");
            Scanner myReader = new Scanner(myObj);
            System.out.println("Reading from file \"" + myObj.getName() + "\":");
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        System.out.println();

        // Get File Information
        System.out.println("Get File Information");
        File myObj = new File("src/Jv26FileHandling-Test.java");
        if (myObj.exists()) {
            System.out.println("File name: " + myObj.getName());
            System.out.println("Absolute path: " + myObj.getAbsolutePath());
            System.out.println("Writeable: " + myObj.canWrite());
            System.out.println("Readable " + myObj.canRead());
            System.out.println("File size in bytes " + myObj.length());
        } else {
            System.out.println("The file does not exist.");
        }
        System.out.println();

        // Delete a File
        System.out.println("Delete a File");
        if (myObj.delete()) { 
            System.out.println("Deleted the file: " + myObj.getName());
        } else {
            System.out.println("Failed to delete the file.");
        }
        System.out.println();

        // Creates an empty Directory/Folder
        System.out.println("Creates an empty Directory/Folder");
        File myDir = new File("src/myDir");
        if (myDir.mkdir()) {
            System.out.println("Created the directory (folder) : " + myDir.getAbsolutePath());
        }
        System.out.println();

        // Delete an empty Directory/Folder
        System.out.println("Delete an empty Directory/Folder");
        if (myDir.delete()) {
            System.out.println("Deleted the directory (folder) : " + myDir.getAbsolutePath());
        }
    }
}
