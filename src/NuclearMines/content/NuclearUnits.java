package NuclearMines.content;

import mindustry.ctype.ContentList;
import mindustry.gen.Flyingc;
import mindustry.gen.Unit;
import mindustry.gen.UnitEntity;
import mindustry.type.UnitType;
import mindustry.type.Weapon;


public class NuclearUnits implements ContentList {
    public static UnitType virus;

    @Override
    public void load() {
        virus = new UnitType("virus"){{
            constructor = UnitEntity::create;

            localizedName = "Virus";
            description = "A flying unit that fires radioactive flak bullets.";
            flying = true;
            canDrown = false;
            speed = 5f;
            drag = 0.6f;
            hitSize = 10f;
            health = 300f;
            armor = 3f;

            rotateSpeed = 5f;

            weapons.add(new Weapon("virus-weapon"){{
                x = 3;
                y = 3;
                reload = 10f;
                rotate = true;
//                shootStatus = NuclearStatus.irradiated;
//                shootStatusDuration = 180f;
                bullet = NuclearBullets.radioFlakBullet;
            }},
                new Weapon("virus-weapon"){{
                    x = 7;
                    y = 3;
                    reload = 10f;
                    rotate = true;
//                    shootStatus = NuclearStatus.irradiated;
//                    shootStatusDuration = 180f;
                    bullet = NuclearBullets.radioFlakBullet;
                }});
        }};
    }
}
