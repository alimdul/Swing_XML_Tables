package View;

import Controller.StudentController;
import Model.Student;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.SqlDateModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.Random;

public class AddDialog {

    private StudentController controller;

    public JDialog addDialog = new JDialog();
    private MainFrame mainFrame;

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
    private JButton addButton = new JButton("Добавить студента");

    private JButton randomAddButton = new JButton("Случайное добавление");

    public AddDialog (StudentController controller, MainFrame mainFrame) {

        this.controller = controller;
        this.mainFrame = mainFrame;

        addDialog.setTitle("Добавление студента");
        addDialog.setSize(300, 400);
        addDialog.setLocationRelativeTo(null);
        addDialog.setLayout(new GridBagLayout());
        addDialog.setResizable(false);

        this.faculty.addItem("ФИТиУ");
        this.faculty.addItem("КСиС");
        this.faculty.addItem("ФКП");
        this.faculty.addItem("ФРЭ");
        this.faculty.addItem("ИЭФ");
        this.faculty.addItem("ФТК");
        this.faculty.addItem("ВФ");

        this.composition.addItem("основной");
        this.composition.addItem("запасной");

        this.position.addItem("вратарь");
        this.position.addItem("защитник");
        this.position.addItem("полузащитник");
        this.position.addItem("нападающий");

        addDialog.setResizable(false);
        addDialog.setModal(true);
    }

        public void initAddDialog() {

        addButton.addActionListener(new AddButtonActionListener(controller));
        randomAddButton.addActionListener(new RandomAddButtonActionListener(controller));

        addDialog.add(surNameLabel, new GridBagConstraints(0, 0, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.CENTER, new Insets(2, 2, 2, 2), 0, 0));
        addDialog.add(surName, new GridBagConstraints(1, 0, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.CENTER, new Insets(2, 2, 2, 2), 0, 0));
        addDialog.add(firstNameLabel, new GridBagConstraints(0, 1, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.CENTER, new Insets(2, 2, 2, 2), 0, 0));
        addDialog.add(firstName, new GridBagConstraints(1, 1, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.CENTER, new Insets(2, 2, 2, 2), 0, 0));
        addDialog.add(lastNameLabel, new GridBagConstraints(0, 2, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.CENTER, new Insets(2, 2, 2, 2), 0, 0));
        addDialog.add(lastName, new GridBagConstraints(1, 2, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.CENTER, new Insets(2, 2, 2, 2), 0, 0));
        addDialog.add(dateLabel, new GridBagConstraints(0, 3, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.CENTER, new Insets(2, 2, 2, 2), 0, 0));
        addDialog.add(datePicker, new GridBagConstraints(1, 3, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.CENTER, new Insets(2, 2, 2, 2), 0, 0));
        addDialog.add(footballTeamLabel, new GridBagConstraints(0, 4, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.CENTER, new Insets(2, 2, 2, 2), 0, 0));
        addDialog.add(footballTeam, new GridBagConstraints(1, 4, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.CENTER, new Insets(2, 2, 2, 2), 0, 0));
        addDialog.add(facultyLabel, new GridBagConstraints(0, 5, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.CENTER, new Insets(2, 2, 2, 2), 0, 0));
        addDialog.add(faculty, new GridBagConstraints(1, 5, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.CENTER, new Insets(2, 2, 2, 2), 0, 0));
        addDialog.add(compositionLabel, new GridBagConstraints(0, 6, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.CENTER, new Insets(2, 2, 2, 2), 0, 0));
        addDialog.add(composition, new GridBagConstraints(1, 6, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.CENTER, new Insets(2, 2, 2, 2), 0, 0));
        addDialog.add(positionLabel, new GridBagConstraints(0, 7, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.CENTER, new Insets(2, 2, 2, 2), 0, 0));
        addDialog.add(position, new GridBagConstraints(1, 7, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.CENTER, new Insets(2, 2, 2, 2), 0, 0));
        addDialog.add(addButton, new GridBagConstraints(0, 8, 3, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
        addDialog.add(randomAddButton, new GridBagConstraints(0, 9, 3, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));

            addDialog.pack();
        addDialog.setVisible(true);
    }

    public class AddButtonActionListener implements ActionListener {

        private StudentController controller;
        private AddButtonActionListener(StudentController controller) {
            this.controller = controller;
        }

        public void actionPerformed(ActionEvent event) {

            if (surName.getText().equals("") || firstName.getText().equals("") || lastName.getText().equals("") ||
                    date.getValue()==null || footballTeam.getText().equals("") || faculty.getSelectedItem().equals("") ||
                    composition.getSelectedItem().equals("") ||  position.getSelectedItem().equals(""))
                JOptionPane.showMessageDialog(new JFrame(), "Ошибка! Не все данные введены" );

            else {
                Student student = new Student(surName.getText(), firstName.getText(), lastName.getText(),
                        date.getValue(), footballTeam.getText(), faculty.getSelectedItem().toString(), composition.getSelectedItem().toString(),
                        position.getSelectedItem().toString());
                controller.addStudentInStudentBase(student);
                mainFrame.updateMainFrame();
                addDialog.dispose();
                JOptionPane.showMessageDialog(new JFrame(), "Данные успешно добавлены" );
            }
        }
    }

    public class RandomAddButtonActionListener implements ActionListener {

        String surNameR[] = {"Иванов", "Сидоров", "Петров"};
        String firstNameR[] = {"Иван", "Сидор", "Петр"};
        String lastNameR[] = {"Иванович", "Сидорович", "Петрович"};
        Date dateR[] = {Date.valueOf( "2017-03-12" ), Date.valueOf( "2016-03-03" ), Date.valueOf( "2015-07-12" )};
        String footballTeamR[] = {"Реал", "Челси", "Барселона"};
        String facultyR[] = {"ФИТиУ", "КСиС", "ИЭФ"};
        String compositionR[] = {"основной", "запасной"};
        String positionR[] = {"нападающий", "защитник", "вратарь", "полузащитник"};

        private StudentController controller;
        private RandomAddButtonActionListener(StudentController controller) {
            this.controller = controller;
        }

        public void actionPerformed(ActionEvent event) {

            for (int i = 0; i < 100; i++) {

                Random random = new Random();

                int position1 = random.nextInt(surNameR.length);
                surName.setText(surNameR[position1]);
                int position2 = random.nextInt(firstNameR.length);
                firstName.setText(firstNameR[position2]);
                int position3 = random.nextInt(lastNameR.length);
                lastName.setText(lastNameR[position3]);
                int position4 = random.nextInt(dateR.length);
                date.setValue(dateR[position4]);
                int position5 = random.nextInt(footballTeamR.length);
                footballTeam.setText(footballTeamR[position5]);
                int position6 = random.nextInt(facultyR.length);
                faculty.setActionCommand(facultyR[position6]);
                int position7 = random.nextInt(compositionR.length);
                composition.setActionCommand(compositionR[position7]);
                int position8 = random.nextInt(positionR.length);
                position.setActionCommand(positionR[position8]);

                Student student = new Student(surName.getText(), firstName.getText(), lastName.getText(),
                        date.getValue(), footballTeam.getText(), faculty.getActionCommand().toString(), composition.getActionCommand().toString(),
                        position.getActionCommand().toString());
                controller.addStudentInStudentBase(student);
            }
                mainFrame.updateMainFrame();
                addDialog.dispose();
                JOptionPane.showMessageDialog(new JFrame(), "Данные успешно добавлены");
        }
    }

}
