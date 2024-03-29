import com.google.inject.assistedinject.Assisted;
import com.sun.identity.sm.DNMapper;
import lombok.extern.slf4j.Slf4j;
import org.forgerock.openam.auth.node.api.*;
import org.forgerock.openam.core.CoreWrapper;

import javax.inject.Inject;

@Slf4j
@Node.Metadata(outcomeProvider = SetProfilePropertyOutcomeProvider.class,
        configClass = SetProfilePropertyConfig.class,
        tags = {"utilities"})
public class SetProfilePropertyNode extends SingleOutcomeNode {
    private final CoreWrapper coreWrapper;
    private final SetProfilePropertyConfig setProfilePropertyConfig;

    @Inject
    public SetProfilePropertyNode(CoreWrapper coreWrapper, @Assisted SetProfilePropertyConfig setProfilePropertyConfig) {
        this.coreWrapper = coreWrapper;
        this.setProfilePropertyConfig = setProfilePropertyConfig;
    }

    @Override
    public Action process(TreeContext treeContext) throws NodeProcessException {
        Action.ActionBuilder actionBuilder = goToNext();
        NodeState state = treeContext.getStateFor(this);
        setProfilePropertyConfig.properties().forEach((key, value) -> {
            actionBuilder.putSessionProperty(key, value);
            state.putShared(key, value);
        });
//        AMIdentity;
//        IdUtils.getIdentity();
        new DNMapper();
        return goToNext().build();
    }
}
