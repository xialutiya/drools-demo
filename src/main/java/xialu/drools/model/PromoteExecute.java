package xialu.drools.model;

import org.kie.api.KieBase;
import org.kie.api.runtime.StatelessKieSession;

import java.util.List;

import static xialu.drools.service.NewKieBase.ruleKieBase;

public class PromoteExecute {
    // 促销编号.
    private String promoteCode;
    // 业务kbase.
    private KieBase workbase;
    // 业务session.
    private StatelessKieSession workSession;
    // 规则内容.
    private String workContent;
    // 促销规则名称.
    private List<String> ruleName;

    private String promoteName;

    public String getPromoteCode() {
        return promoteCode;
    }

    public void setPromoteCode(String promoteCode) {
        this.promoteCode = promoteCode;
    }

    public KieBase getWorkbase() {
        if (this.workbase == null) {
            this.setWorkbase();
        }
        return workbase;
    }

    public void setWorkbase() {
        this.workbase = ruleKieBase(this.getWorkContent());
    }

    public StatelessKieSession getWorkSession() {
        if (this.workSession == null) {
            this.setWorkSession();
        }
        return workSession;
    }

    public void setWorkSession() {
        if (null != this.getWorkbase()) {
            this.workSession = this.getWorkbase().newStatelessKieSession();
        }
    }

    public String getWorkContent() {
        return workContent;
    }

    public void setWorkContent(String workContent) {
        this.workContent = workContent;
    }

    public List<String> getRuleName() {
        return ruleName;
    }

    public void setRuleName(List<String> ruleName) {
        this.ruleName = ruleName;
    }

    public String getPromoteName() {
        return promoteName;
    }

    public void setPromoteName(String promoteName) {
        this.promoteName = promoteName;
    }
}
