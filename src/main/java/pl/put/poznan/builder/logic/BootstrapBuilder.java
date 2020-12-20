package pl.put.poznan.builder.logic;

import com.google.gson.Gson;

/**
 * Class that contains methods to get the information about bootstrap based webpage from the json
 * and then generate html based on that information
 * @author Jakub Różycki & Joanna Bronka & Mateusz Lemański & Mateusz Kempa
 * @version 1.0
 */
public class BootstrapBuilder {

    private String jsonContent;
    private BootstrapData bootstrapData;
    private Gson gson = new Gson();

    public String getJsonContent() {
        return jsonContent;
    }

    public void setJsonContent(String jsonContent) {
        this.bootstrapData = gson.fromJson(jsonContent, BootstrapData.class);
    }

    /**
     * Generates html code for web page based on informations given by Builder's template.
     * Covers everything inside 'body' tag.
     *
     * @return  html code as String
     */
    public String getBodyContent() {
        String result = "";

        //navbar
        if (this.bootstrapData.isHeader) {
            result += "<nav class=\"navbar";
            if (this.bootstrapData.responsive) {
                result += " navbar-expand-md";
            }
            switch (this.bootstrapData.header.style) {
                case "dark": result += " bg-dark navbar-dark"; break;
                case "light": result += " bg-light navbar-light"; break;
                case "blue": result += " bg-primary navbar-dark"; break;
                default: result += " bg-success navbar-dark";
            }
            result += this.bootstrapData.header.fixed ? " fixed-top" : " static-top";
            result += "\">";

            //brand name
            result += "<a class=\"navbar-brand\" href=\"#\">" + this.bootstrapData.header.name + "</a>";

            //collapsing button
            if (this.bootstrapData.header.collapsable) {
                result += "<button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#collapsibleNavbar\">"
                        + "<span class=\"navbar-toggler-icon\"></span></button>\n";
                result += "<div class=\"collapse navbar-collapse\" id=\"collapsibleNavbar\">";
            }



            //search form
            if (this.bootstrapData.header.searchform) {
                result += "<form class=\"form-inline\" action=\"#\">"
                        + "<input class=\"form-control mr-sm-2\" type=\"text\" placeholder=\"Search\">"
                        + "<button class=\"btn btn-secondary\" type=\"submit\">Search</button></form>";
            }

            if (this.bootstrapData.header.collapsable) { result += "</div>"; }

            result += "</nav>";
        }


        System.out.println(result);
        return result;
    }

    /**
     * Returns title of the web page given by the Builder's user.
     *
     * @return title of the web page
     */
    public String getTitle(){ return this.bootstrapData.title; }

}
