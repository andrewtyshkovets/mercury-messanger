package com.bomgee.nemyti.messages.model;

import com.bomgee.nemyti.chats.model.Chat;
import com.bomgee.nemyti.users.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@Entity
@Table(name = "messages")
@NoArgsConstructor
@AllArgsConstructor
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    private String body;

    @UpdateTimestamp
    @Column(nullable = false, name = "deliver_time")
    private LocalDateTime sendTime;

    @ManyToOne
    private User sender;

    @ManyToOne
    private Chat chat;
}
