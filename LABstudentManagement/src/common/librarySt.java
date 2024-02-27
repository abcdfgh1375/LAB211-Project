
package common;

import Model.Student;
import java.util.Collections;
import java.util.List;

public class librarySt {
    public List<Student> sortStudent(List<Student> a){
        Collections.sort(a);
        return a;
    }
}
