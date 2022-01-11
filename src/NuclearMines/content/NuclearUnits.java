package NuclearMines.content;

import mindustry.content.Fx;
import mindustry.ctype.ContentList;
import mindustry.gen.Flyingc;
import mindustry.gen.Unit;
import mindustry.gen.UnitEntity;
import mindustry.type.UnitType;
import mindustry.type.Weapon;


public class NuclearUnits implements ContentList {
    public static UnitType virus, infection, plague;

    @Override
    public void load() {
        virus = new UnitType("virus"){{
            constructor = UnitEntity::create;

//            outlineRadius = 5;
//            outlines = true;
            localizedName = "[acid]Virus";
            description = "A flying unit that fires radioactive flak bullets.";
            flying = true;
            canDrown = false;
            speed = 5f;
            drag = 0.6f;
            hitSize = 8f;
            health = 300f;
            armor = 3f;
            commandLimit = 3;

            rotateSpeed = 5f;

            weapons.add(new Weapon("virus-weapon"){{
                x = 1f;
                y = 1f;
                mirror = false;
                reload = 20f;
                rotate = false;
                bullet = NuclearBullets.radioFlakBullet;
                ejectEffect = Fx.casing2;
            }});
        }};

        infection = new UnitType("infection"){{
            constructor = UnitEntity::create;

            localizedName = "[acid]Infection";
            description = "An upgrade to [acid]Virus[white].";
            flying = true;
            canDrown = false;
            speed = 5.5f;
            drag = 0.8f;
            hitSize = 10f;
            health = 500f;
            armor = 4f;

            rotateSpeed = 4.6f;

//            weapons.add(new Weapon("virus-weapon"){{
//                x = 1f;
//                y = 1f;
//                mirror = false;
//                reload = 20f;
//                rotate = false;
//                bullet = NuclearBullets.radioFlakBullet;
//            }});

            weapons.add(new Weapon("infection-weapon"){{
                x = -5f;
                y = 0f;
                mirror = true;
                reload = 5f;
                rotate = true;
                bullet = NuclearBullets.radioBasicShot;
                ejectEffect = Fx.casing1;
            }});
        }};
    }
}
