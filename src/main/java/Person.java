import java.util.*;

/**
 * Main class for work with dataset. Contains information about each person in set, include subdivision.
 */

public class Person {
    private String name;
    private String gender;
    private Subdivision subdivision;
    private String ID;
    private String birthDate;
    private String salary;

    /**
     * Constructor with parameters
     */
    public Person(String id, String n, String g, String ns, int ids, String bd, String s) {
        ID = id;
        name = n;
        gender = g;
        subdivision = new Subdivision(ids, ns);
        birthDate = bd;
        salary = s;
    }
    /**
     * Default constructor
     */
    public Person() {}

    /**
     * Getter for ID
     * @return ID
     */
    public String getID() {
        return ID;
    }
    /**
     * Getter for name
     * @return name
     */
    public String getName() {
        return name;
    }
    /**
     * Getter for gender
     * @return gender
     */
    public String getGender() {
        return gender;
    }
    /**
     * Getter for Subdivision ID
     * @return Subdivision ID
     */
    public int getSubdivisionID() {
        return subdivision.getID();
    }
    /**
     * Getter for Subdivision name
     * @return Subdivision name
     */
    public String getSubdivisionName() {
        return subdivision.getName();
    }
    /**
     * Getter for birthDate
     * @return birthDate
     */
    public String getBirthDate() {
        return birthDate;
    }
    /**
     * Getter for salary
     * @return salary
     */
    public String getSalary() {
        return salary;
    }

    /**
     * Function for printing structure
     * @return string storing all the elements of the structure
     */
    @Override
    public String toString() {
        return this.getID() + " " + this.getName() + " " + this.getGender() + " " + this.getBirthDate() + " " +
                this.getSubdivisionID() + " " + this.getSubdivisionName() + " " + this.getSalary();
    }

}