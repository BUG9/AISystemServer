package com.swpu.socket;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by BUG666 on 2017/1/4.
 */
@Getter
@Setter
public class InfoItem {
    private int mNodeId;// 树莓派节点  不用
    private int mSoilTemperature;// 土壤温度
    private int mSoilMoisture;// 土壤湿度
    private int mAirTemperature; // 空气温度
    private int mAirMoisture; // 空气湿度
    private int mLightIntensity; // 光照强度
    private int mLightState; // 灯状态 暂时不用
    private int mPumpState; // 抽水机状态 暂时不用
    private int mFanState; // 风扇状态 暂时不用
    private long mTimeStamp; // 时间戳   暂时不用
}
