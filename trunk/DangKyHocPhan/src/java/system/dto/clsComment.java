

package system.dto;

public class clsComment {
private int Id;
private String Content;
private String Author;
private String Email;
private String Date;
public clsComment(){

}
public clsComment(int id, String content, String author, String email, String date){
    this.Id=id;
    this.Content=content;
    this.Author=author;
    this.Email=email;
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
public void setEmail(String email){
    this.Email=email;
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
public String getEmail(){
    return this.Email;
}
public String getDate(){
    return this.Date;
}
}
