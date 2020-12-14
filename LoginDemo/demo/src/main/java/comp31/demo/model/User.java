package comp31.demo.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

//Nick Best


@Data
@Entity
@NoArgsConstructor
@Table(name="User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="USER_ID")
    private Integer userId;
    @Column(name="USER_NAME")
    private String userName;
    @Column(name="USER_ROLE")
    private String userRole;
    
    public Integer getId() {
		return userId;
    }
    public String getName() {
		return userName;
    }
    

}
