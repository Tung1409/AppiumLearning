package test_data.models;

public class TitleAndDescription {
    private String title;
    private String description;

    public TitleAndDescription(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
