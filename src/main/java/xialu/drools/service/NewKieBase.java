package xialu.drools.service;

import org.kie.api.KieBase;
import org.kie.api.io.ResourceType;
import org.kie.internal.utils.KieHelper;

public class NewKieBase {

    /**
     * 将业务规则写到规则库中.
     *
     * @param rule
     * @return
     */
    public static KieBase ruleKieBase(String rule) {
        KieHelper helper = new KieHelper();
        try {
            helper.addContent(rule, ResourceType.DRL);
            return helper.build();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("规则初始化失败.");
        }
    }
}
