package NuclearMines.content;

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
            hitSize = 6f;
            health = 300f;
            armor = 3f;

            rotateSpeed = 5f;

            weapons.add(new Weapon("virus-weapon"){{
                x = 1f;
                y = 1f;
                mirror = false;
                reload = 15f;
                rotate = false;
                bullet = NuclearBullets.radioFlakBullet;
            }});
        }};

        infection = new UnitType("infection"){{
            constructor = UnitEntity::create;

            localizedName = "[acid]Infection";
            description = "An upgrade to [acid]Virus[white], with more weapons.";
            flying = true;
            canDrown = false;
            speed = 5.5f;
            drag = 0.8f;
            hitSize = 10f;
            health = 500f;
            armor = 4f;

            rotateSpeed = 4.6f;

            weapons.add(new Weapon("virus-weapon"){{
                x = 1f;
                y = 1f;
                mirror = false;
                reload = 15f;
                rotate = false;
                bullet = NuclearBullets.radioFlakBullet;
            }});

            weapons.add(new Weapon("infection-weapon"){{
                x = 0f;
                y = 0f;
                mirror = true;
                reload = 10f;
                rotate = true;
                bullet = NuclearBullets.radioBasicShot;
            }});
        }};
    }
}
