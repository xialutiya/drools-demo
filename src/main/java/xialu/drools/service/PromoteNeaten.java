package xialu.drools.service;

import org.springframework.stereotype.Service;
import xialu.drools.model.PromoteExecute;

@Service
public class PromoteNeaten {

    /**
     * 初始化指定的规则.
     *
     * @param rule
     * @return
     */
    public PromoteExecute editRule(String rule) {

        PromoteExecute promoteExecute = new PromoteExecute();
        promoteExecute.setWorkContent(rule);
        // 规则库初始化.
        promoteExecute.getWorkSession();
        return promoteExecute;
    }
}
