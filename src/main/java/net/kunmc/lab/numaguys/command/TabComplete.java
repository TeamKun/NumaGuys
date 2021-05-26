package net.kunmc.lab.numaguys.command;

import net.kunmc.lab.numaguys.util.Const;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TabComplete implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        int subCommandLength = args.length;
        switch (subCommandLength) {
            // /numaguys
            case 1:
                return args1(args);
            // /keyboard config
            case 2:
                return args2(args);
            // /keyboard config set
            case 3 :
                return args3(args);
        }
        return new ArrayList<>();
    }

    /**
     * 第1引数の補完
     * @param args
     */
    private List<String> args1(String[] args) {
        return Stream.of(Const.COMMAND_NORMAL_MODE_START,
                Const.COMMAND_KIDS_MODE_START,
                Const.COMMAND_GAME_STOP,
                Const.COMMAND_SET_STAGE,
                Const.COMMAND_CONFIG)
                .filter(e -> e.startsWith(args[0]))
                .collect(Collectors.toList());
    }

    /**
     * 第2引数の補完
     * @param args
     */
    private List<String> args2(String[] args) {
        if(!args[0].equalsIgnoreCase(Const.COMMAND_CONFIG)) return new ArrayList<>();

        return Stream.of(Const.COMMAND_SHOW,
                Const.COMMAND_SET)
                .filter(e -> e.startsWith(args[1]))
                .collect(Collectors.toList());
    }

    /**
     * 第3引数の補完
     * @param args
     */
    private List<String> args3(String[] args) {
        if(!args[1].equalsIgnoreCase(Const.COMMAND_SET)) return new ArrayList<>();

        return Stream.of(Const.COMMAND_PANEL_SIZE,
                Const.COMMAND_QUESTION_SET_LIMIT,
                Const.COMMAND_THINKING_TIME)
                .filter(e -> e.startsWith(args[2]))
                .collect(Collectors.toList());
    }
}