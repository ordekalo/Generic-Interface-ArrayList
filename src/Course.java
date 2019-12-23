public class Course<E> implements Comparable<Course<E>> {
    private E idOrName;
    private float avg;

    @Override
    public String toString() {
        return "(" + idOrName + ", " + avg + ')';
    }

    public Course(E idOrName, float avg) {
        this.idOrName = idOrName;
        this.avg = avg;
    }

    public E getIdOrName() {
        return idOrName;
    }

    public float getAvg() {
        return avg;
    }

    @Override
    public int compareTo(Course<E> o) {
        //TODO
        return 0;
    }
}
