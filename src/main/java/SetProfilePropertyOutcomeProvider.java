import org.forgerock.json.JsonValue;
import org.forgerock.openam.auth.node.api.NodeProcessException;
import org.forgerock.openam.auth.node.api.OutcomeProvider;
import org.forgerock.util.i18n.PreferredLocales;

import java.util.List;

public class SetProfilePropertyOutcomeProvider implements OutcomeProvider {
    @Override
    public List<Outcome> getOutcomes(PreferredLocales preferredLocales, JsonValue jsonValue) throws NodeProcessException {
        return null;
    }
}
