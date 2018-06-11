package View;

import Model.StudentBase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OperationsOnTable {

    public static final int NULL = 0;
    public static final int ONE = 1;

    private StudentBase studentBase;
    
    private int firstNumberEntriesOnPage = 20;
    private int numberCurrentEntries = 0;
    private int numberAllEntries = 0;
    private int numberCurrentPage = 0;
    private int numberAllPages = 0;

    private TableModel model = new TableModel();
    private JTable table = new JTable(model);
    private JScrollPane jsp = new JScrollPane(table);

    int begin;
    int end;

    public JPanel panel = new JPanel();

    private ImageIcon image1 = new ImageIcon("back.png");
    private ImageIcon image2 = new ImageIcon("next.png");

    private JButton backButton = new JButton(image1);
    private JButton nextButton = new JButton(image2);
    private JButton firstPageButton = new JButton("На первую страницу");
    private JButton lastPageButton = new JButton("На последнюю страницу");
    private JButton otherNumberRecord = new JButton("Изменить");

    private JLabel numberEntriesOnPageLabel = new JLabel("Число записей:");
    private JTextField numberEntriesOnPageTextField = new JTextField(10);   
   
    private JLabel currentNumberEntriesValue = new JLabel();
    private JLabel numberAllEntriesValue = new JLabel();
    private JLabel currentNumberPageValue = new JLabel();
    private JLabel numberAllPagesValue = new JLabel();

    public OperationsOnTable(StudentBase studentBase)
    {
        this.studentBase = studentBase;
    }

    public JPanel createPanel() {

        nextButton.addActionListener(new nextButtonActionListener());
        backButton.addActionListener(new prevButtonActionListener());
        firstPageButton.addActionListener(new firstButtonActionListener());
        lastPageButton.addActionListener(new lastButtonActionListener());
        otherNumberRecord.addActionListener(new newEntriesNumberActionListener());

        JLabel currentNumberEntriesLabel = new JLabel("Текущее число записей:");
        currentNumberEntriesValue.setText(String.valueOf(numberCurrentEntries));

        JLabel numberAllEntriesLabel = new JLabel("Число всех записей:");
        numberAllEntriesValue.setText(String.valueOf(numberAllEntries));

        JLabel currenrNumberPageLabel = new JLabel("Текущий номер страницы:");
        currentNumberPageValue.setText(String.valueOf(numberCurrentPage));
        numberCurrentPage ++;

        JLabel numberAllPagesLabel = new JLabel("Число всех страниц:");
        numberAllPagesValue.setText(String.valueOf(numberAllPages));

        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout());
        panel1.add(firstPageButton, new GridBagConstraints(0, 0, 2, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
        panel1.add(backButton, new GridBagConstraints(1, 0, 2, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
        panel1.add(nextButton, new GridBagConstraints(2, 0, 2, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
        panel1.add(lastPageButton, new GridBagConstraints(3, 0, 2, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));

        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout());
        panel2.add(numberEntriesOnPageLabel, new GridBagConstraints(0, 0, 2, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
        panel2.add(numberEntriesOnPageTextField, new GridBagConstraints(1, 0, 2, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
        panel2.add(otherNumberRecord, new GridBagConstraints(2, 0, 2, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));

        JPanel panel3 = new JPanel();
        panel3.setLayout(new GridLayout());
        panel3.add(currentNumberEntriesLabel, new GridBagConstraints(0, 0, 2, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
        panel3.add(currentNumberEntriesValue, new GridBagConstraints(1, 0, 2, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
        panel3.add(numberAllEntriesLabel, new GridBagConstraints(1, 0, 2, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
        panel3.add(numberAllEntriesValue, new GridBagConstraints(1, 1, 2, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));

        JPanel panel4 = new JPanel();
        panel4.setLayout(new GridLayout());
        panel4.add(currenrNumberPageLabel, new GridBagConstraints(0, 0, 2, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
        panel4.add(currentNumberPageValue, new GridBagConstraints(1, 0, 2, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
        panel4.add(numberAllPagesLabel, new GridBagConstraints(1, 0, 2, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
        panel4.add(numberAllPagesValue, new GridBagConstraints(1,1, 2, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));

        panel.setLayout(new GridBagLayout());
        panel.add(panel1, new GridBagConstraints(0, 0, 2, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
        panel.add(panel2, new GridBagConstraints(0,1, 2, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
        panel.add(panel3, new GridBagConstraints(0, 2, 2, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
        panel.add(panel4, new GridBagConstraints(0,3, 2, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));

        return panel;
    }

    public void createTable(StudentBase studentBase)
    {
        this.studentBase = studentBase;

        if(numberEntriesOnPageTextField.getText().isEmpty())
            numberCurrentEntries = firstNumberEntriesOnPage;

        numberAllEntriesValue.setText(String.valueOf(studentBase.size()));
        numberAllPages = (int) Math.ceil((float) studentBase.size() / numberCurrentEntries);

        if((numberCurrentPage > numberAllPages) && (numberAllPages!=NULL)) {
            numberCurrentPage = numberAllPages;
        }

        currentNumberEntriesValue.setText(String.valueOf(numberCurrentEntries));

        if(numberCurrentPage == ONE) {
            backButton.setEnabled(false);
            firstPageButton.setEnabled(false);
        }
        else {
            backButton.setEnabled(true);
            firstPageButton.setEnabled(true);
        }

        if(numberCurrentPage == numberAllPages) {
            nextButton.setEnabled(false);
            lastPageButton.setEnabled(false);
            if(studentBase.size()%numberCurrentEntries != NULL) {
                currentNumberEntriesValue.setText(String.valueOf(studentBase.size() % numberCurrentEntries));
            }
            else currentNumberEntriesValue.setText(String.valueOf(numberCurrentEntries));
        }
        else {
            nextButton.setEnabled(true);
            lastPageButton.setEnabled(true);
        }

        numberAllPagesValue.setText(String.valueOf(numberAllPages));

        model.deleteStudents();
        
        begin = (numberCurrentPage - ONE)*numberCurrentEntries;

        if(studentBase.size() >= begin+numberCurrentEntries) {
            end = begin+numberCurrentEntries;
        }
        else {
            end = ((studentBase.size()%numberCurrentEntries) + begin);
        }

        for (int i = begin; i < end; i++) {
            model.addStudent(studentBase.get(i));
        }

        currentNumberPageValue.setText(String.valueOf(numberCurrentPage));
        
        if(studentBase.size()==NULL) {
            currentNumberEntriesValue.setText(String.valueOf(NULL));
            numberAllPagesValue.setText(String.valueOf(NULL));
            numberAllEntriesValue.setText(String.valueOf(NULL));
            currentNumberPageValue.setText(String.valueOf(NULL));
        }
    }

    public class nextButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            numberCurrentPage++;
            createTable(studentBase);
        }
    }

    public class prevButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            numberCurrentPage--;
            createTable(studentBase);
        }
    }

    public class firstButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            numberCurrentPage = ONE;
            createTable(studentBase);
        }
    }

    public class lastButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            numberCurrentPage = numberAllPages;
            createTable(studentBase);
        }
    }

    public class newEntriesNumberActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            if((Integer.parseInt(numberEntriesOnPageTextField.getText()) <= NULL) && !(numberEntriesOnPageTextField.getText().equals("")) ) {
                JOptionPane.showMessageDialog(new Frame(), "Некорректный ввод!");
                numberCurrentEntries = firstNumberEntriesOnPage;
            }
            else
                numberCurrentEntries = Integer.parseInt(numberEntriesOnPageTextField.getText());
            createTable(studentBase);
        }
    }

    public  JScrollPane getJsp()
    {
        return jsp;
    }


}
