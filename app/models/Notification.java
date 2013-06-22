package models;

import play.data.validation.Constraints.Required;

public class Notification {
    private final static String DEFAULT_CONTENT_ID = "message";

    @Required
    private String content;
    private String contentId;

    public Notification() {
        this("");
    }

    public Notification(String content) {
        this(content, DEFAULT_CONTENT_ID);
    }

    public Notification(String content, String contentId) {
        this.content = content;
        this.contentId = contentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
    }
}
