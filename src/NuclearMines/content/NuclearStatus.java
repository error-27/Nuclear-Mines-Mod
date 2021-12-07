package NuclearMines.content;

import arc.graphics.Color;
import mindustry.ctype.ContentList;
import mindustry.type.StatusEffect;

public class NuclearStatus implements ContentList {
    public static StatusEffect irradiated;

    @Override
    public void load() {
        irradiated = new StatusEffect("irradiated"){{
           damage = 2f;
           color = Color.acid;
           healthMultiplier =  0.8f;
           speedMultiplier = 0.9f;
           damageMultiplier = 1.15f;
           effectChance = 1.0f;
           localizedName = "Irradiated";
           description = "Radiation infects the enemy, causing them to become slower and have less health, but they also do more damage.";
        }};
    }
}
