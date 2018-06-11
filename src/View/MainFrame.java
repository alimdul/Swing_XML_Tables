package View;

import Controller.Handler;
import Controller.Save;
import Controller.StudentController;
import Model.StudentBase;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class MainFrame {

    private StudentController studentController;
    private StudentBase studentBase;

    private JFrame mainFrame = new JFrame();
    private String title;
    private Dimension d;

    private OperationsOnTable operationsOnTable;

    private JMenuBar menuBar = new JMenuBar();
    private JMenu menu = new JMenu("Меню");
    private JMenuItem menuItem1 = new JMenuItem("Открыть файл");
    private JMenuItem menuItem2 = new JMenuItem("Сохранить в файл");
    private JMenuItem menuItem3 = new JMenuItem("Добавить студента");
    private JMenuItem menuItem4 = new JMenuItem("Найти студента");
    private JMenuItem menuItem5 = new JMenuItem("Удалить студента");
    private JMenuItem menuItem6 = new JMenuItem("Выйти");

    private JToolBar toolBar = new JToolBar();
    private ImageIcon image1 = new ImageIcon("open.png");
    private ImageIcon image2 = new ImageIcon("save.png");
    private ImageIcon image3 = new ImageIcon("add.png");
    private ImageIcon image4 = new ImageIcon("search.png");
    private ImageIcon image5 = new ImageIcon("delete.png");
    private ImageIcon image6 = new ImageIcon("close.png");
    private JButton openButton = new JButton(image1);
    private JButton saveButton = new JButton(image2);
    private JButton addButton = new JButton(image3);
    private JButton searchButton = new JButton(image4);
    private JButton deleteButton = new JButton(image5);
    private JButton closeButton = new JButton(image6);

    private JPanel panel = new JPanel();

    public MainFrame (String title, Dimension d, StudentController studentController) {

        this.title = title;
        this.d = d;
        this.studentController = studentController;
        this.studentBase = studentController.getStudentBase();
        operationsOnTable = new OperationsOnTable(studentController.getStudentBase());
    }

    public MainFrame() {}

    public void init () {

        mainFrame.setTitle(title);
        mainFrame.setSize(d);
        mainFrame.setLayout(new BorderLayout());
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLocationRelativeTo(null);

        mainFrame.add(operationsOnTable.getJsp(), BorderLayout.CENTER);
        operationsOnTable.getJsp().setPreferredSize(new Dimension(800, 400));

        openButton.addActionListener(new OpenButtonActionListener());
        menuItem1.addActionListener(new OpenButtonActionListener());
        closeButton.addActionListener(new CloseButtonActionListener());
        menuItem6.addActionListener(new CloseButtonActionListener());
        addButton.addActionListener(new AddButtonActionListener());
        menuItem3.addActionListener(new AddButtonActionListener());
        searchButton.addActionListener(new SearchButtonActionListener());
        menuItem4.addActionListener(new SearchButtonActionListener());
        deleteButton.addActionListener(new DeleteButtonActionListener());
        menuItem5.addActionListener(new DeleteButtonActionListener());
        saveButton.addActionListener(new SaveButtonActionListener());
        menuItem2.addActionListener(new SaveButtonActionListener());

        menu.add(menuItem1);
        menu.add(menuItem2);
        menu.add(menuItem3);
        menu.add(menuItem4);
        menu.add(menuItem5);
        menu.add(menuItem6);

        menuBar.add(menu);
        mainFrame.setJMenuBar(menuBar);

        toolBar.add(openButton);
        toolBar.add(saveButton);
        toolBar.add(addButton);
        toolBar.add(searchButton);
        toolBar.add(deleteButton);
        toolBar.add(closeButton);

        mainFrame.getContentPane().add(toolBar, BorderLayout.NORTH);

        panel = operationsOnTable.createPanel();

        mainFrame.add(panel,BorderLayout.SOUTH);

        mainFrame.setVisible(true);
        mainFrame.pack();
    }

    public class CloseButtonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {

            int respons = JOptionPane.showConfirmDialog(mainFrame, "Вы действительно хотите выйти?", "Подтверждение запроса", JOptionPane.YES_NO_OPTION);
            switch (respons) {
                case JOptionPane.YES_OPTION:
                    System.exit(0);
                    break;
                case JOptionPane.NO_OPTION:
                    break;
                case JOptionPane.CLOSED_OPTION:
                    break;
            }
        }
    }

    public class OpenButtonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {

            JFileChooser fileopen = new JFileChooser();
            int ret = fileopen.showDialog(null, "Открыть файл");
            if (ret == JFileChooser.APPROVE_OPTION) {
                File file = fileopen.getSelectedFile();

            SAXParserFactory parserF = SAXParserFactory.newInstance();
            Handler handler = new Handler(studentController, MainFrame.this);
            try {
                SAXParser saxParser = parserF.newSAXParser();
                saxParser.parse(new File("src/" + file.getName()), handler);
            } catch (ParserConfigurationException e) {
                e.printStackTrace();
            } catch (SAXException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            }
        }
    }

    public class SaveButtonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {

            Save save = new Save(studentController);
            Document document = null;
            try {
                document = save.getDocument();
            } catch (ParserConfigurationException e) {
                e.printStackTrace();
            }

            JFileChooser fileopen = new JFileChooser();
            int ret = fileopen.showDialog(null, "Сохранить в файл");
            if (ret == JFileChooser.APPROVE_OPTION) {
                File file = fileopen.getSelectedFile();

                TransformerFactory factory = TransformerFactory.newInstance();
                try {
                    Transformer transformer = factory.newTransformer();
                    Properties format = new Properties();
                    format.setProperty(OutputKeys.INDENT,"yes");
                    transformer.setOutputProperties(format);
                    DOMSource domSource = new DOMSource(document);
                    StreamResult streamFile = new StreamResult(new File("src/" + file.getName()));

                    transformer.transform(domSource, streamFile);
                } catch (TransformerConfigurationException e) {
                    e.printStackTrace();
                } catch (TransformerException e) {
                    e.printStackTrace();
                }
            }
            }
    }

    public class AddButtonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {

        AddDialog addDialog = new AddDialog(studentController, MainFrame.this);
        addDialog.initAddDialog();
        }
    }

    public class SearchButtonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {

            SearchDialog searchDialog = new SearchDialog(studentController, studentBase);
            searchDialog.initSearchDialog();
        }
    }

    public class DeleteButtonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {

            DeleteDialog deleteDialog = new DeleteDialog(studentController, MainFrame.this);
            deleteDialog.initDeleteDialog();
        }
    }

    public void updateMainFrame() {

        operationsOnTable.createTable(studentBase);
    }
}







