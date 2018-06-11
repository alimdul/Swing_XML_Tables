package Controller;

import Model.StudentBase;
import Model.Student;

public class StudentController {

    private StudentBase studentBase;

    public StudentController (StudentBase studentBase) {
        this.studentBase = studentBase;
    }

    public StudentBase getStudentBase() {
        return studentBase;
    }

    public void addStudentInStudentBase (Student student) {
        studentBase.add(student);
    }

    public Student getStudent(int i) {
        return studentBase.get(i);
    }

    public void deleteStudent (int i) {
        studentBase.delete(i);
    }

    public int size()
    {
        return studentBase.size();
    }

    public void deleteAllStudents() {

        for (int i=0; i<studentBase.size(); i++){
            studentBase.delete(i);
        }
    }

}
