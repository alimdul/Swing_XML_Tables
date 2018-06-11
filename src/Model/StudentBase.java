package Model;

import java.util.ArrayList;

public class StudentBase {

    public ArrayList<Student> students = new ArrayList<>();

    public void add(Student student) {
        students.add(student);
    }

    public void delete(int index) {
        students.remove(index);
    }

    public int size() {
        return students.size();
    }

    public Student get(int index) {
        return students.get(index);
    }

}
