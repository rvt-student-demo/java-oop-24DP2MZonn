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
            } else if (command.equals("add")) {
                System.out.print("To add: ");
                String task  = scanner.nextLine();
                list.add(task);
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
