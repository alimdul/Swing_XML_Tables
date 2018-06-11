package Controller;

import Model.Football;
import Model.Student;
import View.MainFrame;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.swing.*;

public class Handler extends DefaultHandler {

    private StudentController controller;
    private MainFrame mainFrame;
    private String element;
    private Student student;
    private Football football;

    boolean surNameBool = false;
    boolean firstNameBool = false;
    boolean lastNameBool = false;
    boolean dateBool = false;
    boolean facultyBool = false;
    boolean footballTeamBool = false;
    boolean compositionBool = false;
    boolean positionBool = false;

    public Handler (StudentController controller, MainFrame mainFrame) {
        this.controller = controller;
        this.mainFrame = mainFrame;
    }

    @Override
    public void startDocument() throws SAXException {
        controller.deleteAllStudents();
        mainFrame.updateMainFrame();
    }

    @Override
    public void endDocument() throws SAXException {
        mainFrame.updateMainFrame();
        JOptionPane.showMessageDialog(new JFrame(), "Данные успешно добавлены");
    }

    @Override
    public void startElement(String namespace, String localName, String qName, Attributes attr) {

        if (qName.equals("Student")){
            this.student = new Student();
        }
        else if (qName.equals("surname")){
            surNameBool = true;
        }
        else if (qName.equals("firstname")){
            firstNameBool = true;
        }
        else if (qName.equals("lastname")){
            lastNameBool = true;
        }
        else if (qName.equals("date")){
            dateBool = true;
        }
        else if (qName.equals("faculty")){
            facultyBool = true;
        }
        else if (qName.equals("football")) {
            football = new Football();
        }
        else if (qName.equals("footballteam")) {
            footballTeamBool = true;
        }
        else if (qName.equals("composition")) {
            compositionBool = true;
        }
        else if (qName.equals("position")) {
            positionBool = true;
        }
    }

    @Override
    public void endElement(String namespace, String localName, String qName) throws SAXException {
        element = "";
        if (qName.equals("football")) {
            student.setFootball(this.football);
        }
        else if(qName.equals("Student")){
            controller.addStudentInStudentBase(student);
        }
    }

    @Override
    public void characters (char []ch, int start, int end) {

        if (surNameBool) {
            student.setSurName(new String(ch, start, end));
            surNameBool = false;
        }
        else if (firstNameBool) {
            student.setFirstName(new String(ch, start, end));
            firstNameBool = false;
        }
        else if (lastNameBool) {
            student.setLastName(new String(ch, start, end));
            lastNameBool = false;
        }
        else if (dateBool) {
            student.setDate(new String(ch, start, end));
            dateBool = false;
        }
        else if (facultyBool) {
            student.setFaculty(new String(ch, start, end));
            facultyBool = false;
        }
        else if (footballTeamBool) {
            football.setFootballTeam(new String(ch, start, end));
            footballTeamBool = false;
        }
        else if (compositionBool) {
            football.setComposition(new String(ch, start, end));
            compositionBool = false;
        }
        else if (positionBool) {
            football.setPosition(new String(ch, start, end));
            positionBool = false;
        }
    }
}
