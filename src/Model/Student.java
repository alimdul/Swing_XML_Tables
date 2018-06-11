package Model;

import java.sql.Date;

public class Student {

    private String surName;
    private String firstName;
    private String lastName;
    private Date date;
    private Football football;
    private String faculty;

    public Student(String surName, String firstName, String lastName, Date date, String footballTeam, String faculty,
                   String composition, String position) {
        this.surName = surName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.date = date;
        this.football = new Football(footballTeam, composition, position);
        this.faculty = faculty;
    }

    public Student() {}

    public void setSurName(String surName) { this.surName = surName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setDate (String date) { this.date = (Date.valueOf(date)); }
    public void setFootball(Football football) { this.football = football; }
    public void setFaculty(String faculty) { this.faculty = faculty; }

    public String getSurName() { return surName; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public Date getDate() { return date; }
    public Football getFootball() { return football; }
    public String getFaculty() { return faculty; }

    public Object getValue(int columnIndex) {
        switch (columnIndex)
        {
            case 0: return surName+" "+firstName+" "+lastName;
            case 1: return date;
            case 2: return football.getValue(0);
            case 3: return faculty;
            case 4: return football.getValue(1);
            case 5: return football.getValue(2);
        }
        return null;
    }

}
