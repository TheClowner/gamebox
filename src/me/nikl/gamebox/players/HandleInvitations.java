package me.nikl.gamebox.players;

import me.nikl.gamebox.GameBox;
import me.nikl.gamebox.PluginManager;
import me.nikl.gamebox.guis.gui.game.StartMultiplayerGamePage;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.*;

/**
 * Created by Niklas on 22.02.2017.
 *
 *
 */
public class HandleInvitations extends BukkitRunnable{
    private Set<Invitation> invitations = new HashSet<>();
    private PluginManager pluginManager;
    private GameBox plugin;

    public HandleInvitations(GameBox plugin){
        pluginManager = plugin.getPluginManager();
        this.plugin = plugin;
        this.runTaskTimerAsynchronously(plugin, 20, 10);
    }

    @Override
    public void run() {
        Iterator<Invitation> it = invitations.iterator();
        ArrayList<UUID> ranOut = new ArrayList<>();
        while (it.hasNext()){
            Invitation inv = it.next();
            long currentTimeMillis = System.currentTimeMillis();
            if(currentTimeMillis > inv.timeStamp){
                ranOut.add(inv.player1);
                it.remove();
                ((StartMultiplayerGamePage)pluginManager.getGuiManager().getGameGui(inv.args[0], inv.args[1])).removeInvite(inv.player1, inv.player2);
                GameBox.debug("removing old invitation");
            }
        }
    }


    public boolean addInvite(UUID player1, UUID player2, long timeStamp, String... args){
        for(Invitation inv : invitations){
            if(inv.player1.equals(player1) && inv.player2.equals(player2)){
                Player player = Bukkit.getPlayer(player1);
                if(player != null) player.sendMessage(plugin.lang.INVITATION_ALREADY_THERE);
                return false;
            }
            if(inv.player1.equals(player2) && inv.player2.equals(player1)){
                //ToDO: accept invite automatically
                // for now just continue and allow it
            }
        }
        new Invitation(player1, player2, timeStamp, args);
        ((StartMultiplayerGamePage)pluginManager.getGuiManager().getGameGui(args[0], args[1])).addInvite(player1, player2);
        return true;
    }

    public class Invitation{
        protected long timeStamp;
        protected UUID player1, player2;
        protected String[] args;

        public Invitation(UUID player1, UUID player2, long timeStamp, String... args){
            this.player1 = player1;
            this.player2 = player2;
            this.timeStamp = timeStamp;
            this.args = args;

            GameBox.debug("adding new invitation");
            invitations.add(this);
        }
    }
}
