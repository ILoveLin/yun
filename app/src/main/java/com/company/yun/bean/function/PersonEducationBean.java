package com.company.yun.bean.function;

import java.util.List;

/**
 * Created by Lovelin on 2019/5/16
 * <p>
 * Describe:education
 */
public class PersonEducationBean {
    /**
     * education : [{"name":"初中","value":"34.70"},{"name":"高中","value":"28.56"},{"name":"本科","value":"12.17"},{"name":"小学","value":"11.11"},{"name":"未知","value":"9.02"},{"name":"本科以上","value":"4.44"}]
     */
    private List<EducationEntity> education;

    public void setEducation(List<EducationEntity> education) {
        this.education = education;
    }

    public List<EducationEntity> getEducation() {
        return education;
    }

    public class EducationEntity {
        /**
         * name : 初中
         * value : 34.70
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
