package NuclearMines.content;

import arc.struct.Seq;
import mindustry.content.Blocks;
import mindustry.content.Bullets;
import mindustry.content.Items;
import mindustry.content.Liquids;
import mindustry.ctype.ContentList;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.type.UnitType;
import mindustry.world.Block;
import mindustry.world.blocks.defense.turrets.ItemTurret;
import mindustry.world.blocks.power.ImpactReactor;
import mindustry.world.blocks.power.NuclearReactor;
import mindustry.world.blocks.production.GenericCrafter;
import mindustry.world.blocks.units.Reconstructor;
import mindustry.world.blocks.units.UnitFactory;

import static mindustry.type.ItemStack.with;

public class NuclearBlocks implements ContentList {
    public static Block ioniumMixer, ioniumReactor, corruption, nuclearFactory, nuclearUpgrader;

    @Override
    public void load() {
        ioniumMixer = new GenericCrafter("ionium-mixer"){{
            localizedName = "[lime]Ionium Mixer";
           requirements(Category.crafting, with(Items.lead, 200, Items.thorium, 50, Items.titanium, 100));
            // Research: blast-mixer, lead 2000, thorium 300, titanium 300
           consumesPower = true;
           consumes.items(with(Items.thorium, 3, Items.blastCompound, 1));
           consumes.power(12);
           outputItem = new ItemStack(NuclearItems.ionium, 1);
           size = 3;
           craftTime = 90;
        }};

        ioniumReactor = new NuclearReactor("ionium-reactor"){{
            localizedName = "[lime]Ionium Reactor";
           requirements(Category.power, with(Items.lead, 1000, Items.titanium, 700, Items.graphite, 800, Items.metaglass, 800, Items.surgeAlloy, 300));
           // research: impact-reactor
           powerProduction = 800;
            hasLiquids = true;
            liquidCapacity = 30;
            consumes.item(NuclearItems.ionium, 2);
            consumes.liquid(Liquids.cryofluid, 10);
            size = 5;
        }};

        corruption = new ItemTurret("corruption"){{
           localizedName = "[acid]The Corruption";
           requirements(Category.turret, with(Items.lead, 400, Items.titanium, 600, Items.graphite, 500));
           ammo(Items.thorium, NuclearBullets.nuclearBulletSmall,
                   NuclearItems.ionium, NuclearBullets.nuclearBulletBig);

           recoilAmount = 6;
           ammoPerShot = 1;
           maxAmmo = 10;
           rotateSpeed = 3;
           coolantMultiplier = 1.25f;
           acceptCoolant = true;
           coolantUsage = 2.8f;
           targetAir = false;
           size = 3;
           range = 400;
           minRange = 10;
           health = 1760;
           reloadTime = 55f;
           description = "A turret that launches radioactive nuclear missiles over a long range.";
        }};

        // Unit blocks
        nuclearFactory = new UnitFactory("nuclear-factory"){{
            localizedName = "[lime]Nuclear Factory";
            description = "Produces units that have nuclear weapons.";
            requirements(Category.units, with(Items.titanium, 200, Items.silicon, 30, Items.lead, 100));
            size = 3;
            health = 300;
            consumes.power(3);
            itemCapacity = 50;
            plans.add(new UnitPlan(NuclearUnits.virus, 300, with(NuclearItems.ionium, 10, Items.titanium, 20, Items.silicon, 10)));
        }};

        nuclearUpgrader = new Reconstructor("nuclear-upgrader"){{
            localizedName = "[lime]Nuclear Upgrader";
            description = "Upgrades nuclear units.";
            requirements(Category.units, with(Items.titanium, 300, Items.silicon, 60, Items.lead, 1000));
            size = 5;
            health = 400;
            hasLiquids = true;
            consumes.power(5);
            consumes.items(with(Items.titanium, 20, NuclearItems.ionium, 15));
            consumes.liquid(Liquids.cryofluid, 8);
            itemCapacity = 55;
            constructTime = 360;
            upgrades.addAll(
                    new UnitType[]{NuclearUnits.virus, NuclearUnits.infection}
            );
        }};
    }
}
