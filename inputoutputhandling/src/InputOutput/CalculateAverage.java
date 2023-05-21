package InputOutput;

import java.io.*;

class CalculateAverage {

    public static double calculateAverage(File filename, Integer entries ) throws IOException {

        BufferedReader readFile = null;
        try {
            FileReader fileReader = new FileReader(filename);
            readFile = new BufferedReader(fileReader);
        }
        catch(Exception catchException) {
        catchException.printStackTrace();
        }
            int ageOfsum = 0;
            String data;
            while ((data = readFile.readLine()) != null) {
                String[] details = data.split(",");
                String name = details[0].trim();
                int age = Integer.parseInt(details[1].trim());
                ageOfsum += age;
            }
            double average = ageOfsum / entries;
            return average;
        }
    }


