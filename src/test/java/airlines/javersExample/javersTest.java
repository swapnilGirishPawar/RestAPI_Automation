package airlines.javersExample;

import org.javers.core.Javers;
import org.javers.core.JaversBuilder;
import org.javers.core.diff.Diff;

public class javersTest {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setId(10);
        s1.setName("Swapnil");

        Student s2 = new Student();
        s2.setId(1);
        s2.setName("Swapil");

        Javers javers = JaversBuilder.javers().build();
        Diff dif = javers.compare(s1, s2);
        System.out.println(dif);
    }
}
