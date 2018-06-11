package View;

import Controller.StudentController;
import Model.StudentBase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchDialog {

    private StudentController controller;
    private StudentBase studentBase;
    private OperationsOnTable operationsOnTable;

    public JDialog searchDialog = new JDialog();

    private JButton searchButton1 = new JButton("Поиск по ФИО и дате рождения");
    private JButton searchButton2 = new JButton("Поиск по позиции и составу");
    private JButton searchButton3 = new JButton("Поиск по ФИО и футбольной команде");
    private JButton searchButton4 = new JButton("Поиск по факультету и ФИО");

    public SearchDialog (StudentController controller, StudentBase studentBase) {

        this.controller = controller;
        this.studentBase = studentBase;
        operationsOnTable = new OperationsOnTable(studentBase);

        searchDialog.setTitle("Поиск студента");
        searchDialog.setSize(800, 800);
        searchDialog.setLocationRelativeTo(null);
        searchDialog.setLayout(new GridBagLayout());
        searchDialog.setResizable(false);
    }

    public void initSearchDialog () {

        SearchAndDeleteComponent searchAndDeleteComponent = new SearchAndDeleteComponent(searchDialog, controller);
        searchDialog = searchAndDeleteComponent.createDialog();

        searchButton1.addActionListener(new SearchDialog.searchButton1ActionListener(controller, searchAndDeleteComponent));
        searchButton2.addActionListener(new SearchDialog.searchButton2ActionListener(controller, searchAndDeleteComponent));
        searchButton3.addActionListener(new SearchDialog.searchButton3ActionListener(controller, searchAndDeleteComponent));
        searchButton4.addActionListener(new SearchDialog.searchButton4ActionListener(controller, searchAndDeleteComponent));

        searchDialog.add(searchButton1, new GridBagConstraints(0, 1, 3, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
        searchDialog.add(searchButton2, new GridBagConstraints(0, 2, 3, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
        searchDialog.add(searchButton3, new GridBagConstraints(0, 3, 3, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
        searchDialog.add(searchButton4, new GridBagConstraints(0, 4, 3, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));

        searchDialog.add(operationsOnTable.getJsp(), new GridBagConstraints(0, 5, 3, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
        operationsOnTable.getJsp().setPreferredSize(new Dimension(800,200));

        searchDialog.add(operationsOnTable.createPanel(),new GridBagConstraints(0, 6, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));

        searchDialog.pack();
        searchDialog.setVisible(true);
    }

    public class searchButton1ActionListener implements ActionListener {

        private StudentController controller;
        private SearchAndDeleteComponent searchAndDeleteComponent;
        private searchButton1ActionListener(StudentController controller, SearchAndDeleteComponent searchAndDeleteComponent) {
            this.controller = controller;
            this.searchAndDeleteComponent = searchAndDeleteComponent;
        }

        public void actionPerformed(ActionEvent event) {

            StudentBase base = new StudentBase();

            if (searchAndDeleteComponent.checkOnPass1() == true)
                JOptionPane.showMessageDialog(new JFrame(), "Ошибка! Не все данные введены" );

            else {
                for (int i = 0; i < studentBase.size(); i++) {

                    if (searchAndDeleteComponent.findStudent1(i) == true)
                        base.add(studentBase.get(i));
                }
                if (base.size() == 0) {
                    JOptionPane.showMessageDialog(new JFrame(), "Ничего не найдено. Попробуйте еще раз");
                }
                operationsOnTable.createTable(base);
            }
        }
    }

    public class searchButton2ActionListener implements ActionListener {

        private StudentController controller;
        private SearchAndDeleteComponent searchAndDeleteComponent;
        private searchButton2ActionListener(StudentController controller, SearchAndDeleteComponent searchAndDeleteComponent) {
            this.controller = controller;
            this.searchAndDeleteComponent = searchAndDeleteComponent;
        }

        public void actionPerformed(ActionEvent event) {

            StudentBase base = new StudentBase();


            if (searchAndDeleteComponent.checkOnPass2() == true)
                JOptionPane.showMessageDialog(new JFrame(), "Ошибка! Не все данные введены");

            else {
                for (int i = 0; i < studentBase.size(); i++) {

                    if (searchAndDeleteComponent.findStudent2(i) == true) {
                        base.add(studentBase.get(i));
                    }
                }
                if (base.size() == 0) {
                    JOptionPane.showMessageDialog(new JFrame(), "Ничего не найдено. Попробуйте еще раз");
                }
                operationsOnTable.createTable(base);
            }
        }
    }

    public class searchButton3ActionListener implements ActionListener {

        private StudentController controller;
        private SearchAndDeleteComponent searchAndDeleteComponent;
        private searchButton3ActionListener(StudentController controller, SearchAndDeleteComponent searchAndDeleteComponent) {
            this.controller = controller;
            this.searchAndDeleteComponent = searchAndDeleteComponent;
        }

        public void actionPerformed(ActionEvent event) {

            StudentBase base = new StudentBase();

            if (searchAndDeleteComponent.checkOnPass3() == true)
                JOptionPane.showMessageDialog(new JFrame(), "Ошибка! Не все данные введены");

            else {
                for (int i = 0; i < studentBase.size(); i++) {

                    if (searchAndDeleteComponent.findStudent3(i)) {
                        base.add(studentBase.get(i));
                    }
                }
                if (base.size() == 0) {
                    JOptionPane.showMessageDialog(new JFrame(), "Ничего не найдено. Попробуйте еще раз");
                }
                operationsOnTable.createTable(base);
            }
        }
    }

    public class searchButton4ActionListener implements ActionListener {

        private StudentController controller;
        private SearchAndDeleteComponent searchAndDeleteComponent;
        private searchButton4ActionListener(StudentController controller, SearchAndDeleteComponent  searchAndDeleteComponent) {
            this.controller = controller;
            this.searchAndDeleteComponent = searchAndDeleteComponent;
        }

        public void actionPerformed(ActionEvent event) {

            StudentBase base = new StudentBase();

            if (searchAndDeleteComponent.checkOnPass4() == true)
                JOptionPane.showMessageDialog(new JFrame(), "Ошибка! Не все данные введены");

            else {
                for (int i = 0; i < studentBase.size(); i++) {

                    if (searchAndDeleteComponent.findStudent4(i)) {
                        base.add(studentBase.get(i));
                    }
                }
                if (base.size() == 0) {
                    JOptionPane.showMessageDialog(new JFrame(), "Ничего не найдено. Попробуйте еще раз");
                }
                operationsOnTable.createTable(base);
            }
        }
    }


}
