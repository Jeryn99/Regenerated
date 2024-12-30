package mc.jeryn.regenerated.common.data.player;

import mc.jeryn.regenerated.Regenerated;

import java.util.Objects;

public enum RegenState {
    IDLE("idle"),
    REGENERATING("regenerating");

    private final String status;

    RegenState(String status) {
        this.status = status;
    }

    public static RegenState find(String find) {
        for (RegenState value : RegenState.values()) {
            if (Objects.equals(value.getStatus(), find)) {
                return value;
            }
        }
        Regenerated.LOGGER.info("Could not find RegenStage: {}", find);
        return null;
    }

    public String getStatus() {
        return status;
    }
}
