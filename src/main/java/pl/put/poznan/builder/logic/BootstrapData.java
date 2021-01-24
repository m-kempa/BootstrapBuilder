package pl.put.poznan.builder.logic;

/**
 * Class that contains information about the bootstrap based webpage from the json
 *
 * @author Jakub Różycki
 * @version 1.0
 */
public class BootstrapData {
    public String title;
    public Boolean isHeader;
    public Boolean isFooter;
    public Boolean responsive;
    public Body body;
    public Header header;
    public Footer footer;

    boolean getResponsive(){
        return this.responsive;
    }
    String getHeaderStyle(){
        return this.header.style;
    }

    boolean getHeaderFixed(){
        return this.header.fixed;
    }

    String getFooterContent(){
        return this.footer.content;
    }
    String getFooterContact(){
        return this.footer.contact;
    }
}

