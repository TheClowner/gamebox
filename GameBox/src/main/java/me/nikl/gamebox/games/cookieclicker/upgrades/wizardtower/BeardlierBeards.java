package me.nikl.gamebox.games.cookieclicker.upgrades.wizardtower;

import me.nikl.gamebox.games.cookieclicker.CCGame;
import me.nikl.gamebox.games.cookieclicker.buildings.Buildings;
import me.nikl.gamebox.games.cookieclicker.upgrades.Upgrade;
import me.nikl.gamebox.games.cookieclicker.upgrades.UpgradeType;
import org.bukkit.Material;
import org.bukkit.material.MaterialData;

/**
 * @author Niklas Eicker
 */
public class BeardlierBeards extends Upgrade {

    public BeardlierBeards(CCGame game) {
        super(game, 245);
        this.cost = 16500000000.;
        productionsRequirements.put(Buildings.WIZARD_TOWER, 5);

        icon = new MaterialData(Material.BLAZE_ROD).toItemStack();
        icon.setAmount(1);

        loadLanguage(UpgradeType.CLASSIC, Buildings.WIZARD_TOWER);
    }

    @Override
    public void onActivation() {
        game.getBuilding(Buildings.WIZARD_TOWER).multiply(2);
        game.getBuilding(Buildings.WIZARD_TOWER).visualize(game.getInventory());
        active = true;
    }


}
