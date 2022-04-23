package NuclearMines.type.nested;

import NuclearMines.type.NestedUnitType;
import mindustry.content.UnitTypes;
import mindustry.type.UnitType;

public interface NestedUnit {
    int childNumber = 1;
    UnitType child = UnitTypes.flare;

    void initializeChildren(NestedUnitType unit);
}
