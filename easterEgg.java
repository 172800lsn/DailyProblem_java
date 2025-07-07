import java.util.*;
import java.time.LocalDateTime;

/**
 * Totally normal utility class, nothing to see here... 👀
 * (Hint: try calling the secret methods!)
 */
public class easterEgg {

    private static final Scanner scanner = new Scanner(System.in);
    private static boolean matrixMode = false;

    // Normal utility methods (the decoy)
    public static String formatString(String input) {
        return input.trim().toLowerCase();
    }

    public static boolean validateInput(String input) {
        return input != null && !input.isEmpty();
    }

    // 🥚 EASTER EGGS START HERE 🥚

    /**
     * "I know kung fu" - Neo, The Matrix
     * Usage: DeveloperUtils.enterTheMatrix();
     */
    public static void enterTheMatrix() {
        System.out.println("🔴💊 Welcome to the Matrix, Neo...");
        matrixMode = true;

        String[] quotes = {
                "There is no spoon.",
                "What if I told you... your code has no bugs?",
                "Unfortunately, no one can be told what good code is. You have to see it for yourself.",
                "Do not try and bend the spoon—that's impossible. Instead, only try to realize the truth: there is no spoon."
        };

        System.out.println("🕶️ " + quotes[new Random().nextInt(quotes.length)]);

        // Matrix rain effect (simplified)
        System.out.println("\n💚 MATRIX CODE RAIN 💚");
        for (int i = 0; i < 5; i++) {
            System.out.println("01100100 01100101 01110110 01100101 01101100 01101111 01110000 01100101 01110010");
            try { Thread.sleep(200); } catch (InterruptedException e) {}
        }
        System.out.println("Translation: 'developer' 😉\n");
    }

    /**
     * "Hello there!" - Obi-Wan Kenobi
     * Usage: DeveloperUtils.executeOrder66();
     */
    public static void executeOrder66() {
        System.out.println("🌟 A long time ago in a codebase far, far away...");
        System.out.println("\n⚔️  EXECUTE ORDER 66 ⚔️");
        System.out.println("🤖 Eliminating all bugs in the system...");

        String[] bugs = {"NullPointerException", "IndexOutOfBoundsException", "ConcurrentModificationException", "StackOverflowError"};

        for (String bug : bugs) {
            System.out.println("💥 Destroying " + bug + "...");
            try { Thread.sleep(300); } catch (InterruptedException e) {}
        }

        System.out.println("✨ The force is strong with this code now.\n");
        System.out.println("🎭 \"These aren't the bugs you're looking for.\" - Obi-Wan Debugger\n");
    }

    /**
     * "I am inevitable" - Thanos
     * Usage: DeveloperUtils.snapFingers();
     */
    public static void snapFingers() {
        System.out.println("💎✋ *SNAP* ✋💎");
        System.out.println("🌌 Perfectly balanced, as all code should be...");

        List<String> codeProblems = Arrays.asList(
                "Spaghetti Code", "Technical Debt", "Memory Leaks",
                "Infinite Loops", "Hardcoded Values", "TODO Comments from 2019"
        );

        System.out.println("\n💜 Thanos is eliminating half of your code problems:");
        Collections.shuffle(codeProblems);

        for (int i = 0; i < codeProblems.size() / 2; i++) {
            System.out.println("💨 " + codeProblems.get(i) + " has been dusted...");
            try { Thread.sleep(400); } catch (InterruptedException e) {}
        }

        System.out.println("\n🏆 Your codebase is now... inevitable.\n");
    }

    /**
     * "That's what she said" - Michael Scott
     * Usage: DeveloperUtils.michaelScott();
     */
    public static void michaelScott() {
        System.out.println("👔 Michael Scott's Tips for Coding:");

        String[] tips = {
                "\"I'm not a coding expert, but I know what good code looks like.\" - Michael Scott",
                "\"Sometimes I'll start a function, and I don't even know where it's going.\" - Michael Scott",
                "\"I DECLARE BANKRUPTCY!\" - Michael Scott (on handling exceptions)",
                "\"That's what she said!\" - Michael Scott (after 'this function is hard to implement')",
                "\"I am running away from my responsibilities. And it feels good.\" - Michael Scott (on code reviews)"
        };

        System.out.println("🎭 " + tips[new Random().nextInt(tips.length)]);
        System.out.println("\n📺 The Office would be proud of your code!\n");
    }

    /**
     * "Winter is coming" - House Stark
     * Usage: DeveloperUtils.winterIsComing();
     */
    public static void winterIsComing() {
        System.out.println("🐺 House Stark Developer Motto:");
        System.out.println("❄️  \"Winter is coming... and so are the bugs.\" ❄️");
        System.out.println("\n🗡️  You know nothing, Jon Snow... about this codebase.");
        System.out.println("👑 \"A developer always pays their technical debt.\" - House Lannister");
        System.out.println("🔥 \"Fire and Blood... and Code Reviews.\" - House Targaryen");
        System.out.println("\n🏰 Your code will survive the long night!\n");
    }

    /**
     * The ultimate developer console - try calling this!
     * Usage: DeveloperUtils.activateSecretConsole();
     */
    public static void activateSecretConsole() {
        System.out.println("🎮 SECRET DEVELOPER CONSOLE ACTIVATED 🎮");
        System.out.println("🌟 Welcome to the Pop Culture Command Center! 🌟\n");

        System.out.println("Available commands:");
        System.out.println("1. 'matrix' - Enter the Matrix");
        System.out.println("2. 'force' - Use the Force (Star Wars)");
        System.out.println("3. 'snap' - Perfectly balance your code (Marvel)");
        System.out.println("4. 'office' - Get advice from Michael Scott");
        System.out.println("5. 'stark' - House Stark developer wisdom");
        System.out.println("6. 'konami' - Try the Konami code!");
        System.out.println("7. 'exit' - Return to normal reality\n");

        String command;
        do {
            System.out.print("🎯 Enter command: ");
            command = scanner.nextLine().toLowerCase().trim();

            switch (command) {
                case "matrix":
                    enterTheMatrix();
                    break;
                case "force":
                    executeOrder66();
                    break;
                case "snap":
                    snapFingers();
                    break;
                case "office":
                    michaelScott();
                    break;
                case "stark":
                    winterIsComing();
                    break;
                case "konami":
                    konamiCode();
                    break;
                case "exit":
                    System.out.println("👋 Thanks for visiting! Remember: May the code be with you!");
                    break;
                default:
                    System.out.println("🤔 Unknown command. Try again, young Padawan!");
            }
        } while (!command.equals("exit"));
    }

    /**
     * The legendary Konami Code easter egg
     */
    private static void konamiCode() {
        System.out.println("🎮 KONAMI CODE ACTIVATED! 🎮");
        System.out.println("⬆️⬆️⬇️⬇️⬅️➡️⬅️➡️🅱️🅰️");
        System.out.println("\n🚀 +30 LIVES ADDED TO YOUR CODING CAREER!");
        System.out.println("💪 +UNLIMITED COFFEE POWER!");
        System.out.println("🧠 +BOSS-LEVEL DEBUGGING SKILLS!");
        System.out.println("⚡ +INSTANT CODE REVIEW APPROVAL!");
        System.out.println("\n🏆 Achievement Unlocked: 'Retro Gamer Developer'\n");
    }

    // Secret method that only shows up in IDE autocomplete if they type "secret"
    public static void secretTeamMessage() {
        System.out.println("💝 SECRET MESSAGE FOR THE TEAM:");
        System.out.println("🌟 You're all AWESOME developers! 🌟");
        System.out.println("☕ Coffee-powered, bug-squashing legends!");
        System.out.println("🚀 Keep being amazing! 🚀");
        System.out.println("\n- Your Friendly Neighborhood Code Easter Egg 🥚\n");
    }

    // Main method to demonstrate the easter eggs
    public static void main(String[] args) {
        System.out.println("🔍 Try calling these methods to discover the easter eggs:");
        System.out.println("- DeveloperUtils.activateSecretConsole()");
        System.out.println("- DeveloperUtils.enterTheMatrix()");
        System.out.println("- DeveloperUtils.executeOrder66()");
        System.out.println("- DeveloperUtils.snapFingers()");
        System.out.println("- DeveloperUtils.michaelScott()");
        System.out.println("- DeveloperUtils.winterIsComing()");
        System.out.println("- DeveloperUtils.secretTeamMessage()");
        System.out.println("\n🎮 Or just call activateSecretConsole() for the full experience!\n");

        // Uncomment this line to auto-start the console:
        // activateSecretConsole();
    }
}