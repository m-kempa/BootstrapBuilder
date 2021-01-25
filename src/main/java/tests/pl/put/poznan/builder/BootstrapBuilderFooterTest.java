package tests.pl.put.poznan.builder;

import org.junit.jupiter.api.Test;
import pl.put.poznan.builder.logic.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * Test class contains tests for footer elements
 *
 * @author Joanna Bronka, Mateusz Lemański
 * @version 1.0
 */


class BootstrapBuilderFooterTest {
    @Test
    void create_footer() {
        BootstrapBuilder bootstrapBuilder = getBootstrapBuilder("src/examples/with_all_components.json");
        assertThat(bootstrapBuilder.getBodyContent(), containsString("tag=footer"));
    }

    @Test
    void do_not_create_footer() {
        BootstrapBuilder bootstrapBuilder = getBootstrapBuilder("src/examples/without_any_components.json");
        assertThat(bootstrapBuilder.getBodyContent(), not(containsString("tag=footer")));
    }

    @Test
    void email_test(){
        Element element = new Element();
        BootstrapData bootstrapData = getBootstrapData();
        bootstrapData.footer.contact = "email@gmail.com";

        assertThat(element.createFooter(bootstrapData), containsString("email@gmail.com"));
    }

    @Test
    void content_test(){
        Element element = new Element();
        BootstrapData bootstrapData = getBootstrapData();
        bootstrapData.footer.content = "abcd";

        assertThat(element.createFooter(bootstrapData), containsString("abcd"));
    }
    private BootstrapData getBootstrapData() {
        BootstrapData bootstrapData = new BootstrapData();
        bootstrapData.footer = new Footer();

        Header header = new Header();
        header.style = "";

        bootstrapData.header = header;
        return bootstrapData;
    }

    private BootstrapBuilder getBootstrapBuilder(String pathname) {
        File file = new File(pathname);
        String content = null;
        try {
            content = new Scanner(file).useDelimiter("\\Z").next();
        } catch (FileNotFoundException e) {
            fail(e.getMessage());
        }

        BootstrapBuilder bootstrapBuilder = new BootstrapBuilder();
        bootstrapBuilder.setJsonContent(content.toString());
        return bootstrapBuilder;
    }
}