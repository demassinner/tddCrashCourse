package se.sogeti.aleo;

public class StringCalculator {

    public int calculate(String string) {
        int result = 0;
        String[] s = null;
        
        // TODO Auto-generated method stub
        if("".equals(string)) {
            result = 0;
        }
        
        
        if(string.contains(";")){
            s = string.split(";");
            for(String value : s){
                int i = Integer.valueOf(value).intValue();
                if(i < 0){
                    //throw new IllegalArgumentException();
                }
                result = result + i;
            }
        }
        
        return result;
        
    }

}
