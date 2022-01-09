package NuclearMines.content;

import mindustry.content.Items;
import mindustry.content.Liquids;
import mindustry.ctype.ContentList;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import mindustry.world.blocks.defense.turrets.ItemTurret;
import mindustry.world.blocks.power.NuclearReactor;
import mindustry.world.blocks.production.GenericCrafter;
import mindustry.world.blocks.units.UnitFactory;

import static mindustry.type.ItemStack.with;

public class NuclearBlocks implements ContentList {

    // Create block variables
    public static Block ioniumMixer, // Crafters

    ioniumReactor, // Reactors

    corruption, // Turrets

    nuclearFactory; // Unit Factories

    @Override
    public void load() { // Initializes content

        // Initialize crafters
        ioniumMixer = new GenericCrafter("ionium-mixer"){{
            // Basic properties
            localizedName = "[lime]Ionium Mixer"; // Display name
            size = 3;

            // Build materials
            requirements(Category.crafting, with(Items.lead, 200, Items.thorium, 50, Items.titanium, 100));

            // Inputs
            consumesPower = true;
            consumes.items(with(Items.thorium, 3, Items.blastCompound, 1));
            consumes.power(12);

            // Outputs
            outputItem = new ItemStack(NuclearItems.ionium, 1);
            craftTime = 90;
        }};

        //Initialize Reactors
        ioniumReactor = new NuclearReactor("ionium-reactor"){{
            // Basic properties
            localizedName = "[lime]Ionium Reactor";
            size = 5;

            // Build materials
            requirements(Category.power, with(Items.lead, 1000, Items.titanium, 700, Items.graphite, 800, Items.metaglass, 800, Items.surgeAlloy, 300));

            // Inputs
            hasLiquids = true;
            liquidCapacity = 30;
            consumes.item(NuclearItems.ionium, 2);
            consumes.liquid(Liquids.cryofluid, 10);

            // Outputs
            powerProduction = 800;
        }};

        // Initialize Turrets
        corruption = new ItemTurret("corruption"){{
            // Basic properties
            localizedName = "[acid]The Corruption";
            description = "A turret that launches radioactive nuclear missiles over a long range.";
            size = 3;
            health = 1760;

            // Build materials
            requirements(Category.turret, with(Items.lead, 400, Items.titanium, 600, Items.graphite, 500));

            // Weapon properties
            ammo(Items.thorium, NuclearBullets.nuclearBulletSmall,
                   NuclearItems.ionium, NuclearBullets.nuclearBulletBig);

            recoilAmount = 6;
            ammoPerShot = 1;
            maxAmmo = 10;
            rotateSpeed = 3;
            reloadTime = 55f;
            range = 400;
            minRange = 10;
            targetAir = false;

            coolantMultiplier = 1.25f;
            acceptCoolant = true;
            coolantUsage = 2.8f;
        }};

        // Initialize unit factories
        nuclearFactory = new UnitFactory("nuclear-factory"){{
            // Basic properties
            localizedName = "[lime]Nuclear Factory";
            description = "Produces units that have nuclear weapons.";
            size = 3;
            health = 300;

            // Build materials
            requirements(Category.units, with(Items.titanium, 200, Items.silicon, 30, Items.lead, 100));

            // Inputs
            consumes.power(3);
            itemCapacity = 50;

            // Outputs
            plans.add(new UnitPlan(NuclearUnits.virus, 300, with(NuclearItems.ionium, 10, Items.titanium, 20, Items.silicon, 10)));
        }};
    }
}
