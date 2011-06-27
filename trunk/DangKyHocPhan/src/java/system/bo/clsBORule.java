package system.bo;

import system.access.mapper.clsMapperRule;
import system.dto.clsRule;

public class clsBORule {

    public clsRule getRuleInfo() throws Exception {
        clsRule rule = new clsRule();
        clsMapperRule mpr = new clsMapperRule();
        rule = mpr.getRuleInfo();
        return rule;
    }

    public void updateRule(clsRule rule) throws Exception {
        clsMapperRule mpr = new clsMapperRule();
        mpr.RuleUpdate(rule);
    }
}
