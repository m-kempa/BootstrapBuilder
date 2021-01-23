package tests.pl.put.poznan.builder;

import org.junit.jupiter.api.Test;
import pl.put.poznan.builder.logic.BootstrapBuilder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.containsString;

class BootstrapBuilderTest {
    @Test
    void create_clock() throws FileNotFoundException {

        File file = new File("src/examples/with_clock.json");
        String content = new Scanner(file).useDelimiter("\\Z").next();

        BootstrapBuilder bootstrapBuilder = new BootstrapBuilder();
        bootstrapBuilder.setJsonContent(content.toString());

        assertThat(bootstrapBuilder.getBodyContent(), containsString("tag=clock"));
    }
}