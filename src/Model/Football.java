package Model;

public class Football {

    public static final int FOOTBALLTEAM = 0;
    public static final int COMPOSITION = 1;
    public static final int POSITION = 2;

    private String footballTeam;
    private String composition;
    private String position;

    public Football (String footballTeam, String composition, String position) {
        this.footballTeam = footballTeam;
        this.composition = composition;
        this.position = position;
    }

    public Football() {

    }

    public void setFootballTeam(String footballTeam) { this.footballTeam = footballTeam; }
    public void setComposition(String composition) { this.composition = composition; }
    public void setPosition(String position) { this.position = position; }

    public String getFootballTeam() { return footballTeam; }
    public String getComposition() { return composition; }
    public String getPosition() { return position; }

    public Object getValue(int columnIndex) {
        switch (columnIndex)
        {
            case FOOTBALLTEAM: return footballTeam;
            case COMPOSITION: return composition;
            case POSITION: return position;
        }
        return null;
    }

}
