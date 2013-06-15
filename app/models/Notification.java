package models;

import play.data.validation.Constraints.Required;

public class Notification {
    @Required
    private String content;

    public Notification() {
    }

    public Notification(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
