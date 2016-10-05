import org.json.JSONArray;
import org.json.JSONObject;

//API Site
//https://developer.valvesoftware.com/wiki/Steam_Web_API#GetGlobalStatsForGame_.28v0001.29

import java.net.*;
import java.io.*;


public class URLConnectionReader {
    private static String url;

    public static void main(String[] args) throws Exception {
        url = "https://api.steampowered.com/IDOTA2Match_570/GetMatchDetails/V001/?match_id=2684466831&key=4CF8B3DF4EF7B7BBD041E21E620DB912";
        URL oracle = new URL(url);
        URLConnection yc = oracle.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                yc.getInputStream()));
        String inputLine;
        String Json = "";
        while ((inputLine = in.readLine()) != null) {
            Json = Json + inputLine;
        }
        in.close();
        data/abilities.json
        JSONObject jsonObject = new JSONObject(Json);
        JSONObject match = jsonObject.getJSONObject("result");
        //String matchresult = jsonObject.getString("result");
        JSONArray players = match.getJSONArray("players");
        JSONObject player = players.getJSONObject(1);
        String name = player.getString("account_id");

        // System.out.println(match);
        System.out.println(players.length());
        System.out.println(name);
        System.out.println(matchresult);
    }
}

    File f = new File("data/1.txt");
    FileInputStream fop = null;
        try {
                fop = new FileInputStream(f);
                } catch (FileNotFoundException e) {
                e.printStackTrace();
                }
                int i = -1;
                while ((i = fop.read() )!= -1) {
                System.out.println((char)i);
                }