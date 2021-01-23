package pl.put.poznan.builder.logic;
import java.util.List;

/**
 * Class that contains information about the header in the bootstrap based webpage
 *
 * @author Jakub Różycki
 * @version 1.0
 */
public class Header {
    public String name;
    public Boolean searchform;
    public String style;
    public Boolean fixed;
    public Boolean collapsable;
    public List<Subpage> subpages;
    public Boolean clock;

    public class Subpage {
        public String name;
        public Boolean dropdown;
        public String[] elements;
    }

}

