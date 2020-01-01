/**
 * @author Or Dekalo
 */
public class Course<T extends Comparable<T>> implements Comparable<Course<T>> {

    private T idOrName;
    private float avg;

    public Course(T idOrName, float avg) {
        this.avg = avg;
        this.idOrName = idOrName;
    }

    public T getIdOrName() {
        return idOrName;
    }

    public float getAvg() {
        return avg;
    }

    @Override
    public String toString() {
        return "(	" + idOrName + ",	" + avg + "		)";
    }

    @Override
    public int compareTo(Course<T> o) {
        return this.getIdOrName().compareTo(o.getIdOrName());
    }
}

