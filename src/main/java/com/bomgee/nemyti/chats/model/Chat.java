package com.bomgee.nemyti.chats.model;

import com.bomgee.nemyti.messages.model.Message;
import com.bomgee.nemyti.users.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Getter
@Setter
@Builder
@Entity
@Table(name = "chats")
@NoArgsConstructor
@AllArgsConstructor
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user1_id")
    private User sender;

    @ManyToOne
    @JoinColumn(name = "user2_id")
    private User receiver;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "chat_id", updatable = false, insertable = false, referencedColumnName = "id")
    private List<Message> messages;
}
