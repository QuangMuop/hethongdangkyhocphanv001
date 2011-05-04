

package system.dto;

import java.sql.Date;

public class clsNews {
private int Id;
private String Content;
private String Author;
private String Date;
public clsNews(){

}
public clsNews(int id, String content, String author, String date){
    this.Id=id;
    this.Content=content;
    this.Author=author;
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
public void setDate(String date){
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
public String getDate(){
    return this.Date;
}
}
