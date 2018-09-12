package com.ebei.eba.vo;

import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value="RedisParams" , description = "redisParams")
public class RedisParams {

    @ApiModelProperty(value="namespace",name="命名空间")
    private String namespace;

    @ApiModelProperty(value="key",name="key值")
    private String key;

    @ApiModelProperty(value="field",name="字段only for 1-Hash")
    private String field; // only for Hash

    @ApiModelProperty(value="value",name="value值")
    private JSONObject value;

    @ApiModelProperty(value="type",name="类型0-String，1-Hash，2-List，3-Set，4-ZSet")
    private Integer type; // 数据类型：0-String，1-Hash，2-List，3-Set，4-ZSet

    @ApiModelProperty(value="score",name="排序only for 4-ZSet")
    private Integer score; // only for ZSet

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public JSONObject getValue() {
        return value;
    }

    public void setValue(JSONObject value) {
        this.value = value;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
