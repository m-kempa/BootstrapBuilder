package pl.put.poznan.builder.logic;

/**
 * Class required to create mock tests, it contains the methods for builder
 *
 * @author Jakub Różycki
 * @version 1.0
 */


public class Element {

    public String createNavbar(BootstrapData bootstrapData) {
        //navbar
        String result = "";
        result += "<nav tag=navbar class=\"navbar";
        boolean x = bootstrapData.getResponsive();
        if (x) {
            result += " navbar-expand-md";
        }
        String styl = bootstrapData.getHeaderStyle();
        switch (styl) {
            case "dark":
                result += " bg-dark navbar-dark";
                break;
            case "light":
                result += " bg-light navbar-light";
                break;
            case "blue":
                result += " bg-primary navbar-dark";
                break;
            default:
                result += " bg-success navbar-dark";
        }
        boolean fixed = bootstrapData.getHeaderFixed();
        result += fixed ? " fixed-top" : " static-top";
        result += "\">";
        return result;


    }


    public String createFooter(BootstrapData bootstrapData){
        String result = "";
        result += "<footer tag=footer class=\"";
        String style = bootstrapData.getHeaderStyle();
        switch (style) {
            case "dark": result += "bg-dark navbar-dark"; break;
            case "light": result += "bg-light navbar-light"; break;
            case "blue": result += "bg-primary navbar-dark"; break;
            default: result += "bg-success navbar-dark";
        }
        result += "\" style=\"text-align: center; flex-shrink: 0\">";
        result += "<p>" + bootstrapData.getFooterContent() + "</p>";
        result += "<a href=\"mailto:" + bootstrapData.getFooterContact() + "\" target=\"_top\">";
        result += bootstrapData.getFooterContact();
        result += "</a></footer>";
        return result;
    }
}


