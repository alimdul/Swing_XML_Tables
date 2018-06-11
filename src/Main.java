import Controller.StudentController;
import Model.StudentBase;
import View.MainFrame;

import java.awt.*;

public class Main {

    public static void main(String[] args) {
        StudentBase studentBase = new StudentBase();
        StudentController studentController = new StudentController(studentBase);

        MainFrame mf = new MainFrame("laba2", new Dimension(800,800), studentController);
        mf.init();
    }
}

