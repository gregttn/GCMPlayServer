package models;

import play.data.validation.Constraints.Required;

public class Message {
    @Required
    public String content;
}
