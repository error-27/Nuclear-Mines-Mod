package NuclearMines.content;

import arc.graphics.Color;
import mindustry.ctype.ContentList;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.bullet.BulletType;
import mindustry.entities.bullet.FlakBulletType;
import mindustry.content.Fx;

public class NuclearBullets implements ContentList {
    public static BulletType nuclearBulletSmall, nuclearBulletBig, // Artillery

    radioFlakBullet, radioFrag; // Frag

    @Override
    public void load() { // Load content
        // Load artillery bullets
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

        // Load frag bullets
        radioFrag = new BasicBulletType(6, 30){{
           status = NuclearStatus.irradiated;
           statusDuration = 180f;
           lifetime = 3;
           hitSize = 3f;
           frontColor = Color.yellow;
           backColor = Color.acid;
        }};

        radioFlakBullet = new FlakBulletType(7, 70){{
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
    }
}
