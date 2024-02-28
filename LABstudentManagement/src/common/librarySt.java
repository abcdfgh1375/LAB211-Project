
package common;

import Model.Student;
import java.util.Collections;
import java.util.List;

public class librarySt {
    public List<Student> sortStudent(List<Student> a) throws Exception{
        if(a.isEmpty()){
            System.out.println("List is empty!");
            return null;
        }
        Collections.sort(a);
        return a;
    }
}
