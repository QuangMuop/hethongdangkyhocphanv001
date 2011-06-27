package system.access.mapper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import system.dto.clsRule;

public class clsMapperRule extends clsMapperDb {

    public clsMapperRule() throws Exception {
        super();
    }

    private void InitRuleDTOFromRs(clsRule rule, ResultSet rs) throws Exception {
        if ((rs != null) && (rule != null)) {
            rule.setNo();
            rule.setMaxTC(Integer.parseInt(rs.getString("MaxTC")));
            rule.setMinTC(Integer.parseInt(rs.getString("MinTC")));
            rule.setMaxStudentAge(Integer.parseInt(rs.getString("MaxStudentAge")));
            rule.setMinStudentAge(Integer.parseInt(rs.getString("MinStudentAge")));
            rule.setMaxOfStudent(Integer.parseInt(rs.getString("MaxNumOfStudent")));
            rule.setMinOfStudent(Integer.parseInt(rs.getString("MinNumOfStudent")));
            rule.setMarkPass(Float.parseFloat(rs.getString("MarkPass")));
            rule.setMaxLecturerge(Integer.parseInt(rs.getString("MaxLecturerAge")));
            rule.setMinLecturerge(Integer.parseInt(rs.getString("MinLecturerAge")));
        }
    }

    public clsRule getRuleInfo() throws Exception {
        clsRule rule = new clsRule();
        try {
            StringBuffer sql = new StringBuffer();
            sql.append("Select * from dangkyhocphan.rule where STT=1");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            ResultSet rs = stmt.executeQuery();
            if ((rs != null) && rs.next()) {
                InitRuleDTOFromRs(rule, rs);
            }
        } catch (Exception ex) {
            throw ex;
        }
        return rule;
    }

    public void RuleAddColumn(String columnname) throws Exception {
        try {
            StringBuffer sql = new StringBuffer();
            sql.append("ALTER TABLE baocao ADD ").append(columnname).append(" int");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            stmt.execute();
            stmt.close();
        } catch (Exception e) {
            throw e;
        }
    }

    public void RuleDelColumn(String columnname) throws Exception {
        try {
            StringBuffer sql = new StringBuffer();
            sql.append("ALTER TABLE dangkyhocphan.rule DROP ").append(columnname).append("");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            stmt.execute();
            stmt.close();
        } catch (Exception e) {
            throw e;
        }
    }

    public void RuleUpdate(clsRule rule) throws Exception {
        try {
            StringBuffer sql = new StringBuffer();
            sql.append("Update dangkyhocphan.rule set MaxTC=");
            sql.append(rule.getMaxTC()).append(", MinTC=");
            sql.append(rule.getMinTC()).append(", MaxStudentAge=");
            sql.append(rule.getMaxStudentAge()).append(", MinStudentAge=");
            sql.append(rule.getMinStudentAge()).append(", MaxNumOfStudent=");
            sql.append(rule.getMaxOfStudent()).append(", MinNumOfStudent=");
            sql.append(rule.getMinOfStudent()).append(", MarkPass=");
            sql.append(rule.getMarkPass()).append(", MaxLecturerAge=");
            sql.append(rule.getMaxLecturerAge()).append(", MinLecturerAge=");
            sql.append(rule.getMinLecturerAge()).append(" where STT=1");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            boolean execute = stmt.execute();
        } catch (Exception ex) {
            throw ex;
        }
    }
}
