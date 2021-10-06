package utils;

public class Valid {
    /**
     * Password requires, passLength=6, and must have 1 number, 1 capital, 1 lowercase
     * @param pwd
     * @return
     */
    public static boolean validPass(String pwd){
        int passLength = 6;
        if(pwd.length()>=passLength){
            //System.out.println("Passcheck -Valid.validPass(pwd) Length OK: "+passLength);
            boolean hasNum=false; boolean hasCap=false; boolean hasLow=false; char c;
            for(int i=0; i< pwd.length();i++){
                c = pwd.charAt(i);
                if(Character.isDigit(c)){hasNum=true;}  // check for at least 1 digit
                else if(Character.isUpperCase(c)){hasCap=true;}  // check for at least 1 Capital
                else if(Character.isLowerCase(c)){hasLow=true;}  //check for at least 1 lowercase
                if(hasNum && hasCap && hasLow){return true;}
            }  // END FOR
        } else {System.out.println("** Required Minimum ** 6 Characters, 1 Number, 1 Capital, 1 lowercase");return false;}
    return false;
    }

    public static boolean validTransaction(Double transaction){
        if(transaction>=0){return true;} // check to make sure transaction is POSITIVE
        return false;
    }

    public static boolean validName(String name){ //validate no numbers in name
        boolean hasNum=false; char c;
        for(int i=0; i<name.length();i++){
            c = name.charAt(i);
            if(Character.isDigit(c)){hasNum=true;}// make sure no numbers in name.
        }  if(hasNum=false){return true;}
        return false;
    }
}
