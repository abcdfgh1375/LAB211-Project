package Utils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class demo {

    public static boolean isValidPhoneNumber(String phoneNumber) {
        // Biểu thức chính quy để kiểm tra số điện thoại
        String regex = "^(\\()?\\d{3}(\\))?[-.\\s]?\\d{3}[-.\\s]?\\d{4}(\\s?(x|ext)\\d{1,5})?$";

        // Tạo đối tượng Pattern từ regex
        Pattern pattern = Pattern.compile(regex);

        // Tạo đối tượng Matcher để so khớp với chuỗi đầu vào
        Matcher matcher = pattern.matcher(phoneNumber);

        // Kiểm tra xem có khớp hay không
        return matcher.matches();
    }

    public static void main(String[] args) {
        // Test với một số số điện thoại khả dụng
        String[] phoneNumbers = {
                "1234567890",
                "123-456-7890",
                "123-456-7890 x1234",
                "123-456-7890 ext1234",
                "(123)-456-7890",
                "123.456.7890",
                "123 456 7890"
        };

        for (String phoneNumber : phoneNumbers) {
            System.out.println(phoneNumber + ": " + isValidPhoneNumber(phoneNumber));
        }
    }
}


