package io.zerocontribution.summer.components;

import com.artemis.Component;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;
import io.zerocontribution.summer.affixes.*;

public class Affixes extends Component {

    private static Array<Affix> availableAffixes = new Array<Affix>();

    static {
        availableAffixes.add(new EnrageTimerAffix());
        availableAffixes.add(new ExtraHealthAffix());
        availableAffixes.add(new FastAffix());
        availableAffixes.add(new HealerAffix());
        availableAffixes.add(new MissleSalvoAffix());
        availableAffixes.add(new ReflectDamageAffix());
        availableAffixes.add(new SapAffix());
        availableAffixes.add(new SentryAffix());
    }

    public Array<Affix> affixes = new Array<Affix>();

    public Affixes(int levelDifference) {
        switch (levelDifference) {
            case 1:
                generate(2);
                break;
            case 2:
                generate(3);
                break;
            case 3:
                generate(4);
                break;
            case 4:
                generate(5);
                break;
            case 5:
                generate(6);
                break;
            case 0:
            default:
                generate(1);
                break;
        }
    }


    private void generate(int numAffixes) {
        // TODO Each affix should get a chance to spawn %, then the availableAffixes should be sorted based on if the
        // chances. If any affix slots are not filled, just start taking from the next available chances.
        while (affixes.size != numAffixes) {
            Affix selected = availableAffixes.get(MathUtils.random(0, availableAffixes.size - 1));
            if (!affixes.contains(selected, false)) {
                affixes.add(selected);
            }
        }
    }

    public String toLog() {
        String log = "";
        for (int i = 0; i < affixes.size; i++) {
            log += affixes.get(i).toLog() + " ";
        }
        return log.trim();
    }

}
