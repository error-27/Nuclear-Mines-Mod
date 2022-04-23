package NuclearMines.type.nested;

import NuclearMines.type.NestedUnitType;
import mindustry.content.UnitTypes;
import mindustry.gen.LegsUnit;
import mindustry.type.UnitType;

public class NestedLeg extends LegsUnit implements NestedUnit {
    public UnitType child = UnitTypes.flare;
    public int childNumber = 1;

    @Override
    public void killed(){
        super.killed();

        for (int i = 0; i < childNumber; i++) {
            child.spawn(this.x, this.y);
        }
    }

    public void initializeChildren(NestedUnitType unit) {
        childNumber = unit.childNumber;
        child = unit.child;
    }
}
