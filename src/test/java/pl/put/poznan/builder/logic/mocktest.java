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
                assertEquals("<nav class=\"navbar navbar-expand-md bg-light navbar-light fixed-top\">", element.createNavbar(DataMocked, result));
        }

}