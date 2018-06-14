package ali.naseem.keeper;

public class Player {
    private String name;
    private String image;
    private int runs=0;

    public Player(String name, String image) {
        this.name = name;
        this.image = image;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getRuns() {
        return runs;
    }

    public void setRuns(int runs) {
        this.runs = runs;
    }
}
