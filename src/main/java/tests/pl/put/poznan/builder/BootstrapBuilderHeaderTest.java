package tests.pl.put.poznan.builder;

import org.junit.jupiter.api.Test;
import pl.put.poznan.builder.logic.BootstrapBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//import static com.sun.tools.doclint.Entity.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.jupiter.api.Assertions.fail;

class BootstrapBuilderHeaderTest {

    @Test
    void create_header() {
        BootstrapBuilder bootstrapBuilder = getBootstrapBuilder("src/examples/with_all_components.json");
        assertThat(bootstrapBuilder.getBodyContent(), containsString("tag=navbar"));
    }

    @Test
    void do_not_create_header() {
        BootstrapBuilder bootstrapBuilder = getBootstrapBuilder("src/examples/without_any_components.json");
        assertThat(bootstrapBuilder.getBodyContent(), not(containsString("tag=navbar")));
    }

    @Test
    void header_style_dark(){
        BootstrapBuilder bootstrapBuilder = getBootstrapBuilder("src/examples/dark_header.json");
        assertThat(bootstrapBuilder.getBodyContent(), containsString("bg-dark navbar-dark"));
    }

    @Test
    void header_style_light(){
        BootstrapBuilder bootstrapBuilder = getBootstrapBuilder("src/examples/light_header.json");
        assertThat(bootstrapBuilder.getBodyContent(), containsString("bg-light navbar-light"));
    }

    @Test
    void header_style_blue(){
        BootstrapBuilder bootstrapBuilder = getBootstrapBuilder("src/examples/blue_header.json");
        assertThat(bootstrapBuilder.getBodyContent(), containsString("bg-primary navbar-dark"));
    }

    @Test
    void header_style_default(){
        BootstrapBuilder bootstrapBuilder = getBootstrapBuilder("src/examples/default_header.json");
        assertThat(bootstrapBuilder.getBodyContent(), containsString("bg-success navbar-dark"));
    }

    @Test
    void create_brand_name() {
        BootstrapBuilder bootstrapBuilder = getBootstrapBuilder("src/examples/with_all_components.json");
        assertThat(bootstrapBuilder.getBodyContent(), containsString("tag=brand_name"));
    }

    @Test
    void do_not_create_brand_name() {
        BootstrapBuilder bootstrapBuilder = getBootstrapBuilder("src/examples/without_any_components.json");
        assertThat(bootstrapBuilder.getBodyContent(), not(containsString("tag=brand_name")));
    }

    @Test
    void create_collapsing_button() {
        BootstrapBuilder bootstrapBuilder = getBootstrapBuilder("src/examples/with_all_components.json");
        assertThat(bootstrapBuilder.getBodyContent(), containsString("tag=collapsing_button"));
    }

    @Test
    void do_not_create_collapsing_button() {
        BootstrapBuilder bootstrapBuilder = getBootstrapBuilder("src/examples/without_any_components.json");
        assertThat(bootstrapBuilder.getBodyContent(), not(containsString("tag=collapsing_button")));
    }

    @Test
    void create_search_form() {
        BootstrapBuilder bootstrapBuilder = getBootstrapBuilder("src/examples/with_all_components.json");
        assertThat(bootstrapBuilder.getBodyContent(), containsString("tag=search"));
    }

    @Test
    void do_not_create_search_form() {
        BootstrapBuilder bootstrapBuilder = getBootstrapBuilder("src/examples/without_any_components.json");
        assertThat(bootstrapBuilder.getBodyContent(), not(containsString("tag=search")));
    }

    @Test
    void create_clock() {
        BootstrapBuilder bootstrapBuilder = getBootstrapBuilder("src/examples/with_all_components.json");
        assertThat(bootstrapBuilder.getBodyContent(), containsString("tag=clock"));
    }
     @Test
    void do_not_create_clock() {
         BootstrapBuilder bootstrapBuilder = getBootstrapBuilder("src/examples/without_any_components.json");
         assertThat(bootstrapBuilder.getBodyContent(), not(containsString("tag=clock")));
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