package com.o3dr.services.android.lib.drone.companion.solo.tlv.mpcc;

import android.os.Parcel;

import com.o3dr.services.android.lib.drone.companion.solo.tlv.TLVMessageTypes;
import com.o3dr.services.android.lib.drone.companion.solo.tlv.TLVPacket;

import java.nio.ByteBuffer;

/**
 * App to Shotmanager.  Optional. Valid only in playback mode.
 *
 * The app sends this message to configure various aspects of how Shotmanager interprets the current Path.
 * This message is optional -- if the app never sends it, Shotmanager will use the assumed default values listed below.
 * Values stay in effect until the Path is reset by a SOLO_PATH_RECORD message
 *
 * Created by Fredia Huya-Kouadio on 12/8/15.
 * @since 2.8.0
 */
public class SoloSplinePathSettings extends TLVPacket {

    public static final int MESSAGE_LENGTH = 6;

    /**
     * cameraControl: (DEFAULT 0)
     * 0 : Shotmanager controls camera interpolation;  automatically points camera
     * 1 : No camera interpolation - camera is controlled with Artoo only.
     */
    private short cameraControl;

    /**
     * queryUVelocity: (DEFAULT 1.0)
     * The app uses this value to query how long it will take to fly the Path at a specific speed.
     * This value is echoed back in SOLO_SPLINE_PATH_STATUS messages.
     */
    private float queryUVelocity;

    public SoloSplinePathSettings(short cameraControl, float queryUVelocity){
        super(TLVMessageTypes.TYPE_SOLO_SPLINE_PATH_SETTINGS, MESSAGE_LENGTH);
        this.cameraControl = cameraControl;
        this.queryUVelocity = queryUVelocity;
    }

    public SoloSplinePathSettings(ByteBuffer buffer){
        this(buffer.getShort(), buffer.getFloat());
    }

    public short getCameraControl() {
        return cameraControl;
    }

    public float getQueryUVelocity() {
        return queryUVelocity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SoloSplinePathSettings)) return false;
        if (!super.equals(o)) return false;

        SoloSplinePathSettings that = (SoloSplinePathSettings) o;

        if (cameraControl != that.cameraControl) return false;
        return Float.compare(that.queryUVelocity, queryUVelocity) == 0;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (int) cameraControl;
        result = 31 * result + (queryUVelocity != +0.0f ? Float.floatToIntBits(queryUVelocity) : 0);
        return result;
    }

    @Override
    public String toString() {
        return "SoloSplinePathSettings{" +
                "cameraControl=" + cameraControl +
                ", queryUVelocity=" + queryUVelocity +
                '}';
    }

    @Override
    protected void getMessageValue(ByteBuffer valueCarrier) {
        valueCarrier.putShort(cameraControl);
        valueCarrier.putFloat(queryUVelocity);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeInt(this.cameraControl);
        dest.writeFloat(this.queryUVelocity);
    }

    protected SoloSplinePathSettings(Parcel in) {
        super(in);
        this.cameraControl = (short) in.readInt();
        this.queryUVelocity = in.readFloat();
    }

    public static final Creator<SoloSplinePathSettings> CREATOR = new Creator<SoloSplinePathSettings>() {
        public SoloSplinePathSettings createFromParcel(Parcel source) {
            return new SoloSplinePathSettings(source);
        }

        public SoloSplinePathSettings[] newArray(int size) {
            return new SoloSplinePathSettings[size];
        }
    };
}