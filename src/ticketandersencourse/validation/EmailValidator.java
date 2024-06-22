package ticketandersencourse.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {
    public String getValid(String email) {
        Pattern p = Pattern.compile("\\w+\\w+@\\w+\\.\\w+");
        Matcher m = p.matcher(email);
        if (m.matches()) {
            return email;
        }
        return "Invalid email";
    }

}
