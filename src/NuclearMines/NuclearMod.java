package NuclearMines;

import NuclearMines.content.*;
import arc.*;
import arc.util.*;
import mindustry.game.EventType.*;
import mindustry.mod.*;
import mindustry.ui.dialogs.*;

public class NuclearMod extends Mod{

    public NuclearMod(){

    }

    @Override
    public void loadContent(){
        new NuclearItems().load();
        new NuclearEffects().load();
        new NuclearStatus().load();
        new NuclearBullets().load();
        new NuclearUnits().load();
        new NuclearBlocks().load();
        new NuclearTechTree().load();
    }

}
