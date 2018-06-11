package View;

import Controller.StudentController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteDialog {

    private StudentController controller;

    public JDialog deleteDialog = new JDialog();
    private MainFrame mainFrame;

    private JButton deleteButton1 = new JButton("Удаление по ФИО и дате рождения");
    private JButton deleteButton2 = new JButton("Удаление по позиции и составу");
    private JButton deleteButton3 = new JButton("Удаление по ФИО и футбольной команде");
    private JButton deleteButton4 = new JButton("Удаление по факультету и ФИО");

    public DeleteDialog (StudentController controller, MainFrame mainFrame) {

        this.controller = controller;
        this.mainFrame = mainFrame;

        deleteDialog.setTitle("Удаление студента");
        deleteDialog.setSize(300, 400);
        deleteDialog.setLocationRelativeTo(null);
        deleteDialog.setLayout(new GridBagLayout());
        deleteDialog.setResizable(false);
    }

    public void initDeleteDialog() {

        SearchAndDeleteComponent searchAndDeleteComponent = new SearchAndDeleteComponent(deleteDialog, controller);
        deleteDialog = searchAndDeleteComponent.createDialog();

        deleteButton1.addActionListener(new DeleteDialog.deleteButton1ActionListener(controller, searchAndDeleteComponent));
        deleteButton2.addActionListener(new DeleteDialog.deleteButton2ActionListener(controller, searchAndDeleteComponent));
        deleteButton3.addActionListener(new DeleteDialog.deleteButton3ActionListener(controller, searchAndDeleteComponent));
        deleteButton4.addActionListener(new DeleteDialog.deleteButton4ActionListener(controller, searchAndDeleteComponent));

        deleteDialog.add(deleteButton1, new GridBagConstraints(0, 8, 3, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
        deleteDialog.add(deleteButton2, new GridBagConstraints(0, 9, 3, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
        deleteDialog.add(deleteButton3, new GridBagConstraints(0, 10, 3, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
        deleteDialog.add(deleteButton4, new GridBagConstraints(0, 11, 3, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));


        deleteDialog.pack();
        deleteDialog.setVisible(true);
    }

    public class deleteButton1ActionListener implements ActionListener {

        private StudentController controller;
        private SearchAndDeleteComponent searchAndDeleteComponent;
        private deleteButton1ActionListener(StudentController controller, SearchAndDeleteComponent searchAndDeleteComponent) {
            this.controller = controller;
            this.searchAndDeleteComponent = searchAndDeleteComponent;
        }

        public void actionPerformed(ActionEvent event) {

            int number = 0;

            if (searchAndDeleteComponent.checkOnPass1() == true)
                JOptionPane.showMessageDialog(new JFrame(), "Ошибка! Не все данные введены" );

            else {
                for (int i = 0; i < controller.size(); i++) {

                    if (searchAndDeleteComponent.findStudent1(i)) {
                        number++;
                        controller.deleteStudent(i);
                        mainFrame.updateMainFrame();
                    }
                }
                if (number == 0) {
                    JOptionPane.showMessageDialog(new JFrame(), "Ничего не найдено. Попробуйте еще раз");
                }
                else {
                    JOptionPane.showMessageDialog(new JFrame(), "Удалено "+ number + " студента(-ов)");
                }
            }
        }
    }

    public class deleteButton2ActionListener implements ActionListener {

        private StudentController controller;
        private SearchAndDeleteComponent searchAndDeleteComponent;
        private deleteButton2ActionListener(StudentController controller, SearchAndDeleteComponent searchAndDeleteComponent) {
            this.controller = controller;
            this.searchAndDeleteComponent = searchAndDeleteComponent;
        }

        public void actionPerformed(ActionEvent event) {

            int number = 0;

            if (searchAndDeleteComponent.checkOnPass2() == true)
                JOptionPane.showMessageDialog(new JFrame(), "Ошибка! Не все данные введены" );

            else {
                for (int i = 0; i < controller.size(); i++) {

                    if (searchAndDeleteComponent.findStudent2(i)) {
                        number++;
                        controller.deleteStudent(i);
                        mainFrame.updateMainFrame();
                    }
                }
                if (number == 0) {
                    JOptionPane.showMessageDialog(new JFrame(), "Ничего не найдено. Попробуйте еще раз");
                }
                else {
                    JOptionPane.showMessageDialog(new JFrame(), "Удалено "+ number + " студента(-ов)");
                }
            }
        }
    }

    public class deleteButton3ActionListener implements ActionListener {

        private StudentController controller;
        private SearchAndDeleteComponent searchAndDeleteComponent;
        private deleteButton3ActionListener(StudentController controller, SearchAndDeleteComponent searchAndDeleteComponent) {
            this.controller = controller;
            this.searchAndDeleteComponent = searchAndDeleteComponent;
        }

        public void actionPerformed(ActionEvent event) {

            int number = 0;

            if (searchAndDeleteComponent.checkOnPass3() == true)
                JOptionPane.showMessageDialog(new JFrame(), "Ошибка! Не все данные введены" );

            else {
                for (int i = 0; i < controller.size(); i++) {

                    if (searchAndDeleteComponent.findStudent3(i)) {
                        number++;
                        controller.deleteStudent(i);
                        mainFrame.updateMainFrame();
                    }
                }
                if (number == 0) {
                    JOptionPane.showMessageDialog(new JFrame(), "Ничего не найдено. Попробуйте еще раз");
                }
                else {
                    JOptionPane.showMessageDialog(new JFrame(), "Удалено "+ number + " студента(-ов)");
                }
            }
        }
    }

    public class deleteButton4ActionListener implements ActionListener {

        private StudentController controller;
        private SearchAndDeleteComponent searchAndDeleteComponent;
        private deleteButton4ActionListener(StudentController controller, SearchAndDeleteComponent  searchAndDeleteComponent) {
            this.controller = controller;
            this.searchAndDeleteComponent = searchAndDeleteComponent;
        }

        public void actionPerformed(ActionEvent event) {

            int number = 0;

            if (searchAndDeleteComponent.checkOnPass4() == true)
                JOptionPane.showMessageDialog(new JFrame(), "Ошибка! Не все данные введены");

            else {
                for (int i = 0; i < controller.size(); i++) {

                    if (searchAndDeleteComponent.findStudent4(i)) {
                        number++;
                        controller.deleteStudent(i);
                        mainFrame.updateMainFrame();
                    }
                }
                if (number == 0) {
                    JOptionPane.showMessageDialog(new JFrame(), "Ничего не найдено. Попробуйте еще раз");
                }
                else {
                    JOptionPane.showMessageDialog(new JFrame(), "Удалено "+ number + " студента(-ов)");
                }
            }
        }
    }



}
