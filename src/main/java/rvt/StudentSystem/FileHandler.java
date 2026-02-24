package rvt.StudentSystem;
    import java.io.BufferedWriter;
    import java.io.FileWriter;
    import java.io.IOException;
public class FileHandler {
    private final String filePath = "data/data.csv";
    public void saveToFile(Register register) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(this.filePath))) {
            for (int i = 0; i < register.registerlists.size(); i++) {
                writer.write(register.registerlists.get(i).toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving to file: " + e.getMessage());
        }
    }
}
