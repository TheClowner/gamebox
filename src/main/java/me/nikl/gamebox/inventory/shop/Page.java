package me.nikl.gamebox.inventory.shop;

import me.nikl.gamebox.GameBox;
import me.nikl.gamebox.inventory.GuiManager;

/**
 * @author Niklas Eicker
 * <p>
 * save a shop page
 */
public class Page extends Shop {
  private int page;

  Page(GameBox plugin, GuiManager guiManager, int slots, int page, ShopManager shopManager, String[] args) {
    super(plugin, guiManager, slots, shopManager, args, plugin.lang.SHOP_TITLE_PAGE_SHOP);
    this.page = page;
  }

  public int getPage() {
    return this.page;
  }
}
