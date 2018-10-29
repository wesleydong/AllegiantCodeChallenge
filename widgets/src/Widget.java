import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Widget implements Serializable {

    private int id;
    private String title;
    private String description;
    private List<Sprocket> sprockets;

    public Widget(int id) {
        this.id = id;
        sprockets = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Sprocket> getSprockets() {
        return sprockets;
    }


    public void addSprocket(Sprocket sprocket) {
        sprockets.add(sprocket);
    }
    public void setSprockets(List<Sprocket> sprockets) {
        this.sprockets = sprockets;
    }
}
