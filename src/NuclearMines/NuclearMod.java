package NuclearMines;

import NuclearMines.content.*;
import mindustry.mod.*;

public class NuclearMod extends Mod{

    public NuclearMod(){
        // Nothing required. Loading Content is done in another method
    }

    @Override
    public void loadContent(){
        // Load mod contents
        new NuclearItems().load();
        new NuclearEffects().load();
        new NuclearStatus().load();
        new NuclearBullets().load();
        new NuclearUnits().load();
        new NuclearBlocks().load();
        new NuclearTechTree().load();
    }

}
