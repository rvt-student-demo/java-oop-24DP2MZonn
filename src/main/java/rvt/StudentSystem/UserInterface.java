package rvt.StudentSystem;

import java.util.Scanner;
import java.util.List;
import rvt.StudentSystem.Register;





public class UserInterface {
    private Register list;
    private Scanner scanner;
    
    public UserInterface(Register list, Scanner scanner){
        this.list = list;
        this.scanner = scanner;
    }

    public void start(){
        while(true){
            System.out.print("Command: ");
            String command = scanner.nextLine();
            
             if (command.equals("exit")) {
                break;
            } else if (command.equals("register")) {
                System.out.print("Name: ");
                String name = scanner.nextLine();
                
                System.out.println("Surname:");
                String surname = scanner.nextLine();
                
                System.out.println("Email:");
                String email = scanner.nextLine();
                
                System.out.println("Personas kods:");
                String personaskods = scanner.nextLine();
                list.add(name, surname, email, personaskods, timestamp);

                fileHandler.saveToFile(list);
            } else if (command.equals("Show")) {
                list.show();
            } else if (command.equals("remove")) {
                System.out.println("Enter personaskodu: ");
                String code = scanner.nextLine();
                list.remove(code);

                fileHandler.saveToFile(list);
            } else if(command.equals("edit")){
                    System.out.println("Enter personaskodu: ");
                    String code = scanner.nextLine();

                    System.out.println("Enter new name: ");
                    String name = scanner.nextLine();
                    System.out.println("Enter new surname: ");
                    String surname = scanner.nextLine();
                    System.out.println("Enter new email: ");
                    String email = scanner.nextLine();
                    System.out.println("Enter new personas kods: ");
                    String personaskods = scanner.nextLine();
                    list.edit(code, name, surname, email, personaskods);
    
                    fileHandler.saveToFile(list);
            }
        }
    }

}
