package pl.put.poznan.builder.logic;

import com.google.gson.Gson;

/**
 * This is just an example to show that the logic should be outside the REST service.
 */
public class BootstrapBuilder{

    private BootstrapInfo bootstrapInfo;
    private String jsonContent;
    private Gson gson = new Gson();

    public String getJsonContent() {
        return jsonContent;
    }

    public void setJsonContent(String jsonContent) {
        this.bootstrapInfo = gson.fromJson(jsonContent, BootstrapInfo.class);
    }


    public String generatePage(){


        String result = "";



        return result;
    }
}
