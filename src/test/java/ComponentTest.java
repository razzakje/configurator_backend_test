import nl.hu.testendpoint.domain.Component;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComponentTest {
    @Test
    public void createComponent() {
        Component component = new Component(1,"cpu", "Intel i9", 200.80) {};
        assertEquals("cpu", component.getType());
        assertEquals("Intel i9", component.getName());
    }
}
