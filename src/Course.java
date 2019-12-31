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

    public int[] getIdOrNameArray() {
        String s = (String) idOrName;
        int[] temp = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            temp[i] = s.charAt(i) - '0';
        }
        return temp;
    }


    @Override
    public int compareTo(Course<E> o) {
        int[] arr1 = this.getIdOrNameArray();
        int[] arr2 = o.getIdOrNameArray();

        if (arr1.length <= arr2.length) {
            for (int i = 0; i < arr1.length; i++) {
                if (arr2[i] > arr1[i]) {
                    return -1;
                } else if (arr2[i] < arr1[i]) {
                    return 1;
                }
            }
        } else {
            for (int i = 0; i < arr2.length; i++) {
                if (arr2[i] > arr1[i]) {
                    return -1;
                } else if (arr2[i] < arr1[i]) {
                    return 1;
                }
            }
        }
        return 0;
    }
}
