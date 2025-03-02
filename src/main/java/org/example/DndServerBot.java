package org.example;

import lombok.Getter;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;

@Getter
public class DndServerBot {

    public static DndServerBot selfBot;
    protected static DndServerBot serverBot;
    ShardManager shardManager = null;

    public DndServerBot(String token) {
        shardManager = buildShardManager(token);
    }

    private ShardManager buildShardManager(String token) {
        DefaultShardManagerBuilder builder =
                DefaultShardManagerBuilder.createDefault(token);

        return builder.build();
    }

}
