package NuclearMines;

import NuclearMines.content.NuclearBlocks;
import NuclearMines.content.NuclearItems;
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
        new NuclearBlocks().load();
    }

}
