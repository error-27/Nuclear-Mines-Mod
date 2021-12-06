package NuclearMines.content;

import arc.graphics.Color;
import mindustry.ctype.ContentList;
import mindustry.entities.Effect;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.bullet.BombBulletType;
import mindustry.entities.bullet.BulletType;
import mindustry.gen.Bullet;

public class NuclearBullets implements ContentList {
    public static BulletType nuclearBulletSmall, nuclearBulletBig, homingBullet;
    @Override
    public void load() {
        nuclearBulletSmall = new BasicBulletType(6f, 140f){{
            status = NuclearStatus.irradiated;
            collidesAir = false;
            collidesGround = true;
            reflectable = false;
            inaccuracy = 0.1f;
            splashDamageRadius = 2f;
            splashDamage = 100f;
            hitShake = 0.4f;
            lifetime = 360;
            lightColor = Color.green;
            trailColor = Color.acid;

            frontColor = backColor = Color.green;
            width = 1f;
            height = 2f;
        }};

        nuclearBulletBig = new BasicBulletType(6.5f, 210f){{
           status = NuclearStatus.irradiated;
           statusDuration = 45f;
           collidesAir = false;
           reflectable = false;
           collidesGround = true;
           inaccuracy = 0.1f;
           lightColor = Color.green;
           lightRadius = 2f;
           lifetime = 360;
           hitShake = 0.9f;
           splashDamageRadius = 4f;
           splashDamage = 180f;
           reloadMultiplier = 1f;
           collidesTiles = true;

           frontColor = backColor = Color.green;
           width = 2f;
           height = 2f;
        }};
    }
}
