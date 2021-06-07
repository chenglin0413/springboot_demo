package com.fet.springboot.baseapp.repo.domain;
import java.util.Date;
import javax.persistence.*;
/**
 * Data Trasfer Object(Category)
 * 欄位與資料庫對應
 * 
 * @author jamLin
 *
 */
@Entity
@Table(name = "blc_category")
public class Category {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="category_id")
  private long id;

  @Column(name = "name")
  private String name;



  @Column(name = "description")
  private String description;

  @Column(name="long_description")
  private String long_description;
  
  @Temporal(value=TemporalType.TIMESTAMP)
  @Column(name="active_start_date")
  private Date start_date;

public String getLong_description() {
	return long_description;
}

public void setLong_description(String long_description) {
	this.long_description = long_description;
}

  


  public Category() {

  }

  public Category(String name, String description,String long_description,Date start_date) {
    this.name = name;
    this.description = description;
    this.long_description = long_description;
    this.start_date=start_date;
  }

  public long getId() {
    return id;
  }

  public String getName() {
	return name;
  }

  public void setName(String name) {
		this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
  
 
  public Date getStart_date() {
	return start_date;
  }

  public void setStart_date(Date start_date) {
	this.start_date = start_date;
  }

  @Override
  public String toString() {
	  return "Category [id=" + id + ", name=" + name + ", description=" + description + ", long_description="
			+ long_description + ", start_date=" + start_date + "]";
  }



}
