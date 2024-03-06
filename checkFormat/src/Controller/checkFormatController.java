package Controller;

import View.Menu;
import View.viewF;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class checkFormatController extends Menu {

    private static final String DATE_FORMAT = "dd/MM/yyyy";
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);

    public checkFormatController() {
        super("Check Format", Arrays.asList(new String[]{"Phone", "Email", "Date","Exit"}));
    }

    @Override
    public void execute(int choice) {
        viewF v = new viewF();
        String res;
        switch (choice) {
            case 1-> {
                String phone;
                do {
                    phone = v.getInput("Phone number: ");
                    v.displayMsg(checkPhone(phone));
                } while (checkPhone(phone) != null);
            }
            case 2->{
                String email;
                do {
                    email = v.getInput("Email: ");
                    v.displayMsg(checkEmail(email));
                } while (checkEmail(email) != null);
            }
            case 3->{
                String date;
                do { 
                    date = v.getInput("Date: ");
                    v.displayMsg(checkDate(date));
                } while (checkDate(date) != null);
            }
            case 4->{
                System.exit(0);
            }
        }

    }

    public String checkPhone(String phone) {
        String msg = null;       
        if (!phone.matches("[0-9]+")) {
            msg = "Phone number must is number";
        } else if (phone.length() != 10) {
            msg = "Phone number must be 10 digits";
        }
        return msg;
    }

    public String checkDate(String date) {
        
        int s = 0;
        String msg = null;
        dateFormat.setLenient(false);
        if (!date.isEmpty()) {
            try {
                Date datee = dateFormat.parse(date);
            } catch (ParseException e) {
                msg = "Date to correct format(dd/MM/yyyy)";
            }
        }
        return msg;
    }

    public String checkEmail(String email) {
        String msg = null;
        if (!email.matches("^\\w+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
            msg = "Email must is correct format";
        }
        return msg;
    }

}
