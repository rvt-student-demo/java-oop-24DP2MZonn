package rvt.StudentSystem;
    import java.util.ArrayList;
    import java.util.List;
    
public class Register {
    
    public List<Student> registerlists;
    public Register(){
       
        this.registerlists = new ArrayList<>();
    }

    public void add(String name, String surname, String email, String personaskods){
        if(checkEventString(name, surname, email, personaskods)){
            Student newStudent = new Student(name, surname, email, personaskods);
            registerlists.add(newStudent);
        } else {
            System.out.println("Invalid input! Registration cancelled.");
        }
        
    }
    public void show() {
        String border = "+-----------------+-----------------+-----------------+-----------------+";
            
        
        String template = "| %-15s | %-15s | %-15s | %-15s |%n";
        System.out.println(border);
        System.out.printf(template, "Name", "Surname", "Email", "ID Code");
        System.out.println(border);
            for (Student s : registerlists) {
        System.out.printf(template, 
            s.getName(), 
            s.getSurname(), 
            s.getEmail(), 
            s.getPersonaskods()); // Note: capital P here
            }
            System.out.println(border);
        }
    
    public void remove(String remove){
        boolean found = false;
        for(int i = 0; i < registerlists.size(); i++){
            if (registerlists.get(i).getPersonaskods().equals(remove)){
                registerlists.remove(i);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Personas kods not found!");
        }
    }
    public void edit(String code, String name, String surname, String email, String personaskods){
        if(checkEventString(name, surname, email, personaskods)){
            boolean found = false;
            for(int i = 0; i < registerlists.size(); i++){
                if(registerlists.get(i).getPersonaskods().equals(code)){
                    registerlists.set(i, new Student(name, surname, email, personaskods));
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Personas kods not found!");
            }
        } else {
            System.out.println("Invalid input! Edit cancelled.");
        }
       
        
    }
    public boolean checkEventString(String name, String surname, String email, String personaskods) {
        String nameRegex = "^[A-Z][a-z]+(?:[ \\-][A-Z][a-z]+)*$";
        String surnameRegex = "^[A-Z][a-z]+(?:[ \\-][A-Z][a-z]+)*$";
        String emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        String personaskodsRegex = "^(\\d{6}-\\d{5}|32\\d{4}-\\d{5})$";
        if (!name.matches(nameRegex)) {
            System.out.println("Invalid name! Name should start with a capital letter and contain only letters, spaces, or hyphens.");
            return false;
        }
        if (!surname.matches(surnameRegex)) {
            System.out.println("Invalid surname! Surname should start with a capital letter and contain only letters, spaces, or hyphens.");
            return false;
        }
        if (!email.matches(emailRegex)) {
            System.out.println("Invalid email! Email should be in the format name@domain.com.");
            return false;
        }
        if (!personaskods.matches(personaskodsRegex)) {
            System.out.println("Invalid personaskods! Personas kods should be in the format DDMMYY-XXXXX or 32DDMM-XXXXX.");
            return false;
        }
        return true;
    }
    
    
}