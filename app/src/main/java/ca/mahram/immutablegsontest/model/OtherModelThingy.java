package ca.mahram.immutablegsontest.model;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;

/**
 * Created by MahramF.
 */

public final class OtherModelThingy {
    @SerializedName("id") @Getter public String identifier;
    @SerializedName("fn") @Getter public String name;
    @SerializedName("sn") @Getter public int serial;
}
