package org.example;

import lombok.Getter;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;

import javax.security.auth.login.LoginException;

@Getter
public class DndServerBot {

    public static DndServerBot selfBot;
    protected static DndServerBot serverBot;
    ShardManager shardManager = null;

    public DndServerBot(String token) {
        try {
            shardManager = buildShardManager(token);
        } catch (LoginException e) {
            System.exit(0);
        }
    }

    private ShardManager buildShardManager(String token) throws LoginException {
        // It is often better to load your token in from an external file or environment variable, especially if you plan on publishing the source code.
        DefaultShardManagerBuilder builder =
                DefaultShardManagerBuilder.createDefault(token);

        return builder.build();
    }

}
