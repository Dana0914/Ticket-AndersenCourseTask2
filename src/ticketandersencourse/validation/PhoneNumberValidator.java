package ticketandersencourse.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberValidator {
    public String getValidPhoneNumber(String phoneNumber) {
        Pattern p = Pattern.compile("\\+\\d{12}");
        Matcher m = p.matcher(phoneNumber);
        if (m.matches()) {
            return phoneNumber;
        }
        return "Invalid phoneNumber";
    }
}
