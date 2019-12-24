package xialu.drools.dao;

import org.apache.ibatis.annotations.Mapper;
import xialu.drools.model.PromoteExecute;
@Mapper
public interface PromoteExecuteDao {

    /**
     * 插入促销基础信息.
     *
     * @param promote
     * @return
     */
    int insertPromoteExecute(PromoteExecute promote);
}
