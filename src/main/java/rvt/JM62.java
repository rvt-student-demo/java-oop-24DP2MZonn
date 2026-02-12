package rvt;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;                  
import java.io.FileNotFoundException;

public class JM62 {
    public static  class   TodoList {
        List<String> tasks;
        private final String filePath = "";
        public TodoList () {
            tasks = new ArrayList<>();
        }
        private void loadFromFile(){
            try (Scanner myReader = new Scanner(new File("todo.csv"))) {
                while (myReader.hasNextLine()) {
                  String data = myReader.nextLine();
                  System.out.println(data);
                }
              } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
              }
        }
        private int getLasiId(){
            return 0;
        }
        public void add(String task){
            tasks.add(task);
            getLasiId();
        }
        public void print(){
            for(int i = 0; i < tasks.size(); i++  ){
                System.out.println(i + 1 + ": " + tasks.get(i));
            }
        }
        private boolean UpdateFile(){
            return false;
        }
        public void remove(int number){
            int i = number - 1;
            if(i >= 0){
                if(i < tasks.size()){
                    tasks.remove(i);
                }else{
                    System.out.println("Error");
                }
                
            }
        }
    }
    public static class UserInterface{
        private TodoList list;
        private Scanner scanner;

        public UserInterface(TodoList list, Scanner scanner){
            this.list = list;
            this.scanner = scanner;
        }
        public void start(){
            while(true){
                System.out.print("Command: ");
                String command = scanner.nextLine();
                
                 if (command.equals("stop")) {
                    break;
                } else if (command.equals("add")) {
                    System.out.print("To add: ");
                    String task = scanner.nextLine();
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
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TodoList list = new TodoList();
        UserInterface ui = new UserInterface(list, scanner);
        ui.start();
        File toDoFile = new File("todo.csv");
        
    }
}
