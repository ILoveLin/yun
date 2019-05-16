package com.company.yun.bean.function;

import java.util.List;

/**
 * Created by Lovelin on 2019/5/16
 * <p>
 * Describe:consumption
 */
public class PersonConsumptionBean {
    /**
     * consumption : [{"name":"高","value":"15.45"},{"name":"中","value":"22.50"},{"name":"低","value":"62.05"}]
     */
    private List<ConsumptionEntity> consumption;

    public void setConsumption(List<ConsumptionEntity> consumption) {
        this.consumption = consumption;
    }

    public List<ConsumptionEntity> getConsumption() {
        return consumption;
    }

    public class ConsumptionEntity {
        /**
         * name : 高
         * value : 15.45
         */
        private String name;
        private String value;

        public void setName(String name) {
            this.name = name;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public String getValue() {
            return value;
        }
    }
}
