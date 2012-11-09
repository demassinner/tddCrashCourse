package se.sogeti.stringcalculator;

public class StringCalculator {

    public int calculate(String stringValue) {
        if ("".equals(stringValue)) {
            return 0;
        }
        
        int result = 0;
        
        if (stringValue.indexOf(',') > -1) {
            String[] arr = stringValue.split(",|\n");
            
            for (String param : arr) {
                result += Integer.parseInt(param);
            }
        } else {
            result = Integer.parseInt(stringValue);
        }
        
        return result;
    }

}
