package common;

public class validationFile {

    public double setValidSalary(String a) throws Exception {
        try {
            for (char c : a.toCharArray()) {
                if (!Character.isDigit(c)) {
                    a = "0";
                    break;
                }
            }
            if (Double.parseDouble(a) < 0) {
                a = "0";
            }
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
        return Double.parseDouble(a);
    }
}
