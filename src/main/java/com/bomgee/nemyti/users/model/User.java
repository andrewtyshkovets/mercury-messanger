package com.bomgee.nemyti.users.model;

import com.bomgee.nemyti.chats.model.Chat;
import com.bomgee.nemyti.messages.model.Message;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Getter
@Setter
@Builder
@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(nullable = false, name = "username")
    private String userName;

    @Column(nullable = false)
    private String phone;

    @Column(name = "is_online")
    private boolean online;

    @Column(nullable = false)
    private String password;

    @Column(name = "image_url")
    private String imageUrl;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "user1_id", updatable = false, insertable = false, referencedColumnName = "id")
    private List<Chat> chatsSender;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "user2_id", updatable = false, insertable = false, referencedColumnName = "id")
    private List<Chat> chatsReceiver;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "sender_id", updatable = false, insertable = false, referencedColumnName = "id")
    private List<Message> messages;
}
