package ca.mahram.immutablegsontest.model;

import android.support.test.runner.AndroidJUnit4;

import ca.mahram.immutablegsontest.util.JsonConverter;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Created by MahramF.
 */
@RunWith(AndroidJUnit4.class)
public class AbstractModelThingyTest {
    @Test
    public void testParseFromJson () {
        final String json = "{\"id\":\"abc1234def\",\"fn\":\"Object Number One\",\"sn\":232454}";

        final AbstractModelThingy thingy = JsonConverter.fromJson(json, ModelThingy.class);
        assertEquals("abc1234def", thingy.identifier());
        assertEquals("Object Number One", thingy.name());
        assertEquals(232454, thingy.serial());
    }
}