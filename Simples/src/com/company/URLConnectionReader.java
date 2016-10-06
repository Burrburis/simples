import org.json.JSONArray;
import org.json.JSONObject;
import java.net.*;
import java.io.*;
//API Site
//https://developer.valvesoftware.com/wiki/Steam_Web_API#GetGlobalStatsForGame_.28v0001.29



class BufferReaderFile {
 private String Line;
         String file;
private void parse(BufferedReader s) throws Exception{
    file = "";
    while ((Line = s.readLine()) != null) {
        file = file + Line;
    }
    s.close();
}
    public BufferReaderFile(String filepath) throws Exception  {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filepath));
    parse(bufferedReader);
    }

    public BufferReaderFile(Reader potok) throws Exception  {
        BufferedReader bufferedReader = new BufferedReader(potok);
        parse(bufferedReader);
    }
}

public class URLConnectionReader {
    private static String url;
    public static void main(String[] args) throws Exception {
        url = "https://api.steampowered.com/IDOTA2Match_570/GetMatchDetails/V001/?match_id=2684466831&key=4CF8B3DF4EF7B7BBD041E21E620DB912";
        URL oracle = new URL(url);
        URLConnection yc = oracle.openConnection();
        BufferReaderFile readerFile = new BufferReaderFile("data/abilities.json");
        BufferReaderFile readerpotok = new BufferReaderFile(new InputStreamReader(yc.getInputStream()));
        System.out.println(readerFile.file);
        System.out.println(readerpotok.file);
    }
}

      /*  BufferedReader in = new BufferedReader(new InputStreamReader(
                yc.getInputStream()));
        BufferedReader s = new BufferedReader(new FileReader("1"));
        String inputLine;
        String Json = "";
        while ((inputLine = in.readLine()) != null) {
            Json = Json + inputLine;
        }
        in.close();

        JSONObject jsonObject = new JSONObject(Json);
        JSONObject match = jsonObject.getJSONObject("result");
        String matchresult = jsonObject.getString("result");
        JSONArray players = match.getJSONArray("players");
        JSONObject player = players.getJSONObject(1);
        String idplayer = player.getString("account_id");
        System.out.println(readerFile.file);
        String abilities = readerFile.file;
        JSONObject jsonAbilities = new JSONObject(abilities);
        JSONArray arrayAbilities = jsonAbilities.getJSONArray("abilities");
        JSONObject abilitie = arrayAbilities.getJSONObject(0);
        String nameabilitie = abilitie.getString("name");
        System.out.println(nameabilitie);
        */