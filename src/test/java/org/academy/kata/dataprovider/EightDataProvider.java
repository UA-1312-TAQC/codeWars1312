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
}