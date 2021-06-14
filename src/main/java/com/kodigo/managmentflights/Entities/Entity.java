package com.kodigo.managmentflights.Entities;

import java.util.Objects;
import java.util.UUID;

public abstract class Entity {
    private final String id;

    public Entity() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entity identity = (Entity) o;
        return Objects.equals(id, identity.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "[id=" + id.substring(0,8) + "...]";
    }
}
