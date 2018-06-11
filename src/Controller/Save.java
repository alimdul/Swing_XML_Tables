package Controller;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class Save {

    private StudentController controller;

    public Save (StudentController controller) {
        this.controller = controller;
    }

    public org.w3c.dom.Document getDocument() throws ParserConfigurationException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();
        Document document = documentBuilder.newDocument();

        Element students = document.createElement("Students");
        document.appendChild(students);

        for (int i=0; i<controller.size(); i++) {

            Element student = document.createElement("Student");
            students.appendChild(student);

            Element surname = document.createElement("surname");
            surname.appendChild(document.createTextNode(controller.getStudent(i).getSurName()));
            student.appendChild(surname);

            Element firstname = document.createElement("firstname");
            firstname.appendChild(document.createTextNode(controller.getStudent(i).getFirstName()));
            student.appendChild(firstname);

            Element lastname = document.createElement("lastname");
            lastname.appendChild(document.createTextNode(controller.getStudent(i).getLastName()));
            student.appendChild(lastname);

            Element date = document.createElement("date");
            date.appendChild(document.createTextNode(controller.getStudent(i).getDate().toString()));
            student.appendChild(date);

            Element faculty = document.createElement("faculty");
            faculty.appendChild(document.createTextNode(controller.getStudent(i).getFaculty()));
            student.appendChild(faculty);

            Element football = document.createElement("football");
            student.appendChild(football);

            Element footballteam = document.createElement("footballteam");
            footballteam.appendChild(document.createTextNode(controller.getStudent(i).getFootball().getFootballTeam()));
            football.appendChild(footballteam);

            Element composition = document.createElement("composition");
            composition.appendChild(document.createTextNode(controller.getStudent(i).getFootball().getComposition()));
            football.appendChild(composition);

            Element position = document.createElement("position");
            position.appendChild(document.createTextNode(controller.getStudent(i).getFootball().getPosition()));
            football.appendChild(position);
        }
        return document;
    }
}
