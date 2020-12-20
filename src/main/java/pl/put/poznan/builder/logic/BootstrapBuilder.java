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





            //search form
            if (this.bootstrapData.header.searchform) {
                result += "<form class=\"form-inline\" action=\"#\">"
                        + "<input class=\"form-control mr-sm-2\" type=\"text\" placeholder=\"Search\">"
                        + "<button class=\"btn btn-secondary\" type=\"submit\">Search</button></form>";
            }

            if (this.bootstrapData.header.collapsable) { result += "</div>"; }

            result += "</nav>";
        }

        //body (container)
        result += "<main class=\"";
        if (this.bootstrapData.body.container_fluid) {
            result += "container-fluid";
        } else {
            result += "container";
        }
        result += "\" style=\"flex: 1 0 auto";
        if (this.bootstrapData.header.fixed) {
            result += "; margin-top: 70px";
        } else {
            result += "; margin-top: 10px";
        }
        result += "\">";
        if (this.bootstrapData.body.content.equals("Lorem ipsum")) {
            for (int i = 0; i < 8; i++)
                result += "<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin nibh augue, suscipit a, scelerisque sed, lacinia in, mi. Cras vel lorem. Etiam pellentesque aliquet tellus. Phasellus pharetra nulla ac diam. Quisque semper justo at risus. Donec venenatis, turpis vel hendrerit interdum, dui ligula ultricies purus, sed posuere libero dui id orci. Nam congue, pede vitae dapibus aliquet, elit magna vulputate arcu, vel tempus metus leo non est. Etiam sit amet lectus quis est congue mollis. Phasellus congue lacus eget neque. Phasellus ornare, ante vitae consectetuer consequat, purus sapien ultricies dolor, et mollis pede metus eget nisi. Praesent sodales velit quis augue. Cras suscipit, urna at aliquam rhoncus, urna quam viverra nisi, in interdum massa nibh nec erat.</p>";
        } else {
            result += this.bootstrapData.body.content;
        }
        result += "</main>";


        //footer
        if (this.bootstrapData.isFooter) {
            result += "<footer class=\"";
            switch (this.bootstrapData.header.style) {
                case "dark": result += "bg-dark navbar-dark"; break;
                case "light": result += "bg-light navbar-light"; break;
                case "blue": result += "bg-primary navbar-dark"; break;
                default: result += "bg-success navbar-dark";
            }
            result += "\" style=\"text-align: center; flex-shrink: 0\">";
            result += "<p>" + this.bootstrapData.footer.content + "</p>";
            result += "<a href=\"mailto:" + this.bootstrapData.footer.contact + "\" target=\"_top\">";
            result += this.bootstrapData.footer.contact;
            result += "</a></footer>";
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




