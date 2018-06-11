package View;

import Model.Student;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class TableModel extends AbstractTableModel {

    public static final int STUDENT = 0;
    public static final int DATE = 1;
    public static final int FOOTBALLTEAM = 2;
    public static final int FACULTY = 3;
    public static final int COMPOSITION = 4;
    public static final int POSITION = 5;

    private int columnCount = 6;
    private ArrayList<Student> ListData;

    public TableModel () {
        this.ListData = new ArrayList<Student>();
    }

    public String getColumnName (int columnIndex) {
        switch (columnIndex) {
            case STUDENT: return "ФИО студента";
            case DATE: return "Дата рождения";
            case FOOTBALLTEAM: return "Футбольная команда";
            case FACULTY: return "Факультет";
            case COMPOSITION: return "Состав";
            case POSITION: return "Позиция";
        }
        return "";
    }

    public void addStudent(Student student)
    {
        ListData.add(student);
        fireTableDataChanged();
    }

    public int getRowCount () {
        return ListData.size();
    }

    public int getColumnCount () {
        return columnCount;
    }

    public Object getValueAt (int rowIndex, int columnIndex) {
        Student rows = ListData.get(rowIndex);
        return rows.getValue(columnIndex);
    }

    public void deleteStudents() {
        ListData.clear();
        fireTableDataChanged();
    }


}


