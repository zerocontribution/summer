package io.zerocontribution.summer.components;

import com.artemis.Component;

public class Condition extends Component {
    public State state = State.IDLE;

    public enum State {
        IDLE("idle"),
        RUN("run"),
        DYING("dying");

        private String text;

        private State(String text) {
            this.text = text;
        }

        @Override
        public String toString() {
            return text;
        }
    }
}
