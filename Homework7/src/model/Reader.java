package model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Reader {

    private Reader() {
    }

    public static Student[] readFromFile(String filePath) throws IOException {
        try {

            String[] contentOfFile = Files.readAllLines(Paths.get(filePath)).toArray(new String[0]);
            Student[] content = new Student[contentOfFile.length];
            for (int i = 0; i < content.length; ++i) {
                content[i] = Student.parseStudent(contentOfFile[i]);
            }
            return content;
        } catch (IOException e) {
            System.out.printf("%s file doesn't exist\n", filePath);
            throw  e;
        }
    }
}
