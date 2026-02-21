package rvt;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class JM62 {
    public static class TodoList {
        List<String> tasks;
        private final String filePath = "data/todo.csv";

        public TodoList() {
            tasks = new ArrayList<>();
            loadFromFile();
        }

        private void loadFromFile() {
            try (Scanner myReader = new Scanner(new File(this.filePath))) {
                if (myReader.hasNextLine()) {
                    String first = myReader.nextLine();
                    if (!first.startsWith("id,")) {
                        if (!first.isBlank()) {
                            tasks.add(first);
                        }
                    }
                }
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    if (!data.isBlank()) {
                        tasks.add(data);
                    }
                }
            } catch (FileNotFoundException e) {
            }
        }

        private int getLastId() {
            if (this.tasks.isEmpty()) {
                return 0;
            } else {
                String Lastid = this.tasks.get(this.tasks.size() - 1);
                String[] ID = Lastid.split(",");
                int lastId = Integer.parseInt(ID[0]);
                return lastId;

            }

        }

        public void add(String task) {
            if (checkEventString(task)) {
                int NewID = getLastId() + 1;
                String NewTask = NewID + "," + task;
                tasks.add(NewTask);

                this.UpdateFile();
            } else {
                System.out.println("Invalid task! Use at least 3 chars and no symbols.");
            }

        }

        public void print() {
            for (int i = 0; i < tasks.size(); i++) {
                String entry = tasks.get(i);
                String taskText = entry;
                String[] parts = entry.split(",", 2);
                if (parts.length == 2) {
                    taskText = parts[1];
                }
                System.out.println((i + 1) + ": " + taskText);
            }
        }

        private boolean UpdateFile() {
            try (FileWriter myWriter = new FileWriter(this.filePath)) {
                myWriter.write("id,task\n");
                for (String task : this.tasks) {
                    myWriter.write(task + "\n");
                }
                return true;
            } catch (IOException e) {
                System.out.println("An error occurred.");
                return false;
            }

        }

        public void remove(int id) {
            int index = id - 1;
            if (index >= 0 && index < this.tasks.size()) {
                this.tasks.remove(index);
                this.UpdateFile();
            } else {
                System.out.println("Error: invalid item number.");
            }
        }

        public boolean checkEventString(String value) {
            if (value.length() < 3) {
                return false;
            }
            return value.matches("^[a-zA-Z0-9 ]+$");
        }
    }

    public static class UserInterface {
        private TodoList list;
        private Scanner scanner;

        public UserInterface(TodoList list, Scanner scanner) {
            this.list = list;
            this.scanner = scanner;
        }

        public void start() {
            while (true) {
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
        scanner.close();

    }
}
