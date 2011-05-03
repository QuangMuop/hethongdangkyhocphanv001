

package system.dto;

import java.sql.Date;

public class clsNews {
private int Id;
private String Content;
private String Author;
private Date Date;
public clsNews(int id, String content, String author, Date date){
    this.Id=id;
    this.Content=content;
    this.Date=date;
}
public void setId(int id){
    this.Id=id;
}
public void setContent(String content){
    this.Content=content;
}
public void setAuthor(String author){
    this.Author=author;
}
public void setDate(Date date){
    this.Date=date;
}
public int getId(){
    return this.Id;
}
public String getContent(){
    return this.Content;
}
public String getAuthor(){
    return this.Author;
}
public Date getDate(){
    return this.Date;
}
}
