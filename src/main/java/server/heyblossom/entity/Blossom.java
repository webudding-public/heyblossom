package server.heyblossom.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Blossoms")
@Getter
@Setter
@NoArgsConstructor
public class Blossom extends Base {

    @ManyToOne
    @JoinColumn(name = "giver_id", nullable = false)
    private User giver;

    @ManyToOne
    @JoinColumn(name = "receiver_id", nullable = false)
    private User receiver;

    @Column(name = "message", nullable = false)
    private String message;

    public Blossom(User giver, User receiver, String message) {
        this.giver = giver;
        this.receiver = receiver;
        this.message = message;
    }

    public User getGiver() {
        return giver;
    }

    public void setGiver(User giver) {
        this.giver = giver;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
