package org.academy.kata.dataprovider;

import org.academy.kata.IEight;
import org.academy.kata.IFive;
import org.academy.kata.ISix;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Stream;

public class BaseDataProvider {
    protected static final List<IEight> EIGHTS = List.of(
            new org.academy.kata.implementation.TanyaB777.Eight(),
            new org.academy.kata.implementation.Dorrothee.Eight(),
            new org.academy.kata.implementation.NastiaDamian.Eight(),
            new org.academy.kata.implementation.AnastasiiaSun.Eight(),
            new org.academy.kata.implementation.Vovanchek.Eight(),
            new org.academy.kata.implementation.kiyanovskaa.Eight(),
            new org.academy.kata.implementation.NatalyKokhaniuk.Eight(),
            new org.academy.kata.implementation.MisterV03.Eight(),
            new org.academy.kata.implementation.ValKuch.Eight(),
            new org.academy.kata.implementation.nestea4.Eight(),
            new org.academy.kata.implementation.ivanromanuik2014.Eight(),
            new org.academy.kata.implementation.daniilrusanov.Eight(),
            new org.academy.kata.implementation.niker01.Eight(),
            new org.academy.kata.implementation.BasilJaworski.Eight()
    );

    protected static final List<ISix> SIX = List.of(
            new org.academy.kata.implementation.TanyaB777.Six(),
            new org.academy.kata.implementation.Dorrothee.Six(),
            new org.academy.kata.implementation.NastiaDamian.Six(),
            new org.academy.kata.implementation.AnastasiiaSun.Six(),
            new org.academy.kata.implementation.Vovanchek.Six(),
            new org.academy.kata.implementation.kiyanovskaa.Six(),
            new org.academy.kata.implementation.NatalyKokhaniuk.Six(),
            new org.academy.kata.implementation.MisterV03.Six(),
            new org.academy.kata.implementation.ValKuch.Six(),
            new org.academy.kata.implementation.nestea4.Six(),
            new org.academy.kata.implementation.ivanromanuik2014.Six(),
            new org.academy.kata.implementation.daniilrusanov.Six(),
            new org.academy.kata.implementation.niker01.Six(),
            new org.academy.kata.implementation.BasilJaworski.Six()
    );
    protected static final List<IFive> FIFTH = List.of(
            new org.academy.kata.implementation.TanyaB777.Five(),
            new org.academy.kata.implementation.Dorrothee.Five(),
            new org.academy.kata.implementation.NastiaDamian.Five(),
            new org.academy.kata.implementation.AnastasiiaSun.Five(),
            new org.academy.kata.implementation.Vovanchek.Five(),
            new org.academy.kata.implementation.kiyanovskaa.Five(),
            new org.academy.kata.implementation.NatalyKokhaniuk.Five(),
            new org.academy.kata.implementation.MisterV03.Five(),
            new org.academy.kata.implementation.ValKuch.Five(),
            new org.academy.kata.implementation.nestea4.Five(),
            new org.academy.kata.implementation.ivanromanuik2014.Five(),
            new org.academy.kata.implementation.daniilrusanov.Five(),
            new org.academy.kata.implementation.niker01.Five(),
            new org.academy.kata.implementation.BasilJaworski.Five()
    );

    protected static Iterator<Object[]> combineData(List<Object[]> input_data, List<?> impls) {
        final List<Object[]> data = new ArrayList<>();
        for (Object impl : impls) {
            for (Object[] row : input_data) {
                data.add(Stream.concat(Stream.of(impl), Arrays.stream(row).map(obj -> {
                    if (obj == null) return null;
                    if (obj.getClass().isArray()) {
                        var componentType = obj.getClass().getComponentType();
                        if (componentType.isPrimitive()) {
                            if (componentType == int.class) {
                                return Arrays.copyOf((int[]) obj, Array.getLength(obj));
                            } else if (componentType == float.class) {
                                return Arrays.copyOf((float[]) obj, Array.getLength(obj));
                            } else if (componentType == long.class) {
                                return Arrays.copyOf((long[]) obj, Array.getLength(obj));
                            } else if (componentType == double.class) {
                                return Arrays.copyOf((double[]) obj, Array.getLength(obj));
                            } else if (componentType == short.class) {
                                return Arrays.copyOf((short[]) obj, Array.getLength(obj));
                            } else if (componentType == char.class) {
                                return Arrays.copyOf((char[]) obj, Array.getLength(obj));
                            } else if (componentType == boolean.class) {
                                return Arrays.copyOf((boolean[]) obj, Array.getLength(obj));
                            } else if (componentType == byte.class) {
                                return Arrays.copyOf((byte[]) obj, Array.getLength(obj));
                            }
                        } else {
                            return Arrays.copyOf((Object[]) obj, Array.getLength(obj));
                        }

                    }
                    return obj;
                })).toArray(Object[]::new));
            }

        }
        return data.iterator();
    }
}
