package common;

import java.util.Calendar;
import java.util.HashMap;
import model.worker;

/**
 *
 * @author THANH HUYEN
 */
public class validationWorker {
//	Code(id) cannot be null or duplicated with existed Code in DB.
//	Age must be in range 18 to 50
//	Salary must be greater than 0

    public boolean checkExistByCode(HashMap<String, worker> hash, String code) {
        return hash.containsKey(code);
    }

    public boolean checkNullCode(String code) {
        return code == null;
    }

    public boolean checkAvailabilityPositive(double a) {
        return a > 0;
    }

    public boolean checkAvailabilityAge(int a) {
        Calendar instance = Calendar.getInstance();
        int yearNow = instance.get(Calendar.YEAR);
        return yearNow - a >= 18 &&  yearNow - a <= 50;
    }
}
