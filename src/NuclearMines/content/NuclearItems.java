package NuclearMines.content;

import arc.graphics.Color;
import mindustry.ctype.ContentList;
import mindustry.type.Item;

public class NuclearItems implements ContentList {
    public static Item ionium;

    @Override
    public void load() {
        ionium = new Item("ionium", Color.acid){{
            localizedName = "Ionium";
            radioactivity = 1.50f;
            cost = 12;
            description = "A material forged of blast compound and thorium. Very radioactive and volatile. Use to make nuclear weapons and reactors";
        }};
    }
}
