package in.sp.main.entity;


import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Contest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int UserId;

    @ElementCollection
//    @CollectionTable(
//    	    name = "Contest_Badges", 
//    	    joinColumns = @JoinColumn(name = "contest_id")
//    	)
    private List<String> Badges = new ArrayList<>();

    private int Score;

    private String Username;

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public int getScore() {
        return Score;
    }

    public void setScore(int score) {
        Score = score;
    }

    public List<String> getBadges() {
        return Badges;
    }

    public void setBadges(List<String> badges) {
        this.Badges = badges;
    }
}
