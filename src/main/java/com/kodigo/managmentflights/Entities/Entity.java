package com.kodigo.managmentflights.Entities;

import java.util.Objects;
import java.util.UUID;

public abstract class Entity {
    private final String id;

    public Entity() {
        // Datos en memoria.
        this.id = UUID.randomUUID().toString().substring(0,8);
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
        return id.substring(0,8);
    }
}
