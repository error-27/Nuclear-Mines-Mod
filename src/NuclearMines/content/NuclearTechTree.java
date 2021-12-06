package NuclearMines.content;

import arc.struct.Seq;
import mindustry.content.Blocks;
import mindustry.content.Items;
import mindustry.content.TechTree.TechNode;
import mindustry.content.TechTree;
import mindustry.ctype.ContentList;
import mindustry.content.Items.*;
import mindustry.content.Blocks.*;
import mindustry.ctype.UnlockableContent;
import mindustry.game.Objectives;
import mindustry.type.ItemStack;

public class NuclearTechTree implements ContentList {
    public static TechNode context = null;

    @Override
    public void load() {
        createNode(Items.thorium, () -> nodeProduce(NuclearItems.ionium, () -> {}));

        createNode(Blocks.thoriumReactor, () -> node(NuclearBlocks.ioniumReactor));
        createNode(Blocks.blastMixer, () -> node(NuclearBlocks.ioniumMixer));
    }

    // Methods created based off of Mesokrix/Vanilla-Upgraded
    private static void createNode(UnlockableContent parent, Runnable children){
        TechNode parentNode = TechTree.all.find(t -> t.content == parent);
        context = parentNode;
        children.run();
    }

    private static void node(UnlockableContent content, ItemStack[] requirements, Seq<Objectives.Objective> objectives, Runnable children){
        TechNode node =  new TechNode(context, content, requirements);
        if(objectives != null){
            node.objectives = objectives;
        }
        TechNode prev = context;
        context = node;
        children.run();
        context = prev;
    }

    private static void node(UnlockableContent content, ItemStack[] requirements, Runnable children){
        node(content, requirements, null, children);
    }

    private static void node(UnlockableContent content, Runnable children){
        node(content, content.researchRequirements(), children);
    }

    public static void node(UnlockableContent content){
        node(content, () -> {});
    }

    private static void nodeProduce(UnlockableContent content, Seq<Objectives.Objective> objectives, Runnable children){
        node(content, content.researchRequirements(), objectives.and(new Objectives.Produce(content)), children);
    }

    private static void nodeProduce(UnlockableContent content, Runnable children){
        nodeProduce(content, new Seq<>(), children);
    }
}
