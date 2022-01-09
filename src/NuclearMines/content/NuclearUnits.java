package NuclearMines.content;

import mindustry.ctype.ContentList;
import mindustry.gen.UnitEntity;
import mindustry.type.UnitType;
import mindustry.type.Weapon;


public class NuclearUnits implements ContentList {
    public static UnitType virus;

    @Override
    public void load() { // Load content
        virus = new UnitType("virus"){{
            constructor = UnitEntity::create; // Add constructor

            // Basic properties
            localizedName = "[acid]Virus";
            description = "A flying unit that fires radioactive flak bullets.";

            health = 300f;
            armor = 3f;
            flying = true;
            canDrown = false;
            speed = 5f;
            drag = 0.6f;
            hitSize = 6f;
            rotateSpeed = 5f;

            // Weapons
            weapons.add(new Weapon("virus-weapon"){{
                x = 1f;
                y = 1f;
                mirror = false;
                reload = 15f;
                rotate = false;
                bullet = NuclearBullets.radioFlakBullet;
            }});
        }};
    }
}
