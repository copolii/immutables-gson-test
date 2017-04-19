package ca.mahram.immutablegsontest.util;

import android.support.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapterFactory;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.ServiceLoader;


/**
 * Created by MahramF.
 */

@SuppressWarnings({"WeakerAccess", "unused"})
public final class JsonConverter {
    public static final Gson GSON;

    static {
        final GsonBuilder gsonBuilder = new GsonBuilder();

        for (final TypeAdapterFactory taf : ServiceLoader.load(TypeAdapterFactory.class)) {
            gsonBuilder.registerTypeAdapterFactory(taf);
        }

        GSON = gsonBuilder
                .create();
    }

    public static <T> String toJson(final T t) {
        return GSON.toJson(t);
    }

    public static <T> JSONObject toOrgJson(final T t) throws JSONException {
        return new JSONObject(GSON.toJson(t));
    }

    public static <T> JSONArray toOrgArray(final T[] t) throws JSONException {
        return new JSONArray(GSON.toJson(t));
    }

    public static <T> JSONArray toOrgArray(final Collection<T> ts) throws JSONException {
        return new JSONArray(GSON.toJson(ts));
    }

    public static String toJson(final JSONObject o) {
        return null == o ? null : o.toString();
    }

    public static String toJson(final JSONArray a) {
        return null == a ? null : a.toString();
    }

    public static <T> String safelyToJson(final T t) {
        try {
            return toJson(t);
        } catch (Exception e) {
            return null;
        }
    }

    public static String safelyToJson(final JSONObject o) {
        try {
            return toJson(o);
        } catch (Exception e) {
            return null;
        }
    }

    public static String safelyToJson(final JSONArray a) {
        try {
            return toJson(a);
        } catch (Exception e) {
            return null;
        }
    }

    @NonNull
    public static <T> T fromJson(final String json, final Class<T> clas) throws JsonParseException {
        return GSON.fromJson(json, clas);
    }

    public static <T> T fromJson(final String json, final Type type) {
        return GSON.fromJson(json, type);
    }

    @NonNull
    public static <T> T fromJson(final JSONObject jo, final Class<T> clas) throws JsonParseException {
        return fromJson(jo.toString(), clas);
    }

    @NonNull
    public static <T> T fromJson(final JSONArray ja, final Class<T> clas) throws JsonParseException {
        return fromJson(ja.toString(), clas);
    }

    public static <T> T safelyFromJson(final JsonElement json, final Class<T> clas) {
        try {
            return GSON.fromJson(json, clas);
        } catch (Exception e) {
            return null;
        }
    }

    public static <T> T safelyFromJson(final String json, final Class<T> clas) {
        try {
            return fromJson(json, clas);
        } catch (Exception e) {
            return null;
        }
    }

    public static <T> T safelyFromJson(final JSONObject jo, final Class<T> clas) {
        return safelyFromJson(jo.toString(), clas);
    }

    public static <T> T safelyFromJson(final JSONArray ja, final Class<T> clas) {
        return safelyFromJson(ja.toString(), clas);
    }
}
