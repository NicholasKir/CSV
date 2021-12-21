import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.*;

/**
 * Main class for work demonstration.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Enter the way to CSV file : ");
        Scanner console = new Scanner(System.in);
        String path = console.nextLine();
        String separator = ";"; //444
        List <Person> companyList = new LinkedList<>();
        try (InputStream in = Main.class.getClassLoader().getResourceAsStream(path)){

            CSVReaderBuilder csvReaderBuilder = new CSVReaderBuilder(new FileReader(path));
            CSVReader csvReader = csvReaderBuilder.withSkipLines(1).build();

            if (csvReader == null)
                throw new FileNotFoundException(path);
            String[] nextLine;
            while ((nextLine = csvReader.readNext()) != null){
                nextLine = nextLine[0].split(separator);
                if(nextLine.length > 2){
                    Person person = new Person(nextLine[0], nextLine[1], nextLine[2], nextLine[3], nextLine[4].charAt(0) - 'A', nextLine[4], nextLine[5]);
                    companyList.add(person);
                }
            }

            System.out.println("Input the count of values : ");
            int size = console.nextInt();
            System.out.print("При вводе неправильного значения, например, отрицательного, ");
            System.out.println("будут выведены все элементы списка.");

            if(size > 0) {
                System.out.println("Id\t\tName\tGender  Division Birthday   Salary");
                for (int i = 0; i < companyList.size() && i < size; i++)
                {
                    System.out.print(companyList.get(i).getID()+"\t");
                    System.out.print(companyList.get(i).getName()+"\t");
                    System.out.print(companyList.get(i).getGender()+"\t");
                    System.out.print(companyList.get(i).getBirthDate()+"\t");
                    System.out.print(companyList.get(i).getSubdivisionID()+"\t");
                    System.out.print(companyList.get(i).getSubdivisionName()+"\t");
                    System.out.print(companyList.get(i).getSalary()+"\t");
                    System.out.print("\n");
                }

                System.out.println("\nВывод при помощи toString(): ");
                for (int i = 0; i < companyList.size() && i < size; i++) {
                    System.out.println(companyList.get(i).toString());
                }
            }
            else {
                System.out.println("Incorrect type!");
            }
        }
        catch(FileNotFoundException except) {
            System.out.println("Incorrect way to file!");
        }


    }
}