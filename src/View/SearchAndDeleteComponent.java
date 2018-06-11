package View;

import Controller.StudentController;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.SqlDateModel;

import javax.swing.*;
import java.awt.*;
import java.sql.Date;

public class SearchAndDeleteComponent {

    public JDialog dialog = new JDialog();
    public StudentController controller;

    private JLabel surNameLabel = new JLabel("Фамилия");
    private JTextField surName = new JTextField(18);
    private JLabel firstNameLabel = new JLabel("Имя");
    private JTextField firstName = new JTextField(18);
    private JLabel lastNameLabel = new JLabel("Отчество");
    private JTextField lastName = new JTextField(18);

    private JLabel dateLabel = new JLabel("Дата рождения");
    SqlDateModel date = new SqlDateModel();
    JDatePanelImpl datePanel = new JDatePanelImpl(date);
    JDatePickerImpl datePicker = new JDatePickerImpl(datePanel);

    private JLabel footballTeamLabel = new JLabel("Футбольная команда");
    private JTextField footballTeam = new JTextField(18);
    private JLabel facultyLabel = new JLabel("Факультет");
    private JComboBox<String> faculty = new JComboBox<>();
    private JLabel compositionLabel = new JLabel("Состав");
    private JComboBox<String> composition = new JComboBox<>();
    private JLabel positionLabel = new JLabel("Позиция");
    private JComboBox<String> position = new JComboBox<>();

    public SearchAndDeleteComponent (JDialog dialog, StudentController controller) {
        this.dialog = dialog;
        this.controller = controller;
    }

    public JDialog createDialog() {

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        faculty.addItem("ФИТиУ");
        faculty.addItem("КСиС");
        faculty.addItem("ФКП");
        faculty.addItem("ФРЭ");
        faculty.addItem("ИЭФ");
        faculty.addItem("ФТК");
        faculty.addItem("ВФ");

        composition.addItem("основной");
        composition.addItem("запасной");

        position.addItem("вратарь");
        position.addItem("защитник");
        position.addItem("полузащитник");
        position.addItem("нападающий");

        panel.add(surNameLabel, new GridBagConstraints(0, 0, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.CENTER, new Insets(2, 2, 2, 2), 0, 0));
        panel.add(surName, new GridBagConstraints(1, 0, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.CENTER, new Insets(2, 2, 2, 2), 0, 0));
        panel.add(firstNameLabel, new GridBagConstraints(0, 1, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.CENTER, new Insets(2, 2, 2, 2), 0, 0));
        panel.add(firstName, new GridBagConstraints(1, 1, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.CENTER, new Insets(2, 2, 2, 2), 0, 0));
        panel.add(lastNameLabel, new GridBagConstraints(0, 2, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.CENTER, new Insets(2, 2, 2, 2), 0, 0));
        panel.add(lastName, new GridBagConstraints(1, 2, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.CENTER, new Insets(2, 2, 2, 2), 0, 0));
        panel.add(dateLabel, new GridBagConstraints(0, 3, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.CENTER, new Insets(2, 2, 2, 2), 0, 0));
        panel.add(datePicker, new GridBagConstraints(1, 3, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.CENTER, new Insets(2, 2, 2, 2), 0, 0));
        panel.add(footballTeamLabel, new GridBagConstraints(0, 4, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.CENTER, new Insets(2, 2, 2, 2), 0, 0));
        panel.add(footballTeam, new GridBagConstraints(1, 4, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.CENTER, new Insets(2, 2, 2, 2), 0, 0));
        panel.add(facultyLabel, new GridBagConstraints(0, 5, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.CENTER, new Insets(2, 2, 2, 2), 0, 0));
        panel.add(faculty, new GridBagConstraints(1, 5, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.CENTER, new Insets(2, 2, 2, 2), 0, 0));
        panel.add(compositionLabel, new GridBagConstraints(0, 6, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.CENTER, new Insets(2, 2, 2, 2), 0, 0));
        panel.add(composition, new GridBagConstraints(1, 6, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.CENTER, new Insets(2, 2, 2, 2), 0, 0));
        panel.add(positionLabel, new GridBagConstraints(0, 7, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.CENTER, new Insets(2, 2, 2, 2), 0, 0));
        panel.add(position, new GridBagConstraints(1, 7, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.CENTER, new Insets(2, 2, 2, 2), 0, 0));

        dialog.add(panel, new GridBagConstraints(0, 0, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.CENTER, new Insets(2, 2, 2, 2), 0, 0));

        return dialog;
    }

    public String getSurName() {
        return surName.getText();
    }
    public String getFirstName() {
        return firstName.getText();
    }
    public String getLastName() {
        return lastName.getText();
    }
    public Date getDate() {
        return date.getValue();
    }
    public String getFootballTeam() {
        return footballTeam.getText();
    }
    public String getFaculty() {
        return faculty.getSelectedItem().toString();
    }
    public String getComposition() {
        return composition.getSelectedItem().toString();
    }
    public String getPosition() {
        return position.getSelectedItem().toString();
    }

    public boolean checkOnPass1() {

        return ("".equals(surName.getText()) || firstName.getText().equals("") || lastName.getText().equals("") || date.getValue()==null);
    }
    public boolean checkOnPass2() {

        return (composition.getSelectedItem().equals("") || position.getSelectedItem().equals(""));
    }
    public boolean checkOnPass3() {

        return (surName.getText().equals("") || firstName.getText().equals("") || lastName.getText().equals("") || footballTeam.getText().equals(""));
    }
    public boolean checkOnPass4() {

        return (surName.getText().equals("") || firstName.getText().equals("") || lastName.getText().equals("") || faculty.getSelectedItem().equals(""));
    }

    public boolean findStudent1(int i) {

        if ((controller.getStudent(i).getSurName().equals(surName.getText())) &&
                (controller.getStudent(i).getFirstName().equals(firstName.getText())) &&
                (controller.getStudent(i).getLastName().equals(lastName.getText())) &&
                (controller.getStudent(i).getDate().toString().equals(date.getValue().toString())))
            return true;
        else
            return false;
    }
    public boolean findStudent2(int i) {

        if ((controller.getStudent(i).getFootball().getComposition().equals(composition.getSelectedItem().toString())) &&
                (controller.getStudent(i).getFootball().getPosition().equals(position.getSelectedItem().toString())))
            return true;
        else
            return false;
    }
    public boolean findStudent3(int i) {

        if ((controller.getStudent(i).getSurName().equals(surName.getText())) &&
                (controller.getStudent(i).getFirstName().equals(firstName.getText())) &&
                (controller.getStudent(i).getLastName().equals(lastName.getText())) &&
                (controller.getStudent(i).getFootball().getFootballTeam().equals(footballTeam.getText())))
            return true;
        else
            return false;
    }
    public boolean findStudent4(int i) {

        if ((controller.getStudent(i).getSurName().equals(surName.getText())) &&
                (controller.getStudent(i).getFirstName().equals(firstName.getText())) &&
                (controller.getStudent(i).getLastName().equals(lastName.getText())) &&
                (controller.getStudent(i).getFaculty().equals(faculty.getSelectedItem().toString())))
            return true;
        else
            return false;
    }


}
