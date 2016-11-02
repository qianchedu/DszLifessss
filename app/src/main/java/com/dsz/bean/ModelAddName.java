package com.dsz.bean;

/**
 * Created by Administrator on 2016/11/2.
 */

public class ModelAddName {
    private int modelID;
    private String modelName;
    private String modelIconUrl;
    private boolean modelFlag;

    public ModelAddName() {
    }
    public ModelAddName(int modelID) {
        this.modelID = modelID;
    }


    public ModelAddName(boolean modelFlag) {
        this.modelFlag = modelFlag;
    }
    public ModelAddName(int modelID,boolean modelFlag) {
        this.modelID = modelID;
        this.modelFlag = modelFlag;
    }

    public ModelAddName(String modelName, String modelIconUrl, boolean modelFlag) {
        this.modelName = modelName;
        this.modelIconUrl = modelIconUrl;
        this.modelFlag = modelFlag;
    }

    public ModelAddName(int modelID, String modelName, String modelIconUrl, boolean modelFlag) {
        this.modelID = modelID;
        this.modelName = modelName;
        this.modelIconUrl = modelIconUrl;
        this.modelFlag = modelFlag;
    }

    public int getModelID() {
        return modelID;
    }

    public void setModelID(int modelID) {
        this.modelID = modelID;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getModelIconUrl() {
        return modelIconUrl;
    }

    public void setModelIconUrl(String modelIconUrl) {
        this.modelIconUrl = modelIconUrl;
    }

    public boolean isModelFlag() {
        return modelFlag;
    }

    public void setModelFlag(boolean modelFlag) {
        this.modelFlag = modelFlag;
    }
}
