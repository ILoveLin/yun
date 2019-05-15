package com.company.yun.bean.account;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lovelin on 2019/5/15
 * <p>
 * Describe:
 */
public class AccountBean {
    /**
     * data : {"total_data":{"shows":"24749396193","consume":"663348233.59","user":"3839","click":"738466198"},"chams_users":[{"chams_id":"1","shows":"10631045","consume":"910740.20","cham_account":"易哲网络","id":"1","click":"652097","account":"bj-易哲网络05"},{"chams_id":"1","shows":"6731338","consume":"340355.78","cham_account":"易哲网络","id":"2","click":"505758","account":"bj易哲网络05"},{"chams_id":"1","shows":"8433523","consume":"670156.93","cham_account":"易哲网络","id":"3","click":"557027","account":"bj-易哲网络07"},{"chams_id":"1","shows":"22738455","consume":"1457561.92","cham_account":"易哲网络","id":"4","click":"1898354","account":"bj-易哲网络08"},{"chams_id":"1","shows":"48215164","consume":"1654744.01","cham_account":"易哲网络","id":"5","click":"2698738","account":"bj易哲网络08"},{"chams_id":"1","shows":"16851803","consume":"843702.17","cham_account":"易哲网络","id":"6","click":"1016861","account":"bj易哲网络10"},{"chams_id":"1","shows":"21246824","consume":"1576474.08","cham_account":"易哲网络","id":"7","click":"2147581","account":"bj-易哲网络10"},{"chams_id":"1","shows":"23276613","consume":"1193388.65","cham_account":"易哲网络","id":"8","click":"1649655","account":"bj易哲网络09"},{"chams_id":"1","shows":"14218136","consume":"1149372.46","cham_account":"易哲网络","id":"9","click":"828950","account":"bj-易哲网络15"},{"chams_id":"1","shows":"5617455","consume":"455072.17","cham_account":"易哲网络","id":"10","click":"322014","account":"bj-易哲网络16"},{"chams_id":"1","shows":"6765973","consume":"1464110.22","cham_account":"易哲网络","id":"11","click":"652855","account":"广州易哲网络"},{"chams_id":"1","shows":"8110337","consume":"641257.82","cham_account":"易哲网络","id":"12","click":"762738","account":"广州易哲网络01"},{"chams_id":"1","shows":"29482511","consume":"1484573.87","cham_account":"易哲网络","id":"13","click":"1939828","account":"广州易哲网络02"},{"chams_id":"1","shows":"5886028","consume":"519634.42","cham_account":"易哲网络","id":"14","click":"490033","account":"易哲网络02"},{"chams_id":"1","shows":"10675118","consume":"668372.64","cham_account":"易哲网络","id":"15","click":"720884","account":"易哲网络04"}]}
     * status : 0
     * info :
     */
    private DataBean data;
    private String status;
    private String info;


    public void getAllData(String response) {
        try {
            JSONObject object = new JSONObject(response);
            setStatus(object.getString("status"));
            setInfo(object.getString("info"));
            JSONObject data = object.getJSONObject("data");
            DataBean dataBean = new DataBean();
            dataBean.getData(data);
            setData(dataBean);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public DataBean getData() {
        return data;
    }

    public String getStatus() {
        return status;
    }

    public String getInfo() {
        return info;
    }

    public class DataBean {
        /**
         * total_data : {"shows":"24749396193","consume":"663348233.59","user":"3839","click":"738466198"}
         * chams_users : [{"chams_id":"1","shows":"10631045","consume":"910740.20","cham_account":"易哲网络","id":"1","click":"652097","account":"bj-易哲网络05"},{"chams_id":"1","shows":"6731338","consume":"340355.78","cham_account":"易哲网络","id":"2","click":"505758","account":"bj易哲网络05"},{"chams_id":"1","shows":"8433523","consume":"670156.93","cham_account":"易哲网络","id":"3","click":"557027","account":"bj-易哲网络07"},{"chams_id":"1","shows":"22738455","consume":"1457561.92","cham_account":"易哲网络","id":"4","click":"1898354","account":"bj-易哲网络08"},{"chams_id":"1","shows":"48215164","consume":"1654744.01","cham_account":"易哲网络","id":"5","click":"2698738","account":"bj易哲网络08"},{"chams_id":"1","shows":"16851803","consume":"843702.17","cham_account":"易哲网络","id":"6","click":"1016861","account":"bj易哲网络10"},{"chams_id":"1","shows":"21246824","consume":"1576474.08","cham_account":"易哲网络","id":"7","click":"2147581","account":"bj-易哲网络10"},{"chams_id":"1","shows":"23276613","consume":"1193388.65","cham_account":"易哲网络","id":"8","click":"1649655","account":"bj易哲网络09"},{"chams_id":"1","shows":"14218136","consume":"1149372.46","cham_account":"易哲网络","id":"9","click":"828950","account":"bj-易哲网络15"},{"chams_id":"1","shows":"5617455","consume":"455072.17","cham_account":"易哲网络","id":"10","click":"322014","account":"bj-易哲网络16"},{"chams_id":"1","shows":"6765973","consume":"1464110.22","cham_account":"易哲网络","id":"11","click":"652855","account":"广州易哲网络"},{"chams_id":"1","shows":"8110337","consume":"641257.82","cham_account":"易哲网络","id":"12","click":"762738","account":"广州易哲网络01"},{"chams_id":"1","shows":"29482511","consume":"1484573.87","cham_account":"易哲网络","id":"13","click":"1939828","account":"广州易哲网络02"},{"chams_id":"1","shows":"5886028","consume":"519634.42","cham_account":"易哲网络","id":"14","click":"490033","account":"易哲网络02"},{"chams_id":"1","shows":"10675118","consume":"668372.64","cham_account":"易哲网络","id":"15","click":"720884","account":"易哲网络04"}]
         */
        private Total_dataEntity total_data;
        private List<Chams_usersEntity> chams_users;

        public void getData(JSONObject object) {
            try {
                Total_dataEntity total_dataEntity = new Total_dataEntity();
                JSONObject total_data = object.getJSONObject("total_data");
                total_dataEntity.getData(total_data);
                setTotal_data(total_dataEntity);

                JSONArray chams_users = object.getJSONArray("chams_users");
                List<Chams_usersEntity> chams_usersEntities = new ArrayList<>();
                for (int i = 0; i < chams_users.length(); i++) {
                    Chams_usersEntity chams_usersEntity = new Chams_usersEntity();
                    JSONObject jsonObject = chams_users.getJSONObject(i);
                    chams_usersEntity.getData(jsonObject);
                    chams_usersEntities.add(chams_usersEntity);
                    setChams_users(chams_usersEntities);

                }


            } catch (JSONException e) {
                e.printStackTrace();
            }
        }


        public void setTotal_data(Total_dataEntity total_data) {
            this.total_data = total_data;
        }

        public void setChams_users(List<Chams_usersEntity> chams_users) {
            this.chams_users = chams_users;
        }

        public Total_dataEntity getTotal_data() {
            return total_data;
        }

        public List<Chams_usersEntity> getChams_users() {
            return chams_users;
        }

        public class Total_dataEntity {
            /**
             * shows : 24749396193
             * consume : 663348233.59
             * user : 3839
             * click : 738466198
             */
            private String shows;
            private String consume;
            private String user;
            private String click;

            public void getData(JSONObject object) {
                try {
                    setShows(object.getString("shows"));
                    setConsume(object.getString("consume"));
                    setUser(object.getString("user"));
                    setClick(object.getString("click"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }


            public void setShows(String shows) {
                this.shows = shows;
            }

            public void setConsume(String consume) {
                this.consume = consume;
            }

            public void setUser(String user) {
                this.user = user;
            }

            public void setClick(String click) {
                this.click = click;
            }

            public String getShows() {
                return shows;
            }

            public String getConsume() {
                return consume;
            }

            public String getUser() {
                return user;
            }

            public String getClick() {
                return click;
            }
        }

        public class Chams_usersEntity {
            /**
             * chams_id : 1
             * shows : 10631045
             * consume : 910740.20
             * cham_account : 易哲网络
             * id : 1
             * click : 652097
             * account : bj-易哲网络05
             */
            private String chams_id;
            private String shows;
            private String consume;
            private String cham_account;
            private String id;
            private String click;
            private String account;


            public void getData(JSONObject object) {
                try {
                    setChams_id(object.getString("chams_id"));
                    setShows(object.getString("shows"));
                    setConsume(object.getString("consume"));
                    setCham_account(object.getString("cham_account"));
                    setId(object.getString("id"));
                    setClick(object.getString("click"));
                    setAccount(object.getString("account"));

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            public void setChams_id(String chams_id) {
                this.chams_id = chams_id;
            }

            public void setShows(String shows) {
                this.shows = shows;
            }

            public void setConsume(String consume) {
                this.consume = consume;
            }

            public void setCham_account(String cham_account) {
                this.cham_account = cham_account;
            }

            public void setId(String id) {
                this.id = id;
            }

            public void setClick(String click) {
                this.click = click;
            }

            public void setAccount(String account) {
                this.account = account;
            }

            public String getChams_id() {
                return chams_id;
            }

            public String getShows() {
                return shows;
            }

            public String getConsume() {
                return consume;
            }

            public String getCham_account() {
                return cham_account;
            }

            public String getId() {
                return id;
            }

            public String getClick() {
                return click;
            }

            public String getAccount() {
                return account;
            }
        }
    }
}
