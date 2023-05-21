package InputOutput;

import java.io.*;
import java.util.Scanner;

class FileWrite {
    private String filename;
    private String outputFile;
    private Integer entries;

    public FileWrite(String filename, String outputFile, Integer entries) {
        this.filename = filename;
        this.outputFile = outputFile;
        this.entries = entries;
    }


    public void writeInputFile() throws IOException {
        Scanner scanner = new Scanner(System.in);

        FileWriter inputWriter = new FileWriter(filename);

        for (int index = 0; index < entries; index++) {

            System.out.println("Enter the name : ");

            String name = scanner.next();

            System.out.println("Enter the age : ");

            int age = scanner.nextInt();

            inputWriter.write(name + ", " + age + "\n");
        }
        inputWriter.close();
    }


    public void writeToOutputFile() {

        try {

        FileReader fileReader = new FileReader(filename);

        BufferedReader readInputFile = new BufferedReader(fileReader);

        FileWriter outputWriter = new FileWriter(outputFile);

        String line;
            while ((line = readInputFile.readLine()) != null) {
                line = line.replaceAll(",", "(");
                line = line.concat(") \n");
                outputWriter.write(line);
            }
            outputWriter.close();
        }

        catch (FileNotFoundException exception)
        {
            System.out.println("File does not exists!");
        }

        catch (IOException exception)
        {
            System.out.println("IO exception occurred!");
        }

        }
    }




