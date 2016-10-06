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

    public BufferReaderFile(Reader potok) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(potok);
        parse(bufferedReader);
    }

    public String getFile() {
        return file;
    }
}

class Match {
    private JSONObject jsonObject;
    public Match(String file) throws Exception {
        JSONObject jsonObject = new JSONObject(file);
        JSONObject match = jsonObject.getJSONObject("result");
        String matchresult = jsonObject.getString("result");
        JSONArray players = match.getJSONArray("players");
        JSONObject player1 = players.getJSONObject(0);
    }

    public String getplayer(int i) {
        return null;
    }

    public String resultmatch() {

        return null;
    }
}

public class URLConnectionReader {
    private static String url;

    public static void main(String[] args) throws Exception {
        url = "https://api.steampowered.com/IDOTA2Match_570/GetMatchDetails/V001/?match_id=2684466831&key=4CF8B3DF4EF7B7BBD041E21E620DB912";
        URL oracle = new URL(url);
        URLConnection yc = oracle.openConnection();
        BufferReaderFile readAbilities = new BufferReaderFile("data/abilities.json");
        BufferReaderFile readerURL = new BufferReaderFile(new InputStreamReader(yc.getInputStream()));
        BufferReaderFile readHeroes = new BufferReaderFile("data/heroes.json");
        ArrayList<String> dota2 = new ArrayList<String>();
        dota2.add(readAbilities.getFile());
        dota2.add(readerURL.getFile());
        dota2.add(readHeroes.getFile());
        System.out.println(dota2.get(1));
    }
}



