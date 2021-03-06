package org.droidplanner.services.android.core.mission.waypoints;

import com.MAVLink.common.msg_mission_item;
import com.MAVLink.enums.MAV_FRAME;
import com.o3dr.services.android.lib.coordinate.LatLongAlt;

import junit.framework.TestCase;

import org.droidplanner.services.android.core.mission.Mission;

public class SpatialCoordItemTest extends TestCase {

    public void testPackMissionItem() {
        Mission mission = new Mission(null);
        WaypointImpl item = new WaypointImpl(mission, new LatLongAlt(0.1, 1, (2)));

        msg_mission_item mavMsg = item.packMissionItem().get(0);

        assertEquals(1, mavMsg.autocontinue);
        assertEquals(MAV_FRAME.MAV_FRAME_GLOBAL_RELATIVE_ALT, mavMsg.frame);
        assertEquals(0.1f, mavMsg.x);
        assertEquals(1f, mavMsg.y);
        assertEquals(2f, mavMsg.z);
    }

}
