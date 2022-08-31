import com.sun.identity.sm.RequiredValueValidator;
import io.vavr.collection.Map;
import org.forgerock.openam.annotations.sm.Attribute;

public interface SetProfilePropertyConfig {
    /**
     * A map of property name to value.
     *
     * @return a map of properties.
     */
    @Attribute(order = 100, validators = RequiredValueValidator.class)
    Map<String, String> properties();
}
