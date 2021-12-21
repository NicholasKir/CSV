import java.util.*;

/**
 * Class that contains information about each person's subdivision.
 */

public class Subdivision {

    /**
     * Identification number and name of subdivision.
     */
    private int ID;
    private String name;

    /**
     * Constructor
     */
    public Subdivision(int id, String n) {
        ID = id;
        name = n;
    }

    /**
     * Get-method for ID
     * @return ID
     */
    public int getID() {
        return ID;
    }
    /**
     * Get-method for name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * equals method
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subdivision that = (Subdivision) o;
        return ID == that.ID && Objects.equals(name, that.name);
    }

    /**
     * hashcode method
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(ID, name);
    }
}
