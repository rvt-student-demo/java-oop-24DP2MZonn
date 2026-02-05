package rvt;

import java.util.Scanner;

public class Chapter100 {
    public static void main(String[] args) {
        
            Scanner reader = new Scanner(System.in);
            
                while(true){
                    System.out.println("Enter the numerator: ");
                    String numerator = reader.nextLine();
                    char q = numerator.charAt(0);
                    if (q == 'q' || q == 'Q'){
                    break;
                    } 
                    
                
                    int num;
                    
                    try{
                        num = Integer.parseInt(numerator);

                    
                    }catch (NumberFormatException e) {
                        System.out.println("Invalid format! Please enter integers only.");
                        continue;
                    }
                    System.out.println("Enter the divisor: ");
                    String divString = reader.nextLine();

                    int divisor;
                    try{
                        divisor = Integer.parseInt(divString);
                    }catch (NumberFormatException a) {
                        System.out.println("Invalid format! Please enter integers only.");
                        continue;
                    }
                    if(divisor == 0){
                        System.out.println("You cant divide " + num + " by zero");
                    } else{
                        System.out.println(num + " / " + divisor + " is " + num / divisor);
                    }
                 
            }
                
                    
    }
}
