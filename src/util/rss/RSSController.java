/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util.rss;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 *
 * @author Marvin
 */
public class RSSController {

    private final String copyright = "Copyright hold by Moha Messri, Marvin Rüsenberg, Roland Kompalka";
    private final String title = "ChessXML Moves";
    private final String description = "Moves made by players while playing a game of Chess";
    private final String language = "en";
    private final String link = "localhost/ChessXML/rss/feed.xml";
    private int GUID;
    private Feed feed;
    private String filepath;

    public RSSController(String filepath) {
        this.filepath = filepath;
        this.GUID = 0;
    }

    public void setUpFeed() {

        Calendar cal = new GregorianCalendar();
        Date creationDate = cal.getTime();
        SimpleDateFormat date_format = new SimpleDateFormat(
                "EEE', 'dd' 'MMM' 'yyyy' 'HH:mm:ss' 'Z", Locale.ENGLISH);
        String pubdate = date_format.format(creationDate);

        this.feed = new Feed(this.title, this.link, this.description, this.language,
                this.copyright, pubdate);
    }

    public void addFeedItem(String player, String figure, String startX, String startY, String targetX, String targetY) {
        this.GUID++;
        FeedMessage newItem = new FeedMessage();
        newItem.setTitle(player + " made a move.");
        newItem.setDescription(player + " moved his " + figure + " from " + startX + "|" + startY + " to " + targetX + "|" + targetY);
        newItem.setAuthor("ChessXML");
        newItem.setLink(this.link);
        newItem.setGuid(String.valueOf(this.GUID));
        this.feed.getMessages().add(newItem);

        RSSWriter writer = new RSSWriter(this.feed, this.filepath);
        try {
            writer.write();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
