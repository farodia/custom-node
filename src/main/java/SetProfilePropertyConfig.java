import com.sun.identity.sm.RequiredValueValidator;
import org.forgerock.openam.annotations.sm.Attribute;

import java.util.Map;

public interface SetProfilePropertyConfig {
    /**
     * A map of property name to value.
     *
     * @return a map of properties.
     */
    @Attribute(order = 100, validators = RequiredValueValidator.class)
    Map<String, String> properties();
}
