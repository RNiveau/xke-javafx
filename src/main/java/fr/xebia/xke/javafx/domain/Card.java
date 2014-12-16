package fr.xebia.xke.javafx.domain;

/**
 * Created by romainn on 15/12/2014.
 */
public class Card {

    private Integer category;

    private String title;

    private String url;

    private String summary;

    private String description;

    private String bitly;

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBitly() {
        return bitly;
    }

    public void setBitly(String bitly) {
        this.bitly = bitly;
    }
}
