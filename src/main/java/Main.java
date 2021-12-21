import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.*;
import java.io.File;

/**
 * Main class for work demonstration.
 */
public class Main {
    /**
     * Work demonstration.
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        System.out.println("Enter the way to CSV file : ");
        System.out.print(">");
        Scanner console = new Scanner(System.in);
        String path = console.nextLine();
        File f=new File(path);
        while(!f.exists()) {
            System.out.println("Incorrect way or file does not exist.");
            System.out.print(">");
            path = console.nextLine();
            f = new File(path);
        }
        String separator = ";"; //444
        int size = 0;
        List<Person> companyList = new LinkedList<>();
        try (InputStream in = Main.class.getClassLoader().getResourceAsStream(path)) {

            CSVReaderBuilder csvReaderBuilder = new CSVReaderBuilder(new FileReader(path));
            CSVReader csvReader = csvReaderBuilder.withSkipLines(1).build();

            if (csvReader == null)
                throw new FileNotFoundException(path);
            String[] nextLine;
            while ((nextLine = csvReader.readNext()) != null) {
                nextLine = nextLine[0].split(separator);
                if (nextLine.length > 2) {
                    Person person = new Person(nextLine[0], nextLine[1], nextLine[2], nextLine[3], nextLine[4].charAt(0) - 'A', nextLine[4], nextLine[5]);
                    companyList.add(person);
                }
            }

            System.out.println("Input the count of values : ");
            while(true) {
                String k= console.next();
                if (isDigit(k)){
                    if(Integer.parseInt(k)<=0) System.out.println("Incorrect input!");
                    else{size=Integer.parseInt(k);
                        System.out.println("Id\t\tName\tGender  Division Birthday   Salary");
                        for (int i = 0; i < companyList.size() && i < size; i++) {
                            System.out.print(companyList.get(i).getID() + "\t");
                            System.out.print(companyList.get(i).getName() + "\t");
                            System.out.print(companyList.get(i).getGender() + "\t");
                            System.out.print(companyList.get(i).getBirthDate() + "\t");
                            System.out.print(companyList.get(i).getSubdivisionID() + "\t");
                            System.out.print(companyList.get(i).getSubdivisionName() + "\t");
                            System.out.print(companyList.get(i).getSalary() + "\t");
                            System.out.print("\n");
                        }
                        break;}
                }
                else System.out.println("Incorrect type!");
                }
            }
        }
    /**
     * Function that check, what symbol was entered: number or not.
     * @param s
     * @return boolean type: number=true; not number=false;
     * @throws NumberFormatException
     */
    private static boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}