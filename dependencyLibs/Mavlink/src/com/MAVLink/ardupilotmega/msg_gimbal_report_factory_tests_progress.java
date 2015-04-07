        // MESSAGE GIMBAL_REPORT_FACTORY_TESTS_PROGRESS PACKING
package com.MAVLink.ardupilotmega;
import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;
        //import android.util.Log;
        
        /**
        * 
            Reports the current status of a section of a running factory test
        
        */
        public class msg_gimbal_report_factory_tests_progress extends MAVLinkMessage{
        
        public static final int MAVLINK_MSG_ID_GIMBAL_REPORT_FACTORY_TESTS_PROGRESS = 210;
        public static final int MAVLINK_MSG_LENGTH = 4;
        private static final long serialVersionUID = MAVLINK_MSG_ID_GIMBAL_REPORT_FACTORY_TESTS_PROGRESS;
        
        
         	/**
        * Which factory test is currently running
        */
        public byte test;
         	/**
        * Which section of the test is currently running.  The meaning of this is test-dependent
        */
        public byte test_section;
         	/**
        * The progress of the current test section, 0x64=100%
        */
        public byte test_section_progress;
         	/**
        * The status of the currently executing test section.  The meaning of this is test and section-dependent
        */
        public byte test_status;
        
        
        /**
        * Generates the payload for a mavlink message for a message of this type
        * @return
        */
        public MAVLinkPacket pack(){
		MAVLinkPacket packet = new MAVLinkPacket();
		packet.len = MAVLINK_MSG_LENGTH;
		packet.sysid = 255;
		packet.compid = 190;
		packet.msgid = MAVLINK_MSG_ID_GIMBAL_REPORT_FACTORY_TESTS_PROGRESS;
        		packet.payload.putByte(test);
        		packet.payload.putByte(test_section);
        		packet.payload.putByte(test_section_progress);
        		packet.payload.putByte(test_status);
        
		return packet;
        }
        
        /**
        * Decode a gimbal_report_factory_tests_progress message into this class fields
        *
        * @param payload The message to decode
        */
        public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();
        	    this.test = payload.getByte();
        	    this.test_section = payload.getByte();
        	    this.test_section_progress = payload.getByte();
        	    this.test_status = payload.getByte();
        
        }
        
        /**
        * Constructor for a new message, just initializes the msgid
        */
        public msg_gimbal_report_factory_tests_progress(){
    	msgid = MAVLINK_MSG_ID_GIMBAL_REPORT_FACTORY_TESTS_PROGRESS;
        }
        
        /**
        * Constructor for a new message, initializes the message with the payload
        * from a mavlink packet
        *
        */
        public msg_gimbal_report_factory_tests_progress(MAVLinkPacket mavLinkPacket){
        this.sysid = mavLinkPacket.sysid;
        this.compid = mavLinkPacket.compid;
        this.msgid = MAVLINK_MSG_ID_GIMBAL_REPORT_FACTORY_TESTS_PROGRESS;
        unpack(mavLinkPacket.payload);
        //Log.d("MAVLink", "GIMBAL_REPORT_FACTORY_TESTS_PROGRESS");
        //Log.d("MAVLINK_MSG_ID_GIMBAL_REPORT_FACTORY_TESTS_PROGRESS", toString());
        }
        
                
        /**
        * Returns a string with the MSG name and data
        */
        public String toString(){
    	return "MAVLINK_MSG_ID_GIMBAL_REPORT_FACTORY_TESTS_PROGRESS -"+" test:"+test+" test_section:"+test_section+" test_section_progress:"+test_section_progress+" test_status:"+test_status+"";
        }
        }
        