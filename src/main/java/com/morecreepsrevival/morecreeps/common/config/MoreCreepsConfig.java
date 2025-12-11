package com.morecreepsrevival.morecreeps.common.config;

import net.minecraftforge.common.config.Config;
import java.lang.reflect.Field;

@Config(modid = "morecreeps", category = "General")
public class MoreCreepsConfig {

    @Config.Comment("Toggles the playing of the welcome sound when you load the world.")
    public static boolean playWelcomeSound = true;

    @Config.Comment("Sends a welcome message in the chat to each player joining.")
    public static boolean sendWelcomeMessage = true;

    @Config(modid = "morecreeps", category = "Spawn")
    public static class Spawn {
        @Config.Comment("This is a list of entities from core creeps that are not allowed to spawn. Adding entries here will completely disable these entities.\n a list of creep names for reference: guineapig,  tombstone,  trophy,  babymummy,  blacksoul,  mummy,  googoat,  kid,  lolliman,  pyramid_guardian,  evilcreature,  castleguard,  castlecritter,  castleking,  g,  robot_ted,  robot_todd,  lawyer_from_hell,  bigbaby,  schlump,  thief,  floob,  floobship,  horsehead,  hotdog,  digbug,  bubblescum,  sneakysal,  ratman,  prisoner,  snowdevil,  evilchicken,  evilpig,  doghouse,  blorp,  camel,  zebra,  rocketgiraffe,  evilscientist,  mandog,  caveman,  evil_light,  hunchback,  hunchbackskeleton,  bum,  evilsnowman,  preacher,  growbot_gregg,  cameljockey,  invisible_man,  ponygirl,  pony,  ponycloud,  rock_monster,  desert_lizard,  hippo\n You can also use the tellme mod to look up all entities associated with the mod.")
        public static String[] bannedCreeps = {};
        @Config.Comment("This setting controls the overall spawn rate. The spawn rate of every mob is multiplied by this number. So 0.5 is the default rate, 1.0 is 2x the rate, 0.25 is half the rate, etc.")
        public static double globalSpawnRate = 0.75f;

        @Config.Comment("Setting this to true will enable the biome whitelist for more creeps mobs to spawn in. Disabling both the blacklist and the whitelist will prevent mobs from spawning in any modded biomes.")
        public static boolean enableBiomeWL = false;
        @Config.Comment("This is the  whitelist of Non-Vanilla biomes that More Creeps mobs should ONLY spawn in.")
        public static String[] biomesWL = {};

        @Config.Comment("Setting this to true will enable the biome blacklist for more creeps mobs to spawn in. Disabling the whitelist and the blacklist will prevent mobs from spawning in any modded biomes.")
        public static boolean enableBiomeBL = true;
        @Config.Comment("This is the  blacklist of Non-Vanilla biomes that More Creeps mobs should NOT spawn in.")
        public static String[] biomesBL = {};

    }

    @Config(modid = "morecreeps", category = "WorldGen")
    public static class WorldGen {

        @Config.Comment("Enable Pyramid Gen")
        public static boolean pyramidGen = true;

        @Config.Comment("Pyramid Rarity. Given as a percentage chance per chunk, so 1 = 1% chance per Desert chunk.")
        public static float pyramidRarityChance = 1f;

        @Config.Comment("Pyramid Dimensions. list of dimension IDs pyramids are allowed to spawn in")
        public static int[] pyramidDimensions = {0};

        @Config.Comment("Enable Castle Gen")
        public static boolean castleGen = true;

        @Config.Comment("Castle Rarity. Given as a percentage chance per chunk, so 0.1 = 0.1% chance per chunk.")
        public static float castleRarityChance = 0.1f;

        @Config.Comment("Castle Dimensions. list of dimension IDs pyramids are allowed to spawn in")
        public static int[] castleDimensions = {0};

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

        @Config.Comment("Set damage for the raygun (half hearts)")
        public static double raygunDamage = 2.0D;

        @Config.Comment("Set damage for the gun (half hearts)")
        public static double gunDamage = 2.0D;

        @Config.Comment("Set damage for the gem sword")
        public static float gemSwordDamage = 4.5F;

        @Config.Comment("Set damage for the club")
        public static float clubDamage = 2.5F;

        @Config.Comment("Set protection for zebra helmet")
        public static int zebraHelmetP = 2;

        @Config.Comment("Set protection for zebra chestplate")
        public static int zebraChestP = 6;

        @Config.Comment("Set protection for zebra leggings")
        public static int zebraLeggingsP = 4;

        @Config.Comment("Set protection for zebra boots")
        public static int zebraBootsP = 2;

    }

    @Config(modid = "morecreeps", category = "Spawn Weights")
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

    @Config(modid = "morecreeps", category = "Tamed Names")
    public static class TamedNames {

        @Config.Comment("List of names that will be randomly chosen when a Guinea Pig is tamed.")
        public static String[] guineaPigNames = {
                "Sugar", "Clover", "CoCo", "Sprinkles", "Mr. Rabies", "Stinky", "The Incredible Mr. CoCoPants", "Butchie", "Lassie", "Fuzzy",
                "Nicholas", "Natalie", "Pierre", "Priscilla", "Mrs. McGillicutty", "Dr. Tom Jones", "Peter the Rat", "Wiskers", "Penelope", "Sparky",
                "Tinkles", "Ricardo", "Jimothy", "Captain Underpants", "CoCo Van Gough", "Chuck Norris", "PeeWee", "Quasimodo", "ZSA ZSA", "Yum Yum",
                "Deputy Dawg", "Henrietta Pussycat", "Bob Dog", "King Friday", "Jennifer", "The Situation", "Prince Charming", "Sid", "Sunshine", "Bubbles",
                "Carl", "Snowy", "Dorf", "Chilly Willy", "Angry Bob", "George W. Bush", "Ted Lange from The Love Boat", "Notch", "Frank", "A Very Young Pig",
                "Blaster", "Darwin", "Ruggles", "Chang", "Spaz", "Fluffy", "Fuzzy", "Charrlotte", "Tootsie", "Mary",
                "Caroline", "Michelle", "Sandy", "Peach", "Scrappy", "Roxanne", "James the Pest", "Lucifer", "Shaniqua", "Wendy",
                "Zippy", "Prescott Pig", "Pimpin' Pig", "Big Daddy", "Little Butchie", "The Force", "The Handler", "Little Louie", "Satin", "Sparkly Puff",
                "Dr. Chews", "Pickles", "Longtooth", "Jeffry", "Pedro the Paunchy", "Wee Willy Wiskers", "Tidy Smith", "Johnson", "Big Joe", "Tiny Mackeral",
                "Wonderpig", "Wee Wonderpig", "The Polish Baron", "Inconceivable", "Double Danny Dimples", "Jackie Jones", "Pistol", "Tiny Talker", "Strum", "Disco the Pig",
                "Banjo", "Fingers", "Clean Streak", "Little Sweet", "Fern", "Youngblood", "Lazy Cottonball", "Foxy", "SlyFoxHound",
                "Namjoon", "Seokjin", "Yoongi", "Hoseok", "Jimin", "Taehyung", "Jungkook", "Suga", "Jinnie",
                "Halsey", "Rose", "Lisa", "Jennie", "Jisoo", "Momo", "Mina", "Sana", "BamBam",
                "Yuna", "Soobin", "Solar", "Hwasa", "Hyuna", "DAWN", "Mini", "Kai", "GlockBoyKari", "Wonho", "ㅇㅅㅇ",
                "Joongie", "Sannie", "Jongho", "Mingi", "Wooyoung", "Yunho", "Hwa", "Yeosang", "Binnie", "Felix", "Chan", "Han", "MINO", "G-Dragon",
                "BOBBY", "Joshua", "Vernon", "Yuto", "Stan Loona", "Jannabi", "Irene", "Joy", "Mr. Chu", "Rap Monster", "ThreeToe"
        };

        @Config.Comment("List of names that will be randomly chosen when a HotDog is tamed.")
        public static String[] entityHotDogNames = {
                "Pogo", "Spot", "King", "Prince", "Bosco", "Ralph", "Wendy", "Trixie", "Bowser", "The Heat",
                "Weiner", "Wendon the Weiner", "Wallace the Weiner", "William the Weiner", "Terrance", "Elijah", "Good Boy", "Boy", "Girl", "Tennis Shoe",
                "Rusty", "Mean Joe Green", "Lawrence", "Foxy", "SlyFoxHound", "Leroy Brown",
                "Mickey", "Holly", "Yeontan"
        };

        @Config.Comment("List of names that will be randomly chosen when a Zebra is tamed.")
        public static String[] entityZebraNames = {
                "Stanley", "Cid", "Hunchy", "The Heat", "Herman the Hump", "Dr. Hump", "Little Lousie", "Spoony G", "Mixmaster C", "The Maestro",
                "Duncan the Dude", "Charlie Camel", "Chip", "Charles Angstrom III", "Mr. Charles", "Cranky Carl", "Carl the Rooster", "Tiny the Peach", "Desert Dan", "Dungby",
                "Doofus"
        };

        @Config.Comment("List of names that will be randomly chosen when a Camel is tamed.")
        public static String[] entityCamelNames = {
                "Stanley", "Cid", "Hunchy", "The Heat", "Herman the Hump", "Dr. Hump", "Little Lousie", "Spoony G", "Mixmaster C", "The Maestro",
                "Duncan the Dude", "Charlie Camel", "Chip", "Charles Angstrom III", "Mr. Charles", "Cranky Carl", "Carl the Rooster", "Tiny the Peach", "Desert Dan", "Dungby",
                "Doofus"
        };

        @Config.Comment("List of names that will be randomly chosen when a Snow Devil is tamed.")
        public static String[] entitySnowDevilNames = {
                "Satan", "The Butcher", "Killer", "Tad", "Death Spanker", "Death Toll", "Bruiser", "Bones", "The Devil", "Little Devil",
                "Skinny", "Death to All", "I Will Hurt You", "Pierre", "Bonecruncher", "Bone Breaker", "Blood 'N Guts", "Kill Kill", "Murder", "The Juicer",
                "Scream", "Bloody Buddy", "Sawblade", "Ripper", "Razor", "Valley Strangler", "Choppy Joe", "Wiconsin Shredder", "Urinal", "Johnny Choke",
                "Annihilation", "Bloodshed", "Destructo", "Rub Out", "Massacre", "Felony", "The Mangler", "Destroyer", "The Marauder", "Wreck",
                "Vaporizer", "Wasteland", "Demolition Duo", "Two Knocks", "Double Trouble", "Thing One & Thing Two", "Wipeout", "Devil Duo", "Two Shot", "Misunderstood",
                "Twice As Nice"
        };

        @Config.Comment("List of names that will be randomly chosen when a Pony is tamed.")
        public static String[] entityPonyNames = {
                "Chester", "Tugbert the Terrible", "Edward", "Prancer", "Paul", "Ralph", "Captain Sparkles", "Little Mo", "Percy", "Percival the Brave", "Sammy", "Thunderhoof", "Thunderbolt", "Bolt", "Benji", "Rasberry Ron", "Peter Sprinkles", "Captain Rainbow", "Chuckles", "Trigger", "Petuna", "Matilda", "Molly the Magnificent", "Betty", "Tom", "Caronline", "Hillary Hoof", "Paula", "Chaz", "Twinkletoes", "The Fortune Hunter", "Carl C Cluxton", "George", "Betty the Beast", "Nancy Neigh", "Susan Swift", "Claire De Lune", "L.A. Sizzle", "Bunwarmer", "Dirty Dutchess", "Pilar", "Gusty Dreams", "Guts and Glory", "Wiggler", "Shakin' Bacon", "Mr. Maniac", "Little Hoof"
        };

        @Config.Comment("List of names that will be randomly chosen when a Giraffe is tamed.")
        public static String[] entityRocketGiraffeNames = {
                "Rory", "Stan", "Clarence", "FirePower", "Lightning", "Rocket Jockey", "Rocket Ralph", "Tim"
        };

    }

    public static int calculateSpawnRate(int baseRate) {
        return (int) Math.floor(baseRate * Spawn.globalSpawnRate);
    }

    public static boolean hasBiome(String biome) {
        if (Spawn.enableBiomeWL) {
            for (String str : Spawn.biomesWL) {
                if (str.equals(biome)) {
                    return true;
                }
            }
        }
        if (Spawn.enableBiomeBL) {
            for (String str : Spawn.biomesBL) {
                if (str.equals(biome)) {
                    return false;
                }
            }
            return true;
        }
        return false;
        }

    public static boolean hasDimension(int dimension, String structure) {
        try {
            // Get the field from WorldGen class by name
            Field field = WorldGen.class.getField(structure + "Dimensions"); // or getDeclaredField() for non-public fields

            // Ensure it's an array of ints
            if (field.getType().isArray() && field.getType().getComponentType() == int.class) {
                int[] dims = (int[]) field.get(null); // null for static field
                for (int dim : dims) {
                    if (dim == dimension) {
                        return true;
                    }
                }
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return false;
    }
}