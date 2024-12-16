package org.academy.utils.dataprovider;

import org.testng.annotations.DataProvider;

public class LongDataProvider extends BaseDataProvider{

    @DataProvider(name="validGreaterThanZero")
    public static Object[][] validGreaterThanZeroDP(){
        return new Object[][]{
                {"12348943"},
                {"65"},
                {"234092340"},
                {"1"},
                {"13129078998"},
        };
    }

    @DataProvider(name="validLessThenZero")
    public static Object[][] validLessThenZeroDP(){
        return new Object[][]{
                {"-1234352"},
                {"-1"},
                {"-62"},
                {"-423534786"},
                {"-1243678231487"},
        };
    }

    @DataProvider(name="validBoundaryValues")
    public static Object[][] validBoundaryValuesDP(){
        return new Object[][]{
                {"9223372036854775807"},
                {"-9223372036854775808"},
                {"0"},
        };
    }

    @DataProvider(name="invalidSymbols")
    public static Object[][] invalidSymbolsDP(){
        return new Object[][]{
                {"qwd"},
                {"1234398d"},
                {"@#36gsdf"},
                {"\n"},
                {"\r"},
        };
    }

    @DataProvider(name="invalidGreaterThanMAX")
    public static Object[][] invalidGreaterThanMAXDP(){
        return new Object[][]{
                {"9223372036854775808"},
                {"92233720468537458227"},
                {"12123312036834775407"},
        };
    }

    @DataProvider(name="invalidLessThanMIX")
    public static Object[][] invalidLessThanMIXDP(){
        return new Object[][]{
                {"-9223372036854775809"},
                {"-23223372066874775808"},
                {"-142233342056854775808"},
        };
    }

    @DataProvider(name="invalidLikeDouble")
    public static Object[][] invalidLikeDoubleDP(){
        return new Object[][]{
                {"0.00"},
                {"212.321"},
                {"453.0"},
                {"2427894.0"},
                {"-2342398.0"},
        };
    }
}
