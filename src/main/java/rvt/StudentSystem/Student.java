package rvt.StudentSystem;

public class Student {
    private String name;
    private String surname;
    private String email;
    private String personaskods;

    public Student(String name, String surname, String email, String personaskods){
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.personaskods = personaskods;
    }
    public String toString() {
    return this.name + "," + this.surname + "," + this.email + "," + this.personaskods;
    }
}
