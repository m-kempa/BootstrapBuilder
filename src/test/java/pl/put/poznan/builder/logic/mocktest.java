package pl.put.poznan.builder.logic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class BuilderTest {
        public Element element = new Element();
        @Test
        void testCreateNavbar() {
                BootstrapData DataMocked = mock(BootstrapData.class);
                String result = "";
                when(DataMocked.getHeaderFixed()).thenReturn(true);
                when(DataMocked.getHeaderStyle()).thenReturn("light");
                when(DataMocked.getResponsive()).thenReturn(true);
                assertEquals("<nav class=\"navbar navbar-expand-md bg-light navbar-light fixed-top\">", element.createNavbar(DataMocked));
        }

        @Test
        void testCreateFooter() {
                BootstrapData DataMocked = mock(BootstrapData.class);
                when(DataMocked.getHeaderStyle()).thenReturn("light");
                when(DataMocked.getFooterContent()).thenReturn("x");
                when(DataMocked.getFooterContact()).thenReturn("xx");
                assertEquals("<footer class=\"bg-light navbar-light\" style=\"text-align: center; flex-shrink: 0\"><p>x</p><a href=\"mailto:xx\" target=\"_top\">xx</a></footer>", element.createFooter(DataMocked));
        }

        @Test
        void testCreateFooter2() {
                BootstrapData DataMocked = mock(BootstrapData.class);
                when(DataMocked.getHeaderStyle()).thenReturn("dark");
                when(DataMocked.getFooterContent()).thenReturn("x");
                when(DataMocked.getFooterContact()).thenReturn("xx");
                assertEquals("<footer class=\"bg-dark navbar-dark\" style=\"text-align: center; flex-shrink: 0\"><p>x</p><a href=\"mailto:xx\" target=\"_top\">xx</a></footer>", element.createFooter(DataMocked));
        }

}