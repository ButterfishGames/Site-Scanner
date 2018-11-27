/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author dmacisaa
 */
public class SiteScanner {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String url = "https://stackoverflow.com/questions/2835505";
        try
        {
            Document document = Jsoup.connect(url).get();

            String question = document.select("#question .post-text").text();
            System.out.println("Question: " + question);

            Elements answerers = document.select("#answers .user-details a");
            for (Element answerer : answerers) 
            {
                System.out.println("Answerer: " + answerer.text());
            }
        }
        catch (Exception e)
        {
            System.out.print(e);
        }
    }
}
