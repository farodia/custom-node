import org.forgerock.openam.auth.node.api.AbstractNodeAmPlugin;
import org.forgerock.openam.auth.node.api.Node;
import org.forgerock.openam.plugins.PluginException;

import java.util.Map;

import static java.util.Collections.singleton;
import static java.util.Collections.singletonMap;

public class SetProfilePropertyPlugin extends AbstractNodeAmPlugin {
    @Override
    public String getPluginVersion() {
        return "1.1.1";
    }

    @Override
    protected Map<String, Iterable<? extends Class<? extends Node>>> getNodesByVersion() {
        return singletonMap(getPluginVersion(), singleton(SetProfilePropertyNode.class));
    }

    @Override
    public void upgrade(String fromVersion) throws PluginException {
        if (fromVersion.equals("1.0.0") || fromVersion.equals("1.0.1") || fromVersion.equals("1.1.0")) {
            pluginTools.upgradeAuthNode(SetProfilePropertyNode.class);
        }
        super.upgrade(fromVersion);
    }
}
