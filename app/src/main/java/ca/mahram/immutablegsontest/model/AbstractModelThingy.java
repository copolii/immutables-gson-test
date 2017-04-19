package ca.mahram.immutablegsontest.model;

import com.google.gson.annotations.SerializedName;

import org.immutables.value.Value;

/**
 * Created by MahramF.
 */

@org.immutables.gson.Gson.TypeAdapters
@Value.Immutable
@Value.Style (typeImmutable = "*",
        typeAbstract = "Abstract*")
public abstract class AbstractModelThingy {
    @SerializedName("id")
    public abstract String identifier ();
    @SerializedName("fn")
    public abstract String name ();
    @SerializedName("sn")
    public abstract int serial ();
}
