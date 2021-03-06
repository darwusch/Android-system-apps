/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package android.car.apitest;

import android.car.VehicleAreaSeat;
import android.test.AndroidTestCase;
import android.test.suitebuilder.annotation.SmallTest;

@SmallTest
public class VehicleSeatTest extends AndroidTestCase {

    public void testMatchWithVehicleHal() {
        assertEquals(android.hardware.automotive.vehicle.V2_0.VehicleAreaSeat.ROW_1_LEFT,
                VehicleAreaSeat.SEAT_ROW_1_LEFT);
        assertEquals(android.hardware.automotive.vehicle.V2_0.VehicleAreaSeat.ROW_1_CENTER,
                VehicleAreaSeat.SEAT_ROW_1_CENTER);
        assertEquals(android.hardware.automotive.vehicle.V2_0.VehicleAreaSeat.ROW_1_RIGHT,
                VehicleAreaSeat.SEAT_ROW_1_RIGHT);
        assertEquals(android.hardware.automotive.vehicle.V2_0.VehicleAreaSeat.ROW_2_LEFT,
                VehicleAreaSeat.SEAT_ROW_2_LEFT);
        assertEquals(android.hardware.automotive.vehicle.V2_0.VehicleAreaSeat.ROW_2_CENTER,
                VehicleAreaSeat.SEAT_ROW_2_CENTER);
        assertEquals(android.hardware.automotive.vehicle.V2_0.VehicleAreaSeat.ROW_2_RIGHT,
                VehicleAreaSeat.SEAT_ROW_2_RIGHT);
        assertEquals(android.hardware.automotive.vehicle.V2_0.VehicleAreaSeat.ROW_3_LEFT,
                VehicleAreaSeat.SEAT_ROW_3_LEFT);
        assertEquals(android.hardware.automotive.vehicle.V2_0.VehicleAreaSeat.ROW_3_CENTER,
                VehicleAreaSeat.SEAT_ROW_3_CENTER);
        assertEquals(android.hardware.automotive.vehicle.V2_0.VehicleAreaSeat.ROW_3_RIGHT,
                VehicleAreaSeat.SEAT_ROW_3_RIGHT);
    }
}
