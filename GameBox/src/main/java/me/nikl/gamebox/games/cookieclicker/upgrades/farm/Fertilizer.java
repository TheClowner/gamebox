package me.nikl.gamebox.games.cookieclicker.upgrades.farm;

import me.nikl.gamebox.games.cookieclicker.CCGame;
import me.nikl.gamebox.games.cookieclicker.buildings.Buildings;
import me.nikl.gamebox.games.cookieclicker.upgrades.Upgrade;
import me.nikl.gamebox.games.cookieclicker.upgrades.UpgradeType;
import org.bukkit.Material;
import org.bukkit.material.MaterialData;

/**
 * Created by Niklas on 09.07.2017.
 *
 */
public class Fertilizer extends Upgrade{

    public Fertilizer(CCGame game) {
        super(game, 11);
        this.cost = 55000;
        productionsRequirements.put(Buildings.FARM, 5);

        icon = new MaterialData(Material.DIRT).toItemStack();
        icon.setAmount(1);

        loadLanguage(UpgradeType.CLASSIC, Buildings.FARM);
    }

    @Override
    public void onActivation() {
        game.getBuilding(Buildings.FARM).multiply(2);
        game.getBuilding(Buildings.FARM).visualize(game.getInventory());
        active = true;
    }


}