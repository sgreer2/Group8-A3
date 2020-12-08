package comp31.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="WATCHING")
@NoArgsConstructor
public class Watching {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="WATCHING_ID")
    private Integer watchingId;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @ManyToOne
    @JoinColumn(name = "SHOW_ID")
    private Show show;

    @Column(name = "EPISODES_WATCHED")
    private Integer episodesWatched;

    @Column(name = "RATING")
    private Integer rating;
}
