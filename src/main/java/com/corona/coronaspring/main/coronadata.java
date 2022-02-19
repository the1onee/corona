package com.corona.coronaspring.main;

import com.corona.coronaspring.modedd.loc;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@Service

public class coronadata
{
    public List<loc> getAlllist() {
        return alllist;
    }

    public void setAlllist(List<loc> alllist) {
        this.alllist = alllist;
    }

    private static String url_data_virous="https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/archived_data/archived_daily_case_updates/02-11-2020_2044.csv";
    private List<loc> alllist=new ArrayList<>();
    @PostConstruct
    @Scheduled(cron = "* * * 1 * *")
    public void datacss_corona() throws IOException, InterruptedException {
          List<loc> newlist=new ArrayList<>();
        HttpClient client=HttpClient.newHttpClient();
        HttpRequest requst = (HttpRequest) HttpRequest.newBuilder().uri(URI.create(url_data_virous)).build();
        HttpResponse<String> httpResponse= client.send(requst, HttpResponse.BodyHandlers.ofString());
        StringReader csvreder=new StringReader(httpResponse.body());
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(csvreder);
        for (CSVRecord record : records) {
            loc loc=new loc();
            loc.setState(record.get("Province/State"));
          loc.setCountry(record.get("Country/Region"));
          loc.setLastetotal(Integer.parseInt(record.get(record.size()-1)));
          System.out.println(loc);
          newlist.add(loc);
        }
        this.alllist=newlist;


    }

}

