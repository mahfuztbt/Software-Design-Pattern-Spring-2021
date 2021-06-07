

import java.util.EnumMap;
import java.util.Map;

/**
 *
 * Serum is the Flyweight in this example. It minimizes memory use by sharing object
 * instances. It holds a map of potion instances and new potions are created only when none of the
 * type already exists.
 *
 */
public class SerumFactory {

    private final Map<SerumType, Serum> Serums;

    public SerumFactory() {
        Serums = new EnumMap<>(SerumType.class);
    }

    Serum createPotion(SerumType type) {
        Serum serum = Serums.get(type);
        if (serum == null) {
            switch (type) {
                case HEALING:
                    serum = new HealingSerum();
                    Serums.put(type, serum);
                    break;
                case HOLY_WATER:
                    serum = new HolyWaterSerum();
                    Serums.put(type, serum);
                    break;
                case INVISIBILITY:
                    serum = new InvisibilitySerum();
                    Serums.put(type, serum);
                    break;
                case POISON:
                    serum = new PoisonSerum();
                    Serums.put(type, serum);
                    break;
                case STRENGTH:
                    serum = new StrengthSerum();
                    Serums.put(type, serum);
                    break;
                case SUPERHUMAN:
                    serum = new SuperhumanSerum();
                    Serums.put(type, serum);
                    break;
                case CAP:
                    serum = new SuperSoldierCapSerum();
                    Serums.put(type, serum);
                    break;
                case HULK:
                    serum = new BecomeHulkSerum();
                    Serums.put(type, serum);
                    break;
                case FLASH:
                    serum = new FlashSerum();
                    Serums.put(type, serum);
                    break;
                case MAGNETO:
                    serum = new MagnetoSerum();
                    Serums.put(type, serum);
                    break;
                case DEADPOOL:
                    serum = new BeDeadpoolSerum();
                    Serums.put(type, serum);
                    break;
                case WEAKNESS:
                    serum = new SerumOfWeakness();
                    Serums.put(type, serum);
                    break;
                case MINECRAFT:
                    serum = new SerumOfMinecraft();
                    Serums.put(type, serum);
                    break;
                case WOLVERINE:
                    serum = new BeWolverineSerum();
                    Serums.put(type, serum);
                    break;
                case JACKIECHAN:
                    serum = new BeJackieChanSerum();
                    Serums.put(type, serum);
                    break;
                case REGENERATOR:
                    serum = new SerumOfRegenerator();
                    Serums.put(type, serum);
                    break;
                case MINDREADER:
                    serum = new MindReaderSerum();
                    Serums.put(type, serum);
                    break;
                default:
                    break;
            }
        }
        return serum;
    }
}