package mk.news;

/**
 * Created by abbott on 05-Aug-17.
 */

public class list_view {


    private String news;
    private String Description;
    private String Image;
    private String news_Author;
    private String Full_Description;

    public list_view(String news, String description,String image,String author,String full_Description) {
        this.news = news;
        Description = description;
        Image=image;
        news_Author=author;
        Full_Description=full_Description;
    }

    public String getnews() {
        return news;
    }

    public String getDescription() {
        return Description;
    }

    public String getImage() {
        return Image;
    }

    public String getNews_Author() {
        return news_Author;
    }

    public String getFull_Description() {
        return Full_Description;
    }
}
