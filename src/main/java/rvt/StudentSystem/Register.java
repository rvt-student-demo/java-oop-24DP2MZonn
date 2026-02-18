package rvt.StudentSystem;
    import java.util.ArrayList;
    import java.util.List;
public class Register {
    private String name = "^[A-Z][a-z]+(?: [A-Z][a-z]+)*$";
    private String surname = "^[A-Z][a-z]+(?: [A-Z][a-z]+)*$";
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
}
