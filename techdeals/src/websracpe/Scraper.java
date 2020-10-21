package websracpe;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class Scraper {
    public static void main(String[] args) throws IOException {

        final String url = "https://www.amazon.co.uk/Best-Sellers-Computers-Accessories-Keyboards/zgbs/computers/430565031/ref=zg_bs_nav_computers_3_429885031";
        final Document document = Jsoup.connect(url).get();

        String productSelector = ".zg-item.aok-inline-block > a.a-link-normal";
        Elements productElements = document.select(productSelector);
        ArrayList<String> productName = new ArrayList<>();

        String priceSelector = ".p13n-sc-price";
        Elements priceElements = document.select(priceSelector);
        ArrayList<String> productPrice = new ArrayList<>();

        for (Element e : productElements){
            productName.add(e.text());
        }

        for (Element p : priceElements){
            productPrice.add(p.text());
        }

        for(int i = 0; i < productName.size() && i < productPrice.size(); i++){
            System.out.println(productName.get(i) + productPrice.get(i));
        }

    }
}
