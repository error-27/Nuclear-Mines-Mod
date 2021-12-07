package NuclearMines.content;

import arc.fx.FxProcessor;
import arc.graphics.Color;
import mindustry.ctype.ContentList;
import mindustry.entities.Effect;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.bullet.BombBulletType;
import mindustry.entities.bullet.BulletType;
import mindustry.gen.Bullet;
import mindustry.gen.ElevationMovec;
import mindustry.content.Fx;

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
            splashDamageRadius = 10f;
            splashDamage = 100f;
            hitShake = 0.4f;
            lifetime = 360;
            lightColor = Color.green;
//            trailColor = Color.acid;

            frontColor = backColor = Color.green;
            width = 10f;
            height = 20f;
            hitSize = 10f;
            knockback = 2f;
            hitEffect = Fx.explosion;
            shootEffect = Fx.shootSmall;
            scaleVelocity = true;
        }};

        nuclearBulletBig = new BasicBulletType(6.5f, 210f){{
           status = NuclearStatus.irradiated;
           statusDuration = 300f;
           collidesAir = false;
           reflectable = false;
           collidesGround = true;
           inaccuracy = 0.1f;
           lightColor = Color.green;
           lightRadius = 2f;
           lifetime = 150;
           hitShake = 0.9f;
           splashDamageRadius = 100f;
           splashDamage = 150f;
           reloadMultiplier = 1f;
           collidesTiles = true;

           backColor = Color.green;
           frontColor = Color.acid;
           width = 20f;
           height = 20f;

           hitSize = 20f;
           knockback = 5f;
           scaleVelocity = true;
           hitEffect = Fx.massiveExplosion;
           shootEffect = Fx.shootBig;
           smokeEffect = Fx.rocketSmokeLarge;
        }};
    }
}
