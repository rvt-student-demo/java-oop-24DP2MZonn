package rvt.StudentSystem;
    import java.util.ArrayList;
    import java.util.List;
public class Register {
    
    public List<Student> registerlists;

    public Register(){
       
        this.registerlists = new ArrayList<>();
    }

    public void add(String name, String surname, String email, String personaskods){
        Student newStudent = new Student(name, surname, email, personaskods);
        registerlists.add(newStudent);
    }
    public void print(){
        for(int i = 0; i < registerlists.size(); i++  ){
            System.out.println(i + 1 + ": " + registerlists.get(i));
        }
    }
    public void remove(int number){
        int i = number - 1;
        if(i >= 0){
            if(i < registerlists.size()){
                registerlists.remove(i);
            }else{
                System.out.println("Error");
            }
            
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