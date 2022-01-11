package NuclearMines.content;

import arc.fx.FxProcessor;
import arc.graphics.Color;
import mindustry.ctype.ContentList;
import mindustry.entities.Effect;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.bullet.BombBulletType;
import mindustry.entities.bullet.BulletType;
import mindustry.entities.bullet.FlakBulletType;
import mindustry.gen.Bullet;
import mindustry.gen.ElevationMovec;
import mindustry.content.Fx;

public class NuclearBullets implements ContentList {
    public static BulletType nuclearBulletSmall, nuclearBulletBig, radioFlakBullet, radioFrag, radioBasicShot;
    @Override
    public void load() {
        nuclearBulletSmall = new BasicBulletType(6f, 140f){{
            status = NuclearStatus.irradiated;
            statusDuration = 60f;
            collidesAir = false;
            collidesGround = true;
            reflectable = false;
            inaccuracy = 7f;
            splashDamageRadius = 10f;
            splashDamage = 100f;
            hitShake = 1f;
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
            ammoMultiplier = 1;
        }};

        nuclearBulletBig = new BasicBulletType(6.5f, 210f){{
           status = NuclearStatus.irradiated;
           statusDuration = 180f;
           collidesAir = false;
           reflectable = false;
           collidesGround = true;
           inaccuracy = 7f;
           lightColor = Color.green;
           lightRadius = 2f;
           lifetime = 150;
           hitShake = 2f;
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
           ammoMultiplier = 1;
        }};

        radioFrag = new BasicBulletType(4, 30){{
           status = NuclearStatus.irradiated;
           statusDuration = 180f;
           lifetime = 3;
           hitSize = 3f;
           frontColor = Color.yellow;
           backColor = Color.acid;
        }};

        radioFlakBullet = new FlakBulletType(5, 70){{
            frontColor = Color.yellow;
            backColor = Color.acid;
            status = NuclearStatus.irradiated;
            collidesGround = true;
            collidesAir = true;
            statusDuration = 200f;
            lifetime = 45f;
            hitSize = 5f;
            fragBullet = radioFrag;
            fragBullets = 7;
            fragLifeMin = 1.5f;
            fragLifeMax = 2f;
            fragVelocityMax = 5;
            fragVelocityMin = 5;
            ammoMultiplier = 1;
        }};

        radioBasicShot = new BasicBulletType(4, 20){{
            // Status effects
            status = NuclearStatus.irradiated;
            statusDuration = 200f;

            // Collision, lifetime, ammo
            hitSize = 7f;
            collidesAir = true;
            collidesGround = true;
            lifetime = 50f;
            ammoMultiplier = 1;

            // Cosmetic effects
            frontColor = Color.acid;
            backColor = Color.gray;
        }};
    }
}
