package tests.pl.put.poznan.builder;

import org.junit.jupiter.api.Test;
import pl.put.poznan.builder.logic.BootstrapBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

class BootstrapBuilderFooterTest {
    @Test
    void create_clock() {

        BootstrapBuilder bootstrapBuilder = getBootstrapBuilder("src/examples/with_all_components.json");

        assertThat(bootstrapBuilder.getBodyContent(), containsString("tag=clock"));
    }
     @Test
    void do_not_create_clock() {
         BootstrapBuilder bootstrapBuilder = getBootstrapBuilder("src/examples/with_all_components.json");

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