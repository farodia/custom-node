import org.forgerock.openam.auth.node.api.Action;
import org.forgerock.openam.auth.node.api.ExternalRequestContext;
import org.forgerock.openam.auth.node.api.NodeProcessException;
import org.forgerock.openam.auth.node.api.TreeContext;
import org.forgerock.openam.core.CoreWrapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;

import static java.util.Collections.emptyList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.forgerock.json.JsonValue.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SetProfilePropertyNodeTest {

    @Mock
    private CoreWrapper coreWrapper;
    @Mock
    private SetProfilePropertyConfig config;
    private SetProfilePropertyNode node;

    @BeforeEach
    public void setup() {
        node = new SetProfilePropertyNode(coreWrapper, config);
    }

    @Test
    public void should_put_property_shared_state_when_set_properties_successfully() throws NodeProcessException {
        // given
        Map<String, String> property = Map.of("hello", "world");
        when(config.properties()).thenReturn(property);

        // when
        TreeContext context = setupTreeContext();
        Action process = node.process(context);

        // then
        assertThat(context.getStateFor(node).get("hello").asString()).isEqualTo("world");
        assertThat(process.outcome).isEqualTo("outcome");
    }

    private TreeContext setupTreeContext() {
        return new TreeContext("",
                json(object(field("sharedState", "content"))),
                new ExternalRequestContext.Builder().build(),
                emptyList());
    }
}