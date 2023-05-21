package InputOutput;

import java.io.*;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        try {
            Scanner input = new Scanner(System.in);


            System.out.println("Enter the input file name : ");

            File inputFile = new File(input.next());

            if (inputFile.createNewFile()) {
                System.out.println("File created : " + inputFile.getName());
            }
            else {
                System.out.println("File already exists! ");
            }

            System.out.println("Enter output file name : ");

            File outputFile = new File(input.next());

            while(outputFile.exists()){

                System.out.println("File already exits,  To Overwrite the file press 1 else 0");

                int permit= input.nextInt();

                if(permit==1){
                    outputFile.createNewFile();
                    break;
                }

                else if(permit==0){
                    System.out.println("File not overwritten!! please enter a different name");
                    String file=input.next();
                    outputFile = new File(file);
                }
            }

            System.out.println("Enter the number of entries : ");

            int entries = input.nextInt();

            FileWrite filewrite = new FileWrite(inputFile.getName(), outputFile.getName(), entries);

            filewrite.writeInputFile();

            System.out.println("Average of the age is : " + CalculateAverage.calculateAverage(inputFile, entries));

            filewrite.writeToOutputFile();
        }
        catch (IOException e)
        {
            System.out.println("File creation interrupted abruptly!");
            }
        }
    }

