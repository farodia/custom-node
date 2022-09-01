import com.google.common.collect.ImmutableList;
import org.forgerock.json.JsonValue;
import org.forgerock.openam.auth.node.api.NodeProcessException;
import org.forgerock.openam.auth.node.api.OutcomeProvider;
import org.forgerock.util.i18n.PreferredLocales;

import java.util.List;

public class SetProfilePropertyOutcomeProvider implements OutcomeProvider {

    public static final String OUTCOME_ID = "OUTCOME";
    public static final String DISPLAY_NAME = "SetProfilePropertyOutcome";

    @Override
    public List<Outcome> getOutcomes(PreferredLocales preferredLocales, JsonValue jsonValue) throws NodeProcessException {
        return ImmutableList.of(new Outcome(OUTCOME_ID, DISPLAY_NAME));
    }
}
