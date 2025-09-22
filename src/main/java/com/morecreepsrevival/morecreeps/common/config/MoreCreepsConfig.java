package com.morecreepsrevival.morecreeps.common.config;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Config(modid = "morecreeps", category = "General")
public class MoreCreepsConfig {

    @Config.Comment("Toggles the playing of the welcome sound when you load the world.")
    public static boolean playWelcomeSound = true;

    @Config.Comment("Sends a welcome message in the chat to each player joining.")
    public static boolean sendWelcomeMessage = true;

    @Config(modid = "morecreeps", category = "Spawn")
    public static class Spawn {

        @Config.Comment("This setting controls the overall spawn rate. The spawn rate of every mob is multiplied by this number. So 0.5 is the default rate, 1.0 is 2x the rate, 0.25 is half the rate, etc.")
        public static double globalSpawnRate = 0.75f;

        @Config.Comment("Setting this to true will cause More Creeps mobs to spawn in biomes added by other mods.")
        public static boolean spawnInNonVanillaBiomes = false;

        @Config.Comment("This a list of Non-Vanilla biomes that More Creeps mobs should spawn in.")
        public static String[] nonVanillaBiomes = {};

    }

    @Config(modid = "morecreeps", category = "WorldGen")
    public static class WorldGen {

        @Config.Comment("Enable Pyramid Gen")
        public static boolean pyramidGen = true;

        @Config.Comment("Pyramid Rarity")
        public static int pyramidRarity = 500;

        @Config.Comment("Enable Castle Gen")
        public static boolean castleGen = true;

        @Config.Comment("Castle Rarity")
        public static int castleRarity = 1000;

        @Config.Comment("Enable Jail")
        public static boolean jailActive = true;

    }

    @Config(modid = "morecreeps", category = "Miscellaneous")
    public static class Miscellaneous {

        @Config.Comment("Enable Blood")
        public static boolean blood = true;

        @Config.Comment("Enable Raygun Fire")
        public static boolean rayGunFire = true;

        @Config.Comment("Enable Raygun Melt")
        public static boolean rayGunMelt = true;

        @Config.Comment("Allow Floobs to Target Villagers")
        public static boolean floobTargetVillagers = true;

        @Config.Comment("Allow Floobship Explosion")
        public static boolean floobShipExplode = false;

        @Config.Comment("Allow Bum Public Urination")
        public static boolean publicUrination = true;

    }

    @Config(modid = "morecreeps", category = "Spawn Numbers")
    public static class SpawnNumbers {

        public static int guineaPigSpawnAmt = 5;
        public static int babyMummySpawnAmt = 1;
        public static int blackSoulSpawnAmt = 1;
        public static int mummySpawnAmt = 1;
        public static int armyGuySpawnAmt = 1;
        public static int hotdogSpawnAmt = 5;
        public static int gooGoatSpawnAmt = 3;
        public static int kidSpawnAmt = 1;
        public static int lollimanSpawnAmt = 1;
        public static int gSpawnAmt = 3;
        public static int robotTedSpawnAmt = 2;
        public static int robotToddSpawnAmt = 2;
        public static int lawyerFromHellSpawnAmt = 3;
        public static int bigBabySpawnAmt = 4;
        public static int thiefSpawnAmt = 3;
        public static int floobSpawnAmt = 5;
        public static int floobShipSpawnAmt = 1;
        public static int horseHeadSpawnAmt = 1;
        public static int digBugSpawnAmt = 3;
        public static int bubbleScumSpawnAmt = 5;
        public static int sneakySalSpawnAmt = 1;
        public static int snowDevilSpawnAmt = 3;
        public static int blorpSpawnAmt = 3;
        public static int camelSpawnAmt = 1;
        public static int camelJockeySpawnAmt = 1;
        public static int bumSpawnAmt = 3;
        public static int cavemanSpawnAmt = 1;
        public static int desertLizardSpawnAmt = 4;
        public static int evilScientistSpawnAmt = 3;
        public static int hippoSpawnAmt = 3;
        public static int hunchbackSpawnAmt = 2;
        public static int invisibleManSpawnAmt = 2;
        public static int mandogSpawnAmt = 1;
        public static int nonSwimmerSpawnAmt = 1;
        public static int preacherSpawnAmt = 1;
        public static int rockMonsterSpawnAmt = 1;
        public static int rocketGiraffeSpawnAmt = 4;
        public static int zebraSpawnAmt = 5;
        public static int growbotGreggSpawnAmt = 1;
        public static int ponyGirlSpawnAmt = 1;

    }

    public static int calculateSpawnRate(int baseRate) {
        return (int) Math.floor(baseRate * Spawn.globalSpawnRate);
    }

    public static boolean hasBiome(String biome) {
        for (String str : Spawn.nonVanillaBiomes) {
            if (str.equals(biome)) {
                return true;
            }
        }

        return false;
    }
}