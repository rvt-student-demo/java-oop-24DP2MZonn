package rvt.StudentSystem;
    import java.util.ArrayList;
    import java.util.List;
public class Register {
    private String name;
    private String surname;
    private String email;
    private String personaskods;
    List<String> registerlists;

    public Register(String name, String surname, String email, String personaskods){
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.personaskods = personaskods;
        registerlists = new ArrayList<>();
    }

    public void add(String registerlist){
        registerlists.add(registerlist);
    }
}
