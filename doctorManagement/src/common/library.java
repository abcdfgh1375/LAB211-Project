package common;

import Utils.validationDoctor;
import java.util.HashMap;
import model.doctor;

public class library {

    validationDoctor valid;
    public HashMap<String, doctor> doctorList = new HashMap<>();
    
    public library() {
        this.valid = new validationDoctor();
    }

    public HashMap<String, doctor> getDoctorList() {
        return doctorList;
    }

    public void setDoctorList(HashMap<String, doctor> doctorList) {
        this.doctorList = doctorList;
    }
    

    //ADD
    public void add(doctor doc) {
        doctorList.put(doc.getDocCode(), doc);
    }

    public boolean addDoctor(doctor doctor) throws Exception {
        HashMap<String, doctor> res = doctorList;
        try {
            if (res == null) {
                throw new NullPointerException();
            }
        } catch (NullPointerException e) {
            System.out.println("Database does not exist");
            return false;
        }
        try {
            if (doctor == null) {
                throw new NullPointerException();
            }
        } catch (NullPointerException e) {
            System.out.println("Data does not exist");
            return false;
        }
        try {
            if (valid.checkExistDoctorByCode(res, doctor.getDocCode())) {
                throw new IllegalArgumentException("Doctor code " + doctor.getDocCode() + " is duplicate");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Doctor code " + doctor.getDocCode() + " is duplicate");
            return false;
        }
        add(doctor);
        return true;
    }

    //UPDATE
    public void update(doctor doc) {
        if (doc.getDocName().isBlank()) {
            doc.setDocName(doctorList.get(doc.getDocCode()).getDocName());
        } 
        if (doc.getDocSpecialization().isBlank()) {
            doc.setDocSpecialization(doctorList.get(doc.getDocCode()).getDocSpecialization());
        }
        if (doc.getDocAvailability()== -1) {
            doc.setDocAvailability(doctorList.get(doc.getDocCode()).getDocAvailability());
        }
        doctorList.replace(doc.getDocCode(), doc);
    }

    public boolean updateDoctor(doctor doctor) throws Exception {
        HashMap<String, doctor> res = doctorList;
        try {
            if (res == null) {
                throw new NullPointerException();
            }
        } catch (NullPointerException e) {
            System.out.println("Database does not exist");
            return false;
        }
        try {
            if (doctor == null) {
                throw new NullPointerException();
            }
        } catch (NullPointerException e) {
            System.out.println("Data does not exist");
            return false;
        }
        try {
            if (valid.checkExistDoctorByCode(res, doctor.getDocCode())) {
                update(doctor);
            } else if (!valid.checkExistDoctorByCode(res, doctor.getDocCode())) {
                throw new IllegalArgumentException("Doctor code doesn't exist");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Doctor code doesn't exist");
            return false;
        }
        return true;
    }
//DELETE

    public void delete(doctor doc) {
        doctorList.remove(doc.getDocCode(), doc);
    }

    public boolean deleteDoctor(doctor doctor) throws Exception {
        HashMap<String, doctor> res = doctorList;
        try {
            if (res == null) {
                throw new NullPointerException();
            }
        } catch (NullPointerException e) {
            System.out.println("Database does not exist");
            return false;
        }
        try {
            if (doctor == null) {
                throw new NullPointerException();
            }
        } catch (NullPointerException e) {
            System.out.println("Data does not exist");
            return false;
        }
        try {
            if (valid.checkExistDoctorByCode(res, doctor.getDocCode())) {
                delete(doctor);
            } else if (!valid.checkExistDoctorByCode(res, doctor.getDocCode())) {
                throw new IllegalArgumentException("Doctor code doesn't exist");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Doctor code doesn't exist");
            return false;
        }
        return true;
    }

    public doctor searchDoctorByCode(HashMap<String, doctor> hash, String code) throws Exception {
        try {
            if (valid.checkExistDoctorByCode(hash, code)) {
                return hash.get(code);
            }
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    //SEARCH

    public HashMap<String, doctor> searchListDoctorByCode(String str) throws Exception {
        HashMap<String, doctor> listDoctor = null;
        try {
            if (doctorList == null) {
                throw new NullPointerException();
            }
            doctorList.forEach((key, value) -> {
                if (key.contains(str)) {
                    listDoctor.put(str, doctorList.get(str));
                }
            }
            );
        } catch (NullPointerException e) {
            System.out.println("Database does not exist");
        }
        return listDoctor;
    }

    enum field {
        Code, Name, Specialization, Availability;
    }

    public field convertEnum(int f) {
        switch (f) {
            case 1 -> {
                return field.Code;
            }
            case 2 -> {
                return field.Name;
            }
            case 3 -> {
                return field.Specialization;
            }
            case 4 -> {
                return field.Availability;
            }
        }
        return null;
    }

    public HashMap<String, doctor> searchListDoctorByString(String str, int field) throws Exception {
        HashMap<String, doctor> listDoctor = new  HashMap<String, doctor>();
        try {
            if (doctorList == null) {
                throw new NullPointerException("Database does not exist");
            }
            field type = convertEnum(field);
            doctorList.forEach((key, value) -> {
                switch (type) {
                    case Code -> {
                        if (key.contains(str)) {
                            listDoctor.put(key, value);
                        }
                    }
                    case Name -> {
                        if (value.getDocName().contains(str)) {
                            listDoctor.put(key, value);
                        }
                    }
                    case Specialization -> {
                        if (value.getDocSpecialization().contains(str)) {
                            listDoctor.put(key, value);
                        }
                    }
                    case Availability -> {
                        try{
                        if (value.getDocAvailability() == Integer.parseInt(str)) {
                            listDoctor.put(key, value);
                        }}catch(NumberFormatException e){
                            System.out.println("Cannot parse string to int");
                        }
                    }
                }
            });
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
        return listDoctor;
    }
}
