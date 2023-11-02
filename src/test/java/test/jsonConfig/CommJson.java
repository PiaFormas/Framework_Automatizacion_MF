package test.jsonConfig;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class CommJson {
    private URL url = null;
    private HttpURLConnection urlOC = null;
    private StringBuilder builder = null;

    public CommJson() {
    }

    public void setConn(String urlSrv) {
        try {
            this.url = new URL(urlSrv);
            this.urlOC = (HttpURLConnection)this.url.openConnection();
        } catch (MalformedURLException var3) {
            var3.printStackTrace();
        } catch (IOException var4) {
            var4.printStackTrace();
        }

    }

    public void setConnParams(String urlSrv, LinkedHashMap<String, String> params) throws Exception {
        String url = urlSrv + "?";
        boolean first = true;
        Iterator var5 = params.entrySet().iterator();

        while(var5.hasNext()) {
            Map.Entry<String, String> entry = (Map.Entry)var5.next();
            if (first) {
                first = false;
                url = url + (String)entry.getKey() + "=" + (String)entry.getValue();
            } else {
                url = url + "&" + (String)entry.getKey() + "=" + (String)entry.getValue();
            }
        }

        this.setConn(url);
    }

    public String getJsonData() {
        try {
            this.builder = new StringBuilder();
            BufferedReader bfr = new BufferedReader(new InputStreamReader(this.urlOC.getInputStream()));

            String line;
            while((line = bfr.readLine()) != null) {
                this.builder.append(line);
            }
        } catch (IOException var3) {
            var3.printStackTrace();
            this.builder.append("");
        }

        return this.builder.toString();
    }

    public String getJsonDataError() {
        try {
            this.builder = new StringBuilder();
            BufferedReader bfr = new BufferedReader(new InputStreamReader(this.urlOC.getErrorStream()));

            String line;
            while((line = bfr.readLine()) != null) {
                this.builder.append(line);
            }
        } catch (IOException var3) {
            var3.printStackTrace();
            this.builder.append("");
        }

        return this.builder.toString();
    }

    //public int getResponseCode() {
       // int response = false;

        //int response;
        //try {
            //HttpURLConnection httpConnection = this.urlOC;
           // response = httpConnection.getResponseCode();
      //  } catch (IOException var3) {
         //   var3.printStackTrace();
         //   response = 0;
      //  }

      //  return response;
   // }

    public String getResponseHeader(String header) {
        String headerResponse = "";

        try {
            HttpURLConnection httpConnection = this.urlOC;
            headerResponse = httpConnection.getHeaderField(header);
        } catch (Exception var4) {
            var4.printStackTrace();
            headerResponse = "";
        }

        return headerResponse;
    }

    public void postParametros(String parametros) {
        try {
            DataOutputStream wr = new DataOutputStream(this.urlOC.getOutputStream());
            wr.writeBytes(parametros);
            wr.flush();
            wr.close();
        } catch (Exception var3) {
            var3.printStackTrace();
        }

    }

    public void setRequestMethod(String metodo) {
        try {
            this.urlOC.setRequestMethod(metodo);
        } catch (Exception var3) {
            var3.printStackTrace();
        }

    }

    public void setRequestProperty(String key, String value) {
        try {
            this.urlOC.setRequestProperty(key, value);
            this.urlOC.setDoOutput(true);
            this.urlOC.setDoInput(true);
        } catch (Exception var4) {
            var4.printStackTrace();
        }

    }

    public String getDataString(Map<String, String> params) {
        StringBuilder result = new StringBuilder();
        boolean first = true;

        try {
            Iterator var4 = params.entrySet().iterator();

            while(var4.hasNext()) {
                Map.Entry<String, String> entry = (Map.Entry)var4.next();
                if (first) {
                    first = false;
                } else {
                    result.append("&");
                }

                result.append(URLEncoder.encode((String)entry.getKey(), "UTF-8"));
                result.append("=");
                result.append(URLEncoder.encode((String)entry.getValue(), "UTF-8"));
            }
        } catch (UnsupportedEncodingException var6) {
            var6.printStackTrace();
            result.append("");
        }

        return result.toString();
    }

    public void closeSession() throws IOException {
        HttpURLConnection httpConnection = this.urlOC;
        httpConnection.disconnect();
    }
}
