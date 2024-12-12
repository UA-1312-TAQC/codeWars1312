package org.academy.kata.dataprovider;

import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EightDataProvider extends BaseDataProvider {

    @DataProvider(name = "data-Liters")
    public static Iterator<Object[]> dpLiters() {
        final List<Object[]> inputs = new ArrayList<>();
        inputs.add(new Object[]{5, 2});
        inputs.add(new Object[]{55, 27});
        inputs.add(new Object[]{2, 1});
        inputs.add(new Object[]{0.97, 0});
        inputs.add(new Object[]{14.64, 7});
        inputs.add(new Object[]{1600.20, 800});
        inputs.add(new Object[]{80, 40});
        inputs.add(new Object[]{0, 0});
        inputs.add(new Object[]{Integer.MAX_VALUE * 2.0, 2147483647});

        return combineData(inputs, EIGHTS);
    }

    @DataProvider(name = "data-Liters_neg")
    public static Iterator<Object[]> dpLiters_neg() {
        final List<Object[]> inputs = new ArrayList<>();
        inputs.add(new Object[]{-1, -1});
        inputs.add(new Object[]{-77.8, -39});
        inputs.add(new Object[]{Integer.MAX_VALUE * 2.0 + 1, 0});

        return combineData(inputs, EIGHTS);
    }

    @DataProvider(name = "data-MpgToKPM")
    public static Iterator<Object[]> dpMpgToKPM() {
        final List<Object[]> inputs = new ArrayList<>();
        inputs.add(new Object[]{12.0f, 4.25f});
        inputs.add(new Object[]{10.0f, 3.54f});
        inputs.add(new Object[]{20.0f, 7.08f});
        inputs.add(new Object[]{30.0f, 10.62f});
        inputs.add(new Object[]{0.0f, 0.0f});
        inputs.add(new Object[]{-10.0f, -3.54f});
        inputs.add(new Object[]{5.0f, 1.77f});
        inputs.add(new Object[]{1000.0f, 354.83f});
        inputs.add(new Object[]{0.1f, 0.04f});
        inputs.add(new Object[]{15.5f, 5.46f});
        return combineData(inputs, EIGHTS);
    }

    @DataProvider(name = "data-Cuboid")
    public static Iterator<Object[]> dpCuboid() {
        final List<Object[]> inputs = new ArrayList<>();
        // Positive tests
        inputs.add(new Object[]{1, 2, 2, 4});
        inputs.add(new Object[]{6.3, 2, 5, 63});
        inputs.add(new Object[]{4, 5, 6, 120});
        inputs.add(new Object[]{1.5, 2.5, 3, 11.25});
        inputs.add(new Object[]{3, 3, 3, 27});
        // Negative tests
        inputs.add(new Object[]{'a', 2, 3, 6});
        inputs.add(new Object[]{-1, 2, 3, 0});
        inputs.add(new Object[]{Double.NaN, 2, 3, 6});
        inputs.add(new Object[]{1e308, 2.0, Double.MIN_VALUE, 0.0});
        inputs.add(new Object[]{1, 2, 2, 5});

        return combineData(inputs, EIGHTS);
    }

    @DataProvider(name = "data-SquareOrSquareRoot")
    public static Iterator<Object[]> dpSquareOrSquareRoot() {
        List<Object[]> inputs = new ArrayList<>();
        inputs.add(new Object[]{
                new int[]{4, 3, 9, 7, 2, 1},
                new int[]{2, 9, 3, 49, 4, 1}
        });
        inputs.add(new Object[]{
                new int[]{16, 10, 25, 8},
                new int[]{4, 100, 5, 64}
        });
        inputs.add(new Object[]{
                new int[]{100, 101, 5, 5, 1, 1},
                new int[]{10, 10201, 25, 25, 1, 1}
        });
        inputs.add(new Object[]{
                new int[]{1, 2, 3, 4, 5, 6},
                new int[]{1, 4, 9, 2, 25, 36}
        });
        inputs.add(new Object[]{
                new int[]{9},
                new int[]{3}
        });
        inputs.add(new Object[]{
                new int[]{7},
                new int[]{49}
        });
        inputs.add(new Object[]{
                new int[]{-4, -3, -9, -7},
                new int[]{16, 9, 81, 49}
        });
        inputs.add(new Object[]{
                new int[]{-1, -1, 1},
                new int[]{1, 1, 1}
        });
        inputs.add(new Object[]{
                new int[]{},
                new int[]{}
        });
        inputs.add(new Object[]{
                new int[]{0, 0, 0, 0},
                new int[]{0, 0, 0, 0}
        });
        return combineData(inputs, EIGHTS);
    }
}