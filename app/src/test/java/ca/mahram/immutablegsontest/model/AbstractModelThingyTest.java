package ca.mahram.immutablegsontest.model;

import ca.mahram.immutablegsontest.util.JsonConverter;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by MahramF.
 */
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