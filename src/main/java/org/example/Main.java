package org.example;

import loggers.LoggerManager;
import org.apache.commons.cli.*;

import static org.example.DndServerBot.*;

public class Main {

    private static final String HELP_OPTION = "help";
    private static final String TOKEN_OPTION = "token";

    public static void main(String[] args) {
        Options options = defineOptions();
        CommandLine cmd = parseCommandLine(args, options);

        if (cmd == null) return; // Parsing failed, handled in `parseCommandLine`

        if (cmd.hasOption(HELP_OPTION)) {
            printHelp(options);
            return;
        }

        String token = cmd.getOptionValue(TOKEN_OPTION);

        if (token == null || token.isBlank()) {
            LoggerManager.logError("ERROR: No token provided. Use -t or --token to provide a valid token.");
            printHelp(options);
            return;
        }

        startBot(token);
    }

    private static Options defineOptions() {
        Options options = new Options();
        options.addOption("h", HELP_OPTION, false, "Displays this help menu.");
        options.addOption("t", TOKEN_OPTION, true, "Provide the token during startup.");
        return options;
    }

    private static CommandLine parseCommandLine(String[] args, Options options) {
        CommandLineParser parser = new DefaultParser();
        try {
            return parser.parse(options, args);
        } catch (ParseException e) {
            LoggerManager.logError("Command-line parsing error: " + e.getMessage());
            printHelp(options);
            return null;
        }
    }

    private static void printHelp(Options options) {
        new HelpFormatter().printHelp("Usage:", options);
    }

    private static void startBot(String token) {
        try {
            selfBot = new DndServerBot(token);
            LoggerManager.logInfo("Bot started successfully.");
        } catch (Exception e) {
            LoggerManager.logError("Failed to start bot: " + e.getMessage());
        }
    }
}