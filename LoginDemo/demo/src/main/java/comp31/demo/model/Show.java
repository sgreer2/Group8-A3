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

//Nick Best

@Entity
@Data
@Table (name="SHOW")

public class Show {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY )
    @Column(name="SHOW_ID")
    private Long showId;
    @Column(name="SHOW_TITLE")
    private String showTitle;
    @Column(name="SHOW_DESC")
    private String showDesc;
    @Column(name="SHOW_NUM_EP")
    private Integer showNum;
    @Column(name="USER_ID")
    private Integer userId ;
	public void setUserId(Integer userNew) {
        userId=userNew;
  }
  public Long getId()
  {
    return showId;
  }



  //  @ManyToOne 
  // @JoinColumn(name = "USER_ID", nullable = true)
  // private User user;

    
}
