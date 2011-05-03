
package system.dto;


public class clsSubject {
private String SubName;
private String SubCode;
private int NumTC;
public clsSubject(String subname, String subcode, int numtc){
    this.SubName=subname;
    this.SubCode=subcode;
    this.NumTC=numtc;
    }
public void setSubName(String subname){
    this.SubName=subname;
}
public void setSubCode(String subcode){
    this.SubCode=subcode;
}
public void setNumTC(int numtc){
    this.NumTC=numtc;
}
public String getSubName(){
  return this.SubName;
}
 public String getSubCode(){
     return this.SubCode;
 }
 public int getNumTC(){
     return this.NumTC;
 }
}
