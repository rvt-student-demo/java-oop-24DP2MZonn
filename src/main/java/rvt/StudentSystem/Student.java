package rvt.StudentSystem;
    import java.time.LocalDateTime;
    import java.time.format.DateTimeFormatter;
public class Student {
    private String name;
    private String surname;
    private String email;
    private String personaskods;
    private String timestamp;


    public Student(String name, String surname, String email, String personaskods){
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.personaskods = personaskods;
        this.timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
    public String toString() {
    return this.name + "," + this.surname + "," + this.email + "," + this.personaskods + "," + this.timestamp;
    }
    public String getPersonaskods() {
    return this.personaskods;
    }
}
