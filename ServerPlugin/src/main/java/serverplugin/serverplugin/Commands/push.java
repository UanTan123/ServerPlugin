package serverplugin.serverplugin.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;
import serverplugin.serverplugin.ServerPlugin;

public class push implements CommandExecutor
{
    ServerPlugin plugin;

    public push(ServerPlugin plugin)
    {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        Player p = (Player) sender;
        if (!(sender instanceof Player))
        {
            System.out.println("Only use player!");
            return true;
        }
        else if (!(sender.isOp()))
        {
            sender.sendMessage("You don't have a permission!");
            return true;
        }
        else
        {
            if (args.length == 0)
            {
                sender.sendMessage(ChatColor.GREEN + "Server Plugin have push command!");
            }
            else if (args[0].equalsIgnoreCase("info"))
            {
                sender.sendMessage(ChatColor.GREEN + "Server Plugin is made by UN10#7777");
            }
            else if (isDouble(args[0]))
            {
                if (args.length == 1)
                {
                    double tmp = Double.parseDouble(args[0]);
                    Vector unitVector = new Vector(p.getLocation().getDirection().getX(), p.getLocation().getDirection().getY(), p.getLocation().getDirection().getZ());
                    unitVector = unitVector.normalize();
                    p.setVelocity(unitVector.multiply(tmp));
                    sender.sendMessage(ChatColor.YELLOW + "Push!");
                }
            }
        }
        return false;
    }

    boolean isDouble(String str)
    {
        try
        {
            Double.parseDouble(str);
            return true;
        }
        catch (NumberFormatException ex)
        {
            return false;
        }
    }
}
