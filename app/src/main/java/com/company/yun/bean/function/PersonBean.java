package com.company.yun.bean.function;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lovelin on 2019/5/16
 * <p>
 * Describe:
 */
public class PersonBean {

    /**
     * data : {"education":[{"name":"高中","value":"32.13"},{"name":"初中","value":"26.16"},{"name":"本科","value":"15.91"},{"name":"小学","value":"12.00"},{"name":"未知","value":"9.36"},{"name":"本科以上","value":"4.44"}],"social":{"str_age":{"noe":"3","four":"28","tow":"9","three":"56","five":"4"},"period":"201804|201903","str_sex":{"F":"46","M":"54"},"word":"test"},"consumption":[{"name":"高","value":"16.05"},{"name":"中","value":"28.50"},{"name":"低","value":"55.45"}],"industry":{"city":{"x":["效率办公","生活实用","丽人母婴","图像","运动健康","生活服务","聊天社交","影音","新闻阅读","汽车","旅游","教育","购物","金融理财"],"y":["一线城市","二线城市","三线城市"],"z":[["128","240","199","170","216","257","210","251","158","247","156","233","215","155"],["230","286","251","270","324","353","384","331","247","340","313","272","307","252"],["854","1146","866","1000","1080","1071","1241","1006","988","1031","979","972","1025","970"]]},"sex":{"x":["效率办公","生活实用","丽人母婴","图像","运动健康","生活服务","聊天社交","影音","新闻阅读","汽车","旅游","教育","购物","金融理财"],"y":["男","女"],"z":[["418","687","389","420","594","610","546","422","553","597","420","388","492","562"],["436","459","477","580","486","461","695","584","435","434","559","584","533","408"]]},"age":{"x":["效率办公","生活实用","丽人母婴","图像","运动健康","生活服务","聊天社交","影音","新闻阅读","汽车","旅游","教育","购物","金融理财"],"y":["0-17","18-24","25-34","35-44","45+"],"z":[["34","34","43","10","21","53","86","50","9","30","48","58","71","9"],["76","114","112","110","140","139","173","110","118","134","107","97","153","87"],["384","584","398","490","496","546","620","513","523","463","460","524","481","465"],["222","343","216","330","378","267","335","261","326","278","274","272","256","300"],["138","71","97","60","45","66","27","72","12","126","90","21","64","109"]]}},"keyword":"test","region":{"provinces":{"total":"8291","list":[{"name":"广东","value":"1000"},{"name":"江苏","value":"630"},{"name":"北京","value":"562"},{"name":"浙江","value":"517"},{"name":"山东","value":"495"},{"name":"河南","value":"484"},{"name":"上海","value":"455"},{"name":"河北","value":"398"},{"name":"四川","value":"324"},{"name":"福建","value":"301"},{"name":"辽宁","value":"281"},{"name":"湖北","value":"267"},{"name":"安徽","value":"256"},{"name":"陕西","value":"254"},{"name":"山西","value":"214"},{"name":"湖南","value":"210"},{"name":"江西","value":"198"},{"name":"黑龙江","value":"183"},{"name":"天津","value":"181"},{"name":"重庆","value":"146"},{"name":"甘肃","value":"144"},{"name":"吉林","value":"141"},{"name":"广西","value":"140"},{"name":"内蒙古","value":"124"},{"name":"云南","value":"106"},{"name":"贵州","value":"97"},{"name":"新疆","value":"63"},{"name":"海南","value":"33"},{"name":"宁夏","value":"30"},{"name":"青海","value":"21"},{"name":"香港","value":"20"},{"name":"台湾","value":"7"},{"name":"西藏","value":"6"},{"name":"澳门","value":"3"}]},"city":{"total":"6267","list":[{"name":"北京","value":"1000"},{"name":"上海","value":"810"},{"name":"广州","value":"542"},{"name":"深圳","value":"475"},{"name":"杭州","value":"441"},{"name":"郑州","value":"398"},{"name":"成都","value":"390"},{"name":"天津","value":"322"},{"name":"苏州","value":"321"},{"name":"武汉","value":"313"},{"name":"西安","value":"284"},{"name":"重庆","value":"261"},{"name":"南京","value":"256"},{"name":"青岛","value":"235"},{"name":"福州","value":"219"}]}}}
     * status : 0
     * info :
     */
    private DataEntity data;
    private String status;
    private String info;

    public void getAllData(String response) {
        try {
            JSONObject object = new JSONObject(response);
            setStatus(object.getString("status"));
            setInfo(object.getString("info"));
            DataEntity dataEntity = new DataEntity();
            JSONObject data = object.getJSONObject("data");
            dataEntity.getData(data);
            setData(dataEntity);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }



    public void setData(DataEntity data) {
        this.data = data;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public DataEntity getData() {
        return data;
    }

    public String getStatus() {
        return status;
    }

    public String getInfo() {
        return info;
    }

    public class DataEntity {
        /**
         * education : [{"name":"高中","value":"32.13"},{"name":"初中","value":"26.16"},{"name":"本科","value":"15.91"},{"name":"小学","value":"12.00"},{"name":"未知","value":"9.36"},{"name":"本科以上","value":"4.44"}]
         * social : {"str_age":{"noe":"3","four":"28","tow":"9","three":"56","five":"4"},"period":"201804|201903","str_sex":{"F":"46","M":"54"},"word":"test"}
         * consumption : [{"name":"高","value":"16.05"},{"name":"中","value":"28.50"},{"name":"低","value":"55.45"}]
         * industry : {"city":{"x":["效率办公","生活实用","丽人母婴","图像","运动健康","生活服务","聊天社交","影音","新闻阅读","汽车","旅游","教育","购物","金融理财"],"y":["一线城市","二线城市","三线城市"],"z":[["128","240","199","170","216","257","210","251","158","247","156","233","215","155"],["230","286","251","270","324","353","384","331","247","340","313","272","307","252"],["854","1146","866","1000","1080","1071","1241","1006","988","1031","979","972","1025","970"]]},"sex":{"x":["效率办公","生活实用","丽人母婴","图像","运动健康","生活服务","聊天社交","影音","新闻阅读","汽车","旅游","教育","购物","金融理财"],"y":["男","女"],"z":[["418","687","389","420","594","610","546","422","553","597","420","388","492","562"],["436","459","477","580","486","461","695","584","435","434","559","584","533","408"]]},"age":{"x":["效率办公","生活实用","丽人母婴","图像","运动健康","生活服务","聊天社交","影音","新闻阅读","汽车","旅游","教育","购物","金融理财"],"y":["0-17","18-24","25-34","35-44","45+"],"z":[["34","34","43","10","21","53","86","50","9","30","48","58","71","9"],["76","114","112","110","140","139","173","110","118","134","107","97","153","87"],["384","584","398","490","496","546","620","513","523","463","460","524","481","465"],["222","343","216","330","378","267","335","261","326","278","274","272","256","300"],["138","71","97","60","45","66","27","72","12","126","90","21","64","109"]]}}
         * keyword : test
         * region : {"provinces":{"total":"8291","list":[{"name":"广东","value":"1000"},{"name":"江苏","value":"630"},{"name":"北京","value":"562"},{"name":"浙江","value":"517"},{"name":"山东","value":"495"},{"name":"河南","value":"484"},{"name":"上海","value":"455"},{"name":"河北","value":"398"},{"name":"四川","value":"324"},{"name":"福建","value":"301"},{"name":"辽宁","value":"281"},{"name":"湖北","value":"267"},{"name":"安徽","value":"256"},{"name":"陕西","value":"254"},{"name":"山西","value":"214"},{"name":"湖南","value":"210"},{"name":"江西","value":"198"},{"name":"黑龙江","value":"183"},{"name":"天津","value":"181"},{"name":"重庆","value":"146"},{"name":"甘肃","value":"144"},{"name":"吉林","value":"141"},{"name":"广西","value":"140"},{"name":"内蒙古","value":"124"},{"name":"云南","value":"106"},{"name":"贵州","value":"97"},{"name":"新疆","value":"63"},{"name":"海南","value":"33"},{"name":"宁夏","value":"30"},{"name":"青海","value":"21"},{"name":"香港","value":"20"},{"name":"台湾","value":"7"},{"name":"西藏","value":"6"},{"name":"澳门","value":"3"}]},"city":{"total":"6267","list":[{"name":"北京","value":"1000"},{"name":"上海","value":"810"},{"name":"广州","value":"542"},{"name":"深圳","value":"475"},{"name":"杭州","value":"441"},{"name":"郑州","value":"398"},{"name":"成都","value":"390"},{"name":"天津","value":"322"},{"name":"苏州","value":"321"},{"name":"武汉","value":"313"},{"name":"西安","value":"284"},{"name":"重庆","value":"261"},{"name":"南京","value":"256"},{"name":"青岛","value":"235"},{"name":"福州","value":"219"}]}}
         */
        private List<EducationEntity> education;
        private SocialEntity social;
        private List<ConsumptionEntity> consumption;
        private IndustryEntity industry;
        private String keyword;
        private RegionEntity region;   //todo

        @Override
        public String toString() {
            return "DataEntity{" +
                    "education=" + education +
                    ", social=" + social +
                    ", consumption=" + consumption +
                    ", industry=" + industry +
                    ", keyword='" + keyword + '\'' +
                    ", region=" + region +
                    '}';
        }

        public void getData(JSONObject data) {

            try {
                JSONArray education = data.getJSONArray("education");
                ArrayList<EducationEntity> educationEntities = new ArrayList<>();
                for (int i = 0; i < education.length(); i++) {
                    EducationEntity educationEntity = new EducationEntity();
                    educationEntity.getData((JSONObject) education.get(i));
                    educationEntities.add(educationEntity);
                    setEducation(educationEntities);
                }

                JSONObject social = data.getJSONObject("social");
                SocialEntity socialEntity = new SocialEntity();
                socialEntity.getData(social);
                setSocial(socialEntity);

                JSONArray consumption = data.getJSONArray("consumption");
                ArrayList<ConsumptionEntity> consumptionEntities = new ArrayList<>();
                for (int i = 0; i < consumption.length(); i++) {
                    ConsumptionEntity consumptionEntity = new ConsumptionEntity();
                    consumptionEntity.getData((JSONObject) consumption.get(i));
                    consumptionEntities.add(consumptionEntity);
                    setConsumption(consumptionEntities);
                }
                JSONObject industry = data.getJSONObject("industry");
                IndustryEntity industryEntity = new IndustryEntity();
                industryEntity.getData(industry);
                setIndustry(industryEntity);

                setKeyword(data.getString("keyword"));

                JSONObject region = data.getJSONObject("region");
                RegionEntity regionEntity = new RegionEntity();
                regionEntity.getData(region);
                setRegion(regionEntity);

            } catch (JSONException e) {
                e.printStackTrace();
            }


        }


        public void setEducation(List<EducationEntity> education) {
            this.education = education;
        }

        public void setSocial(SocialEntity social) {
            this.social = social;
        }

        public void setConsumption(List<ConsumptionEntity> consumption) {
            this.consumption = consumption;
        }

        public void setIndustry(IndustryEntity industry) {
            this.industry = industry;
        }

        public void setKeyword(String keyword) {
            this.keyword = keyword;
        }

        public void setRegion(RegionEntity region) {
            this.region = region;
        }

        public List<EducationEntity> getEducation() {
            return education;
        }

        public SocialEntity getSocial() {
            return social;
        }

        public List<ConsumptionEntity> getConsumption() {
            return consumption;
        }

        public IndustryEntity getIndustry() {
            return industry;
        }

        public String getKeyword() {
            return keyword;
        }

        public RegionEntity getRegion() {
            return region;
        }


        public class EducationEntity {
            /**
             * name : 高中
             * value : 32.13
             */
            private String name;
            private String value;

            public void getData(JSONObject object) {
                try {
                    setName(object.getString("name"));
                    setValue(object.getString("value"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }


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

        public class SocialEntity {
            /**
             * str_age : {"noe":"3","four":"28","tow":"9","three":"56","five":"4"}
             * period : 201804|201903
             * str_sex : {"F":"46","M":"54"}
             * word : test
             */
            private String period;
            private String word;
            private Str_ageEntity str_age;
            private Str_sexEntity str_sex;

            public void getData(JSONObject object) {
                try {
                    setPeriod(object.getString("period"));
                    setWord(object.getString("word"));

                    Str_ageEntity str_ageEntity = new Str_ageEntity();
                    str_ageEntity.getData(object.getJSONObject("str_age"));
                    setStr_age(str_ageEntity);

                    Str_sexEntity str_sexEntity = new Str_sexEntity();
                    str_sexEntity.getData(object.getJSONObject("str_sex"));
                    setStr_sex(str_sexEntity);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }


            public void setStr_age(Str_ageEntity str_age) {
                this.str_age = str_age;
            }

            public void setPeriod(String period) {
                this.period = period;
            }

            public void setStr_sex(Str_sexEntity str_sex) {
                this.str_sex = str_sex;
            }

            public void setWord(String word) {
                this.word = word;
            }

            public Str_ageEntity getStr_age() {
                return str_age;
            }

            public String getPeriod() {
                return period;
            }

            public Str_sexEntity getStr_sex() {
                return str_sex;
            }

            public String getWord() {
                return word;
            }

            public class Str_ageEntity {
                /**
                 * noe : 3
                 * four : 28
                 * tow : 9
                 * three : 56
                 * five : 4
                 */
                private String noe;
                private String four;
                private String tow;
                private String three;
                private String five;


                public void getData(JSONObject object) {
                    try {
                        setNoe(object.getString("1"));
                        setTow(object.getString("2"));
                        setThree(object.getString("3"));
                        setFour(object.getString("4"));
                        setFive(object.getString("5"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }


                public void setNoe(String noe) {
                    this.noe = noe;
                }

                public void setFour(String four) {
                    this.four = four;
                }

                public void setTow(String tow) {
                    this.tow = tow;
                }

                public void setThree(String three) {
                    this.three = three;
                }

                public void setFive(String five) {
                    this.five = five;
                }

                public String getNoe() {
                    return noe;
                }

                public String getFour() {
                    return four;
                }

                public String getTow() {
                    return tow;
                }

                public String getThree() {
                    return three;
                }

                public String getFive() {
                    return five;
                }
            }

            public class Str_sexEntity {
                /**
                 * F : 46
                 * M : 54
                 */
                private String F;
                private String M;

                public void getData(JSONObject object) {
                    try {
                        setF(object.getString("F"));
                        setM(object.getString("M"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                public void setF(String F) {
                    this.F = F;
                }

                public void setM(String M) {
                    this.M = M;
                }

                public String getF() {
                    return F;
                }

                public String getM() {
                    return M;
                }
            }
        }

        public class ConsumptionEntity {
            /**
             * name : 高
             * value : 16.05
             */
            private String name;
            private String value;

            public void getData(JSONObject object) {
                try {
                    setName(object.getString("name"));
                    setValue(object.getString("value"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

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

        public class IndustryEntity {
            /**
             * city : {"x":["效率办公","生活实用","丽人母婴","图像","运动健康","生活服务","聊天社交","影音","新闻阅读","汽车","旅游","教育","购物","金融理财"],"y":["一线城市","二线城市","三线城市"],"z":[["128","240","199","170","216","257","210","251","158","247","156","233","215","155"],["230","286","251","270","324","353","384","331","247","340","313","272","307","252"],["854","1146","866","1000","1080","1071","1241","1006","988","1031","979","972","1025","970"]]}
             * sex : {"x":["效率办公","生活实用","丽人母婴","图像","运动健康","生活服务","聊天社交","影音","新闻阅读","汽车","旅游","教育","购物","金融理财"],"y":["男","女"],"z":[["418","687","389","420","594","610","546","422","553","597","420","388","492","562"],["436","459","477","580","486","461","695","584","435","434","559","584","533","408"]]}
             * age : {"x":["效率办公","生活实用","丽人母婴","图像","运动健康","生活服务","聊天社交","影音","新闻阅读","汽车","旅游","教育","购物","金融理财"],"y":["0-17","18-24","25-34","35-44","45+"],"z":[["34","34","43","10","21","53","86","50","9","30","48","58","71","9"],["76","114","112","110","140","139","173","110","118","134","107","97","153","87"],["384","584","398","490","496","546","620","513","523","463","460","524","481","465"],["222","343","216","330","378","267","335","261","326","278","274","272","256","300"],["138","71","97","60","45","66","27","72","12","126","90","21","64","109"]]}
             */
            private CityEntity city;
            private SexEntity sex;
            private AgeEntity age;

            public void getData(JSONObject object) {
                try {
                    CityEntity cityEntity = new CityEntity();
                    cityEntity.getData(object.getJSONObject("city"));
                    setCity(cityEntity);

                    SexEntity sexEntity = new SexEntity();
                    sexEntity.getData(object.getJSONObject("sex"));
                    setSex(sexEntity);

                    AgeEntity ageEntity = new AgeEntity();
                    ageEntity.getData(object.getJSONObject("age"));
                    setAge(ageEntity);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            public void setCity(CityEntity city) {
                this.city = city;
            }

            public void setSex(SexEntity sex) {
                this.sex = sex;
            }

            public void setAge(AgeEntity age) {
                this.age = age;
            }

            public CityEntity getCity() {
                return city;
            }

            public SexEntity getSex() {
                return sex;
            }

            public AgeEntity getAge() {
                return age;
            }

            public class CityEntity {
                /**
                 * x : ["效率办公","生活实用","丽人母婴","图像","运动健康","生活服务","聊天社交","影音","新闻阅读","汽车","旅游","教育","购物","金融理财"]
                 * y : ["一线城市","二线城市","三线城市"]
                 * z : [["128","240","199","170","216","257","210","251","158","247","156","233","215","155"],["230","286","251","270","324","353","384","331","247","340","313","272","307","252"],["854","1146","866","1000","1080","1071","1241","1006","988","1031","979","972","1025","970"]]
                 */
                private List<String> x;
                private List<String> y;
                private List<List<String>> z;


                public void getData(JSONObject object) {
                    try {
                        ArrayList<String> xList = new ArrayList<>();
                        ArrayList<String> yList = new ArrayList<>();

                        JSONArray x = object.getJSONArray("x");
                        JSONArray y = object.getJSONArray("y");
                        for (int i = 0; i < x.length(); i++) {
                            xList.add((String) x.get(i));
                            setX(xList);
                        }
                        for (int i = 0; i < y.length(); i++) {
                            yList.add((String) y.get(i));
                            setY(yList);
                        }

//                        private List<List<String>> z;

                        ArrayList<List<String>> lists = new ArrayList<>();
                        JSONArray z = object.getJSONArray("z");

                        for (int i = 0; i < z.length(); i++) {

                            ArrayList<String> zList = new ArrayList<>();
                            //取出第一个array
                            JSONArray arrayZ = (JSONArray) z.get(i);
                            for (int zz = 0; zz < arrayZ.length(); zz++) {
                                zList.add((String) arrayZ.get(zz));
                            }
                            lists.add(zList);
                            setZ(lists);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }


                }

                public void setX(List<String> x) {
                    this.x = x;
                }

                public void setY(List<String> y) {
                    this.y = y;
                }

                public void setZ(List<List<String>> z) {
                    this.z = z;
                }

                public List<String> getX() {
                    return x;
                }

                public List<String> getY() {
                    return y;
                }

                public List<List<String>> getZ() {
                    return z;
                }
            }

            public class SexEntity {
                /**
                 * x : ["效率办公","生活实用","丽人母婴","图像","运动健康","生活服务","聊天社交","影音","新闻阅读","汽车","旅游","教育","购物","金融理财"]
                 * y : ["男","女"]
                 * z : [["418","687","389","420","594","610","546","422","553","597","420","388","492","562"],["436","459","477","580","486","461","695","584","435","434","559","584","533","408"]]
                 */
                private List<String> x;
                private List<String> y;
                private List<List<String>> z;


                public void getData(JSONObject object) {
                    try {
                        ArrayList<String> xList = new ArrayList<>();
                        ArrayList<String> yList = new ArrayList<>();

                        JSONArray x = object.getJSONArray("x");
                        JSONArray y = object.getJSONArray("y");
                        for (int i = 0; i < x.length(); i++) {
                            xList.add((String) x.get(i));
                            setX(xList);
                        }
                        for (int i = 0; i < y.length(); i++) {
                            yList.add((String) y.get(i));
                            setY(yList);
                        }

//                        private List<List<String>> z;

                        ArrayList<List<String>> lists = new ArrayList<>();
                        JSONArray z = object.getJSONArray("z");

                        for (int i = 0; i < z.length(); i++) {

                            ArrayList<String> zList = new ArrayList<>();

                            //取出第一个array
                            JSONArray arrayZ = (JSONArray) z.get(i);
                            for (int zz = 0; zz < arrayZ.length(); zz++) {
                                zList.add((String) arrayZ.get(zz));
                            }
                            lists.add(zList);
                            setZ(lists);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }


                }

                public void setX(List<String> x) {
                    this.x = x;
                }

                public void setY(List<String> y) {
                    this.y = y;
                }

                public void setZ(List<List<String>> z) {
                    this.z = z;
                }

                public List<String> getX() {
                    return x;
                }

                public List<String> getY() {
                    return y;
                }

                public List<List<String>> getZ() {
                    return z;
                }
            }

            public class AgeEntity {
                /**
                 * x : ["效率办公","生活实用","丽人母婴","图像","运动健康","生活服务","聊天社交","影音","新闻阅读","汽车","旅游","教育","购物","金融理财"]
                 * y : ["0-17","18-24","25-34","35-44","45+"]
                 * z : [["34","34","43","10","21","53","86","50","9","30","48","58","71","9"],["76","114","112","110","140","139","173","110","118","134","107","97","153","87"],["384","584","398","490","496","546","620","513","523","463","460","524","481","465"],["222","343","216","330","378","267","335","261","326","278","274","272","256","300"],["138","71","97","60","45","66","27","72","12","126","90","21","64","109"]]
                 */
                private List<String> x;
                private List<String> y;
                private List<List<String>> z;

                public void getData(JSONObject object) {
                    try {
                        ArrayList<String> xList = new ArrayList<>();
                        ArrayList<String> yList = new ArrayList<>();

                        JSONArray x = object.getJSONArray("x");
                        JSONArray y = object.getJSONArray("y");
                        for (int i = 0; i < x.length(); i++) {
                            xList.add((String) x.get(i));
                            setX(xList);
                        }
                        for (int i = 0; i < y.length(); i++) {
                            yList.add((String) y.get(i));
                            setY(yList);
                        }

//                        private List<List<String>> z;

                        ArrayList<List<String>> lists = new ArrayList<>();
                        JSONArray z = object.getJSONArray("z");

                        for (int i = 0; i < z.length(); i++) {

                            ArrayList<String> zList = new ArrayList<>();

                            //取出第一个array
                            JSONArray arrayZ = (JSONArray) z.get(i);
                            for (int zz = 0; zz < arrayZ.length(); zz++) {
                                zList.add((String) arrayZ.get(zz));
                            }
                            lists.add(zList);
                            setZ(lists);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }


                }

                public void setX(List<String> x) {
                    this.x = x;
                }

                public void setY(List<String> y) {
                    this.y = y;
                }

                public void setZ(List<List<String>> z) {
                    this.z = z;
                }

                public List<String> getX() {
                    return x;
                }

                public List<String> getY() {
                    return y;
                }

                public List<List<String>> getZ() {
                    return z;
                }
            }
        }

        public class RegionEntity {
            /**
             * provinces : {"total":"8291","list":[{"name":"广东","value":"1000"},{"name":"江苏","value":"630"},{"name":"北京","value":"562"},{"name":"浙江","value":"517"},{"name":"山东","value":"495"},{"name":"河南","value":"484"},{"name":"上海","value":"455"},{"name":"河北","value":"398"},{"name":"四川","value":"324"},{"name":"福建","value":"301"},{"name":"辽宁","value":"281"},{"name":"湖北","value":"267"},{"name":"安徽","value":"256"},{"name":"陕西","value":"254"},{"name":"山西","value":"214"},{"name":"湖南","value":"210"},{"name":"江西","value":"198"},{"name":"黑龙江","value":"183"},{"name":"天津","value":"181"},{"name":"重庆","value":"146"},{"name":"甘肃","value":"144"},{"name":"吉林","value":"141"},{"name":"广西","value":"140"},{"name":"内蒙古","value":"124"},{"name":"云南","value":"106"},{"name":"贵州","value":"97"},{"name":"新疆","value":"63"},{"name":"海南","value":"33"},{"name":"宁夏","value":"30"},{"name":"青海","value":"21"},{"name":"香港","value":"20"},{"name":"台湾","value":"7"},{"name":"西藏","value":"6"},{"name":"澳门","value":"3"}]}
             * city : {"total":"6267","list":[{"name":"北京","value":"1000"},{"name":"上海","value":"810"},{"name":"广州","value":"542"},{"name":"深圳","value":"475"},{"name":"杭州","value":"441"},{"name":"郑州","value":"398"},{"name":"成都","value":"390"},{"name":"天津","value":"322"},{"name":"苏州","value":"321"},{"name":"武汉","value":"313"},{"name":"西安","value":"284"},{"name":"重庆","value":"261"},{"name":"南京","value":"256"},{"name":"青岛","value":"235"},{"name":"福州","value":"219"}]}
             */
            private ProvincesEntity provinces;
            private CityEntity city;


            public void getData(JSONObject object) {
                try {
                    ProvincesEntity provincesEntity = new ProvincesEntity();
                    provincesEntity.getData(object.getJSONObject("provinces"));
                    setProvinces(provincesEntity);
                    CityEntity cityEntity = new CityEntity();
                    cityEntity.getData(object.getJSONObject("city"));
                    setCity(cityEntity);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }


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
                 * total : 8291
                 * list : [{"name":"广东","value":"1000"},{"name":"江苏","value":"630"},{"name":"北京","value":"562"},{"name":"浙江","value":"517"},{"name":"山东","value":"495"},{"name":"河南","value":"484"},{"name":"上海","value":"455"},{"name":"河北","value":"398"},{"name":"四川","value":"324"},{"name":"福建","value":"301"},{"name":"辽宁","value":"281"},{"name":"湖北","value":"267"},{"name":"安徽","value":"256"},{"name":"陕西","value":"254"},{"name":"山西","value":"214"},{"name":"湖南","value":"210"},{"name":"江西","value":"198"},{"name":"黑龙江","value":"183"},{"name":"天津","value":"181"},{"name":"重庆","value":"146"},{"name":"甘肃","value":"144"},{"name":"吉林","value":"141"},{"name":"广西","value":"140"},{"name":"内蒙古","value":"124"},{"name":"云南","value":"106"},{"name":"贵州","value":"97"},{"name":"新疆","value":"63"},{"name":"海南","value":"33"},{"name":"宁夏","value":"30"},{"name":"青海","value":"21"},{"name":"香港","value":"20"},{"name":"台湾","value":"7"},{"name":"西藏","value":"6"},{"name":"澳门","value":"3"}]
                 */
                private String total;
                private List<ListEntity> list;

                public void getData(JSONObject object) {
                    try {
                        setTotal(object.getString("total"));

                        JSONArray list = object.getJSONArray("list");
                        ArrayList<ListEntity> listEntities = new ArrayList<>();
                        for (int i = 0; i < list.length(); i++) {
                            ListEntity listEntity = new ListEntity();
                            listEntity.getData((JSONObject) list.get(i));
                            listEntities.add(listEntity);
                            setList(listEntities);
                        }


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }


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


                    public void getData(JSONObject object) {

                        try {
                            setName(object.getString("name"));
                            setValue(object.getString("value"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }

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
                 * total : 6267
                 * list : [{"name":"北京","value":"1000"},{"name":"上海","value":"810"},{"name":"广州","value":"542"},{"name":"深圳","value":"475"},{"name":"杭州","value":"441"},{"name":"郑州","value":"398"},{"name":"成都","value":"390"},{"name":"天津","value":"322"},{"name":"苏州","value":"321"},{"name":"武汉","value":"313"},{"name":"西安","value":"284"},{"name":"重庆","value":"261"},{"name":"南京","value":"256"},{"name":"青岛","value":"235"},{"name":"福州","value":"219"}]
                 */
                private String total;
                private List<ListEntity> list;

                public void getData(JSONObject object) {
                    try {
                        setTotal(object.getString("total"));

                        JSONArray list = object.getJSONArray("list");
                        ArrayList<ListEntity> listEntities = new ArrayList<>();
                        for (int i = 0; i < list.length(); i++) {
                            ListEntity listEntity = new ListEntity();
                            listEntity.getData((JSONObject) list.get(i));
                            listEntities.add(listEntity);
                            setList(listEntities);
                        }


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }


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

                    public void getData(JSONObject object) {

                        try {
                            setName(object.getString("name"));
                            setValue(object.getString("value"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }

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
}
