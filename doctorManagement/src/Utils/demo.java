package Utils;
import common.library;
import model.doctor;
import view.viewDoctor;

public class demo {

    public static void main(String[] args) throws Exception {
        library lib = new library();
        viewDoctor view = new viewDoctor();
//        common common = new common();
        doctor doc = new doctor("DOC 1","NA","SURGERY",3);
//        doctor doc2 = new doctor("DOC 2","NAM","NURSE",5);
        doc.addDoctor();
//        doc.addDoctor();
        doc.updateDoctor();
        doc.displayDoctor();
//        List<doctor> docList = new ArrayList<doctor>();
//        docList.add(doc);
//        doc.setDocValue((ArrayList) docList);
//        System.out.println(doc.getDocValue().toString());
        
    }
}


