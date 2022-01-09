package NuclearMines.content;

import arc.graphics.Color;
import mindustry.ctype.ContentList;
import mindustry.entities.Effect;
import mindustry.entities.effect.ParticleEffect;

public class NuclearEffects implements ContentList {
    public static Effect irradiatedFx;

    @Override
    public void load() { // Load content
        irradiatedFx = new ParticleEffect(){{
            // Properties
            particles = 1;
            lifetime = 60;
            region = "shell";
            length = 15;
            sizeFrom = 1;
            sizeTo = 5;
            strokeFrom = 2;
            strokeTo = 1;
            colorFrom = Color.acid;
            colorTo = Color.green;
        }};
    }
}
