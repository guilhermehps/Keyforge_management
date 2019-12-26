package com.Keyforge_management.data.model;

import com.Keyforge_management.data.storage.ExpansionTypeConverter;
import com.Keyforge_management.data.storage.HouseArrayTypeConverter;

import java.io.Serializable;
import java.util.Arrays;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

@Entity(tableName = "decks")
public class Deck implements Serializable {
    @PrimaryKey
    private long id;
    private String keyforgeid;
    private String name;
    @TypeConverters({ExpansionTypeConverter.class})
    private Expansion expansion;
    private int creatureCount;
    private int actionCount;
    private int artifactCount;
    private int upgradeCount;
    private int sasRating;
    private int rawAmber;
    @TypeConverters({HouseArrayTypeConverter.class})
    private House[] houses;

    public void setId(long id) {
        this.id = id;
    }

    public void setKeyforgeid(String keyforgeid) {
        this.keyforgeid = keyforgeid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setExpansion(Expansion expansion) {
        this.expansion = expansion;
    }

    public void setCreatureCount(int creatureCount) {
        this.creatureCount = creatureCount;
    }

    public void setActionCount(int actionCount) {
        this.actionCount = actionCount;
    }

    public void setArtifactCount(int artifactCount) {
        this.artifactCount = artifactCount;
    }

    public void setUpgradeCount(int upgradeCount) {
        this.upgradeCount = upgradeCount;
    }

    public void setSasRating(int sasRating) {
        this.sasRating = sasRating;
    }

    public void setRawAmber(int rawAmber) {
        this.rawAmber = rawAmber;
    }

    public void setHouses(House[] houses) {
        this.houses = houses;
    }

    public long getId() {
        return id;
    }

    public String getKeyforgeid() {
        return keyforgeid;
    }

    public String getName() {
        return name;
    }

    public int getCreatureCount() {
        return creatureCount;
    }

    public int getActionCount() {
        return actionCount;
    }

    public int getArtifactCount() {
        return artifactCount;
    }

    public int getUpgradeCount() {
        return upgradeCount;
    }

    public int getSasRating() {
        return sasRating;
    }

    public int getRawAmber() {
        return rawAmber;
    }

    public House[] getHouses() {
        return houses;
    }

    public Expansion getExpansion() {
        return expansion;
    }

    @Override
    public String toString() {
        return "Deck{" +
                "id=" + id +
                ", keyforgeid='" + keyforgeid + '\'' +
                ", name='" + name + '\'' +
                ", expansion=" + expansion +
                ", creatureCount=" + creatureCount +
                ", actionCount=" + actionCount +
                ", artifactCount=" + artifactCount +
                ", upgradeCount=" + upgradeCount +
                ", sasRating=" + sasRating +
                ", rawAmber=" + rawAmber +
                ", houses=" + Arrays.toString(houses) +
                '}';
    }
}
