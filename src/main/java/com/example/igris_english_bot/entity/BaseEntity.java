package com.example.igris_english_bot.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Setter;
import org.apache.http.util.Asserts;
import org.springframework.data.domain.Persistable;

@Setter
@MappedSuperclass
public abstract class BaseEntity implements Persistable<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    public BaseEntity(){}

    @Override
    public boolean isNew() {
        return id == null;
    }

    @Override
    public Long getId() {
        return id;
    }

    public long id() {
        Asserts.notNull(id, "entity must have id");
        return this.id;
    }

    @Override
    public int hashCode() {
        return id == null ? 0 : id.intValue();
    }
}