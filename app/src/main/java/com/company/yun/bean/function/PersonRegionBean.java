package com.company.yun.bean.function;

import java.util.List;

/**
 * Created by Lovelin on 2019/5/16
 * <p>
 * Describe:region
 */
public class PersonRegionBean {
    /**
     * region : {"provinces":{"total":"7951","list":[{"name":"广东","value":"1000"},{"name":"山东","value":"663"},{"name":"河南","value":"577"},{"name":"江苏","value":"545"},{"name":"浙江","value":"464"},{"name":"河北","value":"397"},{"name":"四川","value":"391"},{"name":"北京","value":"352"},{"name":"湖南","value":"293"},{"name":"福建","value":"277"},{"name":"上海","value":"271"},{"name":"湖北","value":"261"},{"name":"安徽","value":"253"},{"name":"辽宁","value":"223"},{"name":"江西","value":"217"},{"name":"陕西","value":"198"},{"name":"山西","value":"187"},{"name":"广西","value":"182"},{"name":"重庆","value":"158"},{"name":"云南","value":"140"},{"name":"黑龙江","value":"137"},{"name":"吉林","value":"125"},{"name":"贵州","value":"105"},{"name":"天津","value":"102"},{"name":"甘肃","value":"102"},{"name":"内蒙古","value":"97"},{"name":"新疆","value":"96"},{"name":"海南","value":"63"},{"name":"宁夏","value":"32"},{"name":"青海","value":"20"},{"name":"香港","value":"10"},{"name":"西藏","value":"10"},{"name":"澳门","value":"2"},{"name":"台湾","value":"1"}]},"city":{"total":"8219","list":[{"name":"北京","value":"1000"},{"name":"上海","value":"769"},{"name":"广州","value":"732"},{"name":"郑州","value":"683"},{"name":"杭州","value":"672"},{"name":"深圳","value":"640"},{"name":"成都","value":"597"},{"name":"武汉","value":"449"},{"name":"重庆","value":"449"},{"name":"苏州","value":"399"},{"name":"长沙","value":"390"},{"name":"济南","value":"387"},{"name":"青岛","value":"370"},{"name":"西安","value":"354"},{"name":"南京","value":"328"}]}}
     */
    private RegionEntity region;

    public void setRegion(RegionEntity region) {
        this.region = region;
    }

    public RegionEntity getRegion() {
        return region;
    }

    public class RegionEntity {
        /**
         * provinces : {"total":"7951","list":[{"name":"广东","value":"1000"},{"name":"山东","value":"663"},{"name":"河南","value":"577"},{"name":"江苏","value":"545"},{"name":"浙江","value":"464"},{"name":"河北","value":"397"},{"name":"四川","value":"391"},{"name":"北京","value":"352"},{"name":"湖南","value":"293"},{"name":"福建","value":"277"},{"name":"上海","value":"271"},{"name":"湖北","value":"261"},{"name":"安徽","value":"253"},{"name":"辽宁","value":"223"},{"name":"江西","value":"217"},{"name":"陕西","value":"198"},{"name":"山西","value":"187"},{"name":"广西","value":"182"},{"name":"重庆","value":"158"},{"name":"云南","value":"140"},{"name":"黑龙江","value":"137"},{"name":"吉林","value":"125"},{"name":"贵州","value":"105"},{"name":"天津","value":"102"},{"name":"甘肃","value":"102"},{"name":"内蒙古","value":"97"},{"name":"新疆","value":"96"},{"name":"海南","value":"63"},{"name":"宁夏","value":"32"},{"name":"青海","value":"20"},{"name":"香港","value":"10"},{"name":"西藏","value":"10"},{"name":"澳门","value":"2"},{"name":"台湾","value":"1"}]}
         * city : {"total":"8219","list":[{"name":"北京","value":"1000"},{"name":"上海","value":"769"},{"name":"广州","value":"732"},{"name":"郑州","value":"683"},{"name":"杭州","value":"672"},{"name":"深圳","value":"640"},{"name":"成都","value":"597"},{"name":"武汉","value":"449"},{"name":"重庆","value":"449"},{"name":"苏州","value":"399"},{"name":"长沙","value":"390"},{"name":"济南","value":"387"},{"name":"青岛","value":"370"},{"name":"西安","value":"354"},{"name":"南京","value":"328"}]}
         */
        private ProvincesEntity provinces;
        private CityEntity city;

        public void setProvinces(ProvincesEntity provinces) {
            this.provinces = provinces;
        }

        public void setCity(CityEntity city) {
            this.city = city;
        }

        public ProvincesEntity getProvinces() {
            return provinces;
        }

        public CityEntity getCity() {
            return city;
        }

        public class ProvincesEntity {
            /**
             * total : 7951
             * list : [{"name":"广东","value":"1000"},{"name":"山东","value":"663"},{"name":"河南","value":"577"},{"name":"江苏","value":"545"},{"name":"浙江","value":"464"},{"name":"河北","value":"397"},{"name":"四川","value":"391"},{"name":"北京","value":"352"},{"name":"湖南","value":"293"},{"name":"福建","value":"277"},{"name":"上海","value":"271"},{"name":"湖北","value":"261"},{"name":"安徽","value":"253"},{"name":"辽宁","value":"223"},{"name":"江西","value":"217"},{"name":"陕西","value":"198"},{"name":"山西","value":"187"},{"name":"广西","value":"182"},{"name":"重庆","value":"158"},{"name":"云南","value":"140"},{"name":"黑龙江","value":"137"},{"name":"吉林","value":"125"},{"name":"贵州","value":"105"},{"name":"天津","value":"102"},{"name":"甘肃","value":"102"},{"name":"内蒙古","value":"97"},{"name":"新疆","value":"96"},{"name":"海南","value":"63"},{"name":"宁夏","value":"32"},{"name":"青海","value":"20"},{"name":"香港","value":"10"},{"name":"西藏","value":"10"},{"name":"澳门","value":"2"},{"name":"台湾","value":"1"}]
             */
            private String total;
            private List<ListEntity> list;

            public void setTotal(String total) {
                this.total = total;
            }

            public void setList(List<ListEntity> list) {
                this.list = list;
            }

            public String getTotal() {
                return total;
            }

            public List<ListEntity> getList() {
                return list;
            }

            public class ListEntity {
                /**
                 * name : 广东
                 * value : 1000
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

        public class CityEntity {
            /**
             * total : 8219
             * list : [{"name":"北京","value":"1000"},{"name":"上海","value":"769"},{"name":"广州","value":"732"},{"name":"郑州","value":"683"},{"name":"杭州","value":"672"},{"name":"深圳","value":"640"},{"name":"成都","value":"597"},{"name":"武汉","value":"449"},{"name":"重庆","value":"449"},{"name":"苏州","value":"399"},{"name":"长沙","value":"390"},{"name":"济南","value":"387"},{"name":"青岛","value":"370"},{"name":"西安","value":"354"},{"name":"南京","value":"328"}]
             */
            private String total;
            private List<ListEntity> list;

            public void setTotal(String total) {
                this.total = total;
            }

            public void setList(List<ListEntity> list) {
                this.list = list;
            }

            public String getTotal() {
                return total;
            }

            public List<ListEntity> getList() {
                return list;
            }

            public class ListEntity {
                /**
                 * name : 北京
                 * value : 1000
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
    }
}
