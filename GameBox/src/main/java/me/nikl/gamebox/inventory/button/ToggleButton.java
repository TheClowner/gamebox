package me.nikl.gamebox.inventory.button;

import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.MaterialData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Niklas Eicker
 *
 */
public class ToggleButton extends AButton {
    private boolean toggled = false;
    private MaterialData toggleData;
    private String toggleDisplayName = "missing name";
    private List<String> toggleLore = new ArrayList<>(Arrays.asList("missing lore"));

    // ToDo: get rid of MaterialData / Data usage for mc 1.13

    @Deprecated
    public ToggleButton(MaterialData mat, int count, MaterialData mat2) {
        super(mat.toItemStack(1));
        this.toggleData = mat2;
    }

    @SuppressWarnings("deprecation")
    public ToggleButton toggle(){
        toggled = !toggled;
        MaterialData mat = toggleData;
        ItemMeta meta = getItemMeta();
        String displayName = toggleDisplayName;
        ArrayList<String> lore = new ArrayList<>(toggleLore);

        toggleData = getData();
        toggleDisplayName = meta.getDisplayName();
        toggleLore = new ArrayList<>(meta.getLore());

        setData(mat);
        setType(mat.getItemType());
        setDurability(mat.getData());
        meta.setDisplayName(displayName);
        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.values());
        setItemMeta(meta);
        return this;
    }

    public void setToggleDisplayName(String toggleDisplayName){
        this.toggleDisplayName = toggleDisplayName;
    }

    public void setToggleLore(List<String> toggleLore) {
        this.toggleLore = toggleLore;
    }
}
