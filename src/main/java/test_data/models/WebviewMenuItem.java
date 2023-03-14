package test_data.models;

public class WebviewMenuItem {

    private String text;
    private String href;

    public WebviewMenuItem(String text, String href) {
        this.text = text;
        this.href = href;
    }

    public String getText() {
        return text;
    }

    public String getHref() {
        return href;
    }
}
