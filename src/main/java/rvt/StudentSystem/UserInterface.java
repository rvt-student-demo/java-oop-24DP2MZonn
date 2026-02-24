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
                list.add(name, surname, email, personaskods);
            } else if (command.equals("list")) {
                list.print();
            } else if (command.equals("remove")) {
                System.out.println("Which one is removed? ");
                int i = Integer.parseInt(scanner.nextLine());
                list.remove(i);

            }
        }
    }

}
