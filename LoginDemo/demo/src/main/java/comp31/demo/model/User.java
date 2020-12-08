package comp31.demo.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;


// CREATE TABLE user
// (
//     userId int PRIMARY KEY AUTO_INCREMENT,
//     userName TEXT,
//     userRole TEXT
// );
@Data
@Entity
@NoArgsConstructor
@Table(name="User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="USER_ID")
    private Long userId;
    @Column(name="USER_NAME")
    private String userName;
    @Column(name="USER_ROLE")
    private String userRole;
    
    public Long getId() {
		return userId;
    }
    public String getName() {
		return userName;
    }
    

}
