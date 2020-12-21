package serverplugin.serverplugin.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import serverplugin.serverplugin.ServerPlugin;

import java.util.ArrayList;

public class FlyCommands implements CommandExecutor
{
    ArrayList<Player> playersList = new ArrayList<>();
    ServerPlugin plugin;

    public FlyCommands(ServerPlugin plugin)
    {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        Player player = (Player) sender;
        if (player.isOp())
        {
            if (!(sender instanceof Player)) return true;

            if (playersList.contains(player))
            {
                playersList.remove(player);
                player.setAllowFlight(false);
                player.sendMessage(ChatColor.GREEN + "FLy is on!");
            }
            else
            {
                playersList.add(player);
                player.setAllowFlight(true);
                player.sendMessage(ChatColor.RED + "FLy is off.");
            }
        }
        else
        {
            sender.sendMessage(ChatColor.RED + "You don't have a permission!");
            return false;
        }

        return true;
    }
}
