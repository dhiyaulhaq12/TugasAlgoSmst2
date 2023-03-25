package TM;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class firstConnect {
    public static void main(String[] args) throws IOException {
        Connect KoneksiSaya = new Connect();
        URL myAddres = KoneksiSaya.buildURL("https://farmasi.mimoapps.xyz/mimoqss2auyqD1EAlkgZCOhiffSsFl6QqAEIGtM");
        String response = KoneksiSaya.getResponseFromhttpUrl(myAddres);

        assert response != null;
        JSONArray responseJSON = new JSONArray(response);
        ArrayList<model> model = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < responseJSON.length(); i++){
            model resModel = new model();
            JSONObject myJSONObject = responseJSON.getJSONObject(i);
            String harga = myJSONObject.getString("i_sell");
            resModel.setI_sell(harga);
            model.add(resModel);

            int priceInt = Integer.parseInt(harga);
            if (priceInt <= 2000){
                count++;
            }
        }

        for (int index = 0; index < model.size(); index++){
            int sell = Integer.parseInt(model.get(index).getI_sell());
            if (sell<=2000){

                System.out.println("harga : " + sell);
            }
        }

        System.out.println("total harga obat 2000 = " +count );
    }


}
