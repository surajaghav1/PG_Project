import java.util.Scanner;
import java.util.regex.*;
public class aadhar_pan_validation {

    private static final String matchAadhar = "^[2-9]{1}[0-9]{11}$";
    private static final String matchPan = "^[A-Z]{5}[0-9]{4}[A-Z]{1}$";
    private static final String matchPincode = "^[1-9][0-9]{5}$";
    private static final String matchName = "^[a-zA-Z]+(\\s[a-zA-Z]+)?$";


    public static boolean isValidAadhar(String aadhar) {
        Pattern pattern = Pattern.compile(matchAadhar);
        Matcher matcher = pattern.matcher(aadhar);
        return matcher.matches();
    }

    // pan match
    public static boolean isValidPan(String pan) {
        Pattern pattern = Pattern.compile(matchPan);
        Matcher matcher = pattern.matcher(pan);
        return matcher.matches();
    }

    //     Driving License Validation
    public static boolean isValidDrivingLicenseNumber(String licenseNumber) {
        String regex = "^[A-Za-z]{2}\\d{2}-[0-9]{7}-[0-9]{2}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(licenseNumber);
        return matcher.matches();
    }

    // validate mobile number
    public static boolean isValidMobileNumber(String number) {
         String regex = "^[0-9]{10}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(number);
        return matcher.matches();
    }

//    Pincode validation
public static boolean isValidPincode(String pincode) {
    Pattern pattern = Pattern.compile(matchPincode);
    Matcher matcher = pattern.matcher(pincode);
    return matcher.matches();
}

// name validation
public static boolean isValidName(String name) {
    Pattern pattern = Pattern.compile(matchName);
    Matcher matcher = pattern.matcher(name);
    return matcher.matches();
}
}




