package support;

import com.opencsv.bean.CsvToBeanBuilder;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadAndExtractCsv {
    //Read input file and returning string
    public static String readInput(String filename) {
        String inputText = null;
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            try {
                StringBuilder sb = new StringBuilder();
                String line = br.readLine();
                while (line != null) {
                    sb.append(line);
                    sb.append(System.lineSeparator());
                    line = br.readLine();
                }
                inputText = sb.toString();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                br.close();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inputText;
    }

    //Regex for uk license plate
    public static List<String> regNumberList() {
        String filename = "src/test/java/testData/car_input.txt";
        String inputSeq = readInput(filename);
        Pattern pattern = Pattern.compile("([A-Z]{2}[0-9]{2}[A-Z]{3})|([A-Z]{2}[0-9]{2} [A-Z]{3})|([A-Z][0-9]{1,3} [A-Z]{3})|([A-Z]{3} [0-9]{1,3}[A-Z])|([0-9]{1,4} [A-Z]{1,2})|([0-9]{1,3} [A-Z]{1,3})|([A-Z]{1,2} [0-9]{1,4})|([A-Z]{1,3} [0-9]{1,3})");
        Matcher matcher = pattern.matcher(inputSeq);
        List<String> reg = new ArrayList<String>();
        while (matcher.find()) {
            reg.add(matcher.group());
        }
        return reg;
    }

    //Car output file read and parse
    public static List<Car> vehicleInfo() {
        List<Car> cars = new ArrayList<>();
        try {
            String fileName = "src/test/java/testData/car_output.txt";
            cars = new CsvToBeanBuilder(new FileReader(fileName)).withType(Car.class).build().parse();
            cars.remove(0);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return cars;
    }
}
