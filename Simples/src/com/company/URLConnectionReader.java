import org.json.JSONArray;
import org.json.JSONObject;

import java.net.*;
import java.io.*;
import java.util.ArrayList;
//API Site
//https://developer.valvesoftware.com/wiki/Steam_Web_API#GetGlobalStatsForGame_.28v0001.29


class BufferReaderFile {
    private String line;
    private String file;

    private void parse(BufferedReader s) throws Exception {
        file = "";
        while ((line = s.readLine()) != null) {
            file = file + line;
        }
        s.close();
    }

    public BufferReaderFile(String filepath) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filepath));
        parse(bufferedReader);
    }

    public BufferReaderFile(Reader stream) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(stream);
        parse(bufferedReader);
    }

    public String getFile() {
        return file;
    }
}

class Match {
    private JSONObject jsonObject;

    public Match(String file) throws Exception {
        this.jsonObject = new JSONObject(file);
    }

    public JSONObject getplayerstats(int i)  throws Exception {
        JSONObject match = this.jsonObject.getJSONObject("result");
        JSONArray players =  match.getJSONArray("players");
        JSONObject player = players.getJSONObject(i);

        return player;
    }

    public String resultmatch() throws Exception {
   String result =  this.jsonObject.getString("result");
        return result;
    }

    public String getidplayer(int i) throws Exception{
        JSONObject idplayer = this.getplayerstats(i);
        return  idplayer.getString("account_id");
    }

}

public class URLConnectionReader {
    private static String url;
    private static String ABILITIES = "data/abilities.json";
    private static String HEROES = "https://api.steampowered.com/IEconDOTA2_570/GetHeroes/v0001/?key=4CF8B3DF4EF7B7BBD041E21E620DB912&language=?ru_ru";
    private static String ITEMS = "data/items.json";


    public static void main(String[] args) throws Exception {
        url = "https://api.steampowered.com/IDOTA2Match_570/GetMatchDetails/V001/?match_id=2684466831&key=4CF8B3DF4EF7B7BBD041E21E620DB912";
        URL oracle = new URL(url);
        URLConnection yc = oracle.openConnection();
        BufferReaderFile abilities = new BufferReaderFile(ABILITIES);
        BufferReaderFile URL = new BufferReaderFile(new InputStreamReader(yc.getInputStream()));
        BufferReaderFile heroes = new BufferReaderFile(HEROES);

        ArrayList<String> dota2 = new ArrayList<>();
        dota2.add(URL.getFile());
       // dota2.add(abilities.getFile());
      //  dota2.add(heroes.getFile());
        Match match = new Match(dota2.get(0));
        System.out.println(match.resultmatch());
        System.out.println(match.getplayerstats(9));
        System.out.println(match.getidplayer(0));

    }
}



