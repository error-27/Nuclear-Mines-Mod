package NuclearMines.type;

import NuclearMines.type.nested.NestedUnit;
import mindustry.content.UnitTypes;
import mindustry.game.Team;
import mindustry.gen.Unit;
import mindustry.type.UnitType;

public class NestedUnitType extends UnitType {
    public int childNumber = 1;
    public UnitType child = UnitTypes.flare;

    public NestedUnitType(String name) {
        super(name);
    }

    @Override
    public Unit create(Team team){
        Unit unit = super.create(team);
        if(unit instanceof NestedUnit) ((NestedUnit) unit).initializeChildren(this);
        return unit;
    }
}
