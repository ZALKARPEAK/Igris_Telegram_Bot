package com.example.igris_english_bot.entity;

import com.example.igris_english_bot.util.enums.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Entity
@Table(name = "Users")
@NoArgsConstructor
public class User extends BaseEntity {

    @Getter
    @Setter
    @Column(name = "chat_id")
    private String chatId;

    @Getter
    @Setter
    @Column(name = "active")
    private boolean active;

    @Getter
    @Setter
    @Column(name = "user_role")
    @Enumerated(EnumType.STRING)
    private Role role;

    public User(String chatId, Role role) {
        this.chatId = chatId;
        this.role = role;
        this.active = true;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof User)) return false;
        return this.chatId.equals(((User) obj).getChatId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.chatId);
    }
}
