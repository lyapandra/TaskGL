package task01Multiple;

import java.util.HashMap;
import java.util.Map;

public class Runner {

    /**
     * Finding digits that are devided without remainder at divides in range from 1 to dividedMax
     * Знаходження чисел які діляться без залишку на дільники від 1 до dividedMax
     *
     * In the main method the dividerMap is initialised and filled out.
     * в методі проініціалізовано і заповнено мапу dividerMap
     *
     * Keys in map dividerMap are dividers
     * ключі map dividerMap є дільниками
     *
     * Values in map dividerMap is text that is logged if devided can be devided at devider without remainder
     * Значенням мапи dividerMap є текст, якиий виводиться в лог при дільник ділиться на ділене без залишку
     *
     * Result is contained in a feild listOfDividers in the class Multiple
     * Результат знаходиться у змінній listOfDividers класу Multiple
     */
    public static void main(String[] args) {

        Map<Integer, String> dividerMap = new HashMap();
        dividerMap.put(3, "three");
        dividerMap.put(5, "five");
        int dividedMax = 15;

        new Multiple(dividerMap, dividedMax);
    }
}
