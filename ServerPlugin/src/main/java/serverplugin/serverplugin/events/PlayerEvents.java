package serverplugin.serverplugin.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;
import serverplugin.serverplugin.ServerPlugin;
import java.util.ArrayList;

public class PlayerEvents implements Listener
{
    ServerPlugin plugin;


    public PlayerEvents(ServerPlugin plugin)
    {
        this.plugin = plugin;
    }

    public ArrayList<Player> list = new ArrayList<>();

    private String jprfix = ChatColor.AQUA + "[ " + ChatColor.LIGHT_PURPLE + "입장" + ChatColor.AQUA + " ]";
    private String qprfix = ChatColor.RED + "[ " + ChatColor.YELLOW + "퇴장" + ChatColor.RED + " ]";

    @EventHandler
    public void OnJoined(PlayerJoinEvent ev)
    {
        //String test = plugin.getConfig().getString("test");
        //System.out.println(test);
        Player p = ev.getPlayer();
        System.out.println(jprfix + p.getDisplayName() + "has entered the server!");
        ev.setJoinMessage(jprfix + ChatColor.BLUE + " " + p.getDisplayName() + "님(이)가 서버에 접속하였습니다.");
        list.add(p);
    }

    @EventHandler
    public void OnQuit(PlayerQuitEvent ev)
    {
        Player p = ev.getPlayer();
        System.out.println(qprfix + p.getDisplayName() + "has leave the server!");
        ev.setQuitMessage(qprfix + ChatColor.BLUE + " " + p.getDisplayName() + "님(이)가 서버에서 퇴장하였습니다.");
        list.remove(p);
    }

    @EventHandler
    public void OnDeathEvent(PlayerDeathEvent ev)
    {
        Player p = ev.getEntity();

        ev.setDeathMessage(ChatColor.RED + p.getDisplayName() + "님이 사망하셨습니다.");
    }

    @EventHandler
    public void OnChat(PlayerChatEvent ev)
    {
        if (!ev.getPlayer().isOp()) ev.setFormat(ChatColor.AQUA + "[ " + ChatColor.YELLOW + "플레이어" + ChatColor.AQUA + " ]" + ChatColor.WHITE + " : ");
        else ev.setFormat(ChatColor.RED + "[ 관리자 ]" + ChatColor.WHITE + " : ");
    }
}
